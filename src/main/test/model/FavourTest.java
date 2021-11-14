package test.model;

import model.Favour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FavourTest {
    private Favour shortFavour;
    private Favour longFavour;
    private Favour longFavourSameName;
    private Favour shortFavourSameName;
    private Favour shortFavourSameDesc;
    private Favour longFavourSameDesc;

    @BeforeEach
    void setUp() {
        shortFavour = new Favour("Get milk", "Purchase some milk at the store.", 5);
        shortFavourSameName = new Favour("Get milk", "Purchase some cow's milk at the store.", 5);
        shortFavourSameDesc = new Favour("Retrieve milk", "Purchase some milk at the store.", 5);
        longFavour = new Favour("Souvenir Fetch", "Retrieve a souvenir from Mozambique", 100);
        longFavourSameName = new Favour("Souvenir Fetch", "Retrieve a souvenir from Luxembourg", 100);
        longFavourSameDesc = new Favour("Souvenir Retrieval", "Retrieve a souvenir from Mozambique", 100);
    }

    @Test
    void testGetReqName() {
        String result = shortFavour.getReqName();
        assertEquals(result, "Get milk");
    }

    @Test
    void testGetReqNameLong() {
        String result = longFavour.getReqName();
        assertEquals(result, "Souvenir Fetch");
    }

    @Test
    void testGetReqNameCaseSensitive() {
        String result = shortFavour.getReqName();
        assertFalse(result == "get milk");
    }

    @Test
    void testGetDescName() {
        String result = shortFavour.getDesc();
        assertEquals(result, "Purchase some milk at the store.");
    }

    @Test
    void testGetDescLong() {
        String result = longFavour.getDesc();
        assertEquals(result, "Retrieve a souvenir from Mozambique");
    }

    @Test
    void testGetDescCaseSensitive() {
        String result = shortFavour.getDesc();
        assertFalse(result == "purchase some milk at the store.");
    }

    @Test
    void testGetEstimatedCompletionTimeShort() {
        double result = shortFavour.getEstimatedCom();
        assertEquals(result, 5);
    }

    @Test
    void testGetEstimatedCompletionTimeLong() {
        double result = longFavour.getEstimatedCom();
        assertEquals(result, 100);
    }
}