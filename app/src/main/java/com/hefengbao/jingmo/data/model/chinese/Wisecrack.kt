/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.model.chinese

import com.hefengbao.jingmo.data.database.entity.chinese.WisecrackEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 歇后语
 */
@Serializable
data class ChineseWisecrack(
    val id: Int,
    val riddle: String,
    val answer: String,
    @SerialName("first_word")
    val firstWord: String = "",
    @SerialName("first_letter")
    val firstLetter: String = ""
)

fun ChineseWisecrack.asChineseWisecrackEntity() = WisecrackEntity(
    id, riddle, answer, firstWord, firstLetter
)
