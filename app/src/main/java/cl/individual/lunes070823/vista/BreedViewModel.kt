package cl.individual.lunes070823.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.individual.lunes070823.data.Repositorio
import cl.individual.lunes070823.data.local.BreedsDatabase
import cl.individual.lunes070823.data.remote.BreedsRetrofit
import kotlinx.coroutines.launch

class BreedViewModel (app:Application) : AndroidViewModel(app) {
    val repo : Repositorio
    fun breedsLiveData() = repo.getBreedsFromLocal()

    init {
        val api = BreedsRetrofit.getRetrofitDogBreed()
        val dao = BreedsDatabase.getDatabase(app).getBreedsDao()

        repo = Repositorio(api, dao)
    }

    fun getAllBreeds() = viewModelScope.launch {
        repo.loadBreedsToDatabase() // tengo duda de esta funcion (? por el nombre que le puse vs lo que hace aquí
    }

}