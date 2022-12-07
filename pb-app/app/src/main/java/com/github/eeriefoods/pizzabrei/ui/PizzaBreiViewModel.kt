package com.github.eeriefoods.pizzabrei.ui

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class PizzaBreiViewModel() {
    private val coroutineScope = MainScope()

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _textToDisplay: MutableStateFlow<String> = MutableStateFlow("")
    val textToDisplay =  _textToDisplay.asStateFlow()

    private val _navigateToResults = Channel<Boolean>(Channel.BUFFERED)
    val navigateToResults = _navigateToResults.receiveAsFlow()

}