/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.ProverbSearchRoute

private const val ROUTE = "chinese_proverb_search"

fun NavController.navigateToChineseProverbSearchScreen() {
    this.navigate(ROUTE) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chineseProverbSearchScreen(
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
) {
    composable(ROUTE) {
        ProverbSearchRoute(
            onBackClick = onBackClick,
            onItemClick = onItemClick
        )
    }
}