/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.database.util

import androidx.room.TypeConverter
import com.hefengbao.jingmo.data.model.classicalliterature.people.Alias
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PeopleAliasListConverter {
    @TypeConverter
    fun listToString(list: List<Alias>?): String? {
        return if (list == null) {
            null
        } else {
            Json.encodeToString(list)
        }
    }

    @TypeConverter
    fun stringToList(str: String?): List<Alias>? {
        return if (str == null) {
            null
        } else {
            Json.decodeFromString(str)
        }
    }
}