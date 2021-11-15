package model;

import org.json.JSONObject;
import persistence.Writable;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

// YEOJUN
// Represents a user of the application
public class User implements Writable {
    private String name;
    private FavourManager favourManager;
    private double ratio;
    private int numDone;
    private int numReq;
    public static final double ratioWarningBoundary = 0.25;
    private boolean isWarned;

    // constructor
    // EFFECTS: creates a new user with the given name and params
    public User(String name, FavourManager fm, double rat, int nmDone, int nmReq, boolean isWarn) {
        this.name = name;
        //favourManager = new FavourManager(new LinkedList<Favour>(), new LinkedList<Favour>(), 0);
        this.favourManager = fm;
        this.numDone = nmDone;
        this.numReq = nmReq;
        this.ratio = rat;
        //numDone = 0;
        //numReq = 0;
        //ratio = 0;
    }

    // MODIFIES: this, favourManager
    // EFFECTS: adds a favour request for the user with given name, description, estimated completion time
    public void addReq(String reqName, String description, double estTime) {
        if (!favourManager.containsInAsked(reqName)) {
            Favour newReq = new Favour(reqName, description, estTime); // Favour is not implemented yet
            favourManager.addToAsked(newReq); // double check
            numReq++;
            favourManager.updateFavourRatio();
            checkRatioWarning();
        }
    }

    // MODIFIES: this, favourManager
    // EFFECTS: if there is a request with reqName, then remove it. Nothing otherwise
    public void removeReq(String reqName) {
        if (favourManager.containsInAsked(reqName)) {
            favourManager.removeFromAsked(reqName);
            numReq--;
        }
        favourManager.updateFavourRatio();
        checkRatioWarning();
    }

    // MODIFIES: this
    public void checkRatioWarning() {
        if (ratio > ratioWarningBoundary) {
            this.isWarned = true;
        } else {
            this.isWarned = false;
        }
    }

    // this will likely be handled by user manager
//    // REQUIRES: favourName is already a pre-existing favour in favourManager
//    // MODIFIES: favourManager
//    // EFFECTS: marks the favour as completed, notifies the other person that it has been completed
//    public void complete(String favourName) {
//        numDone++;
//        favourManager.updateRatio();
//        favourManager.markCompleted(favourName); // need to implement this - maybe a
//    }

    // GETTERS
    public String getName() {
        return name;
    }

    public FavourManager getFavourManager() {
        return favourManager;
    }

    public double getRatio() {
        if (numReq == 0) {
            return 100;
        } else {
            return (numDone / numReq);
        }
    }

    public int getNumDone() {
        return numDone;
    }

    public int getNumReq() {
        return numReq;
    }

    public boolean getIsWarned() {
        return isWarned;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Name: ", name);
        json.put("Favour Manager: ", favourManager);
        json.put("User Ratio: ", ratio);
        json.put("Number Done: ", numDone);
        json.put("Number Requested: ", numReq);
        json.put("Ratio Warning Boundary: ", 0.25);
        json.put("Is Warned: ", isWarned);

        return json;
    }
}
