/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.settings

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryPinyinEntity
import com.xmg2024.xiangmo.data.datastore.DatasetPreference
import com.xmg2024.xiangmo.data.model.china.WorldCulturalHeritage
import com.xmg2024.xiangmo.data.model.china.asWorldCulturalHeritageEntity
import com.xmg2024.xiangmo.data.model.chinese.AntitheticalCouplet
import com.xmg2024.xiangmo.data.model.chinese.ChineseKnowledge
import com.xmg2024.xiangmo.data.model.chinese.ChineseWisecrack
import com.xmg2024.xiangmo.data.model.chinese.DictionaryWrapper
import com.xmg2024.xiangmo.data.model.chinese.ExpressionWrapper
import com.xmg2024.xiangmo.data.model.chinese.IdiomWrapper
import com.xmg2024.xiangmo.data.model.chinese.Lyric
import com.xmg2024.xiangmo.data.model.chinese.ModernPoetry
import com.xmg2024.xiangmo.data.model.chinese.Proverb
import com.xmg2024.xiangmo.data.model.chinese.Quote
import com.xmg2024.xiangmo.data.model.chinese.Riddle
import com.xmg2024.xiangmo.data.model.chinese.TongueTwister
import com.xmg2024.xiangmo.data.model.chinese.asAntitheticalCoupletEntity
import com.xmg2024.xiangmo.data.model.chinese.asChineseExpressionEntity
import com.xmg2024.xiangmo.data.model.chinese.asChineseKnowledgeEntity
import com.xmg2024.xiangmo.data.model.chinese.asChineseWisecrackEntity
import com.xmg2024.xiangmo.data.model.chinese.asDictionaryEntity
import com.xmg2024.xiangmo.data.model.chinese.asIdiomEntity
import com.xmg2024.xiangmo.data.model.chinese.asLyricEntity
import com.xmg2024.xiangmo.data.model.chinese.asModernPoetryEntity
import com.xmg2024.xiangmo.data.model.chinese.asProverbEntity
import com.xmg2024.xiangmo.data.model.chinese.asQuoteEntity
import com.xmg2024.xiangmo.data.model.chinese.asRiddleEntity
import com.xmg2024.xiangmo.data.model.chinese.asTongueTwisterEntity
import com.xmg2024.xiangmo.data.model.classicalliterature.ClassicPoem
import com.xmg2024.xiangmo.data.model.classicalliterature.PeopleWrapper
import com.xmg2024.xiangmo.data.model.classicalliterature.PoemSentence
import com.xmg2024.xiangmo.data.model.classicalliterature.WritingWrapper
import com.xmg2024.xiangmo.data.model.classicalliterature.asClassicPoemEntity
import com.xmg2024.xiangmo.data.model.classicalliterature.asPeopleEntity
import com.xmg2024.xiangmo.data.model.classicalliterature.asPoemSentenceEntity
import com.xmg2024.xiangmo.data.model.classicalliterature.asWritingEntity
import com.xmg2024.xiangmo.data.repository.settings.ImportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class ImportViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val json: Json,
    private val repository: ImportRepository,
    private val preference: DatasetPreference,
) : ViewModel() {
    private val chinaWorldCultureHeritageCount = 44
    private val chineseAntitheticalCoupletCount = 490
    private val chineseExpressionCount = 320349
    private val chineseKnowledgeCount = 465
    private val chineseModernPoetryCount = 62
    private val chineseProverbsCount = 964
    private val chineseQuotesCount = 362
    private val chineseWisecracksCount = 14026
    private val chineseDictionaryCount = 20552
    private val chineseIdiomsCount = 49639
    private val chineseLyricCount = 499
    private val chineseRiddlesCount = 42446
    private val chineseTongueTwistersCount = 45
    private val classicalLiteratureClassicPoemCount = 955
    private val classicalLiteraturePeopleCount = 126830
    private val classicalLiteratureSentencesCount = 10000
    private val classicalLiteratureWritingsCount = 1430340

    val chinaWorldCultureHeritageRatio =
        repository.chinaChinaWorldCultureHeritageTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chinaWorldCultureHeritageCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _chinaWorldCultureHeritageStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chinaWorldCultureHeritageStatus: SharedFlow<ImportStatus<Any>> =
        _chinaWorldCultureHeritageStatus

    fun chinaWorldCultureHeritage(uris: List<Uri>) {
        viewModelScope.launch {
            _chinaWorldCultureHeritageStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<WorldCulturalHeritage>>(readTextFromUri(it))
                    .forEach { worldCulturalHeritage ->
                        repository.insertChinaWorldCultureHeritage(worldCulturalHeritage.asWorldCulturalHeritageEntity())
                    }
            }
            _chinaWorldCultureHeritageStatus.value = ImportStatus.Finish
        }
    }

    fun clearChinaWorldCultureHeritage() {
        viewModelScope.launch {
            repository.clearChinaWorldCultureHeritage()
        }
    }

    val chineseAntitheticalCoupletRatio =
        repository.chineseAntitheticalCoupletTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseAntitheticalCoupletCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _chineseAntitheticalCoupletStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseAntitheticalCoupletStatus: SharedFlow<ImportStatus<Any>> =
        _chineseAntitheticalCoupletStatus

    fun chineseAntitheticalCouplet(uris: List<Uri>) {
        viewModelScope.launch {
            _chineseAntitheticalCoupletStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<AntitheticalCouplet>>(readTextFromUri(it))
                    .forEach { antitheticalCouplet ->
                        repository.insertChineseAntitheticalCouplet(antitheticalCouplet.asAntitheticalCoupletEntity())
                    }
            }
            _chineseAntitheticalCoupletStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseAntitheticalCouplet() {
        viewModelScope.launch {
            repository.clearChineseAntitheticalCouplet()
        }
    }

    val chineseExpressionRatio =
        repository.chineseExpressionTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseExpressionCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _chineseExpressionStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseExpressionStatus: SharedFlow<ImportStatus<Any>> = _chineseExpressionStatus
    fun chineseExpression(uris: List<Uri>) {
        viewModelScope.launch {
            _chineseExpressionStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<ExpressionWrapper>(readTextFromUri(it))
                    .data
                    .forEach { chineseExpression ->
                        repository.insertChineseExpression(chineseExpression.asChineseExpressionEntity())
                    }
            }
            _chineseExpressionStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseExpressions() {
        viewModelScope.launch {
            repository.clearChineseExpressions()
            preference.setChineseExpressionVersion(0)
        }
    }

    val chineseModernPoetryRatio =
        repository.chineseModernPoetryTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseModernPoetryCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _chineseModernPoetryStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseModernPoetryStatus: SharedFlow<ImportStatus<Any>> = _chineseModernPoetryStatus
    fun chineseModernPoetry(uris: List<Uri>) {
        viewModelScope.launch {
            _chineseModernPoetryStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<ModernPoetry>>(readTextFromUri(it))
                    .forEach { modernPoetry ->
                        repository.insertChineseModernPoetry(modernPoetry.asModernPoetryEntity())
                    }
            }
            _chineseModernPoetryStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseModernPoetry() {
        viewModelScope.launch {
            repository.clearChineseModernPoetry()
            preference.setChineseModernPoetryVersion(0)
        }
    }

    val chineseProverbRatio =
        repository.chineseProverbTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseProverbsCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _chineseProversStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseProverbStatus: SharedFlow<ImportStatus<Any>> = _chineseProversStatus
    fun chineseProverb(uris: List<Uri>) {
        viewModelScope.launch {
            _chineseProversStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<Proverb>>(readTextFromUri(it))
                    .forEach { proverb ->
                        repository.insertChineseProverb(proverb.asProverbEntity())
                    }
            }
            _chineseProversStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseProverbs() {
        viewModelScope.launch {
            repository.clearChineseProverbs()
            preference.setChineseProverbVersion(0)
        }
    }

    val chineseQuotesRatio =
        repository.chineseQuoteTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseQuotesCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _chineseQuotesStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseQuotesStatus: SharedFlow<ImportStatus<Any>> = _chineseQuotesStatus
    fun chineseQuotes(uris: List<Uri>) {
        viewModelScope.launch {
            _chineseQuotesStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<Quote>>(readTextFromUri(it))
                    .forEach { quote ->
                        repository.insertChineseQuote(quote.asQuoteEntity())
                    }
            }
            _chineseQuotesStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseQuotes() {
        viewModelScope.launch {
            repository.clearChineseQuotes()
            preference.setChineseQuoteVersion(0)
        }
    }

    val chineseWisecrackRatio =
        repository.chineseWisecrackTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseWisecracksCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _chineseWisecrackStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseWisecrackStatus: SharedFlow<ImportStatus<Any>> = _chineseWisecrackStatus
    fun chineseWisecrack(uris: List<Uri>) {
        viewModelScope.launch {
            _chineseWisecrackStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<ChineseWisecrack>>(readTextFromUri(it))
                    .forEach { chineseWisecrack ->
                        repository.insertChineseWisecrack(chineseWisecrack.asChineseWisecrackEntity())
                    }

            }
            _chineseWisecrackStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseWisecracks() {
        viewModelScope.launch {
            repository.clearChineseWisecracks()
            preference.setChineseWisecrackVersion(0)
        }
    }

    val chineseKnowledgeRatio =
        repository.chineseKnowledgeTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseKnowledgeCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _chineseKnowledgeStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseKnowledgeStatus: SharedFlow<ImportStatus<Any>> = _chineseKnowledgeStatus
    fun chineseKnowledge(uris: List<Uri>) {
        viewModelScope.launch {
            _chineseKnowledgeStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<ChineseKnowledge>>(readTextFromUri(it))
                    .forEach { chineseKnowledge ->
                        repository.insertChineseKnowledge(chineseKnowledge.asChineseKnowledgeEntity())
                    }
            }
            _chineseKnowledgeStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseKnowledge() {
        viewModelScope.launch {
            repository.clearChineseKnowledge()
            preference.setChineseKnowledgeVersion(0)
        }
    }

    val chineseRiddleRatio =
        repository.chineseRiddleTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseRiddlesCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _chineseRiddleStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseRiddleStatus: SharedFlow<ImportStatus<Any>> = _chineseRiddleStatus
    fun chineseRiddle(uris: List<Uri>) {
        viewModelScope.launch {
            _chineseRiddleStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<Riddle>>(readTextFromUri(it))
                    .forEach { riddle ->
                        repository.insertChineseRiddle(riddle.asRiddleEntity())
                    }
            }
            _chineseRiddleStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseRiddle() {
        viewModelScope.launch {
            repository.clearChineseRiddles()
            preference.setChineseRiddleVersion(0)
        }
    }

    val classicPoemsRatio =
        repository.classicalLiteratureClassicPoemTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / classicalLiteratureClassicPoemCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _classicPoemsStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val classicPoemsStatus: SharedFlow<ImportStatus<Any>> = _classicPoemsStatus
    fun classicPoems(uris: List<Uri>) {
        viewModelScope.launch {
            _classicPoemsStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<ClassicPoem>>(readTextFromUri(it)).forEach { poem ->
                    repository.insertClassicalLiteratureClassicPoems(poem.asClassicPoemEntity())
                }
            }
            _classicPoemsStatus.value = ImportStatus.Finish
        }
    }

    fun clearClassicalLiteratureClassicPoems() {
        viewModelScope.launch {
            repository.clearClassicalLiteratureClassicPoems()
            preference.setClassicalLiteratureClassicPoemVersion(0)
        }
    }

    val chineseDictionaryRatio =
        repository.chineseDictionaryTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseDictionaryCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _dictionaryStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseDictionaryStatus: SharedFlow<ImportStatus<Any>> = _dictionaryStatus
    fun dictionary(uris: List<Uri>) {
        viewModelScope.launch {
            _dictionaryStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<DictionaryWrapper>(readTextFromUri(it)).data.forEach { dictionary ->
                    repository.insertChineseDictionary(dictionary.asDictionaryEntity())
                    dictionary.pinyin2?.map { pinyin ->
                        repository.insertChineseDictionaryPinyin(
                            DictionaryPinyinEntity(
                                dictionaryId = dictionary.id,
                                pinyin = pinyin,
                            )
                        )
                    }
                }
            }
            _dictionaryStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseDictionaries() {
        viewModelScope.launch {
            repository.clearChineseDictionaries()
            preference.setChineseDictionaryVersion(0)
        }
    }

    val chineseIdiomsRatio = repository.chineseIdiomTotal().distinctUntilChanged().flatMapLatest {
        MutableStateFlow(it.toFloat() / chineseIdiomsCount)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = 0f
    )
    private val _idiomStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseIdiomStatus: SharedFlow<ImportStatus<Any>> = _idiomStatus
    fun idioms(uris: List<Uri>) {
        viewModelScope.launch {
            _idiomStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<IdiomWrapper>(readTextFromUri(it)).data.forEach { idiom ->
                    repository.insertChineseIdiom(idiom.asIdiomEntity())
                }
            }
            _idiomStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseIdioms() {
        viewModelScope.launch {
            repository.clearChineseIdioms()
            preference.setChineseIdiomVersion(0)
        }
    }

    val chineseLyricRatio = repository.chineseLyricTotal().distinctUntilChanged().flatMapLatest {
        MutableStateFlow(it.toFloat() / chineseLyricCount)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = 0f
    )
    private val _lyricStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseLyricStatus: SharedFlow<ImportStatus<Any>> = _lyricStatus
    fun lyrics(uris: List<Uri>) {
        viewModelScope.launch {
            _lyricStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<Lyric>>(readTextFromUri(it)).forEach { lyric ->
                    repository.insertChineseLyric(lyric.asLyricEntity())
                }
            }
            _lyricStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseLyrics() {
        viewModelScope.launch {
            repository.clearChineseLyrics()
            preference.setChineseLyricVersion(0)
        }
    }

    val peopleRatio =
        repository.classicalLiteraturePeopleTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / classicalLiteraturePeopleCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _peopleStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val peopleStatus: SharedFlow<ImportStatus<Any>> = _peopleStatus
    fun people(uris: List<Uri>) {
        viewModelScope.launch {
            _peopleStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<PeopleWrapper>(readTextFromUri(it)).data.forEach { people ->
                    repository.insertClassicalLiteraturePeople(people.asPeopleEntity())
                }
            }
            _peopleStatus.value = ImportStatus.Finish
        }
    }

    fun clearClassicalLiteraturePeople() {
        viewModelScope.launch {
            repository.clearClassicalLiteraturePeople()
            preference.setClassicalLiteraturePeopleVersion(0)
        }
    }

    val poemSentencesRatio =
        repository.classicalLiteratureSentenceTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / classicalLiteratureSentencesCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _poemSentenceStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val poemSentenceStatus: SharedFlow<ImportStatus<Any>> = _poemSentenceStatus
    fun poemSentences(uris: List<Uri>) {
        viewModelScope.launch {
            _peopleStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<PoemSentence>>(readTextFromUri(it))
                    .forEach { poemSentence ->
                        repository.insertClassicalLiteratureSentence(poemSentence.asPoemSentenceEntity())
                    }
            }
            _peopleStatus.value = ImportStatus.Finish
        }
    }

    fun clearClassicalLiteratureSentence() {
        viewModelScope.launch {
            repository.clearClassicalLiteratureSentence()
            preference.setClassicalLiteratureSentenceVersion(0)
        }
    }

    val chineseTongueTwistersRatio =
        repository.chineseTongueTwistersTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / chineseTongueTwistersCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _tongueTwisterStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val chineseTongueTwisterStatus: SharedFlow<ImportStatus<Any>> = _tongueTwisterStatus
    fun tongueTwisters(uris: List<Uri>) {
        viewModelScope.launch {
            _tongueTwisterStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<List<TongueTwister>>(readTextFromUri(it))
                    .forEach { tongueTwister ->
                        repository.insertChineseTongueTwister(tongueTwister.asTongueTwisterEntity())
                    }
            }
            _tongueTwisterStatus.value = ImportStatus.Finish
        }
    }

    fun clearChineseTongueTwisters() {
        viewModelScope.launch {
            repository.clearChineseTongueTwisters()
            preference.setChineseTongueTwisterVersion(0)
        }
    }

    val writingsRatio =
        repository.classicalLiteratureWritingTotal().distinctUntilChanged().flatMapLatest {
            MutableStateFlow(it.toFloat() / classicalLiteratureWritingsCount)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0f
        )
    private val _writingStatus: MutableStateFlow<ImportStatus<Any>> =
        MutableStateFlow(ImportStatus.Finish)
    val writingStatus: SharedFlow<ImportStatus<Any>> = _writingStatus
    fun writings(uris: List<Uri>) {
        viewModelScope.launch {
            _writingStatus.value = ImportStatus.Loading
            uris.forEach {
                json.decodeFromString<WritingWrapper>(readTextFromUri(it)).data.forEach { writing ->
                    repository.insertClassicalLiteratureWriting(writing.asWritingEntity())
                }
            }
            _writingStatus.value = ImportStatus.Finish
        }
    }

    fun clearClassicalLiteratureWritings() {
        viewModelScope.launch {
            repository.clearClassicalLiteratureWritings()
            preference.setClassicalLiteratureWritingVersion(0)
            preference.setClassicalLiteratureWritingCurrentCount(0)
            preference.setClassicalLiteratureWritingCurrentPage(0)
        }
    }

    private val contentResolver = context.contentResolver

    @Throws(IOException::class)
    private fun readTextFromUri(uri: Uri): String {
        val stringBuilder = StringBuilder()
        contentResolver.openInputStream(uri)?.use { inputStream ->
            BufferedReader(InputStreamReader(inputStream)).use { reader ->
                var line: String? = reader.readLine()
                while (line != null) {
                    stringBuilder.append(line)
                    line = reader.readLine()
                }
            }
            inputStream.close()
        }
        return stringBuilder.toString()
    }
}

sealed interface ImportStatus<out T> {
    data object Finish : ImportStatus<Nothing>
    data object Loading : ImportStatus<Nothing>
}