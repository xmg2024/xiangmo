/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.model.chinese

import com.hefengbao.jingmo.data.database.entity.chinese.LyricEntity
import kotlinx.serialization.Serializable

/**
 * 歌词
 */
@Serializable
data class Lyric(
    val id: Int,
    val title: String,
    val writer: String?,
    val singer: String?,
    val content: String
)

fun Lyric.asLyricEntity() = LyricEntity(
    id, title, writer, singer, content
)