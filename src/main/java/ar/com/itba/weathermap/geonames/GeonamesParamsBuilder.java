/**
 * 
 */
package ar.com.itba.weathermap.geonames;


/**
 * Builder for geonames params.
 * 
 * @author David Cisneros
 *
 */
public class GeonamesParamsBuilder {

	/**
	 * @return
	 */
	public static String[] getFeatureCodes() {
		String[] featureCodes = {"PPLA","PPLA2","PPLA3","PPLA4","PPLC","PPLS","PPLL"};
		return featureCodes;
	}

}
