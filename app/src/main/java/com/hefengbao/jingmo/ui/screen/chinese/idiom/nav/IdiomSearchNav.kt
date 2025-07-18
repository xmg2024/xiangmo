/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.idiom.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.chinese.idiom.IdiomSearchRoute

private const val ROUTE = "chinese_idiom_search"

fun NavController.navigateToChineseIdiomSearchScreen() {
    this.navigate(ROUTE)
}

fun NavGraphBuilder.chineseIdiomSearchScreen(
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
) {
    composable(ROUTE) {
        IdiomSearchRoute(
            onBackClick = onBackClick,
            onItemClick = onItemClick,
        )
    }
}