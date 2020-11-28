public class Score {

    protected final int start = 501;
    private int score;
    private int legs;
    private int sets;

    public Score() {
        this.score = start;
        legs = 0;
        sets = 0;
    }

    /**
     * Add score if valid
     * @param scored number scored
     * @return t/f
     */
    public boolean addScore(int scored) {
        if (checkScore(scored)) {
            this.score -= scored;
            return true;
        }
        else {
            return false;
        }
    }

    public void legWon() {
        legs++;
    }

    public void resetLegs() {
        legs = 0;
    }

    public int getLegs() {
        return legs;
    }

    public void setWon() {
        sets++;
    }

    public int getSets() {
        return sets;
    }

    public void resetScore() {
        this.score = start;
    }

    /**
     * Check if score is a valid darts score e.g. Cannot be greater than 180, cannot be greater than remaining score or leave 1 to end
     * Also accounts for impossible scores such as 163,166,169 etc.
     * Checks that checkout is valid/has hit a double
     * @param scored
     * @return
     */
    private boolean checkScore(int scored) {
        if (scored > 180) {
            return false;
        }
        else if (scored > this.score) {
            return false;
        }
        else if (this.score - scored == 1) {
            return false;
        }
        else if (scored == 163 || scored == 166 || scored == 169 || scored == 172 || scored == 173 || scored == 175 ||
        scored == 176 || scored == 178 || scored == 179) {
            return false;
        }
        else if (this.score - scored == 0 && (scored % 2 != 0 || scored == 168 || scored == 165 || scored == 162 || scored == 159)) {
            return false;
        }
        // add checks for impossible scores
        else return true;
    }

    public int getScore() {
        return this.score;
    }

    public boolean checkOut() {
        return score == 0;
    }
}
