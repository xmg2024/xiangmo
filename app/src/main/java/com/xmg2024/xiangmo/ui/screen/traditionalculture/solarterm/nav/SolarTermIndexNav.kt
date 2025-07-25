/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.traditionalculture.solarterm.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.traditionalculture.solarterm.SolarTermIndexRoute

private const val ROUTE = "traditional_culture_solar_term_index"
private const val ROUTE_GRAPH = "traditional_culture_solar_term_index_graph"

fun NavController.navigateToTraditionalCultureSolarTermIndexGraph() {
    return this.navigate(ROUTE_GRAPH)
}

fun NavGraphBuilder.traditionalCultureSolarTermIndexGraph(
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE,
        route = ROUTE_GRAPH
    ) {
        composable(ROUTE) {
            SolarTermIndexRoute(
                onBackClick = onBackClick,
                onItemClick = onItemClick
            )
        }

        nestGraph()
    }
}