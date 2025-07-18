/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.china

import com.xmg2024.xiangmo.data.database.entity.china.WorldCulturalHeritageEntity
import kotlinx.serialization.Serializable

/**
 * 中国的世界文化遗产
 */
@Serializable
data class WorldCulturalHeritage(
    val id: Int,
    val name: String,
    val year: String,
    val year2: String?,
    val level: String,
    val address: String,
    val image: String,
    val content: String
)

fun WorldCulturalHeritage.asWorldCulturalHeritageEntity() = WorldCulturalHeritageEntity(
    id, name, year, year2, level, address, image, content
)
