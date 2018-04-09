package edu.hm.cs.softarch.kwic.dip.creator;

import java.util.Collections;
import java.util.List;

import edu.hm.cs.softarch.kwic.dip.KwicEntry;

/**
 * Klasse zur Repräsentation eines Eintrags in einem Kwic-Index. Diese
 * Implementierung speichert die Phrase als Liste von Wörtern mit einem Index
 * auf das indizierte Wort. Links- und Rechtskontext werden dann daraus
 * ermittelt.s
 * 
 * @author katz.bastian
 */
public class IndexingKwicEntry implements KwicEntry {

	private final List<String> context;
	private final int indexOfWord;

	public IndexingKwicEntry(final List<String> context, final int indexOfWord) {
		super();
		this.context = context;
		this.indexOfWord = indexOfWord;
	}

	/* (non-Javadoc)
	 * @see edu.hm.cs.softarch.kwic.oop.KwicIndex#getWord()
	 */
	@Override
	public String getWord() {
		return context.get(indexOfWord);
	}

	/* (non-Javadoc)
	 * @see edu.hm.cs.softarch.kwic.oop.KwicIndex#getPreContext()
	 */
	@Override
	public List<String> getPreContext() {
		return Collections.unmodifiableList(context.subList(0, indexOfWord));
	}

	/* (non-Javadoc)
	 * @see edu.hm.cs.softarch.kwic.oop.KwicIndex#getPostContext()
	 */
	@Override
	public List<String> getPostContext() {
		return Collections.unmodifiableList(context.subList(indexOfWord + 1, context.size()));
	}

	/* (non-Javadoc)
	 * @see edu.hm.cs.softarch.kwic.oop.KwicIndex#hasPostContext()
	 */
	@Override
	public boolean hasPostContext() {
		return indexOfWord != context.size() - 1;
	}

	/* (non-Javadoc)
	 * @see edu.hm.cs.softarch.kwic.oop.KwicIndex#hasPreContext()
	 */

	@Override
	public boolean hasPreContext() {
		return indexOfWord > 0;
	}
}
