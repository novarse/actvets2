package org.smwillsdev.actvets.type;

/**
 * Saved in database as ordinal. Used by {@link Institution}.
 * 
 * @author novarse
 * 
 */
public enum AuState {
	ACT("Australian Capital Territories"), NSW("New South Wales"), NT(
			"Northern Territories"), QLD("Queensland"), SA("South Australia"), TAS(
			"Tasmania"), VIC("Victoria"), WA("Western Australia");

	private String name;

	private AuState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
