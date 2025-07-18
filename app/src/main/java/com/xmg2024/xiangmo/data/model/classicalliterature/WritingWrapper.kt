/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.classicalliterature

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WritingWrapper(
    val data: List<Writing>,
    @SerialName("next_page")
    val nextPage: Int?
)
