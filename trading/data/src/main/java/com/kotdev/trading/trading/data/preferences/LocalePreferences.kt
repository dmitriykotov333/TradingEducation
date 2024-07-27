package com.kotdev.trading.trading.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.kotdev.trading.core.Utils
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class LocalePreferences(
    private val context: Context
) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Utils.PREFERENCES_LOCALE)
        private val LANGUAGE = stringPreferencesKey("language")
        private val LOCALE = stringPreferencesKey("locale")
    }

    suspend fun saveLanguage(language: String) {
        context.dataStore.edit { preferences ->
            preferences[LANGUAGE] = language
        }
    }

    suspend fun saveLocale(language: String, locale: String) {
        context.dataStore.edit { preferences ->
            preferences[LANGUAGE] = language
            preferences[LOCALE] = locale
        }
    }

    suspend fun getLocale() = context.dataStore.data
        .map { preferences ->
            Pair(
                preferences[LANGUAGE] ?: "English",
                preferences[LOCALE] ?: "en",
            )
        }.first()

    suspend fun clearLocale() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }

}