/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.database.entity.classicalliterature

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 经典诗文
 */
@Entity(tableName = "classic_poems")
data class ClassicPoemEntity(
    @PrimaryKey
    val id: Int,
    val dynasty: String,
    val writer: String,
    @ColumnInfo(name = "writer_introduction")
    val writerIntroduction: String?,
    val title: String,
    val subtitle: String?,
    val preface: String?,
    val content: String,
    val annotation: String?,
    val translation: String?,
    @ColumnInfo(name = "creative_background")
    val creativeBackground: String?,
    val explain: String?,
    val comment: String?,
    val collection: String,
    val category: String?
)
