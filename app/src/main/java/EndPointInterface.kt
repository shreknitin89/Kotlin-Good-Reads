
import models.Output
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by nitingeetasagardasari on 1/19/17.
 */

interface EndPointInterface {
    @GET("/api_getdata.php?userid=timspalding&showstructure=1&max=10&showCollections=1&showTags=1&booksort=title_REV&responseType=json")
    fun getBooks(): Call<Output>
}
