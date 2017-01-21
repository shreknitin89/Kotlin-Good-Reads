package models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel

@PaperParcel
data class _3589685(
        @SerializedName("title")
        @Expose
        val title: String? = null,
        @SerializedName("cover")
        @Expose
        val cover: String? = null) : Parcelable {
    companion object {
        @JvmField val CREATOR = PaperParcel_3589685.CREATOR
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcel_3589685.writeToParcel(this, dest, flags)
    }
}