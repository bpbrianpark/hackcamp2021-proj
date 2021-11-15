package test.persistence;

import model.Favour;
import model.FavourManager;
import model.User;
import model.UserManager;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class JsonTest {
    protected void checkFavour(String rqName, String rqDesc, double estCt, Favour f) {
        assertEquals(rqName, f.getReqName());
        assertEquals(rqDesc, f.getDesc());
        assertEquals(estCt, f.getEstimatedCom());
    }

    protected void checkFavourManager(LinkedList<Favour> completed, LinkedList<Favour> requested, double rati, FavourManager favMan) {
        assertEquals(completed, favMan.getCompleted());
        assertEquals(requested, favMan.getAsked());
        assertEquals(rati, favMan.getRatio());
    }

    protected void checkUser(String usName, FavourManager favMan, double rati, int numbDone, int numbReq, boolean isWarned, User u) {
        assertEquals(usName, u.getName());
        assertEquals(favMan, u.getFavourManager());
        assertEquals(rati, u.getRatio());
        assertEquals(numbDone, u.getNumDone());
        assertEquals(numbReq, u.getNumReq());
        assertEquals(isWarned, u.getIsWarned());
    }

    protected void checkUserManager(ArrayList<User> userList, UserManager usMan) {
        assertEquals(userList, usMan.getUsers());
    }
}
