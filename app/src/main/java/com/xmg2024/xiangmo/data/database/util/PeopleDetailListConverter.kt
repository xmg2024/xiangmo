/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.database.util

import androidx.room.TypeConverter
import com.xmg2024.xiangmo.data.model.classicalliterature.people.Detail
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PeopleDetailListConverter {
    @TypeConverter
    fun listToString(list: List<Detail>?): String? {
        return if (list == null) {
            null
        } else {
            Json.encodeToString(list)
        }
    }

    @TypeConverter
    fun stringToList(str: String?): List<Detail>? {
        return if (str == null) {
            null
        } else {
            Json.decodeFromString(str)
        }
    }
}