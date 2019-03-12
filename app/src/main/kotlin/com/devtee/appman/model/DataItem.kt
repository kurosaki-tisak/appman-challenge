package com.devtee.appman.model

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("docType")
	val docType: String? = null,

	@field:SerializedName("description")
	val description: Description? = null
)