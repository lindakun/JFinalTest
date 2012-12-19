package demo;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 校验器
 * 
 * @author LinDK
 * 
 */
public class HelloValidator extends Validator {

	@Override
	protected void handleError(Controller c) {
		c.keepModel(User.class);
		String actionKey = getActionKey();
		if (actionKey.equals("/hello/save"))
			c.render("hello.jsp");
		else if (actionKey.equals("/hello/update"))
			c.render("edit.jsp");
	}

	@Override
	protected void validate(Controller c) {
		validateRequiredString("user.username", "unMsg", "请输入用户名!");
		validateRequiredString("user.password", "upMsg", "请输入密码!");
	}

}
