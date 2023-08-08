package cl.individual.lunes070823.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breeds_table")
data class DogBreedEntity(val breed: String) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}
