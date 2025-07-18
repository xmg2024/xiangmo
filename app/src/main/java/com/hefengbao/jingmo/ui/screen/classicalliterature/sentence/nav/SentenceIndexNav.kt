/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.classicalliterature.sentence.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hefengbao.jingmo.ui.screen.classicalliterature.sentence.SentenceIndexRoute

private const val ROUTE = "classical_literature_sentence_index"
private const val ROUTE_GRAPH = "classical_literature_sentence_index_graph"

fun NavController.navigateToClassicalLiteratureSentenceIndexGraph() {
    this.navigate(ROUTE) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.classicalLiteratureSentenceIndexGraph(
    onBackClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
    onReadMoreClick: () -> Unit,
    onSearchClick: () -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE,
        route = ROUTE_GRAPH
    ) {
        composable(ROUTE) {
            SentenceIndexRoute(
                onBackClick = onBackClick,
                onBookmarksClick = onBookmarksClick,
                onCaptureClick = onCaptureClick,
                onReadMoreClick = onReadMoreClick,
                onSearchItemClick = onSearchClick,
            )
        }
    }

    nestGraph()
}