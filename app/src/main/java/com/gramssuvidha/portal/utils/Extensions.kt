package com.gramssuvidha.portal.utils

import java.text.NumberFormat
import java.util.Locale

/**
 * Extension functions and formatting utilities used across the app.
 */

/** Format a currency amount in Indian Rupees */
fun Double.toIndianCurrency(): String {
    val format = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    return format.format(this)
}

/** Format budget in lakhs/crores for readability */
fun Double.formatBudget(): String {
    return when {
        this >= 10_000_000 -> "₹%.2f Cr".format(this / 10_000_000)
        this >= 100_000   -> "₹%.2f L".format(this / 100_000)
        else               -> "₹%.0f".format(this)
    }
}

/** Clamp an Int value between min and max */
fun Int.clamp(min: Int, max: Int): Int = maxOf(min, minOf(max, this))

/** Convert epoch millis to a readable date string */
fun Long.toReadableDate(): String {
    val sdf = java.text.SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    return sdf.format(java.util.Date(this))
}
