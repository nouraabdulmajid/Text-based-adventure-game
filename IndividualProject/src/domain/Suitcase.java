package domain;

import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Clothing> contents;

    public Suitcase() {
        this.contents = new ArrayList<Clothing>();
    }

    public ArrayList<Clothing> getContents() {

        return this.contents;
    }

    public boolean hasItem(Clothing name) {
        for (Clothing c: contents) {
            if (name.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public void addItem(Clothing name) {
        this.contents.add(name);
    }

    public void removeItem(Clothing name) {
        this.contents.remove(name);
    }


}
