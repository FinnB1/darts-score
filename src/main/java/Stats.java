public class Stats {

    private double average;
    private int dartsThrown;
    private int ton;
    private int tonForty;
    private int tonEighty;
    private int legsWon;
    private int setsWon;

    public Stats() {

    }

    public int getLegsWon() {
        return legsWon;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public void addScore(int score) {
        average = average * dartsThrown;
        average += score;
        dartsThrown += 3;
        average = average / dartsThrown;
        if (score == 180) {
            tonEighty++;
        }
        else if (score >= 140) {
            tonForty++;
        }
        else if (score >= 100) {
            ton++;
        }
    }

    public void legWon() {
        legsWon++;
    }

    public void setWon() {
        setsWon++;
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
