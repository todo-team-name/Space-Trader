package cs2340.todo_team_name.spacetrader.model;

import java.util.HashMap;
import java.util.Map;

import cs2340.todo_team_name.spacetrader.enums.Resources;

public class Inventory {
    private int size = 0;
    private int maxCapacity;
    private Map<Resources, Integer> inventory;

    public Inventory(int size) {
        this.maxCapacity = size;
        this.inventory = new HashMap<>(this.size);
        Resources [] arr = Resources.values();
        for(int i = 0; i < arr.length; i++) {
            this.inventory.put(arr[i], 0);
        }
    }


    public void add(Resources resource) {
        size++;
        this.inventory.put(resource, 1);

    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void remove(Resources resource) {
        Integer value = this.inventory.get(resource);
        value--;
        size--;
        this.inventory.put(resource, value);
    }

    public int getSize() {
        return size;
    }

    public Map<Resources, Integer> getInventory() {
        return inventory;
    }
}
