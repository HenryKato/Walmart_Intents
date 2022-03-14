package henry.mdp.app.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_electronics.*

class ElectronicsActivity : AppCompatActivity(), OnProductClickListener {
    lateinit var productlist: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronics)

        productlist = ArrayList()
        addProduct()
        rvElectronics.layoutManager = LinearLayoutManager(this)
        rvElectronics.addItemDecoration(DividerItemDecoration(this,1))
        rvElectronics.adapter = ElectronicsAdapter(productlist, this)
    }

    fun addProduct() {
        productlist.add(`Product`(
            "Dell PC",
            1372.24,
            "Red and white",
            R.drawable.dellpc,
            "DELL01",
            applicationContext.getString(R.string.DellPC)))
        productlist.add(`Product`(
            "Macbook Pro",
            1285.64,
            "Black and white",
            R.drawable.macbookpc,
            "MAC01",
            applicationContext.getString(R.string.MacbookPC)))
        productlist.add(`Product`(
            "Ipad 12",
            1322.40, "Sliver",
            R.drawable.ipad,
            "PAD01",
            applicationContext.getString(R.string.Ipad)))
        productlist.add(`Product`(
            "Iphone",
            1085.29,
            "Black",
            R.drawable.iphone,
            "IPH01",
            applicationContext.getString(R.string.Iphone)))
        productlist.add(`Product`(
            "Headphones",
            349.99,
            "Black",
            R.drawable.headphone,
            "HPD01",
            applicationContext.getString(R.string.Headphones)))
    }

   override fun onItemClick(item: `Product`, position: Int) {
        var intent = Intent(this, ElectronicsDetailsActivity::class.java)
        intent.putExtra("Title", item.title)
        intent.putExtra("Description", item.desc)
        intent.putExtra("Color", item.color)
        intent.putExtra("Image", item.image.toString())
        startActivity(intent)
    }


}