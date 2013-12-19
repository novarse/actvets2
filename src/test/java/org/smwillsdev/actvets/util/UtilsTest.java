package org.smwillsdev.actvets.util;

import java.util.Calendar;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;
import org.smwillsdev.actvets.domain.EventDesc;
import org.smwillsdev.actvets.type.Gender;

public class UtilsTest {

	private static final float _0F = 0F;
	private static final float _45_8F = 45.8F;
	private static final float _15_7F = 15.7F;
	private static final String _45_8KM = "45.8km";
	private static final String _15_7KM = "15.7km";

	@Test
	public void testGetDistStr() {
		EventDesc desc = null;

		Assert.assertEquals("", Utils.getDistStr(desc));

		desc = new EventDesc();
		desc.setDescription("Test Desc");
		Assert.assertEquals("", Utils.getDistStr(desc));

		desc.setDistLong(_0F);
		Assert.assertEquals("", Utils.getDistStr(desc));

		desc.setDistLong(_45_8F);
		Assert.assertEquals("(" + _45_8KM + ")", Utils.getDistStr(desc));

		desc.setDistShort(0F);
		Assert.assertEquals("(" + _45_8KM + ")", Utils.getDistStr(desc));

		desc.setDistShort(_15_7F);
		Assert.assertEquals("(" + _45_8KM + ", " + _15_7KM + ")",
				Utils.getDistStr(desc));

		desc.setDistShort(_45_8F);
		Assert.assertEquals("(" + _45_8KM + ")", Utils.getDistStr(desc));

		desc.setDistLong(null);
		desc.setDistShort(_15_7F);
		Assert.assertEquals("(" + _15_7KM + ")", Utils.getDistStr(desc));
	}

	@Test
	public void testGetEventLine() {
		Assert.assertEquals("", Utils.getEventLine("", "", "", "", ""));
		Assert.assertEquals("Title",
				Utils.getEventLine("Title", "", "", "", ""));
		Assert.assertEquals("Title, EventType",
				Utils.getEventLine("Title", "EventType", "", "", ""));
		Assert.assertEquals("Title, EventType (Director)",
				Utils.getEventLine("Title", "EventType", "Director", "", ""));
		Assert.assertEquals("Title, EventType (Director), Dist(34km)",
				Utils.getEventLine("Title", "EventType", "Director", "34", ""));
		Assert.assertEquals(
				"Title, EventType (Director), Dist(34km, 23km)",
				Utils.getEventLine("Title", "EventType", "Director", "34", "23"));
	}

	@Test
	public void testGetIntegerFromStr() {
		Assert.assertEquals(null, Utils.getIntegerFromStr(null));
		Assert.assertEquals(null, Utils.getIntegerFromStr(""));
		Assert.assertEquals(null, Utils.getIntegerFromStr("hjh"));
		Assert.assertEquals((Integer) 9, Utils.getIntegerFromStr("9"));
	}

	@Test
	public void testGetDDMMYYYYDateFromStr() {
		Assert.assertEquals(null, Utils.getDDMMYYYYDateFromStr(null));
		Assert.assertEquals(null, Utils.getDDMMYYYYDateFromStr(""));

		Calendar cal = Calendar.getInstance(TimeZone
				.getTimeZone(Constants.TZ_AUSTRALIA_NSW));
		cal.set(1999, Calendar.JANUARY, 31);
		Assert.assertEquals(cal.getTime().toString(), Utils
				.getDDMMYYYYDateFromStr("31/1/1999").toString());
		Assert.assertEquals(cal.getTime().toString(), Utils
				.getDDMMYYYYDateFromStr("31-1-1999").toString());
		Assert.assertEquals(cal.getTime().toString(), Utils
				.getDDMMYYYYDateFromStr("31/1/1999 01:00:00").toString());
	}

	@Test
	public void testGetDDMMYYYYHHMMDateFromStr() {
		Assert.assertEquals(null, Utils.getDDMMYYYYHHMMDateFromStr(null));
		Assert.assertEquals(null, Utils.getDDMMYYYYHHMMDateFromStr(""));

		Calendar cal = Calendar.getInstance(TimeZone
				.getTimeZone(Constants.TZ_AUSTRALIA_NSW));
		cal.set(1999, Calendar.JANUARY, 31);
		Assert.assertEquals(cal.getTime().toString(), Utils
				.getDDMMYYYYHHMMDateFromStr("31/1/1999").toString());
		Assert.assertEquals(cal.getTime().toString(), Utils
				.getDDMMYYYYHHMMDateFromStr("31-1-1999").toString());

		Assert.assertEquals(null, Utils.getDDMMYYYYHHMMDateFromStr("31/1"));

		Assert.assertEquals(null,
				Utils.getDDMMYYYYHHMMDateFromStr("31/1/1999 01"));

		cal.set(1999, Calendar.JANUARY, 31, 01, 30, 00);
		Assert.assertEquals(cal.getTime().toString(), Utils
				.getDDMMYYYYHHMMDateFromStr("31/1/1999 01:30:00").toString());
	}

	@Test
	public void testGetGenderFromStr() {
		Assert.assertEquals(null, Utils.getGenderFromStr(null));
		Assert.assertEquals(null, Utils.getGenderFromStr(""));
		Assert.assertEquals(null, Utils.getGenderFromStr("hjhj"));
		Assert.assertEquals(Gender.M, Utils.getGenderFromStr("M"));
		Assert.assertEquals(Gender.M, Utils.getGenderFromStr("m"));
		Assert.assertEquals(Gender.F, Utils.getGenderFromStr("F"));
		Assert.assertEquals(Gender.F, Utils.getGenderFromStr("f"));
	}

	@Test
	public void testGetBooleanFromStr() {
		Assert.assertEquals(false, Utils.getBooleanFromStr(null));
		Assert.assertEquals(false, Utils.getBooleanFromStr("jkj"));
		Assert.assertEquals(false, Utils.getBooleanFromStr("f"));
		Assert.assertEquals(false, Utils.getBooleanFromStr("false"));
		Assert.assertEquals(true, Utils.getBooleanFromStr("t"));
		Assert.assertEquals(true, Utils.getBooleanFromStr("true"));
		Assert.assertEquals(true, Utils.getBooleanFromStr("TRUE"));
	}
}
