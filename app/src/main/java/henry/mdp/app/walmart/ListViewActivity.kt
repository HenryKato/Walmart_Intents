package henry.mdp.app.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        clothingItems()
    }

    fun clothingItems(){
        var productDetails: IntArray = intArrayOf(R.string.Shirts, R.string.Dresses, R.string.Trousers,
            R.string.Jackets, R.string.Tops, R.string.Jeans, R.string.Hoodies, R.string.Caps
        )
        var clothes: Array<String> = arrayOf("Shirts", "Dresses", "Trousers", "Jackets", "Tops", "Jeans", "Hoodies", "Caps")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, clothes)
        lvItem.adapter = adapter
        lvItem.setOnItemClickListener{
            parent, view, position, id ->
            Toast.makeText(this, "${applicationContext.getString(productDetails[position])}", Toast.LENGTH_LONG).show()
        }
    }
}