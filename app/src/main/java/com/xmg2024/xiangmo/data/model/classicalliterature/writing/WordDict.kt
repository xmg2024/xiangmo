/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.classicalliterature.writing

import kotlinx.serialization.Serializable

@Serializable
data class WordDict(
    val Id: Int,
    val Text: String,
    val CountInPoem: Int,
    val Traditional: String? = null,
    val Explains: List<String>,
    val Categories: List<String>? = null,
    val Spells: String? = null,
    val ContainsUnknownSpell: Boolean
)
