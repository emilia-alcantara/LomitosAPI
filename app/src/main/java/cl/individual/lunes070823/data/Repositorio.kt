package cl.individual.lunes070823.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.individual.lunes070823.data.local.BreedsDao
import cl.individual.lunes070823.data.local.DogBreedDetailEntity
import cl.individual.lunes070823.data.local.DogBreedEntity
import cl.individual.lunes070823.data.remote.BreedsAPI

class Repositorio(private val breedsAPI: BreedsAPI, private val breedsDao: BreedsDao) {
    fun getBreedsFromLocal(): LiveData<List<DogBreedEntity>> = breedsDao.getDogBreeds()
    fun getDogBreedDetails(id: String): LiveData<List<DogBreedDetailEntity>> =
        breedsDao.getDogBreedDetails(id)
    suspend fun loadBreedsToDatabase() {
        val response = breedsAPI.getData()
        if (response.isSuccessful) {
            val message = response.body()!!.message
            val keys = message.keys
            keys.forEach { breed ->
                val dogBreedEntity = breed.toBreedEntity()
                breedsDao.insertDogBreed(dogBreedEntity)
            }
        }
    }
    suspend fun loadBreedDetailsToDatabase(id: String) {
        val response = breedsAPI.getBreedDetails(id)
        if (response.isSuccessful) {
            response.body()!!.message.forEach { imgUrl ->
                val breedDetail = imgUrl.toDetailEntity(id)
                breedsDao.insertDogBreedDetails(breedDetail)
            }
        } else {
            Log.e("repositorio", response.errorBody().toString())
        }
    }
}

