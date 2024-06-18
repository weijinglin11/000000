package com.example.rally

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

interface RallyDestination{
    val icon: ImageVector
    val route: String
}
object Overview : RallyDestination {
    override val icon = Icons.Filled.Build
    override val route = "overview"
}

object Accounts : RallyDestination {
    override val icon = Icons.Filled.AccountBox
    override val route = "accounts"
}

object Bills : RallyDestination {
    override val icon = Icons.Filled.KeyboardArrowDown
    override val route = "bills"
}
object SingleAccount : RallyDestination {
    override val icon = Icons.Filled.Add
    override val route = "single_account"
    const val accountTypeArg = "account_type"
    val routeWithArgs = "$route/{$accountTypeArg}"
    val arguments = listOf(
        navArgument(accountTypeArg){type = NavType.StringType}
    )
    val deepLinks = listOf(
        navDeepLink { uriPattern = "rally://$route/{$accountTypeArg}" }
    )
}
val rallyTabRowScreens = listOf(Overview, Accounts, Bills)