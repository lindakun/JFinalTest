package demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class DemoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants arg0) {
		arg0.setDevMode(true);
		arg0.setViewType(ViewType.JSP);
	}

	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configPlugin(Plugins arg0) {
		// Config MySql
		loadPropertyFile("jdbc.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbc.url"),
				getProperty("jdbc.username"), getProperty("jdbc.password"));
		arg0.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		arg0.add(arp);
		arp.addMapping(TableNames.JF_USER, User.USER_ID, User.class);
	}

	@Override
	public void configRoute(Routes arg0) {
		arg0.add("/hello", HelloController.class, "/demo");
	}

	public static void main(String[] args) {
		JFinal.start("WebRoot", 8888, "/", 5);
	}
}
