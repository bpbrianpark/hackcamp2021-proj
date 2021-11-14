package test.model;

import model.Favour;
import model.FavourManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class FavourManagerTest {
    private Favour shortFavour;
    private Favour longFavour;
    private Favour longFavourSameName;
    private Favour shortFavourSameName;
    private Favour shortFavourSameDesc;
    private Favour longFavourSameDesc;
    private Favour thirdFavour;
    private LinkedList<Favour> emptyAskedFavours;
    private LinkedList<Favour> emptyCompletedFavours;
    private LinkedList<Favour> testAskedFavours;
    private LinkedList<Favour> testCompletedFavours;

    private FavourManager noAskedManyCompleted;
    private FavourManager manyAskedNoCompleted;
    private FavourManager equalAskedandCompleted;
    private FavourManager nothingAskedOrCompleted;


    @BeforeEach
    void setUp() {
        shortFavour = new Favour("Get milk", "Purchase some milk at the store.", 5);
        shortFavourSameName = new Favour("Get milk", "Purchase some cow's milk at the store.", 5);
        shortFavourSameDesc = new Favour("Retrieve milk", "Purchase some milk at the store.", 5);
        longFavour = new Favour("Souvenir Fetch", "Retrieve a souvenir from Mozambique", 100);
        longFavourSameName = new Favour("Souvenir Fetch", "Retrieve a souvenir from Luxembourg", 100);
        longFavourSameDesc = new Favour("Souvenir Retrieval", "Retrieve a souvenir from Mozambique", 100);
        thirdFavour = new Favour("Walk my dog", "Please walk my dog.", 10);

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
    }

    @Test
    void testGetCompletedNotEmpty() {
        LinkedList<Favour> testList = new LinkedList<>();
        testList.add(shortFavour);
        testList.add(longFavour);
        assertEquals(testList, equalAskedandCompleted.getCompleted());
    }

    @Test
    void testGetCompletedEmpty() {
        LinkedList<Favour> testList = new LinkedList<>();
        assertEquals(testList, manyAskedNoCompleted.getCompleted());
    }

    @Test
    void testGetAskedNotEmpty() {
        LinkedList<Favour> testList = new LinkedList<>();
        testList.add(shortFavourSameDesc);
        testList.add(longFavourSameDesc);
        assertEquals(testList, manyAskedNoCompleted.getAsked());
    }

    @Test
    void testGetAskedEmpty() {
        LinkedList<Favour> testList = new LinkedList<>();
        assertEquals(testList, noAskedManyCompleted.getAsked());
    }

    @Test
    void testGetRatio() {
        assertEquals(1, equalAskedandCompleted.getRatio());
    }

    @Test
    void testGetRatioNoAsked() {
        assertEquals(100, noAskedManyCompleted.getRatio());
    }

    @Test
    void testGetRatioNoAskedOrCompleted() {
        assertEquals(1, nothingAskedOrCompleted.getRatio());
    }

    @Test
    void testCalcRatio() {
        equalAskedandCompleted.updateFavourRatio();
        assertEquals(1, equalAskedandCompleted.getRatio());
    }

    @Test
    void testCalcRatioNoAsked() {
        noAskedManyCompleted.updateFavourRatio();
        assertEquals(100, noAskedManyCompleted.getRatio());
    }

    @Test
    void testCalcRatioNoAskedOrCompleted() {
        nothingAskedOrCompleted.updateFavourRatio();
        assertEquals(1, nothingAskedOrCompleted.getRatio());
    }

    @Test
    void testGetNumCompleted() {
        assertEquals(2, equalAskedandCompleted.numCompleted());
    }

    @Test
    void testGetNumAsked() {
        assertEquals(2, equalAskedandCompleted.numAsked());
    }

    @Test
    void testUpdateRatioUponAdd() {
        assertEquals(1, equalAskedandCompleted.updateFavourRatio());
        assertEquals(2, equalAskedandCompleted.numCompleted());
        equalAskedandCompleted.addToCompleted(thirdFavour);
        assertEquals(3, equalAskedandCompleted.numCompleted());
        equalAskedandCompleted.updateFavourRatio();
        assertEquals(1.5, equalAskedandCompleted.updateFavourRatio());
    }

    @Test
    void testUpdateRatioUponRemove() {
        assertEquals(1, equalAskedandCompleted.updateFavourRatio());
        equalAskedandCompleted.removeFromCompleted("Get milk");
        equalAskedandCompleted.updateFavourRatio();
        assertEquals(0.5, equalAskedandCompleted.getRatio());
    }

    @Test
    void testAddToCompleted() {
        assertEquals(0, manyAskedNoCompleted.numCompleted());
        assertEquals(0, manyAskedNoCompleted.getRatio());
        manyAskedNoCompleted.addToCompleted(thirdFavour);
        assertEquals(1, manyAskedNoCompleted.numCompleted());
        assertEquals(2, manyAskedNoCompleted.numAsked());
        manyAskedNoCompleted.updateFavourRatio();
        assertEquals(0.5, manyAskedNoCompleted.getRatio());
        assertEquals(manyAskedNoCompleted.numCompleted(), 1);
    }

    @Test
    void testAddToCompletedAlreadyIn() {
        assertEquals(2, equalAskedandCompleted.numCompleted());
        assertEquals(1, equalAskedandCompleted.getRatio());
        equalAskedandCompleted.addToCompleted(shortFavour);
        equalAskedandCompleted.updateFavourRatio();
        //assertEquals(0, manyAskedNoCompleted.getRatio());
        assertEquals(2, equalAskedandCompleted.numCompleted());
    }

    @Test
    void testContainsInCompletedTrue() {
        assertTrue(noAskedManyCompleted.containsInCompleted("Get milk"));
    }

    @Test
    void testContainsInAskedTrue() {
        assertTrue(manyAskedNoCompleted.containsInAsked("Retrieve milk"));
    }

    @Test
    void testContainsInCompletedFalse() {
        assertFalse(noAskedManyCompleted.containsInCompleted("dab"));
    }

    @Test
    void testContainsInAskedFalse() {
        assertFalse(manyAskedNoCompleted.containsInAsked("dab"));
    }

    @Test
    void testRemoveFromCompletedWorks() {
        assertEquals(2, equalAskedandCompleted.numCompleted());
        assertEquals(1, equalAskedandCompleted.getRatio());
        equalAskedandCompleted.removeFromCompleted(shortFavour.getReqName());
        assertEquals(1, equalAskedandCompleted.numCompleted());
        assertEquals(2, equalAskedandCompleted.numAsked());
        manyAskedNoCompleted.updateFavourRatio();
        assertEquals(0.5, equalAskedandCompleted.getRatio());
        assertEquals(equalAskedandCompleted.numCompleted(), 1);
    }

    @Test
    void testRemoveFromAskedWorks() {
        assertEquals(2, equalAskedandCompleted.numAsked());
        assertEquals(1, equalAskedandCompleted.getRatio());
        equalAskedandCompleted.removeFromAsked(shortFavourSameDesc.getReqName());
        assertEquals(1, equalAskedandCompleted.numAsked());
        assertEquals(2, equalAskedandCompleted.numCompleted());
        manyAskedNoCompleted.updateFavourRatio();
        assertEquals(2, equalAskedandCompleted.getRatio());
        assertEquals(equalAskedandCompleted.numAsked(), 1);
    }

    @Test
    void testRemoveFromCompletedDoesntWork() {
        assertEquals(2, equalAskedandCompleted.numCompleted());
        assertEquals(1, equalAskedandCompleted.getRatio());
        equalAskedandCompleted.removeFromCompleted(shortFavourSameDesc.getReqName());
        assertEquals(2, equalAskedandCompleted.numCompleted());
        assertEquals(2, equalAskedandCompleted.numAsked());
        manyAskedNoCompleted.updateFavourRatio();
        assertEquals(1, equalAskedandCompleted.getRatio());
        assertEquals(equalAskedandCompleted.numCompleted(), 2);
    }

    @Test
    void testRemoveFromAskedDoesntWork() {
        assertEquals(2, equalAskedandCompleted.numAsked());
        assertEquals(1, equalAskedandCompleted.getRatio());
        equalAskedandCompleted.removeFromAsked(shortFavour.getReqName());
        assertEquals(2, equalAskedandCompleted.numAsked());
        assertEquals(2, equalAskedandCompleted.numCompleted());
        manyAskedNoCompleted.updateFavourRatio();
        assertEquals(1, equalAskedandCompleted.getRatio());
        assertEquals(equalAskedandCompleted.numAsked(), 2);
    }

}