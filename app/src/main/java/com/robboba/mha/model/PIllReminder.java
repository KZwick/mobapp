package com.robboba.mha.model;

import com.google.firebase.firestore.IgnoreExtraProperties;

/**
 * Created by kevin on 2018-04-07.
 *
 * POJO
 */


@IgnoreExtraProperties
public class PIllReminder {
    public static final String FIELD_REMINDERNAME = "remindername";
    public static final String FIELD_MEDTIME = "medtime";
    public static final String FIELD_SETREMINDER = "setreminder";
    public static final String FIELD_TEKENTODAY = "takentoday";
    //public static final String FIELD_ALARM_TIME = "alarmtime";
    // public static final String FIELD_MEDSTOTAKE = "medstotake";

    private String remindername;
    private String medtime;
    private String setreminder;
    private String takentoday;
    private String alarmtime;
    // private String medstotake; Array

    public PIllReminder() { }

    public PIllReminder(String remindername, String medtime, String setreminder, String takentoday ) {
        this.remindername = remindername;
        this.medtime = medtime;
        this.setreminder = setreminder;
        this.takentoday = takentoday;
        //this.alarmtime = alarmtime
        // Array medstotake; Array
    }

    public String getRemindername() {
        return remindername;
    }
    public void setRemindername(String remindername) {
        this.remindername = remindername;
    }

    public String getMedtime() {
        return medtime;
    }
    public void setMedtime(String medtime) {
        this.medtime = medtime;
    }

    public String getSetreminder() {
        return setreminder;
    }
    public void setSetreminder(String setreminder) {
        this.setreminder = setreminder;
    }

    public String getTakentoday() {
        return takentoday;
    }
    public void setTakentoday(String takentoday) {
        this.takentoday = takentoday;
    }

    //public String getAlarmtime() {return alarmtime;}
    //public void setAlarmtime(String alarmtime) {this.alarmtime = alarmtime;}

    // Array medstotake; Array
}
