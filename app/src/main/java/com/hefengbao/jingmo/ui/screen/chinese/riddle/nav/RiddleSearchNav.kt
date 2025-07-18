/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.riddle.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.chinese.riddle.RiddleSearchRoute

private const val ROUTE = "chinese_riddle_search"

fun NavController.navigateToChineseRiddleSearchScreen() {
    this.navigate(ROUTE)
}

fun NavGraphBuilder.chineseRiddleSearchScreen(
    onBackClick: () -> Unit
) {
    composable(ROUTE) {
        RiddleSearchRoute(
            onBackClick = onBackClick
        )
    }
}