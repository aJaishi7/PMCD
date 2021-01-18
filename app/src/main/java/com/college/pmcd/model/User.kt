package com.college.pmcd.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.util.*

data class User(
    val fullName: String? = null,
    val username: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val address: String? = null,
    val password: String? = null,
    val gender: String? = null,
    val dateOfBirth: Date = Date(),
    val profileImage: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("dateOfBirth"),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(address)
        parcel.writeString(password)
        parcel.writeString(gender)
        parcel.writeString(profileImage)
    }

    //-------------------------

    fun isLogin(username: String?, password: String?): Boolean {
        return username.toString().trim() == "admin" && password.toString().trim() == "admin"
    }

    // -----------------------

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}