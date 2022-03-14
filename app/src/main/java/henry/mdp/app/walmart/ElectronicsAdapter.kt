package henry.mdp.app.walmart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.electronis_item.view.*

class ElectronicsAdapter(var item: ArrayList<Product>, var clickListener: OnProductClickListener) : RecyclerView.Adapter<ElectronicViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectronicViewHolder {
        var electronicViewHolder: ElectronicViewHolder
        electronicViewHolder = ElectronicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.electronis_item, parent, false))
        return electronicViewHolder
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ElectronicViewHolder, position: Int) {
        holder.intialize(item.get(position), clickListener)
    }

}

class ElectronicViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var title = view.title
    var price = view.price
    var color = view.color
    var image = view.image

    fun intialize(item: Product, action:OnProductClickListener){
        title.text = item.title
        image.setImageResource(item.image)
        price.text = item.price.toString()
        color.text = item.color

        itemView.setOnClickListener {
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnProductClickListener {
    fun onItemClick(item: Product, position: Int)
}