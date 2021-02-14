package com.example.myapi

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray

class DownloadManager {

    companion object{
        var lista = mutableListOf<Bored>()
        suspend fun downloadApiResults():List<Bored>?{
            val client = OkHttpClient()
            val url = "https://www.boredapi.com/api/activity"
            val request = Request.Builder()
                .url(url)
                .build()
            val call = client.newCall(request)
            val response = call.execute()
            val bodyInString = response.body?.string()
            bodyInString?.let {
                Log.w("GetAllBoreds",bodyInString)
                val result = JSONArray(bodyInString)

                result.let {
                    Log.w("GetAllBoreds",result.toString())
                    val gson = Gson()

                    val itemType = object : TypeToken<List<Bored>>(){}.type
                    val list = gson.fromJson<List<Bored>>(result.toString(), itemType)
                    delay(3000)

                    lista = list as MutableList<Bored>
                }
            }
            return lista
        }
        suspend fun downloadApiSingleResult(userChoice: String): List<Bored> {
            val client = OkHttpClient()
            var url = "https://www.boredapi.com/api/activity"
            delay(3000)
            when(userChoice){
                "1" -> url += "/1"
                "2" -> url += "/2"
                "3" -> url += "/3"
                "4" -> url += "/4"
                "5" -> url += "/5"
                "6" -> url += "/6"
                "7" -> url += "/7"
                "8" -> url += "/8"
                "9" -> url += "/9"
                "10" -> url += "/10"
                else -> "No existe ninguno con ese id"
            }
            val request = Request.Builder()
                .url(url)
                .build()
            val call = client.newCall(request)
            val response = call.execute()
            val bodyInString = response.body?.string()
            bodyInString?.let {
                Log.w("GetAllBoreds",bodyInString)
                val result = JSONArray(bodyInString)

                result.let {
                    Log.w("GetAllBoreds",result.toString())
                    val gson = Gson()

                    val itemType = object : TypeToken<List<Bored>>(){}.type
                    val list = gson.fromJson<List<Bored>>(result.toString(), itemType)
                    delay(3000)

                    lista = list as MutableList<Bored>
                }
            }
            return lista
        }
    }
}