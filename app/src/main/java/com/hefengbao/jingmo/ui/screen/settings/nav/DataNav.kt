/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.settings.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.settings.DataRoute

private const val ROUTE_DATA = "settings_data"

fun NavController.navigateToSettingsDataScreen() {
    this.navigate(ROUTE_DATA)
}

fun NavGraphBuilder.settingsDataScreen(
    onBackClick: () -> Unit
) {
    composable(ROUTE_DATA) {
        DataRoute(
            onBackClick = onBackClick
        )
    }
}