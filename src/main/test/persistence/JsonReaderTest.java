package test.persistence;

import model.User;
import model.UserManager;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderFileDoesntExist() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            UserManager um = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //PASS
        }
    }

    @Test
    void testReaderEmptyUserManager() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyUserManager.json");
        try {
            UserManager um = reader.read();
            assertTrue(um.getUsers().isEmpty());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testReaderUserManager() {
        JsonReader reader = new JsonReader("./data/testReaderUserManager.json");
        try {
            UserManager um = reader.read();
            ArrayList<User> users = um.getUsers();
            assertEquals(2, users.size());

            //checkUser("Bob", fm,  ,users.get(0));
            //checkUser( ,users.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
