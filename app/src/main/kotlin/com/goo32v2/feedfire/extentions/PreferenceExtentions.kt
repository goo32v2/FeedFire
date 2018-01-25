package com.goo32v2.feedfire.extentions

import android.preference.ListPreference
import android.preference.Preference
import android.preference.PreferenceManager

/**
 * @author Alexander Steblin (goo32v2)
 * @date 22.08.2017
 */

fun Preference.bindPreferenceSummaryToValue() {
    onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, value ->
        val stringValue = value.toString()

        if (preference is ListPreference) {
            val index = preference.findIndexOfValue(stringValue)

            preference.setSummary(
                    if (index >= 0)
                        preference.entries[index]
                    else
                        null)

        } else {
            preference.summary = stringValue
        }
        true
    }

    onPreferenceChangeListener.onPreferenceChange(this,
            PreferenceManager
                    .getDefaultSharedPreferences(this.context)
                    .getString(this.key, ""))
}