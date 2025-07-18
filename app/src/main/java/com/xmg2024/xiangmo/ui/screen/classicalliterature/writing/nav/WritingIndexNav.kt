/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.WritingIndexRoute

private const val ROUTE = "classical_literature_writing_index"
private const val ROUTE_GRAPH = "classical_literature_writing_index_graph"

fun NavController.navigateToClassicalLiteratureWritingIndexGraph() {
    this.navigate(ROUTE_GRAPH) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.classicalLiteratureWritingIndexGraph(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onBookmarksClick: () -> Unit,
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
            WritingIndexRoute(
                onBackClick = onBackClick,
                onSearchClick = onSearchClick,
                onBookmarksClick = onBookmarksClick,
                onReadMoreClick = onReadMoreClick,
            )
        }
        nestGraph()
    }
}