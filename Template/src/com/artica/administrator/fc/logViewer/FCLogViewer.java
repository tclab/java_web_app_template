package com.artica.administrator.fc.logViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.artica.recommender.conf.PropHandler;
import com.artica.recommender.model.RecomLogRecord;

public class FCLogViewer extends MultiActionController {
	private String logView;

	/**
	 * Init
	 * @param reques
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		
		try {
			
			ArrayList<RecomLogRecord> logs = PropHandler.getLog();
			StringBuffer recLog = new StringBuffer();
			for (RecomLogRecord logRecord : logs) {
				recLog.append(logRecord.date + " - " + logRecord.level + " - " + logRecord.message + "\n");
			}
			
			data.put("logText", recLog);
		} catch (Exception e) {
			data.put("message", "There was an error reading the log!");
			e.printStackTrace();
		}
		return new ModelAndView(this.logView, data);
	}

	//SETTINGS
	public void setLogView(String logView) {
		this.logView = logView;
	}
}