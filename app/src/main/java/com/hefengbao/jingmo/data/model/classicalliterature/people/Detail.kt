/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.model.classicalliterature.people

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 人物资料
 */
@Serializable
data class Detail(
    @SerialName("Book")
    val book: String,
    @SerialName("Section")
    val section: String?,
    @SerialName("Content")
    val content: String?,
    @SerialName("IsReview")
    val isReview: Boolean,
    @SerialName("ReferrenceUrls")
    val referenceUrls: List<String>?
)
