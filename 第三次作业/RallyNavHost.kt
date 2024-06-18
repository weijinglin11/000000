package com.example.rally

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.rally.ui.accounts.AccountsScreen
import com.example.compose.rally.ui.accounts.SingleAccountScreen
import com.example.rally.ui.bills.BillsScreen
import com.example.compose.rally.ui.overview.OverviewScreen
import com.example.rally.data.Account
import com.example.rally.data.Bill

@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = Overview.route,
        modifier =modifier
    ){
        composable(route = Overview.route){
            OverviewScreen(
                onClickSeeAllAccounts = {
                    navController.navigateSingleTopTo(Account.route)
                },
                onClickSeeAllBills = {
                    navController.navigateSingleTopTo(Account.route)
                },
                onAccountClick = {accountType ->
                    navController.navigateToSingleAccount(accountType)
                }
            )
        }
        composable(route = Account.route){
            AccountsScreen(
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                }
            )
        }
        composable(route = Bill.route){
            BillsScreen()
        }
        composable(
            route = SingleAccount.routeWithArgs,
            arguments = SingleAccount.arguments,
            deepLinks = SingleAccount.deepLinks
        ){navBackStackEntry ->
            val accountType =
                navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)
            SingleAccountScreen(accountType)

        }
    }
}
