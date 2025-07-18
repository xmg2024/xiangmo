/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeEntity
import kotlinx.serialization.Serializable

/**
 * 只是卡片
 */
@Serializable
data class ChineseKnowledge(
    val id: Int,
    val content: String,
    val label: String,
    val url: String?,
)

fun ChineseKnowledge.asChineseKnowledgeEntity() = KnowledgeEntity(
    id, content, label, url
)