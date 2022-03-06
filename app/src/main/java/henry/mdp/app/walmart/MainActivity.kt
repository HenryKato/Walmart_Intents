package henry.mdp.app.walmart

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Arraylist of Users
    val arrayList = ArrayList<User>()
    lateinit var user: User
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //User instances
        val user1 = User("Henry", "Kato", "hkato@gmail.com", "kato")
        val user2 = User("Herold", "Kizza", "hkizza@gmail.com", "kizza")
        val user3 = User("Hillary", "Richards", "hrichards@gmail.com", "richards")
        val user4 = User("Hilda", "Roberts", "hroberts@gmail.com", "roberts")
        val user5 = User("Halima", "Namutebi", "hnamutebi@gmail.com", "nautebi")

        //String Users in the list
        arrayList.add(user1)
        arrayList.add(user2)
        arrayList.add(user3);
        arrayList.add(user4);
        arrayList.add(user5);

        //Get created user object from Create Account Activity and save in the arrayList
        var intent = getIntent()
        val returnedUser = intent.getSerializableExtra("user") // return Serializable User Object
        if(returnedUser != null) {
            user = returnedUser as User //User user = (User)returnedUser
            arrayList.add(user)
        }
    }

    fun readForgottenPassword(view: View){
        val email = etEmail.text.toString()
        if(email != null){
            // 1. loop through the list
            for (user in arrayList){
                if(user.username.equals(email)){
                    password = user.password.toString()

                    //Create an implicit intent and pass it to email app

                    /*ACTION_SEND action to launch an email client installed on your Android device.*/
                    val mIntent = Intent(Intent.ACTION_SEND)

                    /*To send an email you need to specify mailto: as URI using setData() method
                    and data type will be to text/plain using setType() method*/
                    mIntent.data = Uri.parse("mailto:")
                    mIntent.type = "text/plain"

                    // put recipient email in intent
                    mIntent.putExtra(Intent.EXTRA_EMAIL, email)

                    //put the message in the intent
                    mIntent.putExtra(Intent.EXTRA_TEXT, password)

                    try {
                        //start email intent
                        startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
                    }
                    catch (e: Exception){
                        //if any thing goes wrong for example no email client application or any exception
                        //get and show exception message
                        Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
    }

    fun createNewAccount(view: View){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun signIn(view: View) {
        //1. Fetch the entered username and password
        var username = etEmail.text.toString()
        var password = etPassword.text.toString()

        //2. Check in the arrayList to see if a user object with those exists
        if((username)!=null && password !=null){
            for (user in arrayList){
                if(user.username.equals(username) && user.password.equals(password)){
                    //route the user to shopping category activity
                    // 1. Create the intent to use to share data between Main Activity and Shopping Activity
                    val intent = Intent(this, ShoppingCategoryActivity::class.java)

                    // 2. Pass the data to the created intent object
                    intent.putExtra("message", "Welcome $username")

                    // 3. Start the Shopping Category Activity
                    startActivity(intent)
                }
            }
        }

        //3. Print an error messages
        if(username.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Both Username and Password are required", Toast.LENGTH_LONG).show().toString()
        }
        if(username.isEmpty()) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_LONG).show()
        }
        if(password.isEmpty()) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_LONG).show()
        }
    }
}