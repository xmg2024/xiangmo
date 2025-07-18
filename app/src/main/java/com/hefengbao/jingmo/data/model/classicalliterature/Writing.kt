/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.model.classicalliterature

import com.hefengbao.jingmo.data.database.entity.classicalliterature.WritingEntity
import com.hefengbao.jingmo.data.model.classicalliterature.writing.Allusion
import com.hefengbao.jingmo.data.model.classicalliterature.writing.Clause
import com.hefengbao.jingmo.data.model.classicalliterature.writing.Quote
import com.hefengbao.jingmo.data.model.classicalliterature.writing.Tune
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 诗文
 */
@Serializable
data class Writing(
    @SerialName("Id")
    val id: Int,
    @SerialName("GroupIndex")
    val groupIndex: Int?,
    @SerialName("Classes")
    val classes: List<String>?,
    @SerialName("Froms")
    val froms: List<String>?,
    @SerialName("Allusions")
    val allusions: List<Allusion>?,
    @SerialName("Pictures")
    val pictures: List<String>?,
    @SerialName("Dynasty")
    val dynasty: String,
    @SerialName("Author")
    val author: String,
    @SerialName("AuthorId")
    val authorId: Int?,
    @SerialName("AuthorDate")
    val authorDate: String?,
    @SerialName("AuthorYears")
    val authorYears: String?,
    @SerialName("AuthorPlace")
    val authorPlace: String?,
    @SerialName("Type")
    val type: String,
    @SerialName("TypeDetail")
    val typeDetail: String?,
    @SerialName("Rhyme")
    val rhyme: String?,
    @SerialName("FirstClauseRhyme")
    val firstClauseRhyme: String?,
    @SerialName("Title")
    val title: Clause,
    @SerialName("SubTitle")
    val subtitle: Clause?,
    @SerialName("TuneId")
    val tuneId: Tune?,
    @SerialName("Preface")
    val preface: String?,
    @SerialName("Clauses")
    val clauses: List<Clause>,
    @SerialName("Note")
    val note: String?,
    @SerialName("Comments")
    val comments: List<Quote>?
)

fun Writing.asWritingEntity() = WritingEntity(
    id = id,
    groupIndex = groupIndex,
    classes = classes,
    froms = froms,
    allusions = allusions,
    pictures = pictures,
    dynasty = dynasty,
    author = author,
    authorId = authorId,
    authorDate = authorDate,
    authorYears = authorYears,
    authorPlace = authorPlace,
    type = type,
    typeDetail = typeDetail,
    rhyme = type,
    firstClauseRhyme = firstClauseRhyme,
    title = title,
    subtitle = subtitle,
    tuneId = tuneId,
    preface = preface,
    clauses = clauses,
    note = note,
    comments = comments
)
