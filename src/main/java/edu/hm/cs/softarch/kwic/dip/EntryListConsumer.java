package edu.hm.cs.softarch.kwic.dip;

/**
 * Interface für Objekte, die eine Liste von {@link KwicEntry}s aufnehmen
 * können.
 * 
 * @author katz.bastian
 *
 */
public interface EntryListConsumer {

	/**
	 * @param provider
	 *            Provider, von dem Einträge entgegengenommen werden.
	 */
	void take(EntryListProvider provider);
}
