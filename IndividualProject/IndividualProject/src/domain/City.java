package domain;

import java.util.HashMap;

public class City {
    private String name;

    private int cost;
    private HashMap<String, String> accommodationList;
    private HashMap<String, String> activitiesList;

    public City(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.accommodationList = new HashMap<>();
        this.activitiesList = new HashMap<>();
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    //getter
    public String getName() {
        return this.name;
    }

    //setter
    public void setCost(int cost) {
        this.cost = cost;
    }

    //getter
    public int getCost() {
        return this.cost;
    }

    //setter
    public void addAccommodation(String accommodationName, String accommodationDescription) {
        this.accommodationList.put(accommodationName, accommodationDescription);
    }

    //getter
    public HashMap<String, String> getAccommodation() {

        return this.accommodationList;
    }


    //allows the return of the accommodation description for use in the story/ UI
    public String getAccommodationDescription(String accommodationName) {
        return this.accommodationList.get(accommodationName);
    }

    //setter
    public void addActivity(String activityName, String activityDescription) {
        //PROGRAMMING NOTES need to add requirements for the clothing
        this.activitiesList.put(activityName, activityDescription);
    }

    //getter
    public HashMap<String, String> getActivitiesList() {
        return this.activitiesList;
    }

    // Allows the return of the description of the activity for use in the story/ UI
    public String getActivityDescription(String activityName) {
        return this.activitiesList.get(activityName);
    }


}
