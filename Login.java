import javax.swing.*;
/** This class represents the login server that verifies the user, using a username
and password.
*/
public class Login {

	private static Login user = null;
	private static String name;
	/** Constructor method to initialize a Login object with given name
	* <p>
	* @param name The name of the new Login
	* <p>
	* @author Eyoel Hailemariam
	*/
	public Login(String name) {
		this.name = name;
	}
	/** Getter Method to return the name of the user
	* <p>
	* @return name The name of the given User
	* <p>
	* @author Eyoel Hailemariam
	*/
	public String getName() {
		return name;
	}
	/** Getter Method to return the user object
	* <p>
	* @return user The given User
	* <p>
	* @author Eyoel Hailemariam
	*/
	public static Login getUser() {
		if (user == null) {
			user = new Login(name);
		}
		return user;
	}
}
