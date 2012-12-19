package demo;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class User extends Model<User> {

	public static final String USER_ID = "id";
	public static final String USER_NAME = "username";
	public static final String USER_PW = "password";

	public static final User dao = new User();
}
