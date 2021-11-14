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


}