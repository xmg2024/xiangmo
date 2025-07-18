/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.repository.classicalliterature

import com.hefengbao.jingmo.data.database.entity.classicalliterature.PeopleEntity
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    fun random(): Flow<PeopleEntity>
    fun get(id: Int): Flow<PeopleEntity>
    fun getByName(name: String): Flow<PeopleEntity>
    fun search(query: String): Flow<List<PeopleEntity>>
    fun recommendList(): List<String>
}