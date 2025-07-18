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
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.settings.SettingsRoute

private const val ROUTE_SETTINGS = "settings"
private const val ROUTE_SETTINGS_GRAPH = "settings_graph"

fun NavController.navigateToSettingsGraph() {
    this.navigate(ROUTE_SETTINGS_GRAPH)
}

fun NavGraphBuilder.settingsGraph(
    onAboutClick: () -> Unit,
    onBackClick: () -> Unit,
    onDataClick: () -> Unit,
    onHomeItemManagerClick: () -> Unit,
    onImportClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE_SETTINGS,
        route = ROUTE_SETTINGS_GRAPH
    ) {
        composable(ROUTE_SETTINGS) {
            SettingsRoute(
                onAboutClick = onAboutClick,
                onBackClick = onBackClick,
                onDataClick = onDataClick,
                onHomeItemManagerClick = onHomeItemManagerClick,
                onImportClick = onImportClick,
                onPrivacyClick = onPrivacyClick,
            )
        }
        nestGraph()
    }
}