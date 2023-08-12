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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDogBreedList(breedList: List<DogBreedEntity>)

    @Query("SELECT * FROM breeds_table ORDER BY breed ASC")
    fun getDogBreeds(): LiveData<List<DogBreedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDogBreedDetails(dogBreedDetail:DogBreedDetailEntity)

    @Query("SELECT * FROM table_detail WHERE breed_detail LIKE :id")
    fun getDogBreedDetails(id:String): LiveData<List<DogBreedDetailEntity>>
}

