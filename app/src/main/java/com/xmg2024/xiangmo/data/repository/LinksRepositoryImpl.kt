/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository

import com.xmg2024.xiangmo.data.model.Link
import javax.inject.Inject

class LinksRepositoryImpl @Inject constructor() : LinksRepository {
    override fun list(): List<Link> {
        return listOf(
            Link(
                title = "智慧中小学",
                desc = "国家中小学智慧教育平台",
                url = "https://basic.smartedu.cn/"
            ),
            Link(
                title = "鲁迅博物馆",
                desc = "鲁迅说过这话吗？",
                url = "http://www.luxunmuseum.com.cn/cx/"
            ),
            Link(
                title = "中国大百科全书",
                desc = "第三版网络版",
                url = "https://www.zgbk.com"
            ),
        )
    }
}