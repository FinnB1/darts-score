public class Stats {

    private double average;
    private double dartsThrown;
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

    /**
     * Update statistics to account for new score added
     * Including updating average and high scores if achieved
     * @param score to add
     */
    public void addScore(int score) {
        average = average * (dartsThrown / 3);
        average += score;
        dartsThrown += 3;
        average = average / (dartsThrown / 3);
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

    public double getDartsThrown() {
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
