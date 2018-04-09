package edu.hm.cs.softarch.kwic.dip;

/**
 * Interface für Objekte, die Listen von {@link KwicEntry}s entgegennehmen
 * können und daraus eine neue Liste ableiten und bereitstellen.
 * 
 * @author katz.bastian
 */
public interface EntryListFilter extends EntryListProvider, EntryListConsumer {
	// keine eigenen Methoden!
}
