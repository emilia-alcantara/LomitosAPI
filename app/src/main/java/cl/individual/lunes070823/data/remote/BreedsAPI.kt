package cl.individual.lunes070823.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface BreedsAPI {

    @GET("breeds/list/all")
    suspend fun getData(): Response<DogBreed>

}