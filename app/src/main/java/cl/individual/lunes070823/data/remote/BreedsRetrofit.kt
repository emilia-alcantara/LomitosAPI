package cl.individual.lunes070823.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BreedsRetrofit {

    companion object {
        private const val URL_BASE =
            "https://god.ceo/api/"

        fun getRetrofitDogBreed() : BreedsAPI {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(BreedsAPI::class.java)
        }
    }
}