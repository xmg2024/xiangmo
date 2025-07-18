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
import com.xmg2024.xiangmo.ui.screen.settings.PrivacyRoute

private const val ROUTE_PRIVACY = "privacy"

fun NavController.navigateToPrivacyScreen() {
    this.navigate(ROUTE_PRIVACY)
}

fun NavGraphBuilder.privacyScreen(
    onBackClick: () -> Unit
) {
    composable(ROUTE_PRIVACY) {
        PrivacyRoute(onBackClick)
    }
}