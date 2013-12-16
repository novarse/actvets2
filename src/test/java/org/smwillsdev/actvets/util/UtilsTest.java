package org.smwillsdev.actvets.util;

import org.junit.Assert;
import org.junit.Test;
import org.smwillsdev.actvets.domain.EventDesc;

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
}
