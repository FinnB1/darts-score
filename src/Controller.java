import javafx.event.ActionEvent;
import javafx.event.Event;
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
    public Label secondaryScoreLabel;
    public Button cancelButton;
    public Button submitButton;
    public Label player2Sets;
    public Label player2Legs;
    public Label player1Legs;
    public Label player1Sets;
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
        player1Sets.setText("0");
        player2Sets.setText("0");
        player1Legs.setText("0");
        player2Legs.setText("0");
        submitButton.setDisable(false);
        player1 = new Player(player1NameField.getText());
        player2 = new Player(player2NameField.getText());
        match = new Match((Integer) setsChoice.getValue(), (Integer) legsChoice.getValue(), player1, player2);
        player1NameLabel.setText(player1.getName());
        player1NameLabel.setStyle("-fx-text-fill: green;");
        player2NameLabel.setText(player2.getName());
        match.startMatch();
    }

    public void numberButtonPress(Event event) {
        if (secondaryScoreLabel.getText().length() != 3) {
            String number = ((Button) event.getSource()).getText();
            System.out.println(number);
            secondaryScoreLabel.setText(secondaryScoreLabel.getText() + number);
        }
    }

    private void refreshScore() {
        if (match.getCurrentPlayer().equals(player1)) {
            player1NameLabel.setStyle("-fx-text-fill: green;");
            player2NameLabel.setStyle("-fx-text-fill: black;");
        }
        else {
            player1NameLabel.setStyle("-fx-text-fill: black;");
            player2NameLabel.setStyle("-fx-text-fill: green;");
        }
        player1Legs.setText("" + player1.getScoreObject().getLegs());
        player2Legs.setText("" + player2.getScoreObject().getLegs());
        player1Sets.setText("" + player1.getScoreObject().getSets());
        player2Sets.setText("" + player2.getScoreObject().getSets());
        player1ScoreLabel.setText("" + player1.getScoreInt());
        player2ScoreLabel.setText("" + player2.getScoreInt());
    }

    public void otherButtonPress(Event event) {
        if (((Button) event.getSource()).equals(submitButton)) {
            if (!match.score(Integer.parseInt(secondaryScoreLabel.getText()))) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Invalid score!");
                alert.showAndWait();
                secondaryScoreLabel.setText("");
                return;
            }
            if (match.checkOut(player1)) {
                match.nextLeg(player1);
                player1.getStats().legWon();
            }
            else if (match.checkOut(player2)) {
                match.nextLeg(player2);
                player1.getStats().legWon();
            }
            secondaryScoreLabel.setText("");
            refreshScore();
        }
        else if (((Button) event.getSource()).equals(cancelButton)) {
            secondaryScoreLabel.setText(secondaryScoreLabel.getText().substring(0, secondaryScoreLabel.getText().length() - 1));
        }
    }
}
