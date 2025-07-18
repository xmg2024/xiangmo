/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.TongueTwisterEntity
import kotlinx.serialization.Serializable

/**
 * 绕口令
 */
@Serializable
data class TongueTwister(
    val id: Int,
    val title: String,
    val content: String,
    val content2: String?,
)

fun TongueTwister.asTongueTwisterEntity() = TongueTwisterEntity(
    id = id,
    title = title,
    content = content,
    content2 = content2,
)
