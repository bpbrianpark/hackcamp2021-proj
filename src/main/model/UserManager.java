package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

// Jason
// Represents the User manager class that deals with many users
public class UserManager implements Writable {
    private ArrayList<User> listOfUsers;

    // Constructor
    // EFFECTS: creates a new list of users
    public UserManager() {
        listOfUsers = new ArrayList<>();
    }

    // GETTERS
    public List<User> getUsers() {
        return this.listOfUsers;
    }

    // MODIFIES: This
    // EFFECTS: adds the given user into the list of user
    public void addUser (User u) {
        if (!listOfUsers.contains(u)) {
            listOfUsers.add(u);
        }
    }

    // MODIFIES: This
    // EFFECTS: removes the given user form the list of users
    public void removeUser (User u) {
        if (listOfUsers.contains(u)) {
            listOfUsers.remove(u);
        }
    }

    // EFFECTS: Returns a sorted list of users given a list of users by their Completed/Asked favour ratio (Descending)
    public List<User> sortedUsers(ArrayList<User> arr) {
        int n = arr.size();
        User temp;
        ArrayList<User> listOfSortedUsers = arr;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n-i); j++) {
                if (listOfSortedUsers.get(j - 1).getRatio() < listOfSortedUsers.get(j).getRatio()) {
                    temp = listOfSortedUsers.get(j - 1);
                    listOfSortedUsers.set((j-1), listOfSortedUsers.get(j));
                    listOfSortedUsers.set(j, temp);
                }
            }
        }
        return listOfSortedUsers;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Users: ", usersToJson());
        return json;
    }

    //EFFECTS: returns list of users as a JSONArray
    private JSONArray usersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (User u : listOfUsers) {
            jsonArray.put(u.toJson());
        }

        return jsonArray;
    }
}