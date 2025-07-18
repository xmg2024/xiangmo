/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.model.chinese

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IdiomWrapper(
    val data: List<Idiom>,
    @SerialName("next_page")
    val nextPage: String?
)
