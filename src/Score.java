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
        // add checks for impossible scores
        else return true;
    }
}
