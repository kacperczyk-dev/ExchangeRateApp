package com.dawid.currencies.domain

import android.os.Parcelable
import com.dawid.currencies.util.convertStringtoDateTime
import com.github.mikephil.charting.data.Entry
import kotlinx.android.parcel.Parcelize
import org.joda.time.DateTimeZone


@Parcelize
data class ExchangeRate(
    val date: String,
    val currencyCode: String,
    val base: String,
    val value: Double,
    val gain: Double = 0.0,
    val diff: Double = 0.0
) : Parcelable

fun List<ExchangeRate>.asChartEntry() : List<Entry> {
    return map {
        val date = convertStringtoDateTime(it.date)
        Entry(date.toDateTime(DateTimeZone.getDefault()).millis.toFloat(), 1/it.value.toFloat())
    }
}