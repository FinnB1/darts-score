import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;

import java.text.DecimalFormat;

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
    public Label currentSetLabel;
    public Label currentLegLabel;
    public Label player1StatsNameLabel;
    public Label player2StatsNameLabel;
    public Label player13DA;
    public Label player23DA;
    public Label player1ton;
    public Label player2ton;
    public Label player1ton40;
    public Label player2ton40;
    public Label player1ton80;
    public Label player2ton80;
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
        currentSetLabel.setText("Set 1 of "+match.getBestOfSets());
        currentLegLabel.setText("Leg 1 of "+match.getBestOfLegs());
        player1NameLabel.setText(player1.getName());
        player1NameLabel.setStyle("-fx-text-fill: green;");
        player2NameLabel.setText(player2.getName());
        player1StatsNameLabel.setText(player1.getName());
        player2StatsNameLabel.setText(player2.getName());
        match.startMatch();
        refreshScore();
        refreshStats();
    }

    public void numberButtonPress(Event event) {
        if (secondaryScoreLabel.getText().length() != 3) {
            String number = ((Button) event.getSource()).getText();
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
        currentSetLabel.setText("Set "+ match.getCurrentSet()+" of "+match.getBestOfSets());
        currentLegLabel.setText("Leg "+ match.getCurrentLeg()+" of "+match.getBestOfLegs());
    }

    private void refreshStats() {
        DecimalFormat df = new DecimalFormat("#.00");
        Stats p1Stats = player1.getStats();
        Stats p2Stats = player2.getStats();
        player13DA.setText(df.format(p1Stats.getAverage()));
        player23DA.setText(df.format(p2Stats.getAverage()));
        player1ton.setText(""+p1Stats.getTon());
        player2ton.setText(""+p2Stats.getTon());
        player1ton40.setText(""+p1Stats.getTonForty());
        player2ton40.setText(""+p2Stats.getTonForty());
        player1ton80.setText(""+p1Stats.getTonEighty());
        player2ton80.setText(""+p2Stats.getTonEighty());
    }

    public void otherButtonPress(Event event) {
        if (((Button) event.getSource()).equals(submitButton)) {
            if (!match.score(Integer.parseInt(secondaryScoreLabel.getText())) || secondaryScoreLabel.getText().length() == 0) {
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
            if (match.isWon()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Congratulations");
                alert.setHeaderText(null);
                alert.setContentText(match.getWinner().getName() + " won the match "+ match.getWinner().getScoreObject().getSets()+ "-" + match.getLoser().getScoreObject().getSets());
                alert.showAndWait();
                refreshScore();
                return;
            }
            secondaryScoreLabel.setText("");
            refreshScore();
            refreshStats();
        }
        else if (((Button) event.getSource()).equals(cancelButton)) {
            secondaryScoreLabel.setText(secondaryScoreLabel.getText().substring(0, secondaryScoreLabel.getText().length() - 1));
        }
    }
}
