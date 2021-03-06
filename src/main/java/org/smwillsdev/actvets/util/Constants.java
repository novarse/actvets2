package org.smwillsdev.actvets.util;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Constants {

	public static final String LOAD_DATA_SECTION = "loadDataSection";

	public static final String MEMBER = "member";
	public static final String EVENT_TYPE = "eventType";
	public static final String EVENT_SEASON = "eventSeason";
	public static final String EVENT_LOCATION = "eventLocation";
	public static final String EVENT_DESC = "eventDesc";
	public static final String EVENT = "event";
	public static final String RACE_HISTORY = "raceHistory";

	public static final String LOAD_MEMBER = "loadMember";
	public static final String LOAD_EVENT_TYPE = "loadEventType";
	public static final String LOAD_EVENT_SEASON = "loadEventSeason";
	public static final String LOAD_EVENT_LOCATION = "loadEventLocation";
	public static final String LOAD_EVENT_DESC = "loadEventDesc";
	public static final String LOAD_EVENT = "loadEvent";
	public static final String LOAD_RACE_HISTORY = "loadRaceHistory";

	public static final String TZ_AUSTRALIA_NSW = "Australia/NSW";
	public static final String FUTURE_EVENT_DETAILS = "futureEventDetails";
	public static final String E_DD_MMM_HH_MM = "E dd MMM h:mma";
	public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy h:mma";

	public static final String UPLOAD_MESSAGE = "uploadMessage";

	public static SimpleDateFormat formatterE_DD_MMM_HH_MM = new SimpleDateFormat(
			E_DD_MMM_HH_MM);

	public static SimpleDateFormat formatterDD_MM_YYYY_HH_MM = new SimpleDateFormat(
			DD_MM_YYYY_HH_MM);

	public static SimpleDateFormat getFormatterE_DD_MMM_HH_MM() {
		formatterE_DD_MMM_HH_MM.setTimeZone(TimeZone
				.getTimeZone(TZ_AUSTRALIA_NSW));
		return formatterE_DD_MMM_HH_MM;
	}

	public static SimpleDateFormat getFormatterDD_MM_YY_HH_MM() {
		formatterDD_MM_YYYY_HH_MM.setTimeZone(TimeZone
				.getTimeZone(TZ_AUSTRALIA_NSW));
		return formatterDD_MM_YYYY_HH_MM;
	}

}
