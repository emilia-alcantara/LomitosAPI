package cl.individual.lunes070823.vista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import cl.individual.lunes070823.R
import cl.individual.lunes070823.data.local.DogBreedEntity
import cl.individual.lunes070823.databinding.BreedsItemLayoutBinding

class BreedsAdapter: RecyclerView.Adapter<BreedsAdapter.BreedsViewHolder>() {
    private lateinit var binding : BreedsItemLayoutBinding
    private val breedsList = mutableListOf<DogBreedEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsViewHolder {
        binding = BreedsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BreedsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BreedsViewHolder, position: Int) {
        val breed = breedsList[position]
        holder.bind(breed)
    }

    override fun getItemCount(): Int = breedsList.size
    fun setData(breed: List<DogBreedEntity>) {
        this.breedsList.clear()
        this.breedsList.addAll(breed)
        notifyDataSetChanged()
    }


    inner class BreedsViewHolder(binding: BreedsItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(breed: DogBreedEntity) {
            binding.txtBreedItem.text = breed.breed
            binding.cardBreedItem.setOnClickListener{
                val selectedItem = Bundle()
                selectedItem.putString("id", breed.breed)
                findNavController(binding.root).navigate(R.id.action_listFragment_to_detailFragment, selectedItem)
            }
        }


    }
}