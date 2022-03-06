package henry.mdp.app.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun createAccount(view: View){
        // 1. Get all data from the fields
        val firstname = etCaFname.text.toString()
        val lastname = etCaLname.text.toString()
        val email = etCaEmail.text.toString()
        val password = etCaPsword.text.toString()

        // 2. Check if the fields are not null
        if(firstname !=null && lastname != null && email != null && password != null) {
            // 3. Display a success message
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
            // 4. Save the user into the database arraylist in the main
                //create the user account object from the fields
            val user = User(firstname, lastname, email, password)
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", user)
        }else{
            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()
        }
    }
}