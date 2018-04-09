package edu.hm.cs.softarch.kwic.dip;

import edu.hm.cs.softarch.kwic.dip.creator.IndexingEntryCreator;
import edu.hm.cs.softarch.kwic.dip.input.SimpleFileInput;
import edu.hm.cs.softarch.kwic.dip.output.AlternativeOutput;
import edu.hm.cs.softarch.kwic.dip.output.ConsoleOutput;

import java.util.LinkedList;
import java.util.List;

public class KwicFac2 extends AbstractKwicFac {

    private static KwicFac2 instance = null;
    private KwicFac2(){};

    public static KwicFac2 getInstance(){
        if(instance == null){
            instance = new KwicFac2();
        }
        return instance;
    }
    @Override
    public EntryListConsumer createConsumer() {
        return ConsoleOutput.getInstance();
    }

    @Override
    public Input createInput(String fileName) {
       return new SimpleFileInput(fileName);
    }

    @Override
    public EntryCreator createCreatort() {
        return new IndexingEntryCreator();
    }

    @Override
    public List<EntryListFilter> createFilter() {
        List<EntryListFilter> filters = new LinkedList<>();
        filters.add(Sorter.getInstance());
        filters.add(new Filter());
        return filters;
    }

}
