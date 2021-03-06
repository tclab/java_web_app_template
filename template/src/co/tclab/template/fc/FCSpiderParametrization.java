package co.tclab.template.fc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import co.tclab.template.bo.MenuItem;
import co.tclab.template.utils.AdminPropHandler;
import co.tclab.template.utils.MenuHandler;
import co.tclab.template.utils.PropHandler;


public class FCSpiderParametrization extends MultiActionController {
	private String generalOptsView;
	private ArrayList<MenuItem> menuItems;
	
	private String spiderVodView;
	private String spiderOdView;
	private String spiderEpgView; 
	private String spiderRatingView;
	private String spiderChannelView;
	
	
	public FCSpiderParametrization(){
		menuItems = new MenuHandler().processMenu(this.getClass().getSimpleName());
	}
	
	/**
	 * Init
	 * @param request
	 * @param response
	 * @return
	 */
	@Secured ({"ROLE_ADMIN"})
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
//		createMenu();
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		//DATABASE INFO
		data.put("host", PropHandler.getDataBaseProp("recommender.host"));
		data.put("port", PropHandler.getDataBaseProp("recommender.port"));
		data.put("usr", PropHandler.getDataBaseProp("recommender.usr"));
		data.put("pss", PropHandler.getDataBaseProp("recommender.pss"));
		data.put("dbName", PropHandler.getDataBaseProp("recommender.dataBaseName"));
		

		//GLOBAL PARAMETERS
//		data.put("startTime", PropHandler.getSchedulerProp("scheduler.startTimeDay"));
//		data.put("logLocation", PropHandler.getSchedulerProp("scheduler.logLocation"));
//		data.put("propsLocation", PropHandler.getDbProp("global.propsLocation"));
		
