
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by nitingeetasagardasari on 1/19/17.
 */

object ServiceGenerator {
    private val BASE_URL = "http://www.librarything.com"
    private val mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    var endPointInterface = mRetrofit.create(EndPointInterface::class.java)!!

}
