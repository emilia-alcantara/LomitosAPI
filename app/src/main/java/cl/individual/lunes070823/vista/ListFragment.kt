package cl.individual.lunes070823.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.individual.lunes070823.R
import cl.individual.lunes070823.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val breedViewModel : BreedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        breedViewModel.getAllBreeds()
        initRecycler()
        return binding.root
    }

    private fun initRecycler() {
        val breedsAdapter = BreedsAdapter()
        binding.recAllDogsList.adapter = breedsAdapter
        breedViewModel.breedsLiveData().observe(viewLifecycleOwner) {
            breedsAdapter.setData(it)
        }
    }


}