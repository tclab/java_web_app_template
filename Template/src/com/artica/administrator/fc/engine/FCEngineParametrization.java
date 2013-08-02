package com.artica.administrator.fc.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.artica.administrator.bo.menuBO.MenuItem;
import com.artica.administrator.fc.MenuHandler;
import com.artica.recommender.conf.PropHandler;

public class FCEngineParametrization extends MultiActionController {

	private ArrayList<MenuItem> menuItems;
	private String engineParamView;
	
	
	public FCEngineParametrization(){
		menuItems = new MenuHandler().processMenu(this.getClass().getSimpleName());
	}
	
	/**
	 * Init
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("engineParams", PropHandler.getEngineProperties());
		return new ModelAndView(engineParamView, data);
	}
	
	/**
	 * Update
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		boolean res = PropHandler.setDbProp(request.getParameter("parameter"), request.getParameter("parameterValue"));
		request.setAttribute("message", res ? "The parameter was updated correctly" : "There was an error updating the parameter");
		return init(request, response);
	}
	
	
	

	//SETTERS
	public void setEngineParamView(String engineParamView) {
		this.engineParamView = engineParamView;
	}
	
	
}