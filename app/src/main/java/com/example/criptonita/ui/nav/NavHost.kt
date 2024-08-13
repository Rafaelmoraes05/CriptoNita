package com.example.criptonita.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.criptonita.ui.HomePage
import com.example.criptonita.ui.AlertListPage
import com.example.criptonita.ui.ConvertPage
import com.example.criptonita.ui.FavoritePage
import com.example.criptonita.ui.SettingsPage

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.HomePage.route) {
        // composable (route = NOME DESTA DESTINAÇÃO) { UI DA DESTINAÇÃO }
        composable(route = BottomNavItem.HomePage.route) {
            HomePage()
        }
        composable(route = BottomNavItem.AlertListPage.route) {
            AlertListPage()
        }
        composable(route = BottomNavItem.ConvertPage.route) {
            ConvertPage()
        }
        composable(route = BottomNavItem.SettingsPage.route) {
            SettingsPage()
        }
        composable(route = BottomNavItem.FavoritePage.route) {
            FavoritePage()
        }
    }
}