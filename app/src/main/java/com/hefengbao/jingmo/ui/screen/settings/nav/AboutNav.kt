/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.settings.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.settings.AboutRoute

private const val ROUTE_ABOUT = "about"

fun NavController.navigateToAboutScreen() {
    this.navigate(ROUTE_ABOUT)
}

fun NavGraphBuilder.aboutScreen(
    onBackClick: () -> Unit
) {
    composable(ROUTE_ABOUT) {
        AboutRoute(onBackClick)
    }
}