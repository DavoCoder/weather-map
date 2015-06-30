/**
 * 
 */
package ar.com.itba.weathermap.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Webservice Response.
 * 
 * @author David Cisneros
 *
 */
@XmlRootElement(name = "Response")
public class Response {

	private String responseCode;
	
	private String responseDescription;

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseDescription
	 */
	public String getResponseDescription() {
		return responseDescription;
	}

	/**
	 * @param responseDescription the responseDescription to set
	 */
	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}
	
	
}
