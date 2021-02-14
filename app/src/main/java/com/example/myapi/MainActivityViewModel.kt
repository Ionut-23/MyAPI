package com.example.myapi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {

    suspend fun getApiResults() {
        return withContext(Dispatchers.IO) {
            val resultado = GlobalScope.async {
                DownloadManager.downloadApiResults()
            }
            resultado.await()
        }
    }
}