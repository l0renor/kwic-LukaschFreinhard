package edu.hm.cs.softarch.kwic.dip;

/**
 * Interface für Klassen zum Einlesen einer Quelle mit Phrasen und Übergabe an
 * einen {@link EntryCreator}.
 * 
 * @author katz.bastian
 */
public interface Input {

	/**
	 * Übergibt die enthaltenen Phrasen an einen {@link EntryCreator}.
	 * 
	 * @param shifter
	 */
	void read(EntryCreator shifter);
}
