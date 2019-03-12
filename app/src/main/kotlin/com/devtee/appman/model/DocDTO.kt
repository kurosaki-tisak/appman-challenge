package com.devtee.appman.model

import com.google.gson.annotations.SerializedName

data class DocDTO(

    @field:SerializedName("firstName")
    val firstName: String? = null,

    @field:SerializedName("lastName")
    val lastName: String? = null,

    @field:SerializedName("data")
    val data: List<DataItem>? = null,

    @field:SerializedName("Id")
    val id: String? = null
)