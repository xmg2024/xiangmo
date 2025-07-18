/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.model.chinese

import com.hefengbao.jingmo.data.database.entity.chinese.DictionaryEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 汉字
 */
@Serializable
data class Dictionary(
    val id: Int,
    val char: String,
    val wubi: String?,
    val radical: String?,
    val stroke: Int,
    val pinyin: String?,
    val pinyin2: List<String>?,
    @SerialName("simple_explanation")
    val simpleExplanation: String?,
    val explanation: String?,
    val loanword: Boolean,
)

fun Dictionary.asDictionaryEntity() = DictionaryEntity(
    id, char, wubi, radical, stroke, pinyin, simpleExplanation, explanation, loanword
)

@Serializable
data class DictionaryWrapper(
    val data: List<Dictionary>,
    @SerialName("next_page")
    val nextPage: String?
)