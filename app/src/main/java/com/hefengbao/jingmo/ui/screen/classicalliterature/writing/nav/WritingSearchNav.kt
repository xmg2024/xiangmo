/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.classicalliterature.writing.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.classicalliterature.writing.WritingSearchRoute

private const val ROUTE = "classical_literature_writing_search"

fun NavController.navigateToClassicalLiteratureWritingSearchScreen() {
    this.navigate(ROUTE) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.classicalLiteratureWritingSearchScreen(
    onBackClick: () -> Unit,
    onItemClick: (id: String) -> Unit,
) {
    composable(
        route = ROUTE,
    ) {
        WritingSearchRoute(
            onBackClick = onBackClick,
            onItemClick = onItemClick,
        )
    }
}