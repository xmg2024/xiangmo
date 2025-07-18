/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.ExpressionEntity
import kotlinx.serialization.Serializable

/**
 * 词语
 */
@Serializable
data class ChineseExpression(
    val id: Int,
    val word: String,
    val pinyin: String,
    val abbr: String? = null,
    val explanation: String? = null
)

fun ChineseExpression.asChineseExpressionEntity() = ExpressionEntity(
    id, word, pinyin, abbr, explanation
)
