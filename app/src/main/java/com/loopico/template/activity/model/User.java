package com.loopico.template.activity.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by yacovyitzhak on 09/05/2016.
 */
public class User {
    private String firstName;
    private String lastName;
    private String fileName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public User(JSONObject jsonObject){
        if (jsonObject!=null){

            try {
                this.fileName = jsonObject.getString("firstName");
                this.lastName = jsonObject.getString("lastName");
                this.fileName = jsonObject.getString("fileName");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<User> fromJson(JSONArray jsonArray){
        ArrayList<User> users = new ArrayList<>();
        if (jsonArray!=null){
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    users.add(new User(jsonObject));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
        return users;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
