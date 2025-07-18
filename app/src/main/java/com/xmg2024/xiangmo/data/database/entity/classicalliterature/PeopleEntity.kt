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
import com.xmg2024.xiangmo.data.model.classicalliterature.people.Alias
import com.xmg2024.xiangmo.data.model.classicalliterature.people.Detail
import com.xmg2024.xiangmo.data.model.classicalliterature.people.Hometown

@Entity(tableName = "people")
data class PeopleEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "birth_year")
    val birthYear: String?,
    @ColumnInfo(name = "birth_day")
    val birthDay: String?,
    @ColumnInfo(name = "death_year")
    val deathYear: String?,
    @ColumnInfo(name = "death_day")
    val deathDay: String?,
    val dynasty: String,
    val aliases: List<Alias>?,
    val titles: List<String>?,
    val hometown: List<Hometown>?,
    val details: List<Detail>?,
)
