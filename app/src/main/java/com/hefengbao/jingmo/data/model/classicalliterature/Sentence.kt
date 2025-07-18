/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.model.classicalliterature

import com.hefengbao.jingmo.data.database.entity.classicalliterature.SentenceEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PoemSentence(
    val id: Int,
    val content: String,
    val from: String,
    @SerialName("poem_id")
    val poemId: Int? = null
)

fun PoemSentence.asPoemSentenceEntity() = SentenceEntity(
    id, content, from, poemId
)
