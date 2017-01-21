package models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by nitingeetasagardasari on 1/21/17.
 */
data class Output(
        @SerializedName("books")
        @Expose
        var books: Books)