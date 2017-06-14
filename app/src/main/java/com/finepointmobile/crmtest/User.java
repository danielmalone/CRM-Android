package com.finepointmobile.crmtest;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by danielmalone on 6/13/17.
 */

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mUid;

    @ColumnInfo
    private String mFirstName;

    @ColumnInfo
    private String mLastName;

    @ColumnInfo
    private String mEmail;

    public User(String firstName, String lastName, String email) {
        mFirstName = firstName;
        mLastName = lastName;
        mEmail = email;
    }

    public int getUid() {
        return mUid;
    }

    public void setUid(int uid) {
        mUid = uid;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }
}
