package com.xmg2024.xiangmo.data.model.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbEntity
import kotlinx.serialization.Serializable

/**
 * 谚语
 */
@Serializable
data class Proverb(
    val id: Int,
    val content: String
)


fun Proverb.asProverbEntity() = ProverbEntity(
    id, content
)