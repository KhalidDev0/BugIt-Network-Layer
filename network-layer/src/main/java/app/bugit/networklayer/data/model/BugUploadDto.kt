package app.bugit.networklayer.data.model

import com.google.gson.annotations.SerializedName

data class BugUploadDto(

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String
)
