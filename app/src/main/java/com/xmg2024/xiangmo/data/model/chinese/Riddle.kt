/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.RiddleEntity
import kotlinx.serialization.Serializable

/**
 * 谜语
 */
@Serializable
data class Riddle(
    val id: Int,
    val puzzle: String,
    val answer: String
)

fun Riddle.asRiddleEntity() = RiddleEntity(
    id, puzzle, answer
)

