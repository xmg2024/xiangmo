/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.character.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hefengbao.jingmo.ui.screen.chinese.character.CharacterRadicalIndexRoute

private const val ROUTE = "chinese_character_radical_index"

fun NavController.navigateToChineseCharacterRadicalIndexScreen() {
    this.navigate(ROUTE) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chineseCharacterRadicalIndexScreen(
    onBackClick: () -> Unit,
    onItemClick: (String, String) -> Unit,
) {
    composable(ROUTE) {
        CharacterRadicalIndexRoute(
            onBackClick = onBackClick,
            onItemClick = onItemClick
        )
    }
}