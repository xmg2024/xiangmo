/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.QuoteEntity
import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    val id: Int,
    val content: String,
    val author: String,
    val from: String
)

fun Quote.asQuoteEntity() = QuoteEntity(
    id, content, author, from
)
