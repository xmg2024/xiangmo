/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.database.entity.chinese

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "riddles")
data class RiddleEntity(
    @PrimaryKey
    val id: Int,
    val puzzle: String,
    val answer: String
)