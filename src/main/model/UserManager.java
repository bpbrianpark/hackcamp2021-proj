package model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private ArrayList<User> listOfUsers;

    public UserManager() {
        listOfUsers = new ArrayList<>();
    }

    public List<User> getUsers() {
        return this.listOfUsers;
    }

    public void addUser (User u) {
        if (!listOfUsers.contains(u)) {
            listOfUsers.add(u);
        }
    }

    public void removeUser (User u) {
        if (listOfUsers.contains(u)) {
            listOfUsers.remove(u);
        }
    }

    //sort by their ratios completed/asked the higher the ratio the higher the user is up on the list
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
}