/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.database.entity.chinese

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tongue_twisters")
data class TongueTwisterEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val content: String,
    val content2: String?,
)
