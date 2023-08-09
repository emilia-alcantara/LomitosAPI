package cl.individual.lunes070823.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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


    inner class BreedsViewHolder(binding: BreedsItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(breed: DogBreedEntity) {
            binding.txtBreedItem.text = breed.breed

        }

    }
}