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

    public void nextLeg(Player player) {
        player1.resetScore();
        player2.resetScore();
        player.getScoreObject().legWon();
        player.getStats().legWon();
        if (player.getScoreObject().getLegs() == Math.round(bestOfLegs * 1.0 / 2)) {
            player1.getScoreObject().resetLegs();
            player2.getScoreObject().resetLegs();
            nextSet(player);
        }
        else currentLeg++;
    }

    public void nextSet(Player player) {
        player1.resetScore();
        player2.resetScore();
        player.getScoreObject().setWon();
        player.getStats().setWon();
        currentLeg = 1;
        currentSet++;
        if (player.getScoreObject().getSets() == Math.round(bestOfSets * 1.0 / 2)) {
            // end match
        }
    }

    public boolean score(int score) {
        if (current.getScoreObject().addScore(score)) {
            current.getStats().addScore(score);
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
