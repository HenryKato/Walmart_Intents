package henry.mdp.app.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_category.*
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ShoppingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        var intent = getIntent()
        val username = intent.getStringExtra("message")
        tvWelcome.text = username
    }

    fun chooseClothing(view: View){
        Toast.makeText(this, "You have chosen the clothing category of shopping", Toast.LENGTH_LONG).show()
    }

    fun chooseElectronics(view: View){
        Toast.makeText(this, "You have chosen the electronics category of shopping", Toast.LENGTH_LONG).show()
    }

    fun chooseFood(view: View){
        Toast.makeText(this, "You have chosen the food category of shopping", Toast.LENGTH_LONG).show()
    }

    fun chooseBeauty(view: View){
        Toast.makeText(this, "You have chosen the beauty category of shopping", Toast.LENGTH_LONG).show()
    }
}