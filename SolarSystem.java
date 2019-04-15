package cs2340.todo_team_name.spacetrader.model;

import java.io.Serializable;

import androidx.annotation.NonNull;

/**
 * Creates/represents solar system and planet objects
 */
public class SolarSystem implements Serializable {
    private final String name;
    private final int[] location;

    /**
     * Returns current created planets
     * @return array of planets in game
     */
    public Planet[] getPlanets() {
        return planets;
    }

    private final Planet[] planets;
    private int numPlanets;

    /**
     * SolarSystem constructor
     * @param name name of solar system
     * @param x x-coordinate location of solar system
     * @param y y-coordinate location of solar system
     */
    public SolarSystem(String name, int x, int y) {
        location = new int[2];
        planets = new Planet[5];
        numPlanets = 0;
        this.name = name;
        this.location[0] = x;
        this.location[1] = y;
    }

    /**
     * Adds planet to solar system
     * @param p the planet to add
     * @return true if successful add, false if invalid addition
     */
    public boolean addPlanet(Planet p) {
        if (numPlanets < planets.length) {
            planets[numPlanets] = p;
            numPlanets++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns info for specific planet in solar system
     * @param ind the index of the planet we are looking for
     * @return the desired planet or null if invalid entry
     */
    public Planet getPlanet(int ind) {
        if (ind < numPlanets) {
            return planets[ind];
        } else {
            return null;
        }
    }

    /**
     * Returns name of solar system
     * @return name of solar system
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns coordinates of solar system's location
     * @return solar system's coordinates
     */
    public String getCord() {
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
                && (this.location[0] == that.location[0])
                && (this.location[1] == that.location[1]);
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash += this.name.hashCode() * 17;
        hash += this.location[0] * 17;
        hash += this.location[1] * 17;
        return hash;
    }

    @NonNull
    @Override
    public String toString() {
       return "Name: " + name + " (" + location[0] + "," +location[1] + ") \n";
    }
}
