package cl.individual.lunes070823.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breeds_table")
data class DogBreedEntity(@PrimaryKey val breed: String)
