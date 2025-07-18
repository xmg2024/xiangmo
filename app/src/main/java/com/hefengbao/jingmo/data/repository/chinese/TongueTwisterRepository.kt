/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.repository.chinese

import com.hefengbao.jingmo.data.database.entity.chinese.TongueTwisterEntity
import kotlinx.coroutines.flow.Flow

interface TongueTwisterRepository {
    fun get(id: Int): Flow<TongueTwisterEntity>
    fun getNextId(id: Int): Flow<Int?>
    fun getPrevId(id: Int): Flow<Int?>
    fun search(): Flow<List<TongueTwisterEntity>>
}