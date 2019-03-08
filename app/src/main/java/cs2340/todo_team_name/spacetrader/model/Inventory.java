package cs2340.todo_team_name.spacetrader.model;

import java.util.HashMap;
import java.util.Map;

import cs2340.todo_team_name.spacetrader.enums.Resources;

public class Inventory {
    private int size = 0;
    private int maxCapacity;
    private Map<Resource, Integer> inventory;

    public Inventory(int size) {
        this.maxCapacity = size;
        this.inventory = new HashMap<>(this.size);
        Resources [] arr = Resources.values();
        for(int i = 0; i < arr.length; i++) {
            this.inventory.put(new Resource(arr[i]), 0);
        }
    }


    public void add(Resource resource) {
        size++;
        this.inventory.put(resource, 1);

    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void remove(Resource resource) {
        Integer value = this.inventory.get(resource);
        value--;
        size--;
        this.inventory.put(resource, value);
    }

    public int getSize() {
        return size;
    }

    public Map<Resource, Integer> getInventory() {
        return inventory;
    }

    public boolean checkSelling(Resource res) {
        return inventory.get(res) > 0;
    }

    public boolean checkPurchase() {
        return size < maxCapacity;
    }

    public boolean incrementResoure(Resource res) {
        if (size < maxCapacity) {
            int curr = inventory.get(res);
            curr++;
            inventory.put(res, curr);
            size++;
            return true;
        } else {
            return false;
        }
    }

    public boolean decrementResource(Resource res) {
        if (size > 0 && inventory.get(res) > 0) {
            int curr = inventory.get(res);
            curr--;
            inventory.put(res, curr);
            size--;
            return true;
        } else {
            return false;
        }
    }
}
