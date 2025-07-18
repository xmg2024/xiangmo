/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.model.theme

enum class DarkThemeConfig {
    FOLLOW_SYSTEM,
    LIGHT,
    DARK;

    companion object {
        infix fun from(value: String): DarkThemeConfig =
            DarkThemeConfig.entries.firstOrNull { it.name == value } ?: FOLLOW_SYSTEM
    }
}
