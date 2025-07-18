/*
 *  This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.database.entity.chinese

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.FtsOptions
import androidx.room.PrimaryKey

@Fts4(
    tokenizer = FtsOptions.TOKENIZER_ICU,
    contentEntity = ModernPoetryEntity::class
)
@Entity(tableName = "chinese_modern_poetry_fts")
data class ModernPoetryFtsEntity(
    @PrimaryKey
    @ColumnInfo("rowid")
    val id: Int,
    val content: String
)
