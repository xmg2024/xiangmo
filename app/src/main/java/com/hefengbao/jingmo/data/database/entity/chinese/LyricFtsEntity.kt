/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.database.entity.chinese

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.FtsOptions
import androidx.room.PrimaryKey

@Fts4(
    tokenizer = FtsOptions.TOKENIZER_ICU,
    contentEntity = LyricEntity::class,
)
@Entity(tableName = "lyrics_fts")
data class LyricFtsEntity(
    @PrimaryKey
    @ColumnInfo("rowid")
    val id: Int,
    val title: String,
    val writer: String?,
    val singer: String?,
    val content: String
)
