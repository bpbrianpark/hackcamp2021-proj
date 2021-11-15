package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;

import model.Favour;
import model.FavourManager;
import model.User;
import model.UserManager;
import org.json.*;
import org.omg.CORBA.DynAnyPackage.Invalid;
import sun.awt.image.ImageWatched;

//NOTE: code is based on JsonSerializationDemo and AccountNotRobust
// Represents a reader that reads team from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads list of users
    // throws IOException if an error occurs reading data from file
    public UserManager read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseUserManager(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses UserManager from JSON object and returns it
    private UserManager parseUserManager(JSONObject jsonObject) {
        UserManager u = new UserManager();
        addUsers(u, jsonObject);
        return u;
    }

    // MODIFIES: u
    // EFFECTS: adds Users to UserManager after parsing
    private void addUsers(UserManager u, JSONObject jsonObject){
        JSONArray jsonArray = jsonObject.getJSONArray("Users: ");
        for (Object json : jsonArray) {
            JSONObject nextUser = (JSONObject) json;
            //addUser(u, nextUser);
        }
    }

    // MODIFIES: u
    // EFFECTS: adds User to list of Users
    private void addUser(UserManager um, JSONObject jsonObject) {
        String name = jsonObject.getString("Name: ");
        //FavourManager fm = jsonObject.get("Favour Manager: ");
        double fmRatio = jsonObject.getDouble("Ratio: ");
        LinkedList<Favour> test = new LinkedList<>();
        FavourManager fm = new FavourManager(test, test, fmRatio);
        double ratio = jsonObject.getDouble("UserManager Ratio: ");
        int numDone = jsonObject.getInt("Number Done: ");
        int numReq  = jsonObject.getInt("Number Requested: ");
        boolean warned = jsonObject.getBoolean("Is Warned: ");

        addCompletedFavours(fm, jsonObject);
        addAskedFavours(fm, jsonObject);

        JSONArray jsonArray1 = jsonObject.getJSONArray("");

        User u = new User(name, fm, ratio, numDone, numReq, warned);
        um.addUser(u);
    }

    //EFFECTS: adds list of completed favours to FavourManager after parsing
    private void addCompletedFavours(FavourManager fm, JSONObject jsonObject){
        JSONArray jsonArray = jsonObject.getJSONArray("Favours Completed: ");
        for (Object json : jsonArray) {
            JSONObject nextFavour = (JSONObject) json;
            addCompletedFavour(fm, nextFavour);
        }
    }

    //EFFECTS: adds list of asked favours to FavourManager after parsing
    private void addAskedFavours(FavourManager fm, JSONObject jsonObject){
        JSONArray jsonArray = jsonObject.getJSONArray("Favours Asked: ");
        for (Object json : jsonArray) {
            JSONObject nextFavour = (JSONObject) json;
            addAskedFavour(fm, nextFavour);
        }
    }

    //EFFECTS: adds Favour to list of completed favours
    private void addCompletedFavour(FavourManager fm, JSONObject jsonObject) {
        String reqName = jsonObject.getString("Request Name: ");
        String desc = jsonObject.getString("Description: ");
        double ect = jsonObject.getDouble("Estimated Completion Time: ");
        Favour f = new Favour(reqName, desc, ect);
        fm.addToCompleted(f);
    }

    //EFFECTS: adds Favour to list of asked favours
    private void addAskedFavour(FavourManager fm, JSONObject jsonObject) {
        String reqName = jsonObject.getString("Request Name: ");
        String desc = jsonObject.getString("Description: ");
        double ect = jsonObject.getDouble("Estimated Completion Time: ");
        Favour f = new Favour(reqName, desc, ect);
        fm.addToAsked(f);
    }
}