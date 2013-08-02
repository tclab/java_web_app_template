package com.artica.administrator.fc.users;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.artica.recommender.conf.PropHandler;

public class FCUserAdmin extends MultiActionController {
	private String userAdmView;

	/**
	 * User adminitration.
	 * @param reques
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("userList", PropHandler.getUserList());
		return new ModelAndView(userAdmView, data);
	}
	
	/**
	 * User adminitration.
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String adminType = request.getParameter("admin");
		String userType = request.getParameter("user");
		
		boolean res = PropHandler.saveUser(
				username, 
				password, 
				adminType != null && !adminType.isEmpty(), 
				userType != null && !userType.isEmpty()
		);
		
		request.setAttribute("message", res ? "The user was saved correctly" : "There was an error saving the user");
		return init(request, response);
	}
	
	/**
	 * User adminitration.
	 * @param reques
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		
		String username = request.getParameter("username");
		boolean res = PropHandler.deleteUser(username);
		
		request.setAttribute("message", res ? "The user was deleted correctly" : 
			"There was an error deletint the user");

		return init(request, response);
	}

	//SETTERS
	public void setUserAdmView(String userAdmView) {
		this.userAdmView = userAdmView;
	}
}