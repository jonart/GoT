package ru.skillbranch.data.storage.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 19.10.2016.
 */

public class HouseModelRes {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("coatOfArms")
    @Expose
    private String coatOfArms;
    @SerializedName("words")
    @Expose
    private String words;
    @SerializedName("titles")
    @Expose
    private List<String> titles = new ArrayList<String>();
    @SerializedName("seats")
    @Expose
    private List<String> seats = new ArrayList<String>();
    @SerializedName("currentLord")
    @Expose
    private String currentLord;
    @SerializedName("heir")
    @Expose
    private String heir;
    @SerializedName("overlord")
    @Expose
    private String overlord;
    @SerializedName("founded")
    @Expose
    private String founded;
    @SerializedName("founder")
    @Expose
    private String founder;
    @SerializedName("diedOut")
    @Expose
    private String diedOut;
    @SerializedName("ancestralWeapons")
    @Expose
    private List<String> ancestralWeapons = new ArrayList<String>();
    @SerializedName("cadetBranches")
    @Expose
    private List<String> cadetBranches = new ArrayList<String>();
    @SerializedName("swornMembers")
    @Expose
    private List<String> swornMembers = new ArrayList<String>();

    public List<String> getSwornMembers() {
        return swornMembers;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCoatOfArms() {
        return coatOfArms;
    }

    public String getWords() {
        return words;
    }

    public List<String> getTitles() {
        return titles;
    }
}