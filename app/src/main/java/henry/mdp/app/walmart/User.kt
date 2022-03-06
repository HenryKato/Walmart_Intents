package henry.mdp.app.walmart
import java.io.Serializable;
class User(var firstName: String?, var lastName: String?, var username: String?, var password: String?) :

    Serializable {
    override fun toString(): String {
        return "User(firstName=$firstName, lastName=$lastName, username=$username)"
    }

}
