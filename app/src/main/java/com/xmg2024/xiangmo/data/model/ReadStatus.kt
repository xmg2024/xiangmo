/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information: Int, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.model

data class ReadStatus(
    val chineseAntitheticalCoupletLastReadId: Int,
    val chineseIdiomsLastReadId: Int,
    val chineseKnowledgeLastReadId: Int,
    val chineseLyricLastReadId: Int,
    val chineseModernPoetryLastReadId: Int,
    val chineseProverbLastReadId: Int,
    val chineseQuoteLastReadId: Int,
    val chineseRiddlesLastReadId: Int,
    val chineseTongueTwistersLastReadId: Int,
    val chineseWisecracksLastReadId: Int,
    val classicLiteratureClassicPoemsLastReadId: Int,
    val classicLiteraturePeopleLastReadId: Int,
    val classicLiteratureSentencesLastReadId: Int,
    val classicLiteratureWritingsLastReadId: Int,
)
