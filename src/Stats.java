public class Stats {

    private double average;
    private int dartsThrown;
    private int ton;
    private int tonForty;
    private int tonEighty;

    public Stats() {

    }

    public void tonScored() {
        ton++;
    }

    public void tonFortyScored() {
        tonForty++;
    }

    public void tonEightyScored() {
        tonEighty++;
    }

    public void addScore(int score) {
        average = average * dartsThrown;
        average += score;
        dartsThrown += 3;
        average = average / dartsThrown;
    }

    public double getAverage() {
        return average;
    }

    public int getDartsThrown() {
        return dartsThrown;
    }

    public int getTon() {
        return ton;
    }

    public int getTonForty() {
        return tonForty;
    }

    public int getTonEighty() {
        return tonEighty;
    }
}
