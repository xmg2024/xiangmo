/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.AntitheticalCoupletIndexRoute

private const val ROUTE = "chinese_antithetical_couplet_index"
private const val ROUTE_GRAPH = "chinese_antithetical_couplet_index_graph"

fun NavController.navigateToChineseAntitheticalCoupletIndexGraph() {
    this.navigate(ROUTE)
}

fun NavGraphBuilder.chineseAntitheticalCoupletIndexGraph(
    onBackClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onSearchClick: () -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE,
        route = ROUTE_GRAPH
    ) {
        composable(ROUTE) {
            AntitheticalCoupletIndexRoute(
                onBackClick = onBackClick,
                onReadMoreClick = onReadMoreClick,
                onBookmarksClick = onBookmarksClick,
                onSearchClick = onSearchClick
            )
        }
    }

    nestGraph()
}