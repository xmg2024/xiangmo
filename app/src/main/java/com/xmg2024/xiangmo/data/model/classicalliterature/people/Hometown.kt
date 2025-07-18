/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.classicalliterature.people

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 人物家乡
 */
@Serializable
data class Hometown(
    @SerialName("RegionId")
    val regionId: String,
    @SerialName("Name")
    val name: String
)
