/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp

@Composable
fun PrivacyRoute(
    onBackClick: () -> Unit
) {
    PrivacyScreen(onBackClick = onBackClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PrivacyScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "隐私政策")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val uriHandler = LocalUriHandler.current

            val content = """
                本应用使用腾讯 Bugly 提供的异常上报、运营统计功能，该 SDK 的隐私政策请查看：
            """.trimIndent()

            Text(text = content)

            val text = buildAnnotatedString {
                withLink(
                    LinkAnnotation.Url(
                        "https://privacy.qq.com/document/preview/fc748b3d96224fdb825ea79e132c1a56",
                        TextLinkStyles(style = SpanStyle(color = MaterialTheme.colorScheme.primary))
                    ) {
                        val url = (it as LinkAnnotation.Url).url
                        uriHandler.openUri(url)
                    }
                ) {
                    append("《Bugly SDK个人信息保护规则》")
                }
            }

            Text(
                text = text
            )

            Text(text = "除此之外，不收集存储任何用户信息。")
        }
    }
}