package com.robboba.mha.model;

/**
 * Created by kevin on 2018-04-07.
 *
 * POJO
 */

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Medication {
    public static final String FIELD_MEDNAME = "medname";
    public static final String FIELD_MEDDOSAGE = "meddosage";
    public static final String FIELD_PILLPERDAY = "pillperday";
    public static final String FIELD_PILLSPERDOSE = "pillsperdose";
    public static final String FIELD_DOSESPERDAY = "dosesperday";
    public static final String FIELD_REFILLDATE = "refilldate";

    private String medname;
    private String meddosage;
    private String pillperday;
    private String pillsperdose;
    private String dosesperday;
    private String refilldate;

    public Medication () {}

    public Medication(String medname, String meddosage, String pillperday, String pillsperdose,
                String dosesperday,String refilldate) {
        this.medname = medname;
        this.meddosage = meddosage;
        this.pillperday = pillperday;
        this.pillsperdose = pillsperdose;
        this.dosesperday = dosesperday;
        this.refilldate = refilldate;
    }

    public String getMedname() {
        return medname;
    }
    public void setMedname(String medname) {
        this.medname = medname;
    }

    public String getMeddosage() {
        return meddosage;
    }
    public void setMeddosage(String meddosage) {
        this.meddosage = meddosage;
    }

    public String getPillperday() {
        return pillperday;
    }
    public void setPillperday(String pillperday) {
        this.medname = pillperday;
    }

    public String getPillsperdose() {
        return pillsperdose;
    }
    public void setPillsperdose(String pillsperdose) {
        this.medname = pillsperdose;
    }

    public String getDosesperday() {
        return dosesperday;
    }
    public void setDosesperday(String dosesperday) {
        this.medname = dosesperday;
    }

    public String getRefilldate() {
        return refilldate;
    }
    public void setRefilldate(String refilldate) {
        this.medname = refilldate;
    }

}
