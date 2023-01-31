package com.github.eeriefoods.pizzabrei.data.repository

import android.net.Uri
import androidx.activity.ComponentActivity
import com.github.eeriefoods.pizzabrei.data.datasource.ApplicationDataSource
import com.github.eeriefoods.pizzabrei.domain.model.Application
import com.github.eeriefoods.pizzabrei.domain.model.ApplicationApiEntity
import com.google.gson.GsonBuilder
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.io.*

class ApplicationAPIImpl : ApplicationDataSource {
    private var applicationGetService = Retrofit.Builder()
        .baseUrl("http://eeriefoods.de:8080/api/v1/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
        .create(ApplicationService::class.java)
    override suspend fun getApplications(): Response<List<ApplicationApiEntity>> = applicationGetService.getApplications().awaitResponse()

    override suspend fun putApplication(application: Application, activity: ComponentActivity): Response<ApplicationApiEntity> {

        val response = applicationGetService.postApplication(application.applicationToApi()).awaitResponse()

        val fileDescriptor = activity.contentResolver.openFile(Uri.parse(application.fileUrl), "r",null)
        val input = FileInputStream(fileDescriptor?.fileDescriptor)
        val byteArray = readBinaryStream(input, fileDescriptor!!.statSize.toInt())
        val file = File(activity.cacheDir, application.name!!)
        val fileSaved = writeFile(file, byteArray)

        if (fileSaved) {
            applicationGetService.uploadAPK("apk/" + application.appId,MultipartBody.Part.createFormData("file", file.name, file.asRequestBody())).awaitResponse()
        }

        return response
    }
}

interface ApplicationService {
    @GET("application/all")
    fun getApplications(): Call<List<ApplicationApiEntity>>

    @POST("application")
    fun postApplication(@Body application: ApplicationApiEntity): Call<ApplicationApiEntity>

    @Multipart
    @POST
    fun uploadAPK(@Url url: String, @Part apk: MultipartBody.Part): Call<String>
}
private fun readBinaryStream(
    stream: InputStream,
    byteCount: Int
): ByteArray {
    val output = ByteArrayOutputStream()
    try {
        val buffer = ByteArray(if (byteCount > 0) byteCount else 4096)
        var read: Int
        while (stream.read(buffer).also { read = it } >= 0) {
            output.write(buffer, 0, read)
        }
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        try {
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    return output.toByteArray()
}

private fun writeFile(cachedFile: File, data: ByteArray): Boolean {
    return try {
        var output: BufferedOutputStream? = null
        try {
            output = BufferedOutputStream(FileOutputStream(cachedFile))
            output.write(data)
            output.flush()
            true
        } finally {
            output?.close()
        }
    } catch (ex: Exception) {
        false
    }
}