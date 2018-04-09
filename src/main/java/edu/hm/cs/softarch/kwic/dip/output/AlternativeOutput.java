package edu.hm.cs.softarch.kwic.dip.output;

import java.util.ArrayList;
import java.util.List;

import edu.hm.cs.softarch.kwic.dip.EntryListConsumer;
import edu.hm.cs.softarch.kwic.dip.EntryListProvider;
import edu.hm.cs.softarch.kwic.dip.KwicEntry;

/**
 * Klasse zur Ausgabe eines Wortes mit seinem Kontext in alternativer Form.
 * 
 * @author katz.bastian
 */
public class AlternativeOutput implements EntryListConsumer {
	private static AlternativeOutput instance = null;
	public AlternativeOutput(){};

	public static AlternativeOutput getInstance() {
		if (instance == null) {
			instance = new AlternativeOutput();
		}
		return instance;
	}

	@Override
	public void take(EntryListProvider provider) {

		for (KwicEntry kwicEntry : provider.getEntries()) {

			List<String> context = new ArrayList<String>();
			context.addAll(kwicEntry.getPreContext());
			context.add("..");
			context.addAll(kwicEntry.getPostContext());

			String result = kwicEntry.getWord() + ": " + String.join(" ", context);

			System.out.println(result);
		}
	}
}
