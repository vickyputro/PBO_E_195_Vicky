import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Random;

public class TebakAngkaApp extends Application {

    private int angkaAcak;
    private int jumlahTebakan = 0;
    private final Random rand = new Random();

    @Override
    public void start(Stage primaryStage) {
        // Judul
        Label titleLabel = new Label("🎯 Tebak Angka 1–100");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.DARKBLUE);

        // Label pengembalian
        Label feedbackLabel = new Label("");
        feedbackLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        // Input
        TextField inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(200);
        inputField.setFont(Font.font("Arial", 14));

        // Tombol
        Button tebakanButton = new Button("🎲 Coba Tebak!");
        tebakanButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-size: 14px;");

        // Label percobaan
        Label percobaanLabel = new Label("Jumlah percobaan: 0");
        percobaanLabel.setFont(Font.font("Arial", 14));
        percobaanLabel.setTextFill(Color.DIMGRAY);

        // Layout input
        HBox inputArea = new HBox(10, inputField, tebakanButton);
        inputArea.setAlignment(Pos.CENTER);

        // Root layout
        VBox root = new VBox(15, titleLabel, feedbackLabel, inputArea, percobaanLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #e6f0ff;");

        // Fungsi reset game
        Runnable resetGame = () -> {
            angkaAcak = rand.nextInt(100) + 1;
            jumlahTebakan = 0;
            percobaanLabel.setText("Jumlah percobaan: 0");
            feedbackLabel.setText("");
            inputField.setText("");
            inputField.setDisable(false);
            tebakanButton.setText("🎲 Coba Tebak!");
            tebakanButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-size: 14px;");
        };

        tebakanButton.setOnAction(e -> {
            if (tebakanButton.getText().equals("🔁 Main Lagi")) {
                resetGame.run();
                return;
            }

            String input = inputField.getText();
            try {
                int tebakan = Integer.parseInt(input);
                jumlahTebakan++;
                percobaanLabel.setText("Jumlah percobaan: " + jumlahTebakan);

                if (tebakan > 100) {
                    feedbackLabel.setText("Masukkan angka yang valid!");
                    feedbackLabel.setTextFill(Color.RED);
                } else if (tebakan > angkaAcak) {
                    feedbackLabel.setText("▲ Terlalu besar!");
                    feedbackLabel.setTextFill(Color.ORANGE);
                } else if (tebakan < angkaAcak) {
                    feedbackLabel.setText("▼ Terlalu kecil!");
                    feedbackLabel.setTextFill(Color.ORANGE);
                } else {
                    feedbackLabel.setText("✔ Tebakan benar!");
                    feedbackLabel.setTextFill(Color.GREEN);
                    inputField.setDisable(true);
                    tebakanButton.setText("🔁 Main Lagi");
                    tebakanButton.setStyle("-fx-background-color: #0d6efd; -fx-text-fill: white; -fx-font-size: 14px;");
                }
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Masukkan angka yang valid!");
                feedbackLabel.setTextFill(Color.RED);
            }
        });

        resetGame.run();//untuk mengulang permainan

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Tebak Angka ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
