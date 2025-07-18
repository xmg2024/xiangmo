/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.LyricBookmarksRoute

private const val ROUTE = "chinese_lyric_bookmarks"

fun NavController.navigateToChineseLyricBookmarksScreen() {
    this.navigate(ROUTE) { launchSingleTop = true }
}

fun NavGraphBuilder.chineseLyricBookmarksScreen(
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
) {
    composable(ROUTE) {
        LyricBookmarksRoute(
            onBackClick = onBackClick,
            onItemClick = onItemClick
        )
    }
}