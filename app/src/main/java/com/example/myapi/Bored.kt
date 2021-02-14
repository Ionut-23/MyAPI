package com.example.myapi
import com.google.gson.annotations.SerializedName

data class Bored (
    var activity : String,
    var type : String,
    var participants : Int,
    var price : Float,
    var link : String,
    var key : Int,
    var accessibility : Float){

    override fun toString(): String {
        return "Actividad: $activity\n Participantes: $participants\n Precio: $price\n"
    }
}
/*
{
  "activity": "Find a charity and donate to it",
  "type": "charity",
  "participants": 1,
  "price": 0.4,
  "link": "",
  "key": "1488053",
  "accessibility": 0.1
}
 */