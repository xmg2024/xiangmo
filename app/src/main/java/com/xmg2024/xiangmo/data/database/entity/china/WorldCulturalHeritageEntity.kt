/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.database.entity.china

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "china_world_cultural_heritage")
data class WorldCulturalHeritageEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val year: String,
    val year2: String?,
    val level: String,
    val address: String,
    val image: String,
    val content: String
)
