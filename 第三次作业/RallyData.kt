package com.example.rally.data

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
@Immutable
data class Account (
    val name: String,
    val number: Int,
    val balance: Float,
    val color: Color
)
@Immutable
data class Bill(
    val name : String,
    val due : String,
    val amount: Float,
    val color: Color
)
object UserData{
    val account: List<Account> = listOf(
        Account(
            "name",
            123,
            12.3f,
            Color(0xFF005D57)
        )
    )
    val bills: List<Bill> = listOf(
        Bill(
            "陈添杜",
            "Jan 29",
            45.36f,
            Color(0xFFFFAC12)
        ),
        Bill(
            "Jake",
            "Jan 23",
            66.92f,
            Color(0xFFFFAC12)
        )

    )
    fun getAcocount(accountName:String?): Account{
        return account.first { it.name == accountName }
    }
},
