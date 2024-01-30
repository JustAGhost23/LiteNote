package com.example.litenote.core.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import javax.inject.Inject

class PreferencesDataStoreUtil @Inject constructor(context: Context) {

    val preferencesDataStore = context.dataStore

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("preferences")
        val IS_DARK_MODE_KEY = booleanPreferencesKey("dark_mode")
    }
}