package com.team.finalproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HorrorModel (
    var titleHorror : String,
    var genreHorror : String,
    var synopsisHorror : String,
    var authorHorror : String,
) : Parcelable