package co.tclab.template.fc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import co.tclab.template.dao.UserAdminDAO;

public class FCUserAdmin extends MultiActionController {
	private String userAdmView;

	/**
	 * Main user administration page.
	 * @param reques
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		UserAdminDAO userDAO = new UserAdminDAO();
		data.put("userList", userDAO.getUserList());
		return new ModelAndView(userAdmView, data);
	}
	
	/**
	 * Save user settings.
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
		
		UserAdminDAO userDAO = new UserAdminDAO();
		
		boolean res = userDAO.saveUser(
				username, 
				password, 
				adminType != null && !adminType.isEmpty(), 
				true
		);
		
		request.setAttribute("message", res ? "The user was saved correctly" : "There was an error saving the user");
		return init(request, response);
	}
	
	/**
	 * Delete user.
	 * @param reques
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		
		String username = request.getParameter("username");
		UserAdminDAO userDAO = new UserAdminDAO();
		boolean res = userDAO.deleteUser(username);;
		
		request.setAttribute("message", res ? "The user was deleted correctly" : 
			"There was an error deletint the user");

		return init(request, response);
	}

	//SETTERS
	public void setUserAdmView(String userAdmView) {
		this.userAdmView = userAdmView;
	}
}