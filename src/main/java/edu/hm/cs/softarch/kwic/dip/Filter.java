package edu.hm.cs.softarch.kwic.dip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Klasse zum Ausfiltern irrelevanter Einträge in einer Liste von
 * Kwic-Index-Einträgen.
 * 
 * @author katz.bastian
 */
public class Filter implements EntryListFilter {

	private static Filter instance = null;
	private Filter(){};

	public static Filter getInstance(){
		if(instance == null){
			instance = new Filter();
		}
		return instance;
	}

	private List<KwicEntry> entries = new ArrayList<>();

	@Override
	public void take(EntryListProvider provider) {
		for (KwicEntry entry : provider.getEntries()) {

			// Hier könnte man natürlich auch Stopplisten überprüfen!
			if (!entry.getWord().equalsIgnoreCase("the")) {
				entries.add(entry);
			}
		}
	}

	@Override
	public List<KwicEntry> getEntries() {
		return Collections.unmodifiableList(entries);
	}
}
