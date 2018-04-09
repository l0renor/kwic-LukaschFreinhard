package edu.hm.cs.softarch.kwic.dip;

import java.util.List;
// Ergibt keinen Sinn wir nie Initialisiert.

public abstract class AbstractKwicFac {
    public abstract EntryListConsumer createConsumer();
    public abstract Input createInput(String fileName);
    public abstract EntryCreator createCreatort();
    public abstract List<EntryListFilter> createFilter();
}
