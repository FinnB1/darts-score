public class Match {

    private int bestOfSets;
    private int bestOfLegs;
    private int currentLeg;
    private int currentSet;
    private Player player1;
    private Player player2;
    private Player current;
    private boolean won;
    private Player winner;
    private Player loser;
    private Player legStart;
    private Player setStart;

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
        legStart = player1;
        setStart = player1;
    }

    public boolean checkOut(Player player) {
        return player.getScoreObject().checkOut();
    }

    public int getBestOfSets() {
        return bestOfSets;
    }

    public int getBestOfLegs() {
        return bestOfLegs;
    }

    public int getCurrentLeg() {
        return currentLeg;
    }

    public int getCurrentSet() {
        return currentSet;
    }

    public Player getCurrentPlayer() {
        return current;
    }

    private void winMatch(Player player) {
        won = true;
        winner = player;
        if (winner.equals(player1))
            loser = player2;
        else loser = player1;
    }

    public boolean isWon() {
        return won;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void nextLeg(Player player) {
        player1.resetScore();
        player2.resetScore();
        player.getScoreObject().legWon();
        player.getStats().legWon();
        legStart = nextPlayer(legStart);
        current = legStart;
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
        setStart = nextPlayer(setStart);
        current = setStart;
        currentSet++;
        if (player.getScoreObject().getSets() == Math.round(bestOfSets * 1.0 / 2)) {
            winMatch(player);
        }
    }

    public boolean score(int score) {
        if (current.getScoreObject().addScore(score)) {
            current.getStats().addScore(score);
            current = nextPlayer(current);
            return true;
        }
        else return false;
    }

    private Player nextPlayer(Player player) {
        if (player.equals(player1))
            player = player2;
        else player = player1;
        return player;
    }

}
