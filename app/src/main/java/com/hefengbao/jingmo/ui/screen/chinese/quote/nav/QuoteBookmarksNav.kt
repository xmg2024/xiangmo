/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.quote.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.chinese.quote.QuoteBookmarksRoute

private const val ROUTE = "chinese_quote_bookmarks"

fun NavController.navigateToChineseQuoteBookmarksScreen() {
    this.navigate(ROUTE) { launchSingleTop = true }
}

fun NavGraphBuilder.chineseQuoteBookmarksScreen(
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
) {
    composable(ROUTE) {
        QuoteBookmarksRoute(
            onBackClick = onBackClick,
            onItemClick = onItemClick
        )
    }
}