package com.github.eeriefoods.pizzabreiserver.apppackage.service

import com.github.eeriefoods.pizzabreiserver.apppackage.api.AppPackageFileAlreadyExistsException
import com.github.eeriefoods.pizzabreiserver.apppackage.api.AppPackageNotFoundException
import com.github.eeriefoods.pizzabreiserver.shared.config.FtpProperties
import org.apache.commons.net.ftp.FTP
import org.apache.commons.net.ftp.FTPClient
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class AppPackageService(
    val properties: FtpProperties
) {

    fun storeFile(file: MultipartFile, appId: String): String {

        val con: FTPClient?
        val errMsg: String?

        try {
            con = FTPClient()
            con.connect(properties.address)

            if (con.login(properties.username, properties.password)) {
//                con.execPBSZ(0)
//                con.execPROT("P")
                con.enterLocalPassiveMode()
                con.setFileType(FTP.BINARY_FILE_TYPE)

                val remotePath = "${properties.directory}/$appId.apk"

                if (con.listFiles(remotePath).isNotEmpty()) {
                    throw AppPackageFileAlreadyExistsException("$remotePath already exists!")
                }

                con.storeFile(remotePath, file.inputStream)
                con.logout()
                con.disconnect()
            }
            return "$appId.apk"

        } catch (e: Exception) {
            e.printStackTrace()
            errMsg = e.localizedMessage
        }
        return "error $errMsg"
    }

    fun load(appId: String): Resource {
        try {
            val con = FTPClient()
            con.connect(properties.address)

            if (con.login(properties.username, properties.password)) {
                con.enterLocalPassiveMode()
                con.setFileType(FTP.BINARY_FILE_TYPE)
                val remoteFile = "${properties.directory}/$appId.apk"

                val resource = InputStreamResource(con.retrieveFileStream(remoteFile))
                if (resource.exists() || resource.isReadable)
                    return resource
                else throw AppPackageNotFoundException("Could not read: $appId.apk")
            } else {
                println("Login failed")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw AppPackageNotFoundException("Error while loading $appId.apk", e)
        }
        throw AppPackageNotFoundException("Error while loading $appId.apk")
    }
}