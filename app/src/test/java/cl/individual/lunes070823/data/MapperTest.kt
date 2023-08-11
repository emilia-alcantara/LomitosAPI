package cl.individual.lunes070823.data

import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {
        // given
        val imgUrl = "imgUrl.cl"
        val id = "id"

        // when
        val result = imgUrl.toDetailEntity(id)

        // then
        assertEquals(id, result.breedDetail)
        assertEquals(imgUrl, result.imgUrl)
    }

    @Test
    fun toBreedEntity() {
        // given
        val breed = "example breed"

        // when
        val result = breed.toBreedEntity()

        // then
        assertEquals(breed, result.breed)



    }
}