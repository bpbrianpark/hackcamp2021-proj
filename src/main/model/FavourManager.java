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
        if (!favCompleted.contains(f)) {
            favCompleted.add(f);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds favour to list asked
    public void addToAsked(Favour f) {
        if (!favAsked.contains(f)) {
            favAsked.add(f);
        }
    }

    //REQUIRES: f is in completed
    //MODIFIES: this
    //EFFECTS: removes favour from list of completed
    public void removeFromCompleted(Favour f) {
        favCompleted.remove(f);
    }

    //REQUIRES: f is in asked
    //MODIFIES: this
    //EFFECTS: removes favour from list asked
    public void removeFromAsked(Favour f) {
        favAsked.remove(f);
    }

}
