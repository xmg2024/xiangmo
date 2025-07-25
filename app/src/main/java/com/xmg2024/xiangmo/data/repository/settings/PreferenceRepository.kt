/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.settings

import com.xmg2024.xiangmo.data.model.AppStatus
import com.xmg2024.xiangmo.data.model.DatasetVersion
import com.xmg2024.xiangmo.data.model.ReadStatus
import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {
    fun getDatasetStatus(): Flow<DatasetVersion>
    suspend fun setChinaWorldCultureHeritageVersion(version: Int)
    suspend fun setChineseAntitheticalVersion(version: Int)
    suspend fun setChineseDictionaryVersion(version: Int)
    suspend fun setChineseExpressionVersion(version: Int)
    suspend fun setChineseIdiomVersion(version: Int)
    suspend fun setChineseKnowledgeVersion(version: Int)
    suspend fun setChineseLyricVersion(version: Int)
    suspend fun setChineseModernPoetryVersion(version: Int)
    suspend fun setChineseProverbVersion(version: Int)
    suspend fun setChineseQuoteVersion(version: Int)
    suspend fun setChineseRiddleVersion(version: Int)
    suspend fun setChineseTongueTwisterVersion(version: Int)
    suspend fun setChineseWisecracksVersion(version: Int)
    suspend fun setClassicalLiteratureClassicPoemsVersion(version: Int)
    suspend fun setClassicalLiteraturePeopleVersion(version: Int)
    suspend fun setClassicalLiteratureSentenceVersion(version: Int)
    suspend fun setClassicalLiteratureWritingVersion(version: Int)
    suspend fun setClassicalLiteratureWritingCurrentPage(page: Int)
    suspend fun setClassicalLiteratureWritingCurrentCount(count: Int)

    fun getReadStatus(): Flow<ReadStatus>
    suspend fun setChineseAntitheticalCoupletLastReadId(id: Int)
    suspend fun setChineseKnowledgeLastReadId(id: Int)
    suspend fun setChineseIdiomLastReadId(id: Int)
    suspend fun setChineseModernPoetryLastReadId(id: Int)
    suspend fun setChineseQuoteLastReadId(id: Int)
    suspend fun setChineseRiddleLastReadId(id: Int)
    suspend fun setChineseTongueTwisterLastReadId(id: Int)
    suspend fun setChineseWisecrackLastReadId(id: Int)
    suspend fun setClassicalLiteratureClassicPoemLastReadId(id: Int)
    suspend fun setClassicalLiteraturePeopleLastReadId(id: Int)
    suspend fun setClassicalLiteratureSentenceLastReadId(id: Int)
    suspend fun setClassicalLiteratureWritingLastReadId(id: Int)

    fun getAppStatus(): Flow<AppStatus>
    suspend fun setCaptureTextColor(color: String)
    suspend fun setCaptureBackgroundColor(color: String)
    suspend fun setShowSyncDataTip(show: Boolean)
}