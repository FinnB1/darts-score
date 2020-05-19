import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    public Button newGameButton;
    public Label player1ScoreLabel;
    public Label player2ScoreLabel;
    public Label player1NameLabel;
    public Label player2NameLabel;
    private Match match;
    private Player player1;
    private Player player2;

    public void newGame() {
        player1 = new Player("one");
        player2 = new Player("two");
        match = new Match(5,5, player1, player2);
        player1NameLabel.setText(player1.getName());
        player2NameLabel.setText(player2.getName());
    }
}
