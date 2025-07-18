/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.traditionalculture.solarterm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hefengbao.jingmo.data.model.traditionalculture.SolarTerm
import com.hefengbao.jingmo.data.repository.traditionalculture.SolarTermsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SolarTermIndexViewModel @Inject constructor(
    private val repository: SolarTermsRepository
) : ViewModel() {
    private val _solarTerms: MutableStateFlow<List<SolarTerm>> = MutableStateFlow(emptyList())
    val solarTerms: SharedFlow<List<SolarTerm>> = _solarTerms
    fun getList() {
        viewModelScope.launch {
            _solarTerms.value = repository.list()
        }
    }
}