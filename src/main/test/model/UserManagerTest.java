package test.model;

import model.Favour;
import model.FavourManager;
import model.User;
import model.UserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    private Favour shortFavour;
    private Favour longFavour;
    private Favour longFavourSameName;
    private Favour shortFavourSameName;
    private Favour shortFavourSameDesc;
    private Favour longFavourSameDesc;
    private Favour thirdFavour;
    private Favour fourthFavour;
    private Favour fifthFavour;

    private LinkedList<Favour> emptyAskedFavours;
    private LinkedList<Favour> emptyCompletedFavours;
    private LinkedList<Favour> testAskedFavours;
    private LinkedList<Favour> testCompletedFavours;

    private FavourManager noAskedManyCompleted;
    private FavourManager manyAskedNoCompleted;
    private FavourManager equalAskedandCompleted;
    private FavourManager nothingAskedOrCompleted;

    private User testUser;
    private User testUserJohn;
    private User testUserBob;
    private User testUserTim;

    private UserManager testum;
    private UserManager emptyTestum;


    @BeforeEach
    void setUp() {
        shortFavour = new Favour("Get milk", "Purchase some milk at the store.", 5);
        shortFavourSameName = new Favour("Get milk", "Purchase some cow's milk at the store.", 5);
        shortFavourSameDesc = new Favour("Retrieve milk", "Purchase some milk at the store.", 5);
        longFavour = new Favour("Souvenir Fetch", "Retrieve a souvenir from Mozambique", 100);
        longFavourSameName = new Favour("Souvenir Fetch", "Retrieve a souvenir from Luxembourg", 100);
        longFavourSameDesc = new Favour("Souvenir Retrieval", "Retrieve a souvenir from Mozambique", 100);
        thirdFavour = new Favour("Walk my dog", "Please walk my dog.", 10);
        fourthFavour = new Favour("Send me water", "Please send me some water.", 2);
        fifthFavour = new Favour("Babysit my niece.", "Babysit my baby niece.", 100);

        emptyCompletedFavours = new LinkedList<>();
        emptyAskedFavours = new LinkedList<>();

        testCompletedFavours = new LinkedList<>();
        testCompletedFavours.add(shortFavour);
        testCompletedFavours.add(longFavour);

        testAskedFavours = new LinkedList<>();
        testAskedFavours.add(shortFavourSameDesc);
        testAskedFavours.add(longFavourSameDesc);

        noAskedManyCompleted = new FavourManager(testCompletedFavours, emptyAskedFavours, 0);
        manyAskedNoCompleted = new FavourManager(emptyCompletedFavours, testAskedFavours, 0);
        equalAskedandCompleted = new FavourManager(testCompletedFavours, testAskedFavours, 0);
        nothingAskedOrCompleted = new FavourManager(emptyCompletedFavours, emptyAskedFavours, 0);

        testUser = new User("Pete", equalAskedandCompleted, 1, 2, 2,  false);
        testUserJohn = new User("John", manyAskedNoCompleted, 0, 0, 2,  false);
        testUserBob = new User("Bob", noAskedManyCompleted, 100, 2, 0,  true);
        testUserTim = new User("Tim", equalAskedandCompleted, 1, 2, 2,  false);

        testum = new UserManager();
        emptyTestum = new UserManager();
        testum.addUser(testUser);
        testum.addUser(testUserJohn);
        testum.addUser(testUserBob);
    }

    @Test
    void testGetUsers() {
        ArrayList<User> expected = new ArrayList<>();
        expected.add(testUser);
        expected.add(testUserJohn);
        expected.add(testUserBob);
        assertEquals(testum.getUsers(), expected);
    }

    @Test
    void testAddUsersSuccess() {
        assertEquals(3, testum.getUsers().size());
        testum.addUser(testUserTim);
        assertEquals(4, testum.getUsers().size());
    }

    @Test
    void testAddUsersFail() {
        assertEquals(3, testum.getUsers().size());
        testum.addUser(testUserBob);
        assertEquals(3, testum.getUsers().size());
    }

    @Test
    void testRemoveUsersSuccess() {
        assertEquals(3, testum.getUsers().size());
        testum.removeUser(testUserBob);
        assertEquals(2, testum.getUsers().size());
    }

    @Test
    void testRemoveUsersFail() {
        assertEquals(3, testum.getUsers().size());
        testum.removeUser(testUserTim);
        assertEquals(3, testum.getUsers().size());
    }

    @Test
    void testSortedUsers() {
        ArrayList<User> expected = new ArrayList<>();
        expected.add(testUserBob);
        expected.add(testUser);
        expected.add(testUserJohn);
        assertEquals(expected, testum.sortedUsers(testum.getUsers()));
    }
}