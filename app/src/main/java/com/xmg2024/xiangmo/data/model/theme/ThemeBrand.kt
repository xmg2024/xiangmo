/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.theme

enum class ThemeBrand {
    DEFAULT,
    ANDROID;

    companion object {
        infix fun from(value: String): ThemeBrand =
            ThemeBrand.entries.firstOrNull { it.name == value } ?: DEFAULT
    }
}
