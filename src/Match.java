public class Match {

    private int bestOfSets;
    private int bestOfLegs;
    private int currentLeg;
    private int currentSet;
    private Player player1;
    private Player player2;
    private Player current;

    public Match(int bestOfSets, int bestOfLegs, Player one, Player two) {
        this.bestOfSets = bestOfSets;
        this.bestOfLegs = bestOfLegs;
        this.player1 = one;
        this.player2 = two;
    }

    public void startMatch() {
        player1.resetScore();
        player2.resetScore();
        currentLeg = 1;
        currentSet = 1;
        current = player1;
    }

    public boolean checkOut(Player player) {
        return player.getScoreObject().checkOut();
    }

    public boolean checkWin() {
        return false;
    }

    public Player getCurrentPlayer() {
        return current;
    }

    public void nextLeg() {
        player1.resetScore();
        player2.resetScore();
        if (currentLeg + 1 == bestOfLegs) {
            nextSet();
        }
        else currentLeg++;
    }

    public void nextSet() {
        currentLeg = 1;
        player1.resetScore();
        player2.resetScore();
    }

    public boolean score(int score) {
        if (current.getScoreObject().addScore(score)) {
            nextPlayer();
            return true;
        }
        else return false;
    }

    private void nextPlayer() {
        if (current.equals(player1))
            current = player2;
        else current = player1;
    }

}
