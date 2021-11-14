package model;

import java.util.LinkedList;
import java.util.List;

//Represents a favour manager, list of favours received and completed
public class FavourManager {
    private LinkedList<Favour> favCompleted;
    private LinkedList<Favour> favAsked;
    private double ratio;
    /*
    //EFFECTS: constructs a FavourManager with
               list of favours completed set to completed
               list of favours asked for set to asked
               (ratio of completed to asked set to ratio) ?
     */
    public FavourManager(LinkedList<Favour> completed, LinkedList<Favour> asked) {
        this.favCompleted = completed;
        this.favAsked = asked;
        this.ratio = calcFavRatio();
    }

    //EFFECTS: returns list of completed favours
    public List<Favour> getCompleted() {
        return favCompleted;
    }

    //EFFECTS: returns list of asked for favours
    public List<Favour> getAsked() {
        return favAsked;
    }

    //EFFECTS; returns ratio
    public double getRatio() {
        return ratio;
    }

    //EFFECTS: returns number of favours completed
    public int numCompleted() {
        return favCompleted.size();
    }

    //EFFECTS: returns number of favours asked for
    public int numAsked() {
        return favAsked.size();
    }

    //EFFECTS: returns ratio of favours completed to asked for
    public double calcFavRatio() {
        if (numAsked() == 0) {
            return 100;
        } else {
            return numCompleted()/numAsked();
        }
    }

    //MODIFIES: this
    //EFFECTS: sets ratio of favours completed to asked for
    public void updateFavRatio() {
        if (numAsked() == 0) {
            this.ratio = 100;
        } else {
            this.ratio = numCompleted()/numAsked();
        }
    }

    //MODIFIES: this
    //EFFECTS: adds favour to list of completed
    public void addToCompleted(Favour f) {
        /* original implementation
        if (!favCompleted.contains(f)) {
            favCompleted.add(f);
        }
         */
        String n = f.getReqName();
        if (!containsInCompleted(n)) {
            favCompleted.add(f);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds favour to list asked
    public void addToAsked(Favour f) {
        /* original implementation
        if (!favAsked.contains(f)) {
            favAsked.add(f);
        }
         */
        String n = f.getReqName();
        if (!containsInAsked(n)) {
            favAsked.add(f);
        }
    }

    //EFFECTS: returns true if request name is in contained in asked
    public boolean containsInAsked(String name) {
        for (Favour f: favAsked) {
            if (name == f.getReqName()) {
                return true;
            } else {
                //
            }
        }
        return false;
    }

    //EFFECTS: returns true if request name is in contained in completed
    public boolean containsInCompleted(String name) {
        for (Favour f: favCompleted) {
            if (name == f.getReqName()) {
                return true;
            } else {
                //
            }
        }
        return false;
    }

    //MODIFIES: this
    //EFFECTS: removes favour from list of completed
    public void removeFromCompleted(String n) {
        /*
        favCompleted.remove(f);

        if (!containsInAsked(n)) {
            favAsked.add(f);
        }
         */
        for (Favour f: favCompleted) {
            if (n == f.getReqName()) {
                favCompleted.remove(f);
            } else {
                //
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: removes favour from list asked
    public void removeFromAsked(String n) {
        /*
        favAsked.remove(f);

         */
        for (Favour f: favAsked) {
            if (n == f.getReqName()) {
                favAsked.remove(f);
            } else {
                //
            }
        }
    }

}
