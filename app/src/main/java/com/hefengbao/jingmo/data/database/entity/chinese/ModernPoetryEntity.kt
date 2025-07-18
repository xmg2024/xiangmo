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
import androidx.room.PrimaryKey

@Entity(tableName = "chinese_modern_poetry")
data class ModernPoetryEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val author: String,
    val content: String,
    val zhu: String?,
    val yi: String?,
    val shang: String?,
    @ColumnInfo("author_info")
    val authorInfo: String?
)
