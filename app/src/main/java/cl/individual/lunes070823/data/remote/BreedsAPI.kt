package cl.individual.lunes070823.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BreedsAPI {

    @GET("breeds/list/all")
    suspend fun getData(): Response<DogBreed>

    @GET ("breed/{id}/images")
    suspend fun getBreedDetails(@Path("id") id:String): Response<DogBreedDetail>

}