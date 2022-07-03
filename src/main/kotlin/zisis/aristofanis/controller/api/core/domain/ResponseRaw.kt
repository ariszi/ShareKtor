package zisis.aristofanis.controller.api.core.domain

import com.google.gson.annotations.SerializedName

open class ResponseRaw {
    @SerializedName("error") val error: SimpleError? = null
}
