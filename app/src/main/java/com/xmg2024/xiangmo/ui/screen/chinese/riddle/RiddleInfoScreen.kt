/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.riddle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun RiddleInfoRoute(
    onBackClick: () -> Unit
) {
    RiddleInfoScreen(
        onBackClick = onBackClick
    )
}

@Composable
private fun RiddleInfoScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {

    SimpleScaffold(
        onBackClick = onBackClick,
        title = "谜语知识"
    ) {
        LazyColumn(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = """
                        谜格，就是要猜谜的人，按照规定的格式，把谜底字的位置、读音、偏旁进行一番加工处理后，来扣合谜面。这是因灯谜向着更高难度的方面发展而创造的。
                        谜格创始于明代。明末扬州马仓山首创了《广陵十八格》后，历代迷格又不断有所创新，多至一百多个格。这其中有不少是重复或类似的格，也有一些因过于深奥而不受欢迎的格。
                    """.trimIndent()
                )
            }
            itemsIndexed(
                items = mige
            ) { index: Int, item: Mige ->
                Card {
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(text = item.title, style = MaterialTheme.typography.titleMedium)
                        Text(text = item.desc)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun InfoScreenPreview(modifier: Modifier = Modifier) {
    RiddleInfoScreen {

    }
}

/**
 * 迷格
 */
private data class Mige(
    val title: String,
    val desc: String
)

private val mige = listOf(
    Mige(
        title = "曹娥格",
        desc = """
                别名：碑阴格。它的构成方法是用化形衍义得出，谜底中的每个字都要左右分读（或上下分读），以扣合其谜面。例如：
                天作丝丝道难行，含泪挥手送君行 (打一鸟名)
                谜底：露禽
                猜时，谜底应读作"雨路人离"才扣合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "虾须格",
        desc = """
                别名：鸦髻，丫髻。谜格即由形似虾须而得名，谜底需两字以上，第一字应左右分开，成为两字，从而解释谜面。例如：
                巾帼英雄传 (打一鲁迅作品)
                谜底:《好的故事》
                谜底第一个字拆为"女子"。
            """.trimIndent()
    ),
    Mige(
        title = "解领格",
        desc = """
                别名：鸳肩格。谜底须四字以上，谜底的第二个字左右分开成两个字，连上下文读切合谜面。例如：
                江淮河汉常作客 (打一成语)
                谜底：四海为家
                将第二个字拆为"水每"连上下文为"四水每为家"，切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "展翼格",
        desc = """
                别名：剖腹、双胎、振翼。谜底需三个以上的单数字，中间一字左右分开作两字读。例如：
                阴阳历合订本 (打一文件名称)
                谜底:说明书
                将中间"明"字左右分开成"日月"，切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "蝇头格",
        desc = """
                别名：垫巾格。谜底需两字以上，第一字上下分开作两字读，形若蝇头，扣合谜面。例如：
                每晚休息 (打一毛泽东词句)
                谜底：多少事
                将"多"分读为"夕夕"。    
            """.trimIndent()
    ),
    Mige(
        title = "蜓尾格",
        desc = """
                别名垫足格：谜底需两字以上，末一字上下分开成两字读。例如：
                气象简报 (打一红楼梦人物)
                谜底:晴雯
                将"雯"字上下分开成"雨文"，即"晴雨文"。
            """.trimIndent()
    ),
    Mige(
        title = "燕尾格",
        desc = """
                别名：燕剪、鱼尾。谜底需两字以上，末一字左右分开作两字读。例如：
                久旱 (打一地名)
                谜底：长沙
                将"沙"左右分开为"水少"，即"长水少"。    
            """.trimIndent()
    ),
    Mige(
        title = "蜂腰格",
        desc = """
                别名：中分格、断绵格。谜底须三字以上的单数词句，但中间一字要上下分开作两字读。例如：
                隆中决策 （打一地名）
                谜底:三岔河
                将"岔"分读为"分山"，即"三分山河"，典出诸葛亮的"隆中对"。
            """.trimIndent()
    ),
    Mige(
        title = "碎锦格",
        desc = """
                别名：堆金格、破镜格、集锦格。谜底需两字以上的词句，每字分作二或三字，可不拘上下左右。例如：
                冠盖满京华(打一古人)
                谜底：管仲
                谜底可拆为"个个官中人"。
            """.trimIndent()
    ),
    Mige(
        title = "离合格",
        desc = """
                别名：金钟格。谜底需两字以上的词句，字字皆可拆为两字或三字，然后将谜底中每一字分读一次后，再读一次。或先读本字，再读分读。也可使以字化三、四字读。句底两字成六或七或八个字，方切合谜面。例如：
                卓文君夜奔相如 (打一词汇)
                谜底:好逑
                将"好"分为"女子"，"逑"分为"求之"，即"女子好逑，求之"。
            """.trimIndent()
    ),
    Mige(
        title = "鹭胫格",
        desc = """
                谜底需四字以上，倒数第二个字作左右分开成两字，连上文读切合谜面。例如：
                医头风请陈琳草檄(打一成语)
                谜底：治病救人
                将"救"分读为"求文"，即"治病请文人"。
            """.trimIndent()
    ),
    Mige(
        title = "宝塔格",
        desc = """
                因谜底的字相间分读，形似宝塔式，故有此名。谜底需有四字以上的双数词句，谜底之二、四、六、八等逢双数字，拆作左右两字读。例如：
                卿卿 (打《诗经》一句)
                谜底:如何如何
                将"何"分为"可人"，即"如可人，如可人"。
            """.trimIndent()
    ),
    Mige(
        title = "鼎足格",
        desc = """
                别名：蟾足格。谜底需两字以上，最后一字分读成三个字。例如：
                欧美民族 (打一春秋人物)
                谜底：西施
                将"施"分读为"方人也"，即"西方人也"。
            """.trimIndent()
    ),
    Mige(
        title = "筠垫格",
        desc = """
                谜底需两字以上，字字按上下分作两字读。例如：
                农夫心内如汤煮 (打一水果名)
                谜底:香蕉
                将"香"分为"禾日"，"蕉"分为"草焦"，即"禾日草焦"。
            """.trimIndent()
    ),
    Mige(
        title = "筠稍格",
        desc = """
                谜底需两字以上，字字均分为左右两部，一字作两字读。例如：
                建筑家 (打一中草药名)
                谜底：杜仲
                分开读为"土木中人"。
            """.trimIndent()
    ),
    Mige(
        title = "折巾格",
        desc = """
                别名：侧帽格。谜底需两字以上，即将谜底第一格字左右分开，成为两字，只用其半边字连下文读切合谜面。例如：
                南甜，北辣，东咸，西酸。(打一成语)
                谜底:饶有风味
                将谜底"饶"去"尧"存"食"，成为"食有风味"。
            """.trimIndent()
    ),
    Mige(
        title = "徐妃格",
        desc = """
                别名：半妆格。谜底需两字以上同偏旁的字，去掉相同偏旁后切合谜面。例如：
                俱往矣 (打一鸟名)
                谜底：鸺鹠
                去掉谜底各字相同的偏旁，读作"休留"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "半面格",
        desc = """
                别名：玉璜格。谜底需两字以上，每字均可左右或上下分开，任取其一半来读。例如：
                横竖横 (打一《聊斋志异》篇名)
                谜底:江城
                将谜底半读为"工成"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "折翼格",
        desc = """
                别名：曲袖、楚腰、瘦腰。谜底需三字以上的但数词句，将中央一字左右分开成两个字，取其一半，连下文读切合谜面。例如：
                皆大欢喜(打一曲牌名)
                谜底：众仙乐
                将"仙"分开取"人"，读作"众人乐"。
            """.trimIndent()
    ),
    Mige(
        title = "折屐格",
        desc = """
                谜底需两字以上，末字是上下结构的字，只取上半截的字连上下文读切合谜面。例如：
                知 (打一《水浒》绰号)
                谜底:智多星
                将"星"取"日"，读成"智多日"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "只履格",
        desc = """
                别名：跻履格。谜底需两字以上，末一字要左右分开成两个字，取其一半取一半，连上下文读切合谜面。例如：
                千秋岭 (打一曲牌名)
                谜底：长寿仙
                将"仙"去"山"，即"长寿山"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "放踵格",
        desc = """
                别名：摘底格。谜底需两字以上，每字的下半截，皆是同一部首的字，射中后排除谜底中每一字的下半截，余下的上半截切合谜面。例如：
                举旗成队 (打一常用词)
                谜底:热烈
                去掉下半部为"执列"。
            """.trimIndent()
    ),
    Mige(
        title = "摩顶格",
        desc = """
                谜底需两字以上，谜底的第一个字分成上下两个字，取下半截的字连上下文读切合谜面。例如：
                楚 (打一成语)
                谜底：覆巢之下无完卵
                第一个字"覆"取下半部，有"双"的意思，"巢之下"为"木"，双木为"林"，"无完卵"是"蛋"的一部分，与"林"组成"楚"，切合谜面
            """.trimIndent()
    ),
    Mige(
        title = "蝉蜕格",
        desc = """
                谜底需具有口、门、行、几等相同外围部首的两字，取其相同的外围部首后切合谜面。例如：
                千分比 (打一词汇)
                谜底:田园
                取其外围后的"十元"，扣合"千分"之一，切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "摘遍格",
        desc = """
                别名：摘顶格。谜底需两字以上同盖头部首的词句，猜中后排除每字的同盖头部首，只读下半截的字。例如：
                一年最热的时候 (打一中草药名)
                谜底：茯苓
                去掉同盖头后为"伏令"，切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "同心格",
        desc = """
                别名：同心结、鸳鸯带。谜底需用四个以上的双数字，将谜底最中间的两个字，作一字读。例如：
                不交真正朋友 (打一成语)
                谜底:与人为善
                将"人为"何为"伪"，读"与伪善"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "合璧格",
        desc = """
                谜底通常用四字组成，每两个字并作一个字读。例如：
                早晨 (打一成语)
                谜底：一日千里
                "一日"和为"旦"，"千里"合为"重"，读"旦重"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "比目格",
        desc = """
                别名：叠绵、合纵格。谜底需三字以上，将第一字、第二字并作一个字，连下文读切合谜面。例如：
                相见再说 (打一成语)
                谜底:人云亦云
                将"人云"合为"会"，读成"会亦云"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "并蒂格",
        desc = """
                别名：并足格、连横格。谜底需三字以上，将最后两字合并成一个字，连上读切合谜面。例如：
                风雨荷塘 (打郑板桥词一句)
                谜底：荷叶乱翻秋水
                将"秋水"合为"湫"，即"荷叶乱翻湫"切合谜面。"湫"即"水"。
            """.trimIndent()
    ),
    Mige(
        title = "梨花格",
        desc = """
                别名：梅花格、谐音格、全白格、全谐格。谜底需用两字以上，字字谐音。例如：
                测绘战士 (打一中国现代作家)
                谜底:梁斌
                "测绘"解为"量"，"战士"解为"兵"，读为"量兵"，与谜底谐音。
            """.trimIndent()
    ),
    Mige(
        title = "粉底格",
        desc = """
                别名：白足格、素履格、立雪格、踏雪格、履霜格。谜底需两字以上，末一字用谐音代替解释谜面。例如：
                新闻纪录 (打一体育活动项目)
                谜底：广播操
                "操"与"抄"谐音。
            """.trimIndent()
    ),
    Mige(
        title = "白头格",
        desc = """
                别名：白首格、皓首格、粉头格、雪帽格、寿星格、素冠格、冠玉格、望月格等。谜底需两字以上，第一字用谐音来代替解释谜面。例如：
                望梅止渴(打一地名)
                谜底:响水
                "响"与"想"谐音。
            """.trimIndent()
    ),
    Mige(
        title = "玉颈格",
        desc = """
                别名：粉颈格。谜底需四字以上，第二字谐音成别义。例如：
                免刑 (打一成语)
                谜底：不乏其人
                "乏"与"罚"谐音。
            """.trimIndent()
    ),
    Mige(
        title = "粉腿格",
        desc = """
                别名：鹤腾、素胫。谜底需四字以上，谜底倒数第二个字用谐音代替解释谜面。例如：
                乡村四月闲人少 (打二节令名)
                谜底:夏至、芒种
                "芒"与"忙"谐音切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "素心格",
        desc = """
                谜底需三字以上单数词句，将谜底中央一字谐音作别义解释谜面。例如：
                幼儿园 (打一京剧名)
                谜底：群英会
                "英"与"婴"谐音切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "朱履格",
        desc = """
                谜底需三字以上，唯末一字正读正义，其他字都要谐读作别义解释谜面。例如：
                一唱雄鸡天下白(打一明代书画家)
                谜底:文征明
                "文征"谐读为"闻正"，即"闻正明"。
            """.trimIndent()
    ),
    Mige(
        title = "围棋格",
        desc = """
                谜底需四字以上的双数字，以上半截字正读正义，下半截谐读作别义，或相反，切合谜面。例如：
                未谙姑食性，先遣小姑尝 (打一成语)
                谜底：心腹之患
                将谜底"心腹"谐读为"新妇"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "榴裙格",
        desc = """
                别名：烧尾格。谜底需四字以上，唯倒数第二字读正义，其他字都谐读作别义切合谜面。例如：
                父亲常在动脑筋 (打一国名)
                谜底:巴巴多斯
                "巴巴"谐读为"爸爸"，"斯"谐读为"思"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "丹心格",
        desc = """
                别名：丹枕格、红中格。谜底需三字以上单数字，唯最中央一字读正义，其他字谐读作别义切合谜面。例如：
                一群老鼠如绳套(打一外国人名)
                谜底：杜勒斯
                "杜"谐读为"都"，"斯"谐读为"死"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "鹤顶格",
        desc = """
                别名：朱颜格。谜底需三字以上，为第一字读正义，其它字皆谐读作别义切合谜面。例如：
                两岸垂杨柳，波心织绮纹 (打一成语)
                谜底:风声鹤唳
                将"声鹤唳"谐读为"生河里"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "赤颈格",
        desc = """
                谜底需四字以上，为第二字正读正义，其它字皆谐读作别义切合谜面。例如：
                伤心细问儿夫病 (打一成语)
                谜底：杯盘狼藉
                "杯"谐读为"悲"，"狼藉"谐读为"郎疾"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "还豕格",
        desc = """
                别名：乌焉、鲁鱼格。谜底需二字以上，故意将所有字别读切合谜面。例如：
                重峦叠嶂 (打一昆虫名)
                谜底:蜜蜂
                将谜底"蜜蜂"别读为"密峰"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "乌纱格",
        desc = """
                谜底需两字以上，将谜底第一字形似别读为它字。例如：
                坐以待旦(打一红楼梦人物)
                谜底：侯晓明
                将"侯"字别读为"候"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "青领格",
        desc = """
                谜底需四字以上，将第二字作形似相近的字，别读成它字。例如：
                独木撑天 (打一成语)
                谜底:一技之长
                将"技"别读为"枝"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "黑胸格",
        desc = """
                谜底需三字以上的单数字，将最中央的字作形似相近的字别读。例如：
                马后炮(打一《红岩》人名)
                谜底：车耀先
                将"耀"别读为"跃"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "黑带格",
        desc = """
                谜底需四字以上，将倒数第二字作形似别读。例如：
                鸿 (打一电影片名)
                谜底:突破乌江
                将"乌"别解为"鸟"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "皂靴格",
        desc = """
                谜底需两字以上，末一字形似别读切合谜面。例如：
                梁上君子(打一成语)
                谜底：登高作赋
                将"赋"别解为"贼"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "系铃格",
        desc = """
                谜底需两字以上，将谜底中某一字，当读本音却故意读作另外的音切合谜面。例如：
                珠穆朗玛峰(打一成语)
                谜底:藏之名山
                "藏"本读（cang），这里却读作西藏的"zang"，切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "解铃格",
        desc = """
                谜底需两字以上，格式和系铃格相反。例如：
                你俩行驶都违章 (打一象棋术语)
                谜底：双车错
                谜底"车"应读（ju），但为切合谜面应读（che）。
            """.trimIndent()
    ),
    Mige(
        title = "移铃格",
        desc = """
                谜底中某一字本应圈读的而解读本音，另一字本读本音的却读圈读。例如：
                为令尹无喜色 (打《礼记》一句)
                谜底:县而不乐
                将"县"（xuan）解铃为（xian），将"乐"（yue）系铃为（le）切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "庐山格",
        desc = """
                谜底需两字以上，将某一字本作今译释的故作古义释。例如：
                欲济无舟楫 (打一物理名词)
                谜底：难度
                "度"本作"程度"释，今返其原与"渡"相通，作古义释切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "秋千格",
        desc = """
                别名：转珠格、颉颃格。谜底限定为两个字，颠倒后切合谜面。例如：
                大家看 (打一常用语)
                谜底:观众
                将"观众"颠倒为"众观（众=大家，观=看）"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "卷帘格",
        desc = """
                别名：倒读格。谜底需三字以上，颠倒读后切合谜面。例如：
                教师示范 (打一学科名)
                谜底：仿生学
                将"仿生学"读成"学生仿"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "掉首格",
        desc = """
                别名：调首格、调头格、掉头格、睡鸭格、乙上格、低首格等。谜底需三字以上，第一字与第二字互换位置。例如：
                丘 (打《岳阳楼记》一句)
                谜底:山岳潜形
                "山"与"岳"互换切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "蕉心格",
        desc = """
                别名：乙中格。谜底需四字以上的双数字，中间两字互换位置。例如：
                京师 (打一成语)
                谜底：千军万马
                谜底读成"千万军马"，古时计数以千万为京。
            """.trimIndent()
    ),
    Mige(
        title = "掉尾格",
        desc = """
                别名：乙下格、掉足格、调尾格。谜底需三字以上，末尾两字互换位置。例如：
                请陈凯歌还 (打一成语)
                谜底:得胜回朝
                末两字倒换得"得胜朝回"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "上楼格",
        desc = """
                别名：登楼格、踢斗格。谜底需三字以上，末一字提到首字前连下读。例如：
                红梅揭晓 (打一植物名)
                谜底：报春花
                读"花报春"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "下楼格",
        desc = """
                别名：低头格、落雁格、落帽格。谜底需三字以上，首字放到末字后读。例如：
                十读成九 (打一成语)
                谜底:一念之差
                读"念之差一"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "上下楼格",
        desc = """
                谜底需四字以上，首末两字互换位置读。例如：
                三代人都很好 (打二红楼梦人物)
                谜底：良儿、孙绍祖
                将"良"和"祖"互换得"祖儿孙绍良"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "移珠格",
        desc = """
                谜底需四字以上，中间一字作间隔两字以上的自由移动，然后连读切合谜面。例如：
                管中窥斑 (各打一水浒人名、浑号)
                谜底:孔明、豹子锦
                猜时，读成"孔明豹子锦"，"锦"口"斑"，"孔"口"管"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "垂柳格",
        desc = """
                谜底需五字以上，把前面的少数字(两字以上)顺移到句子后面，连读切合谜面。例如：
                太极拳操人不老 (打一体育运动形式名)
                谜底：少年运动会
                读成"运动会少年"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "辘轳格",
        desc = """
                谜底需四字以上双数字，第一和第二字互换位置，第三和第四字互换位置，与这类推。例如：
                冬至一阳生 (打一词牌名)
                谜底:应天长慢
                读成"天应慢长"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "双钩格",
        desc = """
                别名：己巳格。谜底限定四字，前两字和后两字双换位置读。例如：
                用战争消灭战争 (打一成语)
                谜底：止戈为武
                读成"为武止戈"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "牵萝格",
        desc = """
                谜底需两字以上，将两个相邻字，取其中某一字的半边(不论上半截或下半截、左半截或右半截)，移置倒另一个字的一边来读。例如：
                构巢而居 (打一县名)
                谜底:西林
                读"栖木"切合谜面
            """.trimIndent()
    ),
    Mige(
        title = "移帜格",
        desc = """
                谜底需三字以上，将某一字的左偏旁或右偏旁，移植到间隔一字或数字的另一字上读。例如：
                真个无忧 (打一成语)
                谜底：何乐而不为
                将"人"字旁移植到"为"自称"伪"，读成"可乐而不伪"。
            """.trimIndent()
    ),
    Mige(
        title = "易帜格",
        desc = """
                谜底需二字以上，将其中两个字，各将一半偏旁或一部分互相移置。例如：
                和平合作 (打一中草药名)
                谜底:并头草
                "头"何"草"互移一部分成"莫斗"，连读"并莫斗"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "螺旋格",
        desc = """
                谜底需四字以上，字字旋转读，不能有字往下连续。有"中向外旋"和"外向中旋"而法。例如：
                诊 (打一成语)
                谜底：毁誉参半
                读成"参誉半毁"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "脱帽格",
        desc = """
                别名：升冠格、免冠格、落帽格、孟嘉格、龙山格等。谜底需三字以上，将第一字除去后切合谜面。例如：
                鲁智深绰号(打一《聊斋志异》篇名)
                谜底:紫花和尚
                读"花和尚"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "摘领格",
        desc = """
                别名：折领格、折项格、射喉格。谜底需四字以上，除去第二个字候切合谜面。例如：
                我们村里的年轻人(打三电影)
                谜底：家、望乡、新的一代
                除去"望"为"家乡新的一代"。
            """.trimIndent()
    ),
    Mige(
        title = "遗珠格",
        desc = """
                别名：解带格、鸿沟格、挖心格、折腰格、比干格、抹胸格等。谜底需三字以上单数字，最中央的一字除去。例如：
                口 (打一成语)
                谜底:因小失大
                读"因失大"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "折胫格",
        desc = """
                别名：脱袜格、缓带格、不胫格。谜底需四字以上，倒数第二字除去。例如：
                分 (打一电影)
                谜底：汾水长流
                读"汾水流"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "脱靴格",
        desc = """
                别名：弃履格、无底格、力士格、跣足格等。谜底需三字以上，除去末一字切合谜面。例如：
                玉环(打一京剧名)
                谜底:杨门女将
                将谜底读作"杨门女"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "期艾格",
        desc = """
                别名：谜底需三字以上，其中有叠字，除去一个叠字后切合谜面。例如：
                乘法入门 (打二杂技节目名)
                谜底：驯马、马术
                去一"马"读"驯马术"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "神龙格",
        desc = """
                别名：谜底需用长句为宜，上半截大部分切合谜面，下半截少部分出去，除去的少部分字应由旁边的邻字消除。例如：
                瞎子 (打一电影)
                谜底:看不见的战线
                将"战线"除去切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "折柳格",
        desc = """
                别名：谜底需用长句为宜，下半截大部分扣合谜面，上半截少部分除去，除去的少部分字由旁边的邻字消除。例如：
                "以君下驷，与彼上驷，取君上驷，与彼中驷，取君中驷，与彼下驷。" (打一首都名)
                谜底：帕拉马里博
                只取"马里博"，"帕"字由邻字"拉"掉。
            """.trimIndent()
    ),
    Mige(
        title = "联珠格",
        desc = """
                别名：连珠格。谜底大都取材于诗、词、文句中的连接句或字，以上一句末一字，下句的第一字，连缀成一词。不能用词组作谜底。例如：
                十二克 (打毛泽东词二句)
                谜底:不管风吹浪打，胜似闲庭信步。
                "打胜"切合谜面，"打"对"十二"，"胜"对"克"。
            """.trimIndent()
    ),
    Mige(
        title = "加冠格",
        desc = """
                别名：正冠格、加冕格。谜底大部分取材于诗、词、文连接着的两个句子，句子文义不足，需借上句末一字，加至本句的句首连续，以补充谜底句文的不足。例如：
                大江东去(打一红楼梦词句)
                谜底：……水，无复向西流
                从原句的"东逝水"借来"水"字。
            """.trimIndent()
    ),
    Mige(
        title = "加履格",
        desc = """
                别名：进履格。谜底大都取材于诗、词、文中连接着的两个句子，用上一句全句，加下一句首句，连读切合谜面。例如：
                党的号召 (打一《韩非子·显学》句)
                谜底:一国可使齐、为
                从下句"为治者用众而舍寡"解来"为"字。
            """.trimIndent()
    ),
    Mige(
        title = "藏珠格",
        desc = """
                别名：嵌腰格。谜底应是双数字，在最中央嵌入一字，切合谜面。例如：
                鹏程展翅 (打二经穴名)
                谜底：飞扬、万里
                中央嵌入一"九"字，为"飞扬九万里"，切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "投影格",
        desc = """
                谜底需两字以上，其中有一字应重复读一次成两字，两字意思不同，加叠字切合谜面。例如：
                一旦豁然贯通(打一俗语)
                谜底:天晓得
                读成"天晓晓得"，两"晓"字意思不同。
            """.trimIndent()
    ),
    Mige(
        title = "回文格",
        desc = """
                谜底需两字以上，先顺读一次，再倒读一次，两次意思加在一起切合谜面。例如：
                射谜能手猜射谜 (打一水浒绰号)
                谜底：打虎将
                读"打虎将，将虎打"切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "探骊格",
        desc = """
                别名：骊珠格。谜条上只写谜面和谜格，不标谜目，让猜者射出谜底并带出谜目，谜目和谜底连贯成一个意思切合题意。例如：
                洞长一千五百米
                谜底:穴位足三里
                其中"穴位"是谜目，"足三里"是谜底，连起来切合谜面。
            """.trimIndent()
    ),
    Mige(
        title = "隐目格",
        desc = """
                谜底一般只用一词组成，谜底前两字隐格目名称，主要谜面不标格名，猜中时，带出暗含的射目来。例如：
                胜利奏凯歌
                谜底：大庆油田
                "胜利"作油田名，"奏凯歌"口大庆。
            """.trimIndent()
    ),
    Mige(
        title = "带目格",
        desc = """
                谜底一般只用一词组成，谜面前两字隐格目名称，不标谜格，让猜中时并带出人名、地名和数字等等来。例如：
                甲午风云
                谜底:干支二寅辰
                其中"干支"为所隐之目，"二"是隐目所带之数字，"寅"、"辰"是谜底，他们包括在十二干支之内，与谜面"甲"、"午"相扣。
            """.trimIndent()
    ),
    Mige(
        title = "内附格",
        desc = """
                别名：暗附格、藏藏格。谜底需用具有格名的句子，暗附格名，须能体现格名的用意。例如：
                奖 (打一《西游记》人名)
                谜底：卷帘大将
                谜面"奖"是"大将"的倒读，和"卷帘格"的用意。
            """.trimIndent()
    ),
    Mige(
        title = "簪花格",
        desc = """
                谜底需用两字以上的词或成语，谜底的第一个字只允许加草字头或竹字头。例如：
                张苞(打一成语)
                谜底:方兴未艾
                "方"字加草字头成"芳"，以"芳兴未艾"切合题意。
            """.trimIndent()
    ),
    Mige(
        title = "反切格",
        desc = """
                以谜面或谜底的两个字"切音"，即将上一字的声母和下一字的韵母相切，得一个字，再加上"反"或"切"字，切合谜面。例如：
                枪林 (打一常用词)
                谜底：亲切
                谜面"枪林"反切成"亲"，扣谜底"亲切"，"切"是附加字。
            """.trimIndent()
    ),
    Mige(
        title = "抵消格",
        desc = """
                别名：停云格、削剩格。谜底多由两词组成，前词的闲字由后词指出抵消，其它实字都应切题。例如：
                尖端 (打《水浒》二绰号名)
                谜底:小遮拦、没遮拦
                "尖"之端为"小"，谜底上句"小遮拦"之"遮拦"由下句"没遮拦"抵消，剩一"小"字。
            """.trimIndent()
    ),
    Mige(
        title = "重门格",
        desc = """
                别名：二进宫格、叠户格。谜底用一字、一词或短句组成，不直接解释谜面的意义，谜面先射中寓意，后入本意，经过转义才切合谜面。例如：
                子丑寅卯辰巳午未申酉亥 (打一字)
                谜底：虫
                第一层门，先从谜面十二地支中，独缺戌；第二层门，应知戌属狗，狗即犬。经转义，独缺犬，为虫字。
            """.trimIndent()
    ),
    Mige(
        title = "苏黄格",
        desc = """
                谜底的词不直释谜面的意思，先以谐音附会，后才入本意，经过转义才切合谜面。例如：
                剪烛（打一古科举名）
                谜底:状元
                "剪烛"会意"一夹一明"，经谐音附会成"一甲一名"，即"状元"。
            """.trimIndent()
    ),
    Mige(
        title = "求凰格",
        desc = """
                谜底文意除和谜面成对仗、分平仄外，要在谜底的前面或后面，加上含有成双成对的附加字，如：对、配、比、双、和、齐、偶、交、会、匹、伍、缘、连、联、朋、相逢、相会、鸳鸯等。例如：
                玉门关(打李白诗一句)
                谜底：金銮锁鸳鸯
                "金銮锁"与"玉门关"对仗，"鸳鸯"是附加词。
            """.trimIndent()
    ),
    Mige(
        title = "遥对格",
        desc = """
                别名：锦屏、楹联、菱花、鸳鸯、流水。谜底字数同谜面字数成对偶句式，底和面，字音平仄分明，字义相对工稳。例如：
                青山 (打一地名)
                谜底:秀水
                "青山"对"秀水"底面对仗工整。
            """.trimIndent()
    ),
    Mige(
        title = "红豆格",
        desc = """
                别名：红逗格、金锁格。谜底需三字以上，将其句子故意断读，变异原意切合谜面。例如：
                九十九 (打一成语)
                谜底：百无一是
                将谜底断读为"百无一，是"。
            """.trimIndent()
    ),
    Mige(
        title = "牟尼格",
        desc = """
                与"红豆格"相反，取消谜底的逗号，上下串读成一句，成谜。例如：
                文丞相印 (打《左传》一句)
                谜底:信，国之宝也
                此典出自文天祥曾任丞相，封信国公。去逗号后为"信国之宝也"。
            """.trimIndent()
    ),
    Mige(
        title = "玉版格",
        desc = """
                将谜面的字，部分暗隐叫销。如谜面上发现有“勿、不、休、莫、去、别、漏、流、泛”等字眼，就把邻近的多余的字除去，剩下的字，才是有关谜底的字。例如：
                漏船载酒泛中流 (打古文《喜雨亭记》一句)
                谜底：是岁之春
                猜时，将"载酒"二字作为谜面，其余字已暗隐，"载"扣"岁"，"酒"扣"春"。
            """.trimIndent()
    ),
    Mige(
        title = "泄白格",
        desc = """
                别名：露面格、漏底格。灯谜术语，称之为"露春"，为文义谜的大忌。例如：
                施珠则太赤，施粉则太白 (打唐诗七言一句)
                谜底:却嫌脂粉污颜色
                "粉"字底面相犯，在谜规上不允许。此格曾有不少子格，如犯第一字为"露头"，第二字为"露颈"，中央一字为"露腹"， 倒数第二字为"露胫"，末字为"露尾"。
            """.trimIndent()
    ),
    Mige(
        title = "玉带格",
        desc = """
                谜底须三字以上成单数，中间一字读谐音。如：
                妈（打地方戏一）
                谜底：女驸马
                中间“驸”作“附”解。即“女附（驸）马”而切谜面 [1]
            """.trimIndent()
    ),
)
