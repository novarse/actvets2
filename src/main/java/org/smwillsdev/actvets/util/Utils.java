package org.smwillsdev.actvets.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.smwillsdev.actvets.domain.EventDesc;
import org.smwillsdev.actvets.type.AuState;
import org.smwillsdev.actvets.type.Gender;

public class Utils {

	private static final String FALSE = "false";

	private static final String F = "f";

	private static final String T = "t";

	private static final String TRUE = "true";

	private static final String _0_0 = "0.0";

	private static final String _0 = "0";

	static Logger log = Logger.getLogger(Utils.class.getClass().getName());

	private static final String ACT = "ACT";

	public static AuState getStateFromStr(String state) {
		AuState result = null;
		if (state == null || state.isEmpty()) {
			result = null;
		} else {
			state = state.toUpperCase();
			try {
				result = AuState.valueOf(state.toUpperCase());
			} catch (IllegalArgumentException e) {
				log.warning("Invalid Australian state: " + state);
			}
		}
		return result;
	}

	public static String getDistStr(EventDesc eventDesc) {
		if (eventDesc == null) {
			return "";
		} else {
			return getDistStr(eventDesc.getDistLong() == null ? null
					: eventDesc.getDistLong().toString(),
					eventDesc.getDistShort() == null ? null : eventDesc
							.getDistShort().toString());
		}

	}

	public static String getDistStr(String distLong, String distShort) {
		StringBuilder result = new StringBuilder("");
		if (distLong != null && !distLong.isEmpty()
				&& !(_0.equals(distLong) || _0_0.equals(distLong))) {
			result = result.append("(" + distLong + "km");
			if (distShort != null && !distShort.isEmpty()
					&& !(_0.equals(distShort) || _0_0.equals(distShort))
					&& !distLong.equals(distShort)) {
				result.append(", " + distShort + "km");
			}
			result.append(")");
		} else if (distShort != null && !distShort.isEmpty()
				&& !(_0.equals(distShort) || _0_0.equals(distShort))
				&& !distShort.equals(distLong)) {
			result.append("(" + distShort + "km)");
		}
		return result.toString();
	}

	public static String getEventLine(String title, String eventType,
			String director, String distLong, String distShort) {
		StringBuilder result = new StringBuilder("");
		if (title != null && !title.isEmpty()) {
			result.append(title);
		}
		if (eventType != null && !eventType.isEmpty()) {
			result.append(", " + eventType);
		}
		if (director != null && !director.isEmpty()) {
			result.append(" (" + director + ")");
		}
		String distStr = getDistStr(distLong, distShort);
		if (!"".equals(distStr)) {
			result.append(", Dist" + distStr + "");
		}
		return result.toString();
	}

	public static Integer getIntegerFromStr(String str) {
		if (str != null && !str.isEmpty()) {
			try {
				int result = Integer.parseInt(str);
				return result;
			} catch (NumberFormatException e) {
				log.warning("Error getting Integer from String: " + str);
			}
		}
		return null;
	}

	public static Date getDDMMYYYYDateFromStr(String str) {
		if (str != null && !str.isEmpty()) {
			String[] parts = str.split("[/-]");
			try {
				Calendar cal = Calendar.getInstance(TimeZone
						.getTimeZone(Constants.TZ_AUSTRALIA_NSW));
				cal.set(Integer.parseInt(parts[2]),
						Integer.parseInt(parts[1]) - 1,
						Integer.parseInt(parts[0]));

				return cal.getTime();
			} catch (NumberFormatException e) {
				log.warning("Error getting Date from String: " + str);
			}
		}
		return null;
	}

	public static Gender getGenderFromStr(String str) {
		if (str != null && !str.isEmpty()) {
			if (str.matches("[mM]")) {
				return Gender.M;
			} else if (str.matches("[fF]")) {
				return Gender.F;
			}
		}
		return null;
	}

	public static boolean getBooleanFromStr(String str) {
		if (str != null && !str.isEmpty()) {
			str = str.toLowerCase();
			if (FALSE.equals(str.toLowerCase()) || F.equals(str.toLowerCase())) {
				return false;
			} else if (TRUE.equals(str.toLowerCase())
					|| T.equals(str.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
