package com.epam.airportlayouts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * A class which represents flight
 *
 * @author Vlad Korotkevich
 */

@Parcelize
data class Flight(
    val status: String,
    val date: String,
    val seatsAmount: Int,
    val cost: Int,
    val currency: String,
    val fromPoint: String,
    val toPoint: String,
    val takeOffTime: String,
    val landTime: String,
    val duration: String
) : Parcelable

fun departFlight() =
        Flight(
            "DEPART",
            "16 SEP 2019",
            3,
            500,
            "BYN",
            "MSQ",
            "FLO",
            "00:20",
            "09:20",
            "9:00"
        )

fun returnFlight() =
    Flight(
        "RETURN",
        "17 SEP 2019",
        5,
        485,
        "BYN",
        "FLO",
        "MSQ",
        "05:20",
        "09:20",
        "4:00"
    )