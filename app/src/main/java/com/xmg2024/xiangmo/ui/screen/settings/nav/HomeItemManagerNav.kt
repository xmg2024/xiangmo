/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.settings.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.xmg2024.xiangmo.ui.screen.settings.HomeItemManagerRoute

private const val ROUTE = "settings_homeitemmanager"

fun NavController.navigateToHomeItemManagerScreen() {
    this.navigate(ROUTE) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.homeItemManagerScreen(
    onBackClick: () -> Unit
) {
    composable(ROUTE) {
        HomeItemManagerRoute(
            onBackClick = onBackClick
        )
    }
}