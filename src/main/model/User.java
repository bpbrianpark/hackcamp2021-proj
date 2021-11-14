package model;

// YEOJUN
// Represents a user of the application
public class User {
    private String name;
    private FavourManager favourManager;
    private int ratio;
    private int numDone;
    private int numReq;
    private double ratioWarningBoundary = 0.25;
    private boolean isWarned;

    // constructor
    // EFFECTS: creates a new user with the given name
    public User(String name) {
        this.name = name;
        favourManager = new FavourManager();
        numDone = 0;
        numReq = 0;
        ratio = 0;
    }

    // MODIFIES: favourManager
    // EFFECTS: adds a favour request for the user with given name, description, estimated completion time
    public void addReq(String reqName, String description, double estTime) {
        Favour newReq = Favour(reqName, ID, description, estTime); // Favour is not implemented yet
        favourManager.addReq(newReq); // double check
        numReq++;
        favourManager.updateRatio();
        checkRatioWarning();
    }

    // MODIFIES: favourManager
    // EFFECTS: if there is a request with reqName, then remove it. Nothing otherwise
    public void removeReq(String reqName) {
        if (favourManager.contains(reqName)) {
            favourManager.removeReq(reqName);
        }
        numReq--;
        favourManager.updateRatio();
        checkRatioWarning();
    }

    public void checkRatioWarning() {
        if (ratio > ratioWarningBoundary) {
            isWarned = true;
        } else {
            isWarned = false;
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

    public int getRatio() {
        return ratio;
    }

    public int getNumDone() {
        return numDone;
    }

    public int getNumReq() {
        return numReq;
    }
}
