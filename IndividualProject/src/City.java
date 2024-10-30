import java.util.ArrayList;
import java.util.HashMap;

public class City {
    private String name;
    private HashMap accommodationList;  //These need to be converted to HashMap
    private HashMap activitiesList;

    public City(String name) {
        this.name = name;
        this.accommodationList = new ArrayList<>();
        this.activitiesList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList getAccommodation() {
        return this.accommodationList();
    }

    public void addAccommodation(String name, String description) {
        this.accommodationList.add(name);
    }

    public ArrayList getActivitiesList() {
        return this.activitiesList();
    }

    public void addActivity(String name, String description) {
        this.activitiesList.add(name);
    }

}
