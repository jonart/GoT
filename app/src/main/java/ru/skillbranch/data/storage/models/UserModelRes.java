package ru.skillbranch.data.storage.models;

/**
 * Created by root on 18.10.2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserModelRes {

    @SerializedName("url")
    @Expose

    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("culture")
    @Expose
    private String culture;
    @SerializedName("born")
    @Expose
    private String born;
    @SerializedName("died")
    @Expose
    private String died;
    @SerializedName("titles")
    @Expose
    private List<String> titles = new ArrayList<String>();
    @SerializedName("aliases")
    @Expose
    private List<String> aliases = new ArrayList<String>();
    @SerializedName("father")
    @Expose
    private String father;
    @SerializedName("mother")
    @Expose
    private String mother;
    @SerializedName("spouse")
    @Expose
    private String spouse;
    @SerializedName("allegiances")
    @Expose
    private List<String> allegiances = new ArrayList<String>();
    @SerializedName("books")
    @Expose
    private List<String> books = new ArrayList<String>();
    @SerializedName("povBooks")
    @Expose
    private List<String> povBooks = new ArrayList<String>();
    @SerializedName("tvSeries")
    @Expose
    private List<String> tvSeries = new ArrayList<String>();
    @SerializedName("playedBy")
    @Expose
    private List<String> playedBy = new ArrayList<String>();

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCulture() {
        return culture;
    }

    public String getBorn() {
        return born;
    }

    public String getDied() {
        return died;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getSpouse() {
        return spouse;
    }

    public List<String> getAllegiances() {
        return allegiances;
    }

    public List<String> getBooks() {
        return books;
    }

    public List<String> getPovBooks() {
        return povBooks;
    }

    public List<String> getTvSeries() {
        return tvSeries;
    }

    public List<String> getPlayedBy() {
        return playedBy;
    }

}