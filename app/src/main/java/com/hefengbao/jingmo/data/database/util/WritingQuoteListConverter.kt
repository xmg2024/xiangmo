/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.database.util

import androidx.room.TypeConverter
import com.hefengbao.jingmo.data.model.classicalliterature.writing.Quote
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class WritingQuoteListConverter {
    @TypeConverter
    fun listToString(list: List<Quote>?): String? {
        return if (list == null) {
            null
        } else {
            Json.encodeToString(list)
        }
    }

    @TypeConverter
    fun stringToList(str: String?): List<Quote>? {
        return if (str == null) {
            null
        } else {
            Json.decodeFromString(str)
        }
    }
}