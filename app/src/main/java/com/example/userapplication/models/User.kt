package com.example.userapplication.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users", primaryKeys = ["value"])
data class User (
    val gender: String,
    @Embedded
    val name: Name,
    @Embedded
    val location: Location,
    val email: String,
    @Embedded
    val login: Login,
    @Embedded(prefix = "dob_")
    val dob: Dob,
    @Embedded(prefix = "reg_")
    val registered: Dob,
    val phone: String,
    val cell: String,
    @Embedded
    val id: ID,
    @Embedded
    val picture: Picture,
    val nat: String
)

//Sub fields below

data class Dob (
    val date: String,
    val age: Long
)

data class ID (
    @ColumnInfo(name = "id_name")
    val name: String,
    @PrimaryKey
    val value: String
)

data class Location (
    @Embedded
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    @Embedded
    val coordinates: Coordinates,
    @Embedded
    val timezone: Timezone
)

data class Coordinates (
    val latitude: String,
    val longitude: String
)

data class Street (
    val number: Long,
    @ColumnInfo(name = "street_name")
    val name: String
)

data class Timezone (
    val offset: String,
    val description: String
)

data class Login (
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
)

data class Name (
    val title: String,
    val first: String,
    val last: String
)

data class Picture (
    val large: String,
    val medium: String,
    val thumbnail: String
)