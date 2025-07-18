/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.database.entity.chinese

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xmg2024.xiangmo.data.model.chinese.IdiomExample
import com.xmg2024.xiangmo.data.model.chinese.IdiomQuote
import com.xmg2024.xiangmo.data.model.chinese.IdiomSource

/**
 * 成语
 */
@Entity(tableName = "idioms")
data class IdiomEntity(
    @PrimaryKey
    val id: Int,
    val word: String,
    val pinyin: String,
    val abbr: String,
    val explanation: String?,
    @Embedded("source_")
    val source: IdiomSource?,
    @Embedded("quote_")
    val quote: IdiomQuote?,
    @Embedded("example_")
    val example: IdiomExample?,
    val similar: List<String>?,
    val opposite: List<String>?,
    val usage: String?,
    val story: List<String>?,
    val notice: String?,
)
