package cl.individual.lunes070823.data.local

import androidx.room.Entity

@Entity(tableName = "table_detail", primaryKeys = ["breedDetail", "imgUrl"])
data class DogBreedDetailEntity(
    val breedDetail: String,
    val imgUrl: String)