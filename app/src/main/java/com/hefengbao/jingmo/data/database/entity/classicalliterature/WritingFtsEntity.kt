/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.database.entity.classicalliterature

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.FtsOptions
import androidx.room.PrimaryKey

@Fts4(
    tokenizer = FtsOptions.TOKENIZER_ICU,
    contentEntity = WritingEntity::class,
)
@Entity(tableName = "writing_fts")
data class WritingFtsEntity(
    @PrimaryKey
    @ColumnInfo("rowid")
    val id: Int,
    val author: String?,
    val title2: String?,
    val content: String?,
)