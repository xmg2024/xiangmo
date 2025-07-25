/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.SentenceCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.SentenceEntity
import com.xmg2024.xiangmo.data.repository.classicalliterature.SentenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SentenceIndexViewModel @Inject constructor(
    private val repository: SentenceRepository
) : ViewModel() {
    init {
        getRandom()
    }

    private val _sentenceEntity: MutableStateFlow<SentenceEntity?> = MutableStateFlow(null)
    val sentenceEntity: SharedFlow<SentenceEntity?> = _sentenceEntity

    fun getRandom() {
        viewModelScope.launch {
            repository.random().collectLatest { _sentenceEntity.value = it }
        }
    }

    private val _sentenceCollectionEntity: MutableStateFlow<SentenceCollectionEntity?> =
        MutableStateFlow(null)
    val sentenceCollectionEntity: SharedFlow<SentenceCollectionEntity?> =
        _sentenceCollectionEntity

    fun isCollected(id: Int) {
        viewModelScope.launch {
            repository.isCollect(id).collectLatest {
                _sentenceCollectionEntity.value = it
            }
        }
    }

    fun setUncollect(id: Int) {
        viewModelScope.launch {
            repository.uncollect(id)
        }
    }

    fun setCollect(id: Int) {
        viewModelScope.launch {
            repository.collect(SentenceCollectionEntity(id))
        }
    }
}