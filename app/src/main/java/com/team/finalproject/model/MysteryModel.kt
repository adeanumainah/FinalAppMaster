package com.team.finalproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MysteryModel (
    var titleMystery : String,
    var genreMystery : String,
    var synopsisMystery : String,
    var authorMystery : String,
) : Parcelable