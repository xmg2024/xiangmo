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

@Entity(tableName = "poem_sentences")
data class SentenceEntity(
    @PrimaryKey
    val id: Int,
    val content: String,
    val from: String,
    @ColumnInfo("poem_id")
    val poemId: Int?
)
