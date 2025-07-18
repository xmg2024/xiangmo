/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.idiom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomEntity
import com.xmg2024.xiangmo.data.repository.chinese.IdiomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IdiomIndexViewModel @Inject constructor(
    private val idiomRepository: IdiomRepository,
) : ViewModel() {
    init {
        getRandomIdiom()
    }

    private val _idiom: MutableStateFlow<IdiomEntity?> = MutableStateFlow(null)
    val idiom: SharedFlow<IdiomEntity?> = _idiom
    fun getRandomIdiom() {
        viewModelScope.launch {
            idiomRepository.random().collectLatest {
                _idiom.value = it
            }
        }
    }

    private val _idiomCollectionEntity: MutableStateFlow<IdiomCollectionEntity?> =
        MutableStateFlow(null)
    val idiomCollectionEntity: SharedFlow<IdiomCollectionEntity?> = _idiomCollectionEntity
    fun getIdiomCollectionEntity(id: Int) {
        viewModelScope.launch {
            idiomRepository.isCollect(id).collectLatest {
                _idiomCollectionEntity.value = it
            }
        }
    }

    fun collect(id: Int) {
        viewModelScope.launch {
            idiomRepository.collect(IdiomCollectionEntity(id))
        }
    }

    fun uncollect(id: Int) {
        viewModelScope.launch {
            idiomRepository.uncollect(id)
        }
    }
}