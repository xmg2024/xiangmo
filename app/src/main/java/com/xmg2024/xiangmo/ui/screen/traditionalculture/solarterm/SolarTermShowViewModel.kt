/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.traditionalculture.solarterm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.xmg2024.xiangmo.data.model.traditionalculture.SolarTerm
import com.xmg2024.xiangmo.data.repository.traditionalculture.SolarTermsRepository
import com.xmg2024.xiangmo.ui.screen.traditionalculture.solarterm.nav.SolarTermShowArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class SolarTermShowViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: SolarTermsRepository
) : ViewModel() {
    private val args = SolarTermShowArgs(savedStateHandle)

    private val _solarTerm: MutableStateFlow<SolarTerm?> = MutableStateFlow(null)
    val solarTerm: SharedFlow<SolarTerm?> = _solarTerm

    init {
        _solarTerm.value = repository.list().first { args.solarTermId.toInt() == it.id }
    }
}