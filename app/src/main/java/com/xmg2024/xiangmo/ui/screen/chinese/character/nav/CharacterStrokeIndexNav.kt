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
import com.xmg2024.xiangmo.ui.screen.chinese.character.CharacterStrokeIndexRoute

private const val ROUTE = "chinese_character_stroke_index"

fun NavController.navigateToChineseCharacterStrokeIndexScreen() {
    this.navigate(ROUTE) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chineseCharacterStrokeIndexScreen(
    onBackClick: () -> Unit,
    onItemClick: (String, String) -> Unit,
) {
    composable(ROUTE) {
        CharacterStrokeIndexRoute(
            onBackClick = onBackClick,
            onItemClick = onItemClick
        )
    }
}