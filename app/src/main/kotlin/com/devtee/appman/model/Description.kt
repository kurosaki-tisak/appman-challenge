package com.devtee.appman.model

import com.google.gson.annotations.SerializedName

data class Description(

	@field:SerializedName("th")
	val th: String? = null,

	@field:SerializedName("en")
	val en: String? = null
)