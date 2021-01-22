package com.college.pmcd.model

import android.os.Parcel
import android.os.Parcelable

data class Disease(val diseaseTitle: String? = null) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(diseaseTitle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Disease> {
        override fun createFromParcel(parcel: Parcel): Disease {
            return Disease(parcel)
        }

        override fun newArray(size: Int): Array<Disease?> {
            return arrayOfNulls(size)
        }
    }
}