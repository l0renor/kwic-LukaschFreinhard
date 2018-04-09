package edu.hm.cs.softarch.kwic.dip;

import java.util.ArrayList;
import java.util.List;

import edu.hm.cs.softarch.kwic.dip.creator.IndexingEntryCreator;
import edu.hm.cs.softarch.kwic.dip.input.SimpleFileInput;
import edu.hm.cs.softarch.kwic.dip.output.AlternativeOutput;

/**
 * Klasse zum Einlesen, Erstellen und Ausgeben einer Liste von Schlüsselwörtern
 * im Kontext. Verbindet die Verarbeitungsschritte.
 * 
 * @author katz.bastian
 */
public class Kwic {

	private Input input;
	private IndexingEntryCreator creator;
	private List<EntryListFilter> filters = new ArrayList<>();
	private EntryListConsumer consumer;

	/**
	 * Konstruktor.
	 * 
	 * @param phraseFileName
	 *            Dateiname mit Phrasen oder Titeln (zeilenweise).
	 */
	public Kwic(String phraseFileName) {
		input = new SimpleFileInput(phraseFileName);		
		creator = new IndexingEntryCreator();
		filters.add(new Sorter());
		filters.add(new Filter());
		consumer = new AlternativeOutput();
	}

	/**
	 * Stößt die Verarbeitung an.
	 */
	public void print() {
		input.read(creator);
		EntryListProvider previous = creator;
		
		for (EntryListFilter filter: filters) {
			filter.take(previous);
			previous = filter;
		}
		consumer.take(previous);
	}

}
