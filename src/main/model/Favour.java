package model;

// Represents a favour to be completed
public class Favour {
    private String id; //favour id
    private String desc; //description of favour
    private double estimatedCom; //estimated completion time in minutes

    /*
     * EFFECTS: constructs a favour
     *          id set to id,
     *          description set to desc
     *          estimated completion time set to estimatedCom
     */

    public Favour(String setId, String setDesc, double setEstimatedCom) {
        this.id = setId;
        this.desc = setDesc;
        this.estimatedCom = setEstimatedCom;
    }

    //EFFECTS: returns a favour id
    public String getId() {
        return id;
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
