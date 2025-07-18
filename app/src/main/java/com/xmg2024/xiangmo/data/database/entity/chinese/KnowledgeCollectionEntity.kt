/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.database.entity.chinese

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * 知识卡片书签
 */
@Entity(tableName = "chinese_knowledge_collections", indices = [Index("collected_at")])
data class KnowledgeCollectionEntity(
    @PrimaryKey
    val id: Int
) {
    @ColumnInfo(name = "collected_at")
    var collectedAt: Long = System.currentTimeMillis()
}
