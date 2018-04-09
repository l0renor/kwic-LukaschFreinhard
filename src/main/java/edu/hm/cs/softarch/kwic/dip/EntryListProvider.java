package edu.hm.cs.softarch.kwic.dip;

/**
 * Interface für Klassen, die Listen von {@link KwicEntry}s bereitstellen.
 * 
 * @author katz.bastian
 */
public interface EntryListProvider {
	/**
	 * @return Liste von {@link KwicEntry}s.
	 */
	Iterable<KwicEntry> getEntries();
}
