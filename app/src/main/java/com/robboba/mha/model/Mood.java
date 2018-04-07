package com.robboba.mha.model;

/**
 * Created by kevin on 2018-04-07.
 *
 * POJO
 */

import com.google.firebase.firestore.IgnoreExtraProperties;

import java.util.Date;

@IgnoreExtraProperties
public class Mood {
    public static final String FIELD_DATETIME = "mdate";
    public static final String FIELD_MOODLVL = "moodlvl";
    public static final String FIELD_MANXIETYLVL = "anxietylvl";
    public static final String FIELD_DEPRESSIONLVL = "depressionlvl";
    public static final String FIELD_STRESSLVL = "stresslvl";

    private Date mdate;
    private String moodlvl;
    private String anxietylvl;
    private String depressionlvl;
    private String stresslvl;

    public Mood () {}

    public Mood(Date mdate, String moodlvl, String anxietylvl, String depressionlvl,
                      String stresslvl) {
        this.mdate = mdate;
        this.moodlvl = moodlvl;
        this.anxietylvl = anxietylvl;
        this.depressionlvl = depressionlvl;
        this.stresslvl = stresslvl;
    }

    public Date getDate() { return mdate; }
    public void setDate(Date mdate) {
        this.mdate = mdate;
    }

    public String getMoodlvl() {
        return moodlvl;
    }
    public void setMoodlvl(String moodlvl) {
        this.moodlvl = moodlvl;
    }

    public String getAnxietylvl() {
        return anxietylvl;
    }
    public void setAnxietylvl(String anxietylvl) {
        this.anxietylvl = anxietylvl;
    }

    public String getDepressionlvl() {
        return depressionlvl;
    }
    public void setDepressionlvl(String depressionlvl) {
        this.depressionlvl = depressionlvl;
    }

    public String getStresslvl() {
        return stresslvl;
    }
    public void setStresslvl(String stresslvl) {
        this.stresslvl = stresslvl;
    }

}
