/*
 *  This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.database.entity.chinese

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chinese_antithetical_couplets")
data class AntitheticalCoupletEntity(
    @PrimaryKey
    val id: Int,
    val body: String,
    val description: String?,
    val image: String? = null
)
