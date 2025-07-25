/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.riddle.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.chinese.riddle.RiddleIndexRoute

private const val ROUTE = "chinese_riddle_index"
private const val ROUTE_GRAPH = "chinese_riddle_index_graph"

fun NavController.navigateToChineseRiddleIndexGraph() {
    this.navigate(ROUTE_GRAPH)
}

fun NavGraphBuilder.chineseRiddleIndexGraph(
    onBackClick: () -> Unit,
    onInfoClick: () -> Unit,
    onSearchClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE,
        route = ROUTE_GRAPH
    ) {
        composable(
            route = ROUTE
        ) {
            RiddleIndexRoute(
                onBackClick = onBackClick,
                onInfoClick = onInfoClick,
                onSearchClick = onSearchClick,
                onReadMoreClick = onReadMoreClick
            )
        }
        nestGraph()
    }
}