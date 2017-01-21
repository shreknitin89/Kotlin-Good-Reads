package models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel

/**
 * Created by nitingeetasagardasari on 1/21/17.
 */
@PaperParcel
data class Output(
        @SerializedName("books")
        @Expose
        var books: Books? = null) : Parcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelOutput.CREATOR
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelOutput.writeToParcel(this, dest, flags)
    }
}