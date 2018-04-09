package edu.hm.cs.softarch.kwic.dip;

/**
 * Interface für Objekte, die Phrasen entgegennehmen und daraus
 * {@link KwicEntry}s erstellen.
 * 
 * @author katz.bastian
 */
public interface EntryCreator extends EntryListProvider {
	void addPhrase(String phrase);
}
