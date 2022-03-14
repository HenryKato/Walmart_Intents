package henry.mdp.app.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_electronics_details.*

class ElectronicsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronics_details)

        var pdtTitle = intent.getStringExtra("Title")
        var pdtDesc = intent.getStringExtra("Description")
        var pdtImage = intent.getStringExtra("Image")!!.toInt()
        var pdtColor = intent.getStringExtra("Color")

        title1.text = pdtTitle
        description.text = pdtDesc
        color.text = pdtColor
        image.setImageResource(pdtImage)
    }
}