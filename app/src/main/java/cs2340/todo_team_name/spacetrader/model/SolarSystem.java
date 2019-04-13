package cs2340.todo_team_name.spacetrader.model;

import java.io.Serializable;

public class SolarSystem implements Serializable {
    private String name;
    private int[] location;

    public Planet[] getPlanets() {
        return planets;
    }

    private Planet[] planets;
    private int numPlanets;

    public SolarSystem(String name, int x, int y) {
        location = new int[2];
        planets = new Planet[5];
        numPlanets = 0;
        this.name = name;
        this.location[0] = x;
        this.location[1] = y;
    }

    public boolean addPlanet(Planet p) {
        if (numPlanets < planets.length) {
            planets[numPlanets] = p;
            numPlanets++;
            return true;
        } else {
            return false;
        }
    }

    public Planet getPlanet(int ind) {
        if (ind < numPlanets) {
            return planets[ind];
        } else {
            return null;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getCoord() {
        return "(" + this.location[0] + ", " + this.location[1] + ")";
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }
        if(!(other instanceof SolarSystem)) {
            return false;
        }
        SolarSystem that = (SolarSystem) other;
        return this.name.equals(that.name)
                && this.location[0] == that.location[0]
                && this.location[1] == that.location[1];
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash += this.name.hashCode() * 17;
        hash += this.location[0] * 17;
        hash += this.location[1] * 17;
        return hash;
    }

    @Override
    public String toString() {
       return "Name: " + name + " (" + location[0] + "," +location[1] + ") \n";
    }
}
