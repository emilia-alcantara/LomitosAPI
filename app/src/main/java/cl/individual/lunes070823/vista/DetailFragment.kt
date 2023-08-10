package cl.individual.lunes070823.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.individual.lunes070823.R
import cl.individual.lunes070823.databinding.FragmentDetailBinding


private const val ARG_PARAM1 = "id"
private const val ARG_PARAM2 = "param2"


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModelDetail : BreedViewModel by activityViewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewModelDetail.getBreedDetails(param1.toString())
        initRecycler()

        return binding.root
    }

    private fun initRecycler() {
        val detailsAdapter = DetailsAdapter()
        binding.recDetails.adapter = detailsAdapter
        viewModelDetail.breedDetailsLiveData(param1.toString()).observe(viewLifecycleOwner) {
            detailsAdapter.setData(it)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}