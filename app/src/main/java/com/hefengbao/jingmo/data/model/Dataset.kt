/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Dataset(
    val id: Int,
    val name: String,
    val count: Int,
    val version: Int
)