package com.example.myapplication1.Data

data class classes(
    val cid :Int,
    val cname : String,
    val cstudent : String
)

data class students(
    val sid : Int,
    val spower : Int,
    val sname : String,
    val scid : Int,
    val spassword : String,
    val savator : Int,
    val stoken : Int,
    val sgithub : String,
    val shomewoek : String,
    val equipment : String,
    val sprops : String,
    val scommodities : String,
)

data class teachers(
    val tid : String,
    val tpower : Int,
    val tname : String,
    val tpassword : String,
    val tavator : String,
    val tclass : String,
)

data class equipments(
    val eid : Int,
    val ename : String,
    val eimage : String,
    val eprice : Int,
    val tamount : Int,
    val edetails : String,
)

data class props(
    val pid : Int,
    val pname : String,
    val pimage : String,
    val pprice : Int,
    val pamount : Int,
    val pdetails : String,
)

data class commodities(
    val cid : Int,
    val cname : String,
    val cimage : String,
    val cprice : Int,
    val camount : Int,
    val cdetails : String,
)

data class major(
    val mid : Int,
    val mname : String
)

data class  logs(
    val lid : Int,
    val ltype : Int,
    val tid : String,
    val cid : Int,
    val sid : String,
    val pid : Int,
    val eid : Int,
    val coid : Int,
    val linfo : String,
)

object UserData{
   val classes: List<classes> = listOf(
       classes(
           1,
           "1班",
           "张三",


       )
   )
   val students: List<students> = listOf(
       students(

       )
   )
}