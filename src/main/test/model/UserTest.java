package test.model;

import model.Favour;
import model.FavourManager;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
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

        testUser = new User("Pete", equalAskedandCompleted, 1, 2, 2, 0.25, false);
    }

    @Test
    void testGetName() {
        assertEquals(testUser.getName(), "Pete");
    }

    @Test
    void testGetFavourManager() {
        assertEquals(testUser.getFavourManager(), equalAskedandCompleted);
    }

    @Test
    void testGetRatio() {
        assertEquals(testUser.getRatio(), 1);
    }

    @Test
    void testGetNumDone() {
        assertEquals(testUser.getNumDone(), 2);
    }

    @Test
    void testGetNumReq() {
        assertEquals(testUser.getNumReq(), 2);
    }

    @Test
    void testGetIsWarned() {
        assertFalse(testUser.getIsWarned());
    }

    @Test
    void testAddReqPass() {
        assertEquals(2, testUser.getNumReq());
        testUser.addReq("Heal my chronic back pain", "Give me a nice massage", 30);
        assertEquals(3, testUser.getNumReq());
    }

    @Test
    void testAddReqFailSameName() {
        assertEquals(2, testUser.getNumReq());
        testUser.addReq("Retrieve milk", "Give me a nice massage", 30);
        assertEquals(2, testUser.getNumReq());
    }

    @Test
    void testRemoveReqPass() {
        assertEquals(2, testUser.getNumReq());
        testUser.removeReq("Retrieve milk");
        assertEquals(1, testUser.getNumReq());
    }

    @Test
    void testRemoveReqFail() {
        assertEquals(2, testUser.getNumReq());
        testUser.removeReq("placeholder");
        assertEquals(2, testUser.getNumReq());
    }

    @Test
    void testRatioWarningEqual() {
        assertEquals(2, testUser.getNumReq());
        testUser.addReq("Heal my chronic back pain", "Give me a nice massage", 30);
        assertEquals(3, testUser.getNumReq());
        testUser.addReq("Heal my tendonitis", "Give me a nice massage", 30);
        assertEquals(4, testUser.getNumReq());
        testUser.addReq("Heal my heart", "Give me a nice massage", 30);
        assertEquals(5, testUser.getNumReq());
        testUser.addReq("Heal my pain", "Give me a nice massage", 30);
        assertEquals(6, testUser.getNumReq());
        testUser.addReq("Heal my sadness", "Give me a nice massage", 30);
        assertEquals(7, testUser.getNumReq());
        testUser.addReq("Heal my arm", "Give me a nice massage", 30);
        assertEquals(8, testUser.getNumReq());
        assertEquals(testUser.getRatio(), 0.25);
        testUser.checkRatioWarning();
        assertFalse(testUser.getIsWarned());
    }

    @Test
    void testRatioWarningTrue() {
        assertEquals(2, testUser.getNumReq());
        testUser.checkRatioWarning();
        assertEquals(testUser.getRatio(), 1);
        assertTrue(testUser.getIsWarned());
    }

    @Test
    void testRatioWarningFalse() {
        assertEquals(2, testUser.getNumReq());
        testUser.addReq("Heal my chronic back pain", "Give me a nice massage", 30);
        assertEquals(3, testUser.getNumReq());
        testUser.addReq("Heal my tendonitis", "Give me a nice massage", 30);
        assertEquals(4, testUser.getNumReq());
        testUser.addReq("Heal my heart", "Give me a nice massage", 30);
        assertEquals(5, testUser.getNumReq());
        testUser.addReq("Heal my pain", "Give me a nice massage", 30);
        assertEquals(6, testUser.getNumReq());
        testUser.addReq("Heal my sadness", "Give me a nice massage", 30);
        assertEquals(7, testUser.getNumReq());
        testUser.addReq("Heal my arm", "Give me a nice massage", 30);
        assertEquals(8, testUser.getNumReq());
        testUser.addReq("Heal my leg", "Give me a nice massage", 30);
        assertEquals(9, testUser.getNumReq());
        testUser.checkRatioWarning();
        assertFalse(testUser.getIsWarned());
    }


}