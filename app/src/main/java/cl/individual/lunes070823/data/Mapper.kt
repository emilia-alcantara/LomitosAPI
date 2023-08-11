package cl.individual.lunes070823.data

import cl.individual.lunes070823.data.local.DogBreedDetailEntity

fun String.toEntity(id:String): DogBreedDetailEntity= DogBreedDetailEntity(id, this)

