/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.character.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.xmg2024.xiangmo.ui.screen.chinese.character.ChineseCharacterStrokeRoute

private const val ROUTE = "chinese_character_stroke"

fun NavController.navigateToChineseCharacterStrokeScreen() {
    this.navigate(ROUTE)
}

fun NavGraphBuilder.chineseCharacterStrokeScreen(
    onBackClick: () -> Unit,
) {
    composable(ROUTE) {
        ChineseCharacterStrokeRoute(
            onBackClick = onBackClick
        )
    }
}