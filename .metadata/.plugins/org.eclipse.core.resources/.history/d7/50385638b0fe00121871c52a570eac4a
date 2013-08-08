package com.artica.administrator.fc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class FCLogout extends MultiActionController {

	private String logView;

	/**
	 * Logout
	 * 
	 * @param resquest
	 * @param response
	 * @return
	 */
	public ModelAndView logOut(HttpServletRequest resquest, HttpServletResponse response) {
		return new ModelAndView(logView);
	}

	//SETTINGS
	public void setLogView(String logView) {
		this.logView = logView;
	}
}