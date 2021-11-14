package model;

// Represents a favour to be completed
public class Favour {
    private String reqName; //request name
    private String desc; //description of favour
    private double estimatedCom; //estimated completion time in minutes

    /*
     * EFFECTS: constructs a favour with
     *          request name set to setReqName,
     *          description set to desc
     *          estimated completion time set to estimatedCom
     */

    public Favour(String setReqName, String setDesc, double setEstimatedCom) {
        this.reqName = setReqName;
        this.desc = setDesc;
        this.estimatedCom = setEstimatedCom;
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

}