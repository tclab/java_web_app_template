package co.tclab.template.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {
	
	public static String getView(String selectedView) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		MessageSource messageSource = (MessageSource) ctx.getBean("messageSource");
		return messageSource.getMessage(selectedView, null, LocaleContextHolder.getLocale());
	}
}