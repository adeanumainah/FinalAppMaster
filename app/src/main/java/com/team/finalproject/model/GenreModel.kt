package com.team.finalproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreModel (
    var novelTitle : String,
    var novelGenre : String,
    var novelSynopsis : String,
    var novelAuthor : String,
) : Parcelable