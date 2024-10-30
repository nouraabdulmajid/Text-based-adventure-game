public class Player {
    private String name;
    private int funds;

    public Player(String name) {
        this.name = name;
        this.funds = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getFunds() {
        return this.funds;
    }

    public void increaseFunds() {
        this.funds += 50;
    }
}
