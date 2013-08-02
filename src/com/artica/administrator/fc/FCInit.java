package com.artica.administrator.fc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.artica.administrator.utils.AdminPropHandler;

public class FCInit extends MultiActionController {
	public String logginView;
	public String logginSuccesView;
	public String externalView;
	public String adminView;

	/**
	 * Init
	 * @param reques
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView init(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		return admin(reques, response);
	}

	
	/**
	 * Loggin method.
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView admin(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("spdCables", AdminPropHandler.getConfProp("FCInit.do.spdCables.url"));
		data.put("gestionMantenimiento", AdminPropHandler.getConfProp("FCInit.do.gestionMantenimiento.url"));
		data.put("diagnosticoVisionRueda", AdminPropHandler.getConfProp("FCInit.do.diagnoVisionRueda.url"));
		data.put("diagnosticoDefectoRueda", AdminPropHandler.getConfProp("FCInit.do.diagnoDefectoRueda.url"));
		data.put("conteoUsuarios", AdminPropHandler.getConfProp("FCInit.do.conteoUsuariosMM.url"));
		data.put("spdTrenes", AdminPropHandler.getConfProp("FCInit.do.spdTrenes.url"));
		data.put("modivim", AdminPropHandler.getConfProp("FCInit.do.modivim.url"));
		
		return new ModelAndView(adminView, data);
	}
	
	public ModelAndView save(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		
		AdminPropHandler.setConfProp("FCInit.do.spdCables.url", reques.getParameter("spdCables"));
		AdminPropHandler.setConfProp("FCInit.do.gestionMantenimiento.url", reques.getParameter("gestionMantenimiento"));
		AdminPropHandler.setConfProp("FCInit.do.diagnoVisionRueda.url", reques.getParameter("diagnosticoVisionRueda"));
		AdminPropHandler.setConfProp("FCInit.do.diagnoDefectoRueda.url", reques.getParameter("diagnosticoDefectoRueda"));
		AdminPropHandler.setConfProp("FCInit.do.conteoUsuariosMM.url", reques.getParameter("conteoUsuarios"));
		AdminPropHandler.setConfProp("FCInit.do.spdTrenes.url", reques.getParameter("spdTrenes"));
		AdminPropHandler.setConfProp("FCInit.do.modivim.url", reques.getParameter("modivim"));
		
		data.put("spdCables", AdminPropHandler.getConfProp("FCInit.do.spdCables.url"));
		data.put("gestionMantenimiento", AdminPropHandler.getConfProp("FCInit.do.gestionMantenimiento.url"));
		data.put("diagnosticoVisionRueda", AdminPropHandler.getConfProp("FCInit.do.diagnoVisionRueda.url"));
		data.put("diagnosticoDefectoRueda", AdminPropHandler.getConfProp("FCInit.do.diagnoDefectoRueda.url"));
		data.put("conteoUsuarios", AdminPropHandler.getConfProp("FCInit.do.conteoUsuariosMM.url"));
		data.put("spdTrenes", AdminPropHandler.getConfProp("FCInit.do.spdTrenes.url"));
		data.put("modivim", AdminPropHandler.getConfProp("FCInit.do.modivim.url"));
		
		return new ModelAndView(adminView, data);
	}
	
	public ModelAndView spdCables(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", AdminPropHandler.getConfProp("FCInit.do.spdCables.url"));
		return new ModelAndView(externalView, data);
	}
	
	public ModelAndView gestionMantenimiento(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", AdminPropHandler.getConfProp("FCInit.do.gestionMantenimiento.url"));
		return new ModelAndView(externalView, data);
	}
	
	public ModelAndView diagnoVisionRueda(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", AdminPropHandler.getConfProp("FCInit.do.diagnoVisionRueda.url"));
		return new ModelAndView(externalView, data);
	}
	
	public ModelAndView diagnoDefectoRueda(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", AdminPropHandler.getConfProp("FCInit.do.diagnoDefectoRueda.url"));
		return new ModelAndView(externalView, data);
	}
	
	public ModelAndView conteoUsuariosMM(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", AdminPropHandler.getConfProp("FCInit.do.conteoUsuariosMM.url"));
		return new ModelAndView(externalView, data);
	}
	
	public ModelAndView spdTrenes(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", AdminPropHandler.getConfProp("FCInit.do.spdTrenes.url"));
		return new ModelAndView(externalView, data);
	}
	
	public ModelAndView modivim(HttpServletRequest reques, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", AdminPropHandler.getConfProp("FCInit.do.modivim.url"));
		return new ModelAndView(externalView, data);
	}
	
	
	
	

	//SETTINGS
	public void setLogginSuccesView(String logginSuccesView) {
		this.logginSuccesView = logginSuccesView;
	}

	public void setExternalView(String externalView) {
		this.externalView = externalView;
	}

	public void setAdminView(String adminView) {
		this.adminView = adminView;
	}
	
	
}