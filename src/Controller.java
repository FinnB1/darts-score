import javafx.scene.control.*;

public class Controller {
    public Button newGameButton;
    public Label player1ScoreLabel;
    public Label player2ScoreLabel;
    public Label player1NameLabel;
    public Label player2NameLabel;
    public TextField player1NameField;
    public TextField player2NameField;
    public ChoiceBox setsChoice;
    public ChoiceBox legsChoice;
    private Match match;
    private Player player1;
    private Player player2;

    public void newGame() {
        if (player1NameField.getText().equals("") || player2NameField.getText().equals("") || setsChoice.getValue() == null || legsChoice.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields to start a game!");
            alert.showAndWait();
            return;
        }
        player1 = new Player(player1NameField.getText());
        player2 = new Player(player2NameField.getText());
        match = new Match((Integer) setsChoice.getValue(), (Integer) legsChoice.getValue(), player1, player2);
        player1NameLabel.setText(player1.getName());
        player2NameLabel.setText(player2.getName());
    }
}
