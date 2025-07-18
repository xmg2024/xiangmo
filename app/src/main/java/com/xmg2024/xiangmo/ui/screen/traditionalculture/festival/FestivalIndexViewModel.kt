/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.traditionalculture.festival

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.model.traditionalculture.Festival
import com.xmg2024.xiangmo.data.repository.traditionalculture.FestivalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FestivalIndexViewModel @Inject constructor(
    private val repository: FestivalRepository
) : ViewModel() {
    private val _festivals: MutableStateFlow<List<Festival>> = MutableStateFlow(emptyList())
    val festivals: SharedFlow<List<Festival>> = _festivals

    fun getList() {
        viewModelScope.launch {
            _festivals.value = repository.list()
        }
    }
}