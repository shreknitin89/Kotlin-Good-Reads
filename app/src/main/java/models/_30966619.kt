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
data class _30966619(
        @SerializedName("title")
        @Expose
        val title: String? = null,
        @SerializedName("cover")
        @Expose
        val cover: String? = null) : Parcelable {
    companion object {
        @JvmField val CREATOR = PaperParcel_30966619.CREATOR
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcel_30966619.writeToParcel(this, dest, flags)
    }
}