		data.put("menuItems", menuItems);
		return new ModelAndView(generalOptsView, data);
	}
	
	/**
	 * Saves database parameters.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView saveDataBaseParameters(HttpServletRequest request, HttpServletResponse response){
		HashMap<String, String> propSet = new HashMap<String, String>();
		String message = null;
		
		try {
			propSet.put("recommender.port", request.getParameter("port"));
			propSet.put("recommender.pss", request.getParameter("pss"));
			propSet.put("recommender.dataBaseName", request.getParameter("dbName"));
			propSet.put("recommender.usr", request.getParameter("usr"));
			propSet.put("recommender.host", request.getParameter("host"));
//			PropHandler.setDataBaseProps(propSet);
			message = "Properties saved properly";
		} catch (Exception e) {
			message = "An error ocurred during the process, please try again";
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		
		return init(request, response);
	}
	
	
	/**
	 * Saves general parameters.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView saveGeneralParameters(HttpServletRequest request, HttpServletResponse response){
		HashMap<String, String> propSet = new HashMap<String, String>();
		String message = "";
		
		try {
			propSet.put("scheduler.startTimeDay", request.getParameter("startTime"));
			propSet.put("scheduler.logLocation", request.getParameter("logLocation"));
//			PropHandler.setSchedulerProp(propSet);
			
//			PropHandler.setDbProp("global.propsLocation", request.getParameter("propsLocation"));
			message = "Properties saved properly";
		} catch (Exception e) {
			message = "An error ocurred during the process, please try again";
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		return init(request, response);
	}
	
	
	/* 
	 * ************
	 * SPIDERS
	 * ************
	 */
	
	/**
	 * SpiderEPG parameters
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderEpg(HttpServletRequest request, HttpServletResponse response) {
		//SpiderEpg parameters
		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("localDataFolder", PropHandler.getDaoProp("epg.localEpgLog"));
//		data.put("processFolder", PropHandler.getDaoProp("epg.xml.processResult"));
//		data.put("rowIdentifierProgram", PropHandler.getDaoProp("epg.rowIdentifierProgram"));
//		data.put("rowIdentifierChannel", PropHandler.getDaoProp("epg.rowIdentifierProgram.channel"));
//		data.put("frequency", PropHandler.getFrequency(AdminPropHandler.getConfProp("admin.spiders.epg")));
//		data.put("historicFolder", PropHandler.getDbProp("history.epg"));
		data.put("menuItems", menuItems);
		
		
		//Metadata
//		data.put("epgMetadata", PropHandler.getMetadata("E"));
		
		return new ModelAndView(spiderEpgView,data);
	}
	
	public ModelAndView spiderEpgSave(HttpServletRequest request, HttpServletResponse response) {
		//SpiderEpg parameters
		
		String message = "";
		try {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("epg.localEpgLog", request.getParameter("localDataFolder"));
			properties.put("epg.xml.processResult", request.getParameter("processFolder"));
			properties.put("epg.rowIdentifierProgram", request.getParameter("rowIdentifierProgram"));
			properties.put("epg.rowIdentifierProgram.channel", request.getParameter("rowIdentifierChannel"));
			properties.put("history.epg", request.getParameter("historicFolder"));
//			PropHandler.setDaoProps(properties);

//			PropHandler.setFrequency(AdminPropHandler.getConfProp("admin.spiders.epg"), request.getParameter("frequency"));
			message = "Properties seted properly";
		} catch (Exception e) {
			message = "There was an error setting properties. Try again.";
		}
		
		request.setAttribute("message", message);
		return spiderEpg(request, response);
	}
	
	/**
	 * Saves epg metadata
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderEpgSaveMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.insertMetadata("E", request.getParameter("keyName"), request.getParameter("keyValue"));
		return spiderEpg(request, response);
	}
	
	/**
	 * Updates epg metadata.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderEpgUpdateMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.updateMetadata("E", Long.parseLong(request.getParameter("epgMetaId")), request.getParameter("keyName"), request.getParameter("keyValue"));
		return spiderEpg(request, response);
	}
	
	/**
	 * Deletes epg metadata.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderEpgDeleteMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.deleteMetadata("E", Long.parseLong(request.getParameter("epgMetaId")));
		return spiderEpg(request, response);
	}

	
	/**
	 * SpiderOD parameters
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderOd(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("localDataFolder", PropHandler.getDaoProp("od.localOdLog"));
//		data.put("historicFolder", PropHandler.getDbProp("history.od"));
//		data.put("frequency", PropHandler.getFrequency(AdminPropHandler.getConfProp("admin.spiders.od")));
		data.put("menuItems", menuItems);
		return new ModelAndView(spiderOdView,data);
	}
	
	public ModelAndView spiderOdSave(HttpServletRequest request, HttpServletResponse response) {
		String message = "";
		try {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("od.localOdLog", request.getParameter("localDataFolder"));
			properties.put("history.od", request.getParameter("historicFolder"));
//			PropHandler.setDaoProps(properties);
//			PropHandler.setFrequency(AdminPropHandler.getConfProp("admin.spiders.od"), request.getParameter("frequency"));
			message = "Properties seted properly";
		} catch (Exception e) {
			message = "There was an error setting properties. Try again.";
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		return spiderOd(request, response);
	}
	
	/**
	 * SpiderRating parameters
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderRating(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("downUrl", PropHandler.getFileDownProp("url.web.rating"));
//		data.put("rowIdentifierRating", PropHandler.getDaoProp("rating.rowIdentifier"));
//		data.put("downFolder", PropHandler.getDaoProp("rating.localRatingLog"));
//		data.put("historicFolder", PropHandler.getDbProp("history.rating"));
//		data.put("frequency", PropHandler.getFrequency(AdminPropHandler.getConfProp("admin.spiders.rating")));
		data.put("menuItems", menuItems);
		return new ModelAndView(spiderRatingView,data);
	}
	
	public ModelAndView spiderRatingSave(HttpServletRequest request, HttpServletResponse response) {
		String message = "";
		
		try {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("rating.rowIdentifier", request.getParameter("rowIdentifierRating"));
			properties.put("rating.localRatingLog", request.getParameter("downFolder"));
			properties.put("history.rating", request.getParameter("historicFolder"));
//			PropHandler.setDaoProps(properties);
			Map<String, String> urlProps = new HashMap<String, String>();
			urlProps.put("url.web.rating", request.getParameter("downUrl"));
//			PropHandler.setFileDownProps(urlProps);
//			PropHandler.setFrequency(AdminPropHandler.getConfProp("admin.spiders.rating"), request.getParameter("frequency"));
			message = "Properties seted properly";
		} catch (Exception e) {
			message = "There was an error setting properties. Try again.";
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		return spiderRating(request, response);
	}

	/**
	 * SpiderChannel parameters
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderChannel(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("downUrl", PropHandler.getFileDownProp("url.web.channelList"));
//		data.put("rowIdentifierChannel", PropHandler.getDaoProp("channel.rowIdentifier"));
//		data.put("downFolder", PropHandler.getDaoProp("channel.localChannelLog"));
//		data.put("processFolder", PropHandler.getDaoProp("channel.xml.processResult"));
//		data.put("historicFolder", PropHandler.getDbProp("history.channel"));
//		data.put("frequency", PropHandler.getFrequency(AdminPropHandler.getConfProp("admin.spiders.channel")));
		data.put("menuItems", menuItems);
		
		//Metadata
//		data.put("channelMetadata", PropHandler.getMetadata("C"));
		
		return new ModelAndView(spiderChannelView,data);
	}
	
	public ModelAndView spiderChannelSave(HttpServletRequest request, HttpServletResponse response) {
		String message = "";
		try {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("channel.rowIdentifier", request.getParameter("rowIdentifierChannel"));
			properties.put("channel.localChannelLog", request.getParameter("downFolder"));
			properties.put("channel.xml.processResult", request.getParameter("processFolder"));
			properties.put("history.channel", request.getParameter("historicFolder"));
//			PropHandler.setDaoProps(properties);
			Map<String, String> urlProps = new HashMap<String, String>();
			urlProps.put("url.web.channelList", request.getParameter("downUrl"));
//			PropHandler.setFileDownProps(urlProps);
//			PropHandler.setFrequency(AdminPropHandler.getConfProp("admin.spiders.channel"), request.getParameter("frequency"));
			message = "Properties seted properly";
		} catch (Exception e) {
			message = "There was an error setting properties. Try again.";
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		return spiderChannel(request, response);
	}
	
	/**
	 * Saves channel metadata
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderChannelSaveMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.insertMetadata("C", request.getParameter("keyName"), request.getParameter("keyValue"));
		return spiderChannel(request, response);
	}
	
	/**
	 * Updates channel metadata.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderChannelUpdateMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.updateMetadata("C", Long.parseLong(request.getParameter("channelMetaId")), request.getParameter("keyName"), request.getParameter("keyValue"));
		return spiderChannel(request, response);
	}
	
	/**
	 * Deletes channel metadata.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderChannelDeleteMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.deleteMetadata("C", Long.parseLong(request.getParameter("channelMetaId")));
		return spiderChannel(request, response);
	}
	
	
	/**
	 * SpiderVod parameters
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderVod(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("orcaLoggin", PropHandler.getFileDownProp("loggin.url"));
//		data.put("downUrl", PropHandler.getFileDownProp("url.web.videoList"));
//		data.put("downUrlPage", PropHandler.getFileDownProp("url.web.pageList"));
//		data.put("rowIdentifierPage", PropHandler.getDaoProp("vod.rowIdentifier.pageList"));
//		data.put("rowIdentifierVideo", PropHandler.getDaoProp("vod.rowIdentifier.vodContent"));
//		data.put("downFolder", PropHandler.getDaoProp("vod.localVodContentLog"));
//		data.put("processFolder", PropHandler.getDaoProp("vod.page.processResult"));
//		data.put("historicFolder", PropHandler.getDbProp("history.vod"));
//		data.put("frequency", PropHandler.getFrequency(AdminPropHandler.getConfProp("admin.spiders.vod")));
		data.put("menuItems", menuItems);
		
		//Metadata
//		data.put("pageMetadata", PropHandler.getMetadata("P"));
//		data.put("vodMetadata", PropHandler.getMetadata("V"));
		
		return new ModelAndView(spiderVodView,data);
	}
	
	public ModelAndView spiderVodSave(HttpServletRequest request, HttpServletResponse response) {
		String message = "";
		try {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("vod.rowIdentifier.pageList", request.getParameter("rowIdentifierPage"));
			properties.put("vod.rowIdentifier.vodContent", request.getParameter("rowIdentifierVideo"));
			properties.put("vod.localVodContentLog", request.getParameter("downFolder"));
			properties.put("vod.page.processResult", request.getParameter("processFolder"));
			properties.put("history.vod", request.getParameter("historicFolder"));
//			PropHandler.setDaoProps(properties);
			Map<String, String> urlProps = new HashMap<String, String>();
			urlProps.put("loggin.url", request.getParameter("orcaLoggin"));
			urlProps.put("url.web.videoList", request.getParameter("downUrl"));
			urlProps.put("url.web.pageList", request.getParameter("downUrlPage"));
//			PropHandler.setFileDownProps(urlProps);
//			PropHandler.setFrequency(AdminPropHandler.getConfProp("admin.spiders.vod"), request.getParameter("frequency"));
			message = "Properties seted properly";
		} catch (Exception e) {
			message = "There was an error setting properties. Try again.";
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		return spiderVod(request, response);
	}
	
	/**
	 * Saves vod metadata
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderVodSaveMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.insertMetadata("V", request.getParameter("keyName"), request.getParameter("keyValue"));
		return spiderVod(request, response);
	}
	
	/**
	 * Updates vod metadata.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderVodUpdateMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.updateMetadata("V", Long.parseLong(request.getParameter("vodMetaId")), request.getParameter("keyName"), request.getParameter("keyValue"));
		return spiderVod(request, response);
	}
	
	/**
	 * Deletes vod metadata.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderVodDeleteMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.deleteMetadata("V", Long.parseLong(request.getParameter("vodMetaId")));
		return spiderVod(request, response);
	}
	
	/**
	 * Saves page metadata
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderPageSaveMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.insertMetadata("P", request.getParameter("keyName"), request.getParameter("keyValue"));
		return spiderVod(request, response);
	}
	
	/**
	 * Updates page metadata.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderPageUpdateMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.updateMetadata("P", Long.parseLong(request.getParameter("pageMetaId")), request.getParameter("keyName"), request.getParameter("keyValue"));
		return spiderVod(request, response);
	}
	
	/**
	 * Deletes page metadata.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView spiderPageDeleteMetadata(HttpServletRequest request, HttpServletResponse response) {
//		PropHandler.deleteMetadata("P", Long.parseLong(request.getParameter("pageMetaId")));
		return spiderVod(request, response);
	}
	
	
	//UTILS
	public void createMenu(){
		menuItems = new MenuHandler().processMenu(this.getClass().getSimpleName());
	}
	

	//SETTINGS
	public void setGeneralOptsView(String generalOptsView) {
		this.generalOptsView = generalOptsView;
	}

	public void setMenuItems(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public void setSpiderVodView(String spiderVodView) {
		this.spiderVodView = spiderVodView;
	}

	public void setSpiderOdView(String spiderOdView) {
		this.spiderOdView = spiderOdView;
	}

	public void setSpiderEpgView(String spiderEpgView) {
		this.spiderEpgView = spiderEpgView;
	}

	public void setSpiderRatingView(String spiderRatingView) {
		this.spiderRatingView = spiderRatingView;
	}

	public void setSpiderChannelView(String spiderChannelView) {
		this.spiderChannelView = spiderChannelView;
	}
}