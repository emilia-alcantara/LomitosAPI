package cl.individual.lunes070823.data

import cl.individual.lunes070823.data.local.BreedsDao
import cl.individual.lunes070823.data.local.DogBreedEntity
import cl.individual.lunes070823.data.remote.BreedsAPI

class Repositorio (private val breedsAPI: BreedsAPI, private val breedsDao: BreedsDao) {

    suspend fun loadBreedsToDatabase(){
        val response = breedsAPI.getData()

        if(response.isSuccessful) {
            val message = response.body()!!.message
            val keys = message.keys

            keys.forEach{
                val dogBreedEntity = DogBreedEntity(it)
                breedsDao.insertDogBreed(dogBreedEntity)
            }
        }
    }
}