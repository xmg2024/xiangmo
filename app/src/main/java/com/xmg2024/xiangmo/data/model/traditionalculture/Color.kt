/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.traditionalculture

data class Color(
    val id: String,
    val name: String,
    val traName: String,
    val colorSeries: String,
    val pinyin: String,
    val fontColor: String,
    val isBright: Boolean,
    val rgb: List<Int>,
    val hex: String,
    val cmyk: List<Int>,
    val desc: String,
    val figure: String
)