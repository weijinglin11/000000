package com.example.middleexam.ui

data class Commodity(
    val name:String,
    val rank:Int,
    val num:Int,
    val weight:Int,
    val role:String,
)
data class Equipment(
    val name: String,
    val rank: Int,
    val num: Int,
    val weight: Int,
    val role: String,
)
object user {
    val Commodity: List<Commodity> = listOf(
        Commodity(
            "西瓜",
            1,
            1,
            1,
            "可以",
        ),
        Commodity(
            "橙子",
            2,
            2,
            2,
            "可以"
        )
    )
    val Equipment: List<Equipment> = listOf(
        Equipment(
            "香蕉",
            2,
            2,
            2,
            "好吃",
        )
    )
}




