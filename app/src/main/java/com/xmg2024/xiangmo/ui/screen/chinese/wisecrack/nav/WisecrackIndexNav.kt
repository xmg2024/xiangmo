/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.ChineseWisecrackIndexRoute

private const val ROUTE_CHINESE_WISECRACK_INDEX = "chinese_wisecrack_index"
private const val ROUTE_CHINESE_WISECRACK_INDEX_GRAPH = "chinese_wisecrack_index_graph"

fun NavController.navigateToChineseWisecrackIndexGraph() {
    this.navigate(ROUTE_CHINESE_WISECRACK_INDEX)
}

fun NavGraphBuilder.chineseWisecrackIndexGraph(
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
    onReadMoreClick: () -> Unit,
    onSearchClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE_CHINESE_WISECRACK_INDEX,
        route = ROUTE_CHINESE_WISECRACK_INDEX_GRAPH
    ) {
        composable(ROUTE_CHINESE_WISECRACK_INDEX) {
            ChineseWisecrackIndexRoute(
                onBackClick = onBackClick,
                onCaptureClick = onCaptureClick,
                onReadMoreClick = onReadMoreClick,
                onSearchClick = onSearchClick,
                onBookmarksClick = onBookmarksClick
            )
        }
    }

    nestGraph()
}