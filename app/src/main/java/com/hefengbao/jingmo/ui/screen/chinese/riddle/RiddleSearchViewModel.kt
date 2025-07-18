/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.riddle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hefengbao.jingmo.data.database.entity.chinese.RiddleEntity
import com.hefengbao.jingmo.data.repository.chinese.RiddleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RiddleSearchViewModel @Inject constructor(
    private val riddleRepository: RiddleRepository
) : ViewModel() {

    private val _list: MutableStateFlow<List<RiddleEntity>> = MutableStateFlow(emptyList())
    val list: SharedFlow<List<RiddleEntity>> = _list
    fun search(query: String) {
        viewModelScope.launch {
            riddleRepository.search(query).collectLatest {
                _list.value = it
            }
        }
    }
}