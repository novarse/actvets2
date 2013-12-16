package org.smwillsdev.actvets.util;

import java.util.logging.Logger;

import org.smwillsdev.actvets.domain.EventDesc;
import org.smwillsdev.actvets.type.AuState;

public class Utils {

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
}
