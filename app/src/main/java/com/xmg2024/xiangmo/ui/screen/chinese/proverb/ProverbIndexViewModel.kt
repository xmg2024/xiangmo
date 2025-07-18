/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.proverb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbEntity
import com.xmg2024.xiangmo.data.repository.chinese.ProverbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProverbIndexViewModel @Inject constructor(
    private val repository: ProverbRepository
) : ViewModel() {
    init {
        random()
    }

    private val _proverbEntity: MutableStateFlow<ProverbEntity?> = MutableStateFlow(null)
    val proverbEntity: SharedFlow<ProverbEntity?> = _proverbEntity

    fun random() {
        viewModelScope.launch {
            repository.random().collectLatest {
                _proverbEntity.value = it
            }
        }
    }

    private val _proverbCollectionEntity: MutableStateFlow<ProverbCollectionEntity?> =
        MutableStateFlow(null)
    val proverbCollectionEntity: SharedFlow<ProverbCollectionEntity?> = _proverbCollectionEntity

    fun isCollect(id: Int) {
        viewModelScope.launch {
            repository.isCollect(id).collectLatest {
                _proverbCollectionEntity.value = it
            }
        }
    }

    fun collect(id: Int) {
        viewModelScope.launch {
            repository.collect(ProverbCollectionEntity(id))
        }
    }

    fun uncollect(id: Int) {
        viewModelScope.launch {
            repository.uncollect(id)
        }
    }
}