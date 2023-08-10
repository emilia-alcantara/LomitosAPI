package cl.individual.lunes070823.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.individual.lunes070823.data.local.DogBreedDetailEntity
import cl.individual.lunes070823.databinding.DetailsItemLayoutBinding
import coil.load

class DetailsAdapter: RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {
    private lateinit var binding:DetailsItemLayoutBinding
    private val detailsList = mutableListOf<DogBreedDetailEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        binding = DetailsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsViewHolder(binding)
    }

    override fun getItemCount(): Int = detailsList.size


    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val breedDetail = detailsList[position]
        holder.bind(breedDetail)
    }

    fun setData(details : List<DogBreedDetailEntity>) {
        this.detailsList.clear()
        this.detailsList.addAll(details)
        notifyDataSetChanged()
    }

    inner class DetailsViewHolder(binding: DetailsItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(breedDetail: DogBreedDetailEntity) {
            binding.imageView.load(breedDetail.imgUrl)
        }

    }
}