/*
 * This file is part of the 京墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.classicalliterature.sentence.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.classicalliterature.sentence.SentenceBookmarksRoute

private const val ROUTE = "classical_literature_sentence_bookmarks"

fun NavController.navigateToClassicalLiteratureSentenceBookmarksScreen() {
    this.navigate(ROUTE) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.classicalLiteratureSentenceBookmarksScreen(
    onBackClick: () -> Unit
) {
    composable(ROUTE) {
        SentenceBookmarksRoute(
            onBackClick = onBackClick
        )
    }
}