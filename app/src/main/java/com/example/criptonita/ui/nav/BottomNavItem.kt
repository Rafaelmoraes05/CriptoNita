package com.example.criptonita.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title: String, var icon: ImageVector, var route: String)
{
    data object HomePage : BottomNavItem("Início", Icons.Default.Home, "home")
    data object AlertListPage : BottomNavItem("Alertas", Icons.Default.Notifications, "Alerts")
    data object ConvertPage : BottomNavItem("Conversor", Icons.Default.Menu, "Convert")
    data object SettingsPage : BottomNavItem("Ajustes", Icons.Default.Settings, "Settings")
    data object FavoritePage : BottomNavItem("Favoritos", Icons.Default.Favorite, "Favorite")
}