package com.paven196.shaketolog.preference

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object AppPreferences {
    val NAME = "ShakeToLogLib"
    private lateinit var mSharedPreferences: SharedPreferences

    fun init(ctx: Context) {
        Log.d("AppPreferences", "init: ")
        mSharedPreferences = ctx.getSharedPreferences(
            NAME,
            Context.MODE_PRIVATE
        )
    }

    fun getString(key: EPreferencesKey, defValue: String = ""): String {
        return mSharedPreferences.getString(key.name, defValue)!!
    }

    fun putString(key: EPreferencesKey, value: String) {
        mSharedPreferences.edit().putString(key.name, value).apply()
    }

    fun getInt(key: EPreferencesKey, defValue: Int = -1): Int {
        return mSharedPreferences.getInt(key.name, defValue)
    }

    fun putInt(key: EPreferencesKey, value: Int) {
        mSharedPreferences.edit().putInt(key.name, value).apply()
    }

    fun getLong(key: EPreferencesKey, defValue: Long = -1): Long {
        return mSharedPreferences.getLong(key.name, defValue)
    }

    fun putLong(key: EPreferencesKey, value: Long) {
        mSharedPreferences.edit().putLong(key.name, value).apply()
    }

    fun getFloat(key: EPreferencesKey, defValue: Float = -1f): Float {
        return mSharedPreferences.getFloat(key.name, defValue)
    }

    fun putFloat(key: EPreferencesKey, value: Float) {
        mSharedPreferences.edit().putFloat(key.name, value).apply()
    }

    fun getBoolean(key: EPreferencesKey, defValue: Boolean = false): Boolean {
        return mSharedPreferences.getBoolean(key.name, defValue)
    }

    fun putBoolean(key: EPreferencesKey, value: Boolean) {
        mSharedPreferences.edit().putBoolean(key.name, value).apply()
    }

    fun remove(key: EPreferencesKey) {
        mSharedPreferences.edit().remove(key.name).apply()
    }
}