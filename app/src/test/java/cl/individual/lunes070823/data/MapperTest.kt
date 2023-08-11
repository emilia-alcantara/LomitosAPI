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
        val result = imgUrl.toEntity(id)

        // then
        assertEquals(id, result.breedDetail)
        assertEquals(imgUrl, result.imgUrl)
    }
}