package application;

import domain.*;
//import fileSaver.*;
import java.util.ArrayList;

public class GameLogic {
    private Player player;
    private ArrayList<City> destinations;
    private ArrayList<Clothing> clothingList;
    private Suitcase suitcase;

    public GameLogic() {
        this.player = null;
        this.destinations = new ArrayList<>();
        this.clothingList = new ArrayList<>();
        this.suitcase = new Suitcase();
        this.populateData();
    }

    public void createPlayer(String name) {
        Player player = new Player(name);
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void addDestination(City city) {
        this.destinations.add(city);
    }

    public ArrayList getDestinations() {
        return this.destinations;
    }

    public City getDestination(String name) {
        for (City c: this.destinations) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList getClothing() {
        return this.clothingList;
    }

    public void addClothing(Clothing clothing) {
        this.clothingList.add(clothing);
    }

    public void pack(Clothing clothing) {
        this.suitcase.addItem(clothing);

    }

    public void work() {
        this.player.increaseFunds();
    }

    public String getAccommodationDescription(String cityName, String accommodation) {
        City destination = this.getDestination(cityName);
        String description = destination.getAccommodationDescription(accommodation);
        return description;
    }

    public String getActivityDescription(String cityName, String activity) {
        City destination = this.getDestination(cityName);
        String description = destination.getActivityDescription(activity);
        return description;
    }

    public void populateData() {
        //Creating the objects that are to be used in the game
        //Create cities
        City oslo = new City("Oslo", 150);
        oslo.addAccommodation("bed and breakfast", "The room is small, but is immaculate for a bed and breakfast, with modern, minimal furniture in neutral colours, a full-length mirror and fresh linen bedding.");
        oslo.addAccommodation("hotel", "The hotel room is very elegantly decorated, with muted wooden furnishings, contemporary, sleek and modern furniture, an elegant divan and a large flatscreen TV.");
        oslo.addActivity("fjord", "The fjord trip that you had been looking forward to is here. You get in a canoe with your guide, who chats amicably as you sail across the Norwegian waters. The skies are clear and the majestic sight of the mountains is breathtaking.");
        oslo.addActivity("museum", "The museum is large and expansive, and you hear the scattered chatter from families, couples and individuals alike. A number of viking artefacts are on display, including helmets, axes and spears, which spark your imagination.");
        City istanbul = new City("Istanbul", 350);
        istanbul.addAccommodation("bed and breakfast", "The room has a peaceful, though somewhat antiquated feel to it. Through the window, you can see a balcony with an interesting variety of potted plants and flowers.");
        istanbul.addAccommodation("three star hotel", "The room is spacious and brand new, with a comfortable double bed with clean linen furnishings. You are free to stretch around and gaze outside the window, through which sunlight streems, into the courtyard below, where you can see people coming and going and children playing.");
        istanbul.addActivity("bazaar", "The bazaar sells a wide array of items, from clothing to crockery and cutlery to jewellery. You gaze at the handmade goods and take a liking to a rug with intricate patterns. After haggling with the seller, it's yours.");
        istanbul.addActivity("palace", "Approaching the palace, you see a beautiful courtyard with fountains and trees. Inside, the brightly coloured walls are decorated by numerous ornaments, while stunning carpets adorn the floors. You take in the history of the place, admiring it all.");
        City paris = new City("Paris", 160);
        paris.addAccommodation("bed and breakfast", "Your room is cheap and cheerful, with a somewhat old bedframe but a nonetheless comfortable mattress. There is an old wooden cupboard for you to store your clothes, and a handy desk. The walls are plain except for a window.");
        paris.addAccommodation("apartment", "The apartment is small, but has modern furnishings and interiors. The kitchen contains a variety of modern gadgets including an air fryer. The room has muted, elegant and minimal furnishings. You particularly like the balcony, which shows a beautiful view of terraced houses and a beautiful sky.");
        paris.addActivity("eiffel tower", "Approaching the tower, there is an expansive green lawn with plenty of visitors from all over the world, many who have set up picnic blankets on the lawn. The tower itself stands tall with many tourists walking around it to try to find the best angle to take a photo.");
        paris.addActivity("palace", "You walk up the steps to the palace, admiring the views of the lawns, gardens and clear blue sky from your high vantage point. The inside is decorated with an array of paintings of people, animals and landscapes from various historical periods, and interesting floor tiles. One room is particularly grand, with an intricately painted ceiling in the roccoco style, gilt details on the walls and interiors and grand solid wood furniture.");

        SunProtection sunglasses = new SunProtection("sunglasses");
        SunProtection sunHat = new SunProtection ("sunHat");

        //Create tops
        Top jacket = new Top("jacket");
        Top shirt = new Top("shirt");
        Top tee = new Top("tee");

        //Create bottoms
        Bottom jeans = new Bottom("jeans");
        Bottom linenTrousers = new Bottom("linen trousers");
        Bottom skirt = new Bottom("skirt");

        this.addClothing(sunglasses);
        this.addClothing(sunHat);
        this.addClothing(jacket);
        this.addClothing(shirt);
        this.addClothing(tee);
        this.addClothing(jeans);
        this.addClothing(linenTrousers);
        this.addClothing(skirt);


        this.addDestination(oslo);
        this.addDestination(istanbul);
        this.addDestination(paris);
    }









}

