package edu.hm.cs.softarch.kwic.dip.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.hm.cs.softarch.kwic.dip.EntryCreator;
import edu.hm.cs.softarch.kwic.dip.Input;
import edu.hm.cs.softarch.kwic.dip.creator.IndexingEntryCreator;

/**
 * Klasse zum Einlesen einer Datei mit Phrasen. Die Zeilen werden einem
 * {@link IndexingEntryCreator}-Objekt übergeben, das daraus die Einträge erstellt.
 * 
 * @author katz.bastian
 */
public class SimpleFileInput implements Input {
	private static Logger LOG = LoggerFactory.getLogger(SimpleFileInput.class);

	private String fileName;

	public SimpleFileInput(String fileName) {
		this.fileName = fileName;
	}

	/* (non-Javadoc)
	 * @see edu.hm.cs.softarch.kwic.oop.Input#read(edu.hm.cs.softarch.kwic.oop.ShifterInput)
	 */
	public void read(EntryCreator consumer) {
		Path inFile = Paths.get(fileName);
		try {
			for (String line : Files.readAllLines(inFile)) {
				consumer.addPhrase(line);
			}
		} catch (IOException e) {
			LOG.error("Fehler beim Einlesen: " + e);
			System.exit(1);
		}
	}
}
