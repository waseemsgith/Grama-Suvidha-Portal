package com.gramssuvidha.portal.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gramssuvidha.portal.utils.LanguageUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SettingsUiState(
    val selectedLanguage: String = "en",
    val isDarkMode: Boolean = false
)

/**
 * ViewModel for Settings screen managing language and dark mode preferences.
 */
@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val languageUtils: LanguageUtils
) : ViewModel() {

    val uiState: StateFlow<SettingsUiState> = combine(
        languageUtils.selectedLanguage,
        languageUtils.isDarkMode
    ) { lang, dark -> SettingsUiState(lang, dark) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), SettingsUiState())

    fun setLanguage(code: String) {
        viewModelScope.launch { languageUtils.setLanguage(code) }
    }

    fun setDarkMode(enabled: Boolean) {
        viewModelScope.launch { languageUtils.setDarkMode(enabled) }
    }
}
