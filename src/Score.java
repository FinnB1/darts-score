public class Score {

    protected final int start = 501;
    private int score;

    public Score() {
        this.score = start;
    }

    public boolean addScore(int scored) {
        if (checkScore(scored)) {
            this.score -= scored;
            return true;
        }
        else {
            return false;
        }
    }

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
