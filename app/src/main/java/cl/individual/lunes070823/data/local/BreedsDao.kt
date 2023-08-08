package cl.individual.lunes070823.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BreedsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDogBreed(dogBreedEntity: DogBreedEntity)

    @Query("SELECT * FROM breeds_table ORDER BY breed DESC")
    fun getDogBreeds(): LiveData<DogBreedEntity>

}