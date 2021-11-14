package model;

import org.junit.Test;
import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;


// BRIAN
// Represents a favour to be completed
public class Favour implements Writable {
    private String reqName; //request name
    private String desc; //description of favour
    private double estimatedCom; //estimated completion time in minutes

    /*
     * EFFECTS: constructs a favour with
     *          request name set to srqName,
     *          request id set to
     *          description set to stDesc
     *          estimated completion time set to stEstimatedCom
     */

    public Favour(String srqName, String stDesc, double stEstimatedCom) {
        this.reqName = srqName;
        this.desc = stDesc;
        this.estimatedCom = stEstimatedCom;
    }

    //EFFECTS: returns a favour id
    public String getReqName() {
        return reqName;
    }

    //EFFECTS: returns a favour description
    public String getDesc() {
        return desc;
    }

    //EFFECTS: returns estimated completion time
    public double getEstimatedCom() {
        return estimatedCom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favour favour = (Favour) o;
        return Double.compare(favour.estimatedCom, estimatedCom) == 0 && reqName.equals(favour.reqName) && desc.equals(favour.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqName, desc, estimatedCom);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Request Name: ", reqName);
        json.put("Description: ", desc);
        json.put("Estimated Completion Time: ", estimatedCom);
        return json;
    }
}