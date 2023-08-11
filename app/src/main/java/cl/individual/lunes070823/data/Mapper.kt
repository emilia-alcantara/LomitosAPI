package cl.individual.lunes070823.data

import cl.individual.lunes070823.data.local.DogBreedDetailEntity
import cl.individual.lunes070823.data.local.DogBreedEntity

fun String.toDetailEntity(id:String): DogBreedDetailEntity= DogBreedDetailEntity(id, this)

fun String.toBreedEntity():DogBreedEntity = DogBreedEntity(this)

