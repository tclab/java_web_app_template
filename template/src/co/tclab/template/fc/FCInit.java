package co.tclab.template.fc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class FCInit extends MultiActionController {
	public String logginView;
	public String logginSuccesView;

	/**
	 * Init
	 * @param reques
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView init(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		return new ModelAndView(logginSuccesView, data);
	}

	/**
	 * Loggin method.
	 * @param reques
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView loggin(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		return new ModelAndView(logginSuccesView, data);
	}
	
	

	//SETTINGS
	public void setLogginSuccesView(String logginSuccesView) {
		this.logginSuccesView = logginSuccesView;
	}
}