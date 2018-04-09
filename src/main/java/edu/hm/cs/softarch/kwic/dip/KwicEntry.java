package edu.hm.cs.softarch.kwic.dip;

import java.util.List;

/**
 * Eintrag für einen Keyword-In-Context-Verzeichnis.
 * 
 * @author katz.bastian
 */
public interface KwicEntry {

	/**
	 * @return das indizierte Wort
	 */
	String getWord();

	/**
	 * @return Liste der Wörter, die in der Phrase auf das indizierte Wort
	 *         folgen.
	 */
	List<String> getPreContext();

	/**
	 * @return Liste der Wörter, die in der Phrase vor dem indizierten Wort
	 *         stehen.
	 */
	List<String> getPostContext();

	/**
	 * @return ob in der Phrase Wörter auf das indizierte Wort folgen.
	 */
	boolean hasPostContext();

	/**
	 * @return ob in der Phrase vor dem indizierten Wort Wörter stehen.
	 */

	boolean hasPreContext();

}