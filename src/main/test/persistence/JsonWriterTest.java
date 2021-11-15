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

    /*
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

     */
}
