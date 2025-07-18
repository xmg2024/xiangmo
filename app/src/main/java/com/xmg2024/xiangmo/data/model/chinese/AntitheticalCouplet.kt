/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletEntity
import kotlinx.serialization.Serializable

@Serializable
data class AntitheticalCouplet(
    val id: Int,
    val body: String,
    val description: String?,
    val image: String? = null
)


fun AntitheticalCouplet.asAntitheticalCoupletEntity() = AntitheticalCoupletEntity(
    id, body, description, image
)
