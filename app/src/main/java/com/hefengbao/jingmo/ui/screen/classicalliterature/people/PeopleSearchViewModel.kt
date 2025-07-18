/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.classicalliterature.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hefengbao.jingmo.data.database.entity.classicalliterature.PeopleEntity
import com.hefengbao.jingmo.data.repository.classicalliterature.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleSearchViewModel @Inject constructor(
    private val peopleRepository: PeopleRepository
) : ViewModel() {
    private val _recommendList: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val recommendList: SharedFlow<List<String>> = _recommendList

    init {
        _recommendList.value = peopleRepository.recommendList()
    }

    private val _searchResult: MutableStateFlow<List<PeopleEntity>> =
        MutableStateFlow(emptyList())
    val searchResult: SharedFlow<List<PeopleEntity>> = _searchResult

    fun search(string: String) {
        viewModelScope.launch {
            peopleRepository.search(string).collectLatest {
                _searchResult.value = it
            }
        }
    }
}