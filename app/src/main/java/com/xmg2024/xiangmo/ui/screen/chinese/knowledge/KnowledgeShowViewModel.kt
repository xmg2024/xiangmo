/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.knowledge

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeCollectionEntity
import com.xmg2024.xiangmo.data.repository.chinese.KnowledgeRepository
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.KnowledgeShowArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class KnowledgeShowViewModel @Inject constructor(
    private val repository: KnowledgeRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val args = KnowledgeShowArgs(savedStateHandle)
    private var id = MutableStateFlow(args.id.toInt())

    val knowledgeEntity = id.flatMapLatest { repository.get(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    val knowledgeCollectionEntity = id.flatMapLatest { repository.isCollect(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    fun collect(id: Int) {
        viewModelScope.launch {
            repository.collect(KnowledgeCollectionEntity(id))
        }
    }

    fun uncollect(id: Int) {
        viewModelScope.launch {
            repository.uncollect(id)
        }
    }
}