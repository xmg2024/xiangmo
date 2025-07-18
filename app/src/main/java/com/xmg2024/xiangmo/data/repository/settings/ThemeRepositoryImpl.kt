package com.xmg2024.xiangmo.data.repository.settings

import com.xmg2024.xiangmo.data.datastore.AppPreference
import com.xmg2024.xiangmo.data.model.AppStatus
import com.xmg2024.xiangmo.data.model.theme.DarkThemeConfig
import com.xmg2024.xiangmo.data.model.theme.ThemeBrand
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ThemeRepositoryImpl @Inject constructor(
    private val preference: AppPreference
) : ThemeRepository {
    override val appStatus: Flow<AppStatus>
        get() = preference.appStatus

    override suspend fun setThemeBrand(themeBrand: ThemeBrand) =
        preference.setThemeBrand(themeBrand)

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) =
        preference.setDarkThemeConfig(darkThemeConfig)

    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) =
        preference.setUseDynamicColor(useDynamicColor)
}