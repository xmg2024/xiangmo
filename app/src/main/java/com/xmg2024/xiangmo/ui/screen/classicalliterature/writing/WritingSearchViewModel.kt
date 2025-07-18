/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.writing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.WritingEntity
import com.xmg2024.xiangmo.data.repository.classicalliterature.PeopleRepository
import com.xmg2024.xiangmo.data.repository.classicalliterature.WritingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class WritingSearchViewModel @Inject constructor(
    private val writingRepository: WritingRepository,
    peopleRepository: PeopleRepository,
) : ViewModel() {

    private val _recommendList: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val recommendList: SharedFlow<List<String>> = _recommendList

    init {
        _recommendList.value = peopleRepository.recommendList()
    }

    private val queryStateFlow = MutableStateFlow("")
    var type = "keyword"
    fun search(query: String, type: String) {
        queryStateFlow.value = query
        this.type = type
    }

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val writings: Flow<PagingData<WritingEntity>> = queryStateFlow.debounce(200)
        .distinctUntilChanged()
        .filter {
            return@filter it.isNotEmpty()
        }.flatMapLatest { query ->
            if (type == "keyword") {
                writingRepository.search(query)
            } else {
                writingRepository.searchByAuthor(query)
            }
        }.cachedIn(viewModelScope)
}