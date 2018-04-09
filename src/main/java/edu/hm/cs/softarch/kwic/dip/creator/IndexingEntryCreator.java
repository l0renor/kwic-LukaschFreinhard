package edu.hm.cs.softarch.kwic.dip.creator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.hm.cs.softarch.kwic.dip.EntryCreator;
import edu.hm.cs.softarch.kwic.dip.KwicEntry;

/**
 * Klasse zum Erstellen einer List von Indexeinträgen bestehend aus Wörtern und
 * ihrem Kontext. 
 * 
 * @see IndexingKwicEntry
 * 
 * @author katz.bastian
 *
 */
public class IndexingEntryCreator implements EntryCreator {

	private List<KwicEntry> entries = new ArrayList<>();

	/**
	 * Nimmt eine neue Phrase auf, indem es für alle enthaltenen Wörter einen
	 * Eintrag erstellt.
	 * 
	 * @param phrase Phrase oder Titel zur Indexerstellung
	 */
	@Override
	public void addPhrase(String phrase) {
		List<String> context = Arrays.asList(phrase.trim().split(" "));

		for (int i = 0; i < context.size(); i++) {
			entries.add(new IndexingKwicEntry(context, i));
		}

	}

	/**
	 * Liefert die Liste aller Einträge
	 * @return
	 */
	@Override
	public Iterable<KwicEntry> getEntries() {
		return Collections.unmodifiableList(entries);
	}
}
