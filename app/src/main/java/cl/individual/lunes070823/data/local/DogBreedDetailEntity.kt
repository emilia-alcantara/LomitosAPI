package cl.individual.lunes070823.data.local

import androidx.room.Entity

@Entity(tableName = "table_detail", primaryKeys = ["breedDetail", "imgUrl"])
data class DogBreedDetailEntity(
    /*@ColumnInfo(name = "breed_detail")*/val breedDetail: String,
    /*@ColumnInfo(name = "img_url") */val imgUrl: String
    // aquí debería haber escrito los nombres de las columnas en snake case! se me olvidó
    // después de hacer commit y que funcione, lo cambiaré
    )