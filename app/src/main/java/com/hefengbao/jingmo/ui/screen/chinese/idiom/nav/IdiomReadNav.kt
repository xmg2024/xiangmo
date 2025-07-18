/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.idiom.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.chinese.idiom.IdiomReadRoute

private const val ROUTE = "chinese_idiom_read"

fun NavController.navigateToChineseIdiomReadScreen() {
    this.navigate(ROUTE)
}

fun NavGraphBuilder.chineseIdiomReadScreen(
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit
) {
    composable(ROUTE) {
        IdiomReadRoute(
            onBackClick = onBackClick,
            onCaptureClick = onCaptureClick
        )
    }
}