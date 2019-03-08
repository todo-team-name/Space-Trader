package cs2340.todo_team_name.spacetrader.model;

import java.util.HashSet;

import cs2340.todo_team_name.spacetrader.enums.Gadgets;
import cs2340.todo_team_name.spacetrader.enums.Shields;
import cs2340.todo_team_name.spacetrader.enums.ShipTypes;
import cs2340.todo_team_name.spacetrader.enums.Weapons;

public class Ship {
    private ShipTypes shipType;
    private HashSet<Gadgets> gadgets;
    private Shields[] shields;
    private Weapons[]  weapons;
    private int[] location;
}
