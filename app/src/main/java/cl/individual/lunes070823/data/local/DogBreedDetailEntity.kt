package cl.individual.lunes070823.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "table_detail", primaryKeys = ["breed_detail", "img_url"])
data class DogBreedDetailEntity(
    @ColumnInfo(name = "breed_detail")val breedDetail: String,
    @ColumnInfo(name = "img_url") val imgUrl: String
    )