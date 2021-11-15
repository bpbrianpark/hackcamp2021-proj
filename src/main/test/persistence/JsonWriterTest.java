package test.persistence;

import model.User;
import model.UserManager;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            ArrayList<User> users = new ArrayList<>();
            UserManager t = new UserManager();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyUserManager() {
        try {
            ArrayList<User> users = new ArrayList<>();
            UserManager um = new UserManager();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyUM.json");
            writer.open();
            writer.write(um);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyUM.json");
            um = reader.read();
            assertTrue(um.getUsers().isEmpty());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    /*
    @Test
    void testWriterGeneralTeam() {
        try {
            Player lbj = new Player("Lebron James", 23, 90, "Fill", 25, 2, 2);
            Player kuz = new Player("Kyle Kuzma", 10, 10, "Fill", 20, 5, 2);
            Player antDav = new Player("Anthony Davis", 2, 87, "Fill", 25, 1, 4);
            LinkedList<Player> players = new LinkedList<>();
            players.add(lbj);
            players.add(kuz);
            players.add(antDav);
            Team t = new Team("Los Angeles Lakers", "Magic Johnson", 10, 2, players);
            JsonWriter writer = new JsonWriter("./data/testWriterLakersTeam.json");
            writer.open();
            writer.write(t);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterLakersTeam.json");
            t = reader.read();
            assertEquals("Los Angeles Lakers", t.getTeamName());
            assertEquals("Magic Johnson", t.getOwner());
            assertEquals(10, t.getWins());
            assertEquals(2, t.getLosses());
            List<Player> lakerRoster = t.getPlayers();
            assertEquals(3, players.size());

            checkPlayer("Lebron James", 23, 90, "Fill", 25, 2, 2, players.get(0));
            checkPlayer("Kyle Kuzma", 10, 10, "Fill", 20, 5, 2, players.get(1));
            checkPlayer("Anthony Davis", 2, 87, "Fill", 25, 1, 4, players.get(2));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

     */


}
