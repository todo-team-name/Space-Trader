package cs2340.todo_team_name.spacetrader.model;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import cs2340.todo_team_name.spacetrader.enums.Colors;
import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.MarketType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class GenerateGame {
    private final String[] nameList =
            {
                    "Acamar",
                    "Adahn",
                    "Aldea",
                    "Andevian",
                    "Antedi",
                    "Balosnee",
                    "Baratas",
                    "Brax",			// One of the heroes in Master of Magic
                    "Bretel",		// This is a Dutch device for keeping your pants up.
                    "Calondia",
                    "Campor",
                    "Capelle",		// The city I lived in while programming this game
                    "Carzon",
                    "Castor",		// A Greek demi-god
                    "Cestus",
                    "Cheron",
                    "Courteney",	// After Courteney Cox…
                    "Daled",
                    "Damast",
                    "Davlos",
                    "Deneb",
                    "Deneva",
                    "Devidia",
                    "Draylon",
                    "Drema",
                    "Endor",
                    "Esmee",		// One of the witches in Pratchett's Discworld
                    "Exo",
                    "Ferris",		// Iron
                    "Festen",		// A great Scandinavian movie
                    "Fourmi",		// An ant, in French
                    "Frolix",		// A solar system in one of Philip K. Dick's novels
                    "Gemulon",
                    "Guinifer",		// One way of writing the name of king Arthur's wife
                    "Hades",		// The underworld
                    "Hamlet",		// From Shakespeare
                    "Helena",		// Of Troy
                    "Hulst",		// A Dutch plant
                    "Iodine",		// An element
                    "Iralius",
                    "Janus",		// A seldom encountered Dutch boy's name
                    "Japori",
                    "Jarada",
                    "Jason",		// A Greek hero
                    "Kaylon",
                    "Khefka",
                    "Kira",			// My dog's name
                    "Klaatu",		// From a classic SF movie
                    "Klaestron",
                    "Korma",		// An Indian sauce
                    "Kravat",		// Interesting spelling of the French word for "tie"
                    "Krios",
                    "Laertes",		// A king in a Greek tragedy
                    "Largo",
                    "Lave",			// The starting system in Elite
                    "Ligon",
                    "Lowry",		// The name of the "hero" in Terry Gilliam's "Brazil"
                    "Magrat",		// The second of the witches in Pratchett's Discworld
                    "Malcoria",
                    "Melina",
                    "Mentar",		// The Psilon home system in Master of Orion
                    "Merik",
                    "Mintaka",
                    "Montor",		// A city in Ultima III and Ultima VII part 2
                    "Mordan",
                    "Myrthe",		// The name of my daughter
                    "Nelvana",
                    "Nix",			// An interesting spelling of a word meaning "nothing" in Dutch
                    "Nyle",			// An interesting spelling of the great river
                    "Odet",
                    "Og",			// The last of the witches in Pratchett's Discworld
                    "Omega",		// The end of it all
                    "Omphalos",		// Greek for navel
                    "Orias",
                    "Othello",		// From Shakespeare
                    "Parade",		// This word means the same in Dutch and in English
                    "Penthara",
                    "Picard",		// The enigmatic captain from ST:TNG
                    "Pollux",		// Brother of Castor
                    "Quator",
                    "Rakhar",
                    "Ran",			// A film by Akira Kurosawa
                    "Regulas",
                    "Relva",
                    "Rhymus",
                    "Rochani",
                    "Rubicum",		// The river Ceasar crossed to get into Rome
                    "Rutia",
                    "Sarpeidon",
                    "Sefalla",
                    "Seltrice",
                    "Sigma",
                    "Sol",			// That's our own solar system
                    "Somari",
                    "Stakoron",
                    "Styris",
                    "Talani",
                    "Tamus",
                    "Tantalos",		// A king from a Greek tragedy
                    "Tanuga",
                    "Tarchannen",
                    "Terosa",
                    "Thera",		// A seldom encountered Dutch girl's name
                    "Titan",		// The largest moon of Jupiter
                    "Torin",		// A hero from Master of Magic
                    "Triacus",
                    "Turkana",
                    "Tyrus",
                    "Umberlee",		// A god from AD&D, which has a prominent role in Baldur's Gate
                    "Utopia",		// The ultimate goal
                    "Vadera",
                    "Vagra",
                    "Vandor",
                    "Ventax",
                    "Xenon",
                    "Xerxes",		// A Greek hero
                    "Yew",			// A city which is in almost all of the Ultima games
                    "Yojimbo",		// A film by Akira Kurosawa
                    "Zalkon",
                    "Zuul"			// From the first Ghostbusters movie
            };
    private final Set<SolarSystem> solarSystems;
    private final Player pilot;
    private int numPlanets;
    private final SolarSystem[] solar;
    private int ind;
    private final Set<String> usedNames;
    private final GovernmentType[] governmentTypes;
    private final TechLevel[] techLevels;
    private final ResourceType[] resources;
    private final MarketType[] marketTypes;
    private int solsCovered;
    private final Colors[] colors;

    public GenerateGame(Player pilot, Set<SolarSystem> solarSystems) {
        this.pilot = pilot;
        this.solarSystems = solarSystems;
        this.solar = new SolarSystem[10];
        this.usedNames = new HashSet<>();
        this.governmentTypes = GovernmentType.values();
        this.techLevels = TechLevel.values();
        this.resources = ResourceType.values();
        this.marketTypes = MarketType.values();
        this.colors = Colors.values();
    }



    public Set<SolarSystem> generate() {
        Random num = new Random();
        //while(solarSystems.size() <= 10) {
        while (numPlanets < 20) {
            int randName = num.nextInt(100);
            if (solarSystems.size() < 10) {
                int randXCoord = num.nextInt(50);
                int randYCoord = num.nextInt(100);
                boolean canAdd = usedNames.add(nameList[randName]);
                if (canAdd) {
                    SolarSystem toAdd = new SolarSystem(nameList[randName], randXCoord, randYCoord);
                    this.solarSystems.add(toAdd);
                    solar[ind] = toAdd;
                    ind++;
                }
            } else {
                int randIndex = num.nextInt(10);
                boolean canAddPlanet = usedNames.add(nameList[randName]);
                if (canAddPlanet) {
                    Planet toAdd = randomPlanet(num, randName);
                    if (solsCovered < 10) {
                        solar[solsCovered].addPlanet(toAdd);
                        solsCovered++;
                        numPlanets++;
                    } else {
                        boolean added = solar[randIndex].addPlanet(toAdd);
                        while (!added) {
                            randIndex = num.nextInt(10);
                            added = solar[randIndex].addPlanet(toAdd);
                        }
                        numPlanets++;
                    }
                }
            }
        }
        return this.solarSystems;
    }

    private Planet randomPlanet(Random num, int nameInd) {
        GovernmentType randGov = governmentTypes[num.nextInt(3)];
        TechLevel randTech = techLevels[num.nextInt(8)];
        MarketType randMarket = marketTypes[num.nextInt(2)];
        ResourceType randResource = resources[num.nextInt(12)];
        String randColor = colors[num.nextInt(4)].getHex();
        return new Planet(nameList[nameInd], randTech, randGov,
                randMarket, randColor, randResource);
    }


}
