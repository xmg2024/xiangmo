/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.ClassicPoemReadRoute

private const val ROUTE = "classical_literature_classic_poem_read"

fun NavController.navigateToClassicalLiteratureClassicPoemReadScreen() {
    this.navigate(ROUTE) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.classicalLiteratureClassicPoemReadScreen(
    onBackClick: () -> Unit
) {
    composable(ROUTE) {
        ClassicPoemReadRoute(
            onBackClick = onBackClick
        )
    }
}