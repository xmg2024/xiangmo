/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.character.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xmg2024.xiangmo.ui.screen.chinese.character.ChineseCharacterIndexRoute

private const val ROUTE = "chinese_character_index"
private const val ROUTE_GRAPH = "chinese_character_index_graph"

fun NavController.navigateToChineseCharacterIndexGraph() {
    this.navigate(ROUTE_GRAPH)
}

fun NavGraphBuilder.chineseCharacterIndexGraph(
    onBackClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onPinyinSearchClick: () -> Unit,
    onRadicalClickSearch: () -> Unit,
    onStrokeSearchClick: () -> Unit,
    onStrokeClick: () -> Unit,
    onSearchClick: (String, String) -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE,
        route = ROUTE_GRAPH
    ) {
        composable(ROUTE) {
            ChineseCharacterIndexRoute(
                onBackClick = onBackClick,
                onBookmarksClick = onBookmarksClick,
                onPinyinSearchClick = onPinyinSearchClick,
                onRadicalClickSearch = onRadicalClickSearch,
                onStrokeSearchClick = onStrokeSearchClick,
                onStrokeClick = onStrokeClick,
                onSearch = onSearchClick
            )
        }
        nestGraph()
    }
}