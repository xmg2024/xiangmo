/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.tonguetwister.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.chinese.tonguetwister.TongueTwisterIndexRoute


private const val ROUTE = "chinese_tongue_twister_index"
private const val ROUTE_GRAPH = "chinese_tongue_twister_index_graph"

fun NavController.navigateToChineseTongueTwisterIndexGraph() {
    this.navigate(ROUTE_GRAPH)
}

fun NavGraphBuilder.chineseTongueTwisterIndexGraph(
    onBackClick: () -> Unit,
    onItemsClick: (Int) -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE,
        route = ROUTE_GRAPH
    ) {
        composable(ROUTE) {
            TongueTwisterIndexRoute(
                onBackClick = onBackClick,
                onItemClick = onItemsClick
            )
        }
    }
    nestGraph()
}