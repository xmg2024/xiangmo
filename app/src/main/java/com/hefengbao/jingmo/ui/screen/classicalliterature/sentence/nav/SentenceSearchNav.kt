/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.classicalliterature.sentence.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.classicalliterature.sentence.SentenceSearchRoute

private const val ROUTE = "classical_literature_sentence_search"

fun NavController.navigateToClassicalLiteratureSentenceSearchScreen() {
    this.navigate(ROUTE)
}

fun NavGraphBuilder.classicalLiteratureSentenceSearchScreen(
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
) {
    composable(
        ROUTE
    ) {
        SentenceSearchRoute(
            onBackClick = onBackClick,
            onCardClick = onCaptureClick
        )
    }
}