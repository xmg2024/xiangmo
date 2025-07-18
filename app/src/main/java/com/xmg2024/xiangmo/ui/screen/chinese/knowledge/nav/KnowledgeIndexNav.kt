/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.ChineseKnowledgeIndexRoute

private const val ROUTE_GRAPH = "chinese_knowledge_index_graph"
private const val ROUTE = "chinese_knowledge_index"

fun NavController.navigateToChineseKnowledgeIndexGraph() {
    this.navigate(ROUTE_GRAPH)
}

fun NavGraphBuilder.chineseKnowledgeIndexGraph(
    onBackClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onSearchClick: () -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE,
        route = ROUTE_GRAPH
    ) {
        composable(ROUTE) {
            ChineseKnowledgeIndexRoute(
                onBackClick = onBackClick,
                onBookmarksClick = onBookmarksClick,
                onReadMoreClick = onReadMoreClick,
                onSearchClick = onSearchClick,
            )
        }
        nestGraph()
    }
}