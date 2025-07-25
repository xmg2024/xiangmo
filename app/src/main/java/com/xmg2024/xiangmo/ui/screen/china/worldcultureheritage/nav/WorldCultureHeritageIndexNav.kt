/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.china.worldcultureheritage.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.china.worldcultureheritage.WorldCultureHeritageIndexRoute

private const val ROUTE = "china_world_culture_heritage_index"
private const val ROUTE_GRAPH = "china_world_culture_heritage_index_graph"

fun NavController.navigateToChinaWorldCultureHeritageGraph() {
    this.navigate(ROUTE) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chinaWorldCultureHeritageGraph(
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE,
        route = ROUTE_GRAPH
    ) {
        composable(
            route = ROUTE
        ) {
            WorldCultureHeritageIndexRoute(
                onBackClick = onBackClick,
                onItemClick = onItemClick
            )
        }

        nestGraph()
    }
}