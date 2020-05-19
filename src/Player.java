public class Player {

    private Stats stats;
    private Score score;
    private String name;

    public Player(String name) {
        stats = new Stats();
        score = new Score();
        this.name = name;
    }

    public Stats getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void resetScore() {
        score = new Score();
    }

    public Score getScore() {
        return score;
    }
}
