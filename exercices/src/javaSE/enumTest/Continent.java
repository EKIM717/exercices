package javaSE.enumTest;

import java.util.Collection;
import java.util.Set;

/**
 * @author Lijk
 *
 */
public enum Continent {

	ASIA("Asia"),
	EUROPE("Europe"),
	AUSTRALIA("Australia"),
	NORTH_AMERICA("North America"),
	SOUTH_AMERICA("South America"),
	AFRICA("Africa"),
	ANTARCTICA("Antarctica"),
	
	UNKNOWN("Unknown");

	private final String value;

	Continent(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	public Set<Country> include() {
		return Country.fromContinent(this);
	}

	public Set<Country> rid(Collection<Country> c) {
		Set<Country> cs = Country.fromContinent(this);
		cs.removeAll(c);
		return cs;
	}

}
