/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.character

import androidx.lifecycle.ViewModel
import com.xmg2024.xiangmo.data.repository.chinese.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterRadicalIndexViewModel @Inject constructor(
    repository: CharacterRepository
) : ViewModel() {
    val radicals = repository.radicals()
}