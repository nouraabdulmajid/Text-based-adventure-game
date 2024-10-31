package domain;

import java.util.ArrayList;

public class Player {
    private String name;
    private int funds;
    private ArrayList<String> citiesVisited;

    public Player(String name) {
        this.name = name;
        this.funds = 0;
        this.citiesVisited = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public int getFunds() {
        return this.funds;
    }

    public void increaseFunds() {
        this.funds += 50;
    }

    public void decreaseFunds(int amount) {
        this.funds -= amount;
    }

    public void addCity(String cityName) {
        if (!citiesVisited.contains(cityName))
            this.citiesVisited.add(cityName);
    }

    public ArrayList getCitiesVisited() {
        return this.citiesVisited;
    }
}
