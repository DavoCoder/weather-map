/**
 * 
 */
package ar.com.itba.weathermap.web.map.marker;

/**
 * Enum for marker icons path.
 * 
 * @author David Cisneros
 *
 */
public enum MarkerIconEnum {

	
	BASE_PATH("/resources/icons/markers/"),
	BLUE_MARKER(MarkerIconEnum.BASE_PATH.getIconPath().concat("blue.png")),
	RED_MARKER(MarkerIconEnum.BASE_PATH.getIconPath().concat("red.png")),
	GREEN_MARKER(MarkerIconEnum.BASE_PATH.getIconPath().concat("green.png")),
	WHITE_MARKER(MarkerIconEnum.BASE_PATH.getIconPath().concat("white.png")),
	GRAY_MARKER(MarkerIconEnum.BASE_PATH.getIconPath().concat("gray.png")),
	PURPLE_MARKER(MarkerIconEnum.BASE_PATH.getIconPath().concat("purple.png")),
	;
	
	private final String iconPath;

	/**
	 * @param iconPath
	 */
	private MarkerIconEnum(String iconPath) {
		this.iconPath = iconPath;
	}

	/**
	 * @return the iconPath
	 */
	public String getIconPath() {
		return iconPath;
	}
	
	
}
