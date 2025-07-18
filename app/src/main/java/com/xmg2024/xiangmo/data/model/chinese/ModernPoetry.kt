/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.ModernPoetryEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModernPoetry(
    val id: Int,
    val title: String,
    val author: String,
    val content: String,
    val zhu: String?,
    val yi: String?,
    val shang: String?,
    @SerialName("author_info")
    val authorInfo: String?
)

fun ModernPoetry.asModernPoetryEntity() = ModernPoetryEntity(
    id, title, author, content, zhu, yi, shang, authorInfo
)