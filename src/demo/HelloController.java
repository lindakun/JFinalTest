package demo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class HelloController extends Controller {
	// Define a static logger variable so that it references the
	// Logger instance named "HelloController".
	Logger logger = LogManager.getLogger(HelloController.class.getName());

	public void index() {
		// User.dao.paginate(getParaToInt(0, 1), 10, "select *",
		// "from user where user_id = 1");
		setAttr("user", User.dao.findById(getParaToInt(0)));
		render("hello.jsp");
	}

	@Before(HelloValidator.class)
	public void save() {
		logger.info("Entering Application.");
		// Add User
		System.out.println(getModel(User.class).getStr("username"));
		System.out.println(getModel(User.class).getStr("password"));
		// 1,添加 第一种
		// getModel(User.class).save();
		// 2,添加第二种
		User user = new User();
		user.set(User.USER_NAME, getModel(User.class).getStr("username"))
				.set(User.USER_PW, getModel(User.class).getStr("password"))
				.save();
		// 3.第三种
		// Record user = new Record().set("name", "James").set("age", 25);
		// Db.save("user", user);
		// User.dao.deleteById(25);
		// User.dao.findById(25).set("name", "James").update();
		// User user = User.dao.findById(25, "name, age");
		// String userName = user.getStr("name");
		// Integer userAge = user.getInt("age");
		// List<User> users = User.dao.find("select * from user where age>18");
		// Page<User> userPage = User.dao.paginate(1, 10, "select *",
		// "from user where age > ?", 18);
		renderText("Hello JFinal world.");
		logger.info("Exiting Application.");
		// getModel(User.class).save();
	}

}
