/**
 * 
 */
package ar.com.itba.weathermap.web.support;

import java.io.IOException;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Utility class for faces context.
 * 
 * @author David Cisneros
 *
 */
public final class FacesContextUtils {

	private static final Logger LOGGER = Logger.getLogger(FacesContextUtils.class);
	/**
	 * 
	 */
	private FacesContextUtils() {
		super();
	}
	
	/**
	 * Returns External Context from actual Faces context
	 * 
	 * @return
	 */
	public static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	/**
	 * Returns application request
	 * 
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return ((HttpServletRequest) getExternalContext().getRequest());
	}
	
	/**
	 * @return servlet context path
	 */
	public static String getContextPath(){
		return getHttpServletRequest().getContextPath();
	}
	
	/**
	 * @param key
	 * @return
	 */
	public static String getParameterFromRequestMap(String key){
		Map<String, String> parameterMap = (Map<String, String>) getExternalContext().getRequestParameterMap();
		return parameterMap.get(key);
	}
	
	/**
	 * @param page
	 */
	public static void facesRedirect(String page){
		try {
			getExternalContext().redirect(getExternalContext().getRequestContextPath() + page);
		} catch (IOException e) {
			LOGGER.error("Can't redirect:" + e.getMessage());
		}
	}
}
