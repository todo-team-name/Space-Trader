package cs2340.todo_team_name.spacetrader.model;

import java.util.HashMap;
import java.util.Map;

import cs2340.todo_team_name.spacetrader.enums.Resources;
import java.io.Serializable;

public class Inventory implements Serializable {
    private int size;
    private int maxCapacity;
    private Map<Resources, Integer> inventory;

    /**
     * Creates inventory
     * @param size size of inventory
     */
    public Inventory(int size) {
        this.maxCapacity = size;
        this.inventory = new HashMap<>(this.size);
        Resources [] arr = Resources.values();
        for(Resources r : arr) {
            this.inventory.put(r, 0);
        }
    }

    /**
     * Adds resource to inventory
     * @param resource resource to add
     */
    public void add(Resources resource) {
        size++;
        this.inventory.put(resource, 1);

    }

    /**
     * Returns maximum capacity of inventory
     * @return inventory's max capacity
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Removes a resource from inventory
     * @param resource resource to remove
     */
    public void remove(Resources resource) {
        Integer value = this.inventory.get(resource);
        value--;
        size--;
        this.inventory.put(resource, value);
    }

    /**
     * Returns the inventory size
     * @return inventory size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns current inventory
     * @return current inventory
     */
    public Map<Resources, Integer> getInventory() {
        return inventory;
    }

    /**
     * Checks if sale is valid
     * @param res resource to sell
     * @return true if sale can be made, false if not
     */
    public boolean checkSelling(Resources res) {
        return inventory.get(res) > 0;
    }

    /**
     * Checks if purchase is valid
     * @return true if purchase can be made, false if not
     */
    public boolean checkPurchase() {
        return size < maxCapacity;
    }

    /**
     * Increments quantity of specified resource
     * @param res resource to increment
     */
    public void incrementResource(Resources res) {
        if (size < maxCapacity) {
            int curr = inventory.get(res);
            curr++;
            inventory.put(res, curr);
            size++;
        }
    }

    /**
     * Decrements the quantity of specified resource
     * @param res resource to decrement
     */
    public void decrementResource(Resources res) {
        if ((size > 0) && (inventory.get(res) > 0)) {
            int curr = inventory.get(res);
            curr--;
            inventory.put(res, curr);
            size--;
        }
    }

    /**
     * Returns resources in inventory
     * @param res resource to find info on
     * @return resource in inventory
     */
    public int getResource(Resources res) {
        return inventory.get(res);
    }

    /**
     * Converts resource to string
     * @param res resource to convert
     * @return resource as string
     */
    public String resourceToString(Resources res) {
        int amount = inventory.get(res);
        return Integer.toString(amount);
    }
}
