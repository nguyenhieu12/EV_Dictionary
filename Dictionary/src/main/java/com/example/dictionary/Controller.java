package com.example.dictionary;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Controller extends DictionaryManagement implements Initializable {
    private final static String FILE_URL = "./database/history.txt";

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane returnAnchor;
    @FXML
    private AnchorPane historyAnchor;
    @FXML
    private AnchorPane introduceAnchor;
    @FXML
    private AnchorPane editAnchor;
    @FXML
    private Button button;
    @FXML
    private Button returnButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button buttonAPI;
    @FXML
    private Button goToHistory;
    @FXML
    private Button goToIntroduce;
    @FXML
    private Button goToEdit;
    @FXML
    private Button returnBehindFromIntroduce;
    @FXML
    private Button returnBehindFromHistory;
    @FXML
    private Button returnBehindFromEdit;
    @FXML
    private Button showHistoryButton;
    @FXML
    private Button speakerButton;
    @FXML
    private Button editButton;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private StackPane stackPane;
    @FXML
    private StackPane returnStack;
    @FXML
    private StackPane historyStack;
    @FXML
    private StackPane introduceStack;
    @FXML
    private StackPane editStack;
    @FXML
    private TextField textField;
    @FXML
    private TextField addWordText1;
    @FXML
    private TextField addWordText2;
    @FXML
    private TextField editWordText1;
    @FXML
    private TextField editWordText2;
    @FXML
    private TextField wordNeedEdit;
    @FXML
    private TextField deleteWordText;
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea historyText;
    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Các hàm chuyển cảnh.
     */
    @FXML
    public void changeToBehindView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("behind-view.fxml"));
        Scene scene = button.getScene();

        root.translateXProperty().set(scene.getWidth());
        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();
    }

    @FXML
    public void changeToHelloView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = returnButton.getScene();

        root.translateYProperty().set(scene.getHeight());
        returnStack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            returnStack.getChildren().remove(returnAnchor);
        });
        timeline.play();
    }

    @FXML
    public void changeToHistoryView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("history-view.fxml"));
        Scene scene = goToHistory.getScene();

        root.translateXProperty().set(scene.getWidth());
        returnStack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            returnStack.getChildren().remove(returnAnchor);
        });
        timeline.play();
    }

    @FXML
    public void changeToIntroduceView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("introduce-view.fxml"));
        Scene scene = goToIntroduce.getScene();

        root.translateXProperty().set(scene.getWidth());
        returnStack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            returnStack.getChildren().remove(returnAnchor);
        });
        timeline.play();
    }

    @FXML
    public void changeToEditView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("edit-view.fxml"));
        Scene scene = goToEdit.getScene();

        root.translateXProperty().set(scene.getWidth());
        returnStack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            returnStack.getChildren().remove(returnAnchor);
        });
        timeline.play();
    }

    @FXML
    public void returnBehindFromHistory(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("behind-view.fxml"));
        Scene scene = returnBehindFromHistory.getScene();

        root.translateYProperty().set(scene.getHeight());
        historyStack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            historyStack.getChildren().remove(historyAnchor);
        });
        timeline.play();
    }

    @FXML
    public void returnBehindFromIntroduce(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("behind-view.fxml"));
        Scene scene = returnBehindFromIntroduce.getScene();

        root.translateYProperty().set(scene.getHeight());
        introduceStack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            introduceStack.getChildren().remove(introduceAnchor);
        });
        timeline.play();
    }

    @FXML
    public void returnBehindFromEdit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("behind-view.fxml"));
        Scene scene = returnBehindFromEdit.getScene();

        root.translateYProperty().set(scene.getHeight());
        editStack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            editStack.getChildren().remove(editAnchor);
        });
        timeline.play();
    }

    // hàm thoát khỏi ứng dụng
    @FXML
    public void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thoát khỏi ứng dụng");
        alert.setContentText("Bạn có thực sự muốn thoát ?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) anchorPane.getScene().getWindow();
            stage.close();
        }
    }

    public int randomColor() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 5 + 1;
        int randomInt = (int) randomDouble;
        return randomInt;
    }

    public void setColorForTextArea() {
        int randomColor = randomColor();
        switch (randomColor) {
            case 1:
                textArea.setStyle("-fx-control-inner-background: #007EFC;" +
                        "-fx-text-fill: yellow;" + "-fx-font-weight: bold;");
                break;
            case 2:
                textArea.setStyle("-fx-control-inner-background: #00FFF7;" +
                        "-fx-text-fill: red;" + "-fx-font-weight: bold;");
                break;
            case 3:
                textArea.setStyle("-fx-control-inner-background: #07E089;" +
                        "-fx-text-fill: purple;" + "-fx-font-weight: bold;");
                break;
            case 4:
                textArea.setStyle("-fx-control-inner-background: #B2E655;" +
                        "-fx-text-fill: #F74A00;" + "-fx-font-weight: bold;");
                break;
            case 5:
                textArea.setStyle("-fx-control-inner-background: pink;" +
                        "-fx-text-fill: green;" + "-fx-font-weight: bold;");
                break;
            default:
                break;
        }
    }

    // tra từ
    @FXML
    public void search(ActionEvent event) throws SQLException {
        String word = textField.getText();
        String explain = "";
        if(word.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Vui lòng nhập từ !");
            alert.show();
            return;
        }
        boolean check = false;
        for(int i = 0;i < newDictionary.getWords().size();i++) {
            if(word.equals(newDictionary.getWords().get(i).getWordTarget())) {
                explain = newDictionary.getWords().get(i).getWordExplain();
                check = true;
                break;
            }
        }
        if(!check) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Không thể dịch nghĩa !");
            alert.show();
            return;
        }

        String tmp = "Ngày tra từ: " + java.time.LocalDateTime.now().toString();
        tmp = tmp.substring(0,33);
        tmp = tmp.replace("T", "\nGiờ tra từ: ");

        String s = "----------------------------------------------";
        String history = tmp + "\n\n-Từ được tra: " + word
                + "\n-Nghĩa của từ:\n" + explain + "\n" + s + "\n";

        try {
            FileWriter fw = new FileWriter(FILE_URL, true);
            fw.write(history);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        textArea.setVisible(true);
        textArea.setFont(Font.font(15));
        setColorForTextArea();
        textArea.setText(explain);
    }

    // dịch đoạn văn
    @FXML
    public void searchWithAPI(ActionEvent event) throws IOException {
        String word = textField.getText();
        if(word.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Vui lòng nhập đoạn văn cần dịch !");
            alert.show();
            return;
        }
        String tmp = API.APITranslate("auto", "vi", word);
        StringBuffer res = new StringBuffer();
        int count = 0;

        String[] hey = tmp.split(" ");

        for(int i = 1; i <= hey.length; i++ ){
            if(92 - count < hey[i - 1].length()) {
                res.append('\n');
                res.append(hey[i-1]);
                res.append(' ');
                count = 0;
                count = count + hey[i-1].length();
            }
            else if(92 - count == hey[i-1].length()) {
                res.append(hey[i-1]);
                res.append('\n');
                count = 0;
            }
            else {
                res.append(hey[i - 1]);
                res.append(' ');
                count = count + 1 + hey[i-1].length();
            }
        }

        textArea.setVisible(true);
        textArea.setFont(Font.font(15));
        setColorForTextArea();
        textArea.setText(res.toString());
    }

    // hiển thị lịch sử tra từ
    @FXML
    public void showHistory(ActionEvent event) throws IOException {
        String s = "----------------------------------------------";
        StringBuffer history = new StringBuffer();
        try {
            FileReader fr = new FileReader(FILE_URL);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                history.append(line);
                history.append("\n");
            }
            br.close();
            fr.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Unable to the file: '" + FILE_URL + "'");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if(history.toString().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Chưa có từ nào trong lịch sử !");
            alert.show();
        }
        historyText.setFont(Font.font(14));
        historyText.setStyle("-fx-font-weight: bold;");
        historyText.setText(history.toString());
    }

    // phát âm
    @FXML
    public void speaker(ActionEvent event) {
        String word = textField.getText();
        if(word.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Vui lòng nhập từ !");
            alert.show();
        }
        else Speaker.getVoice(word);
    }

    //thêm từ
    @FXML
    public void addWord(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");

        String word1 = addWordText1.getText();
        String word2 = addWordText2.getText();
        boolean check = false;
        for(int i = 0;i < newDictionary.getWords().size();i++) {
            if(newDictionary.getWords().get(i).getWordTarget().equals(word1)) {
                check = true;
                break;
            }
        }
        if(word1.equals("")) {
            alert.setHeaderText("Xin hãy nhập từ cần thêm !");
            alert.show();
        }
        else if(check) {
            alert.setHeaderText("Từ bạn thêm đã tồn tại !");
            alert.show();
        }
        else {
            Word new_word = new Word(word1, word2);
            newDictionary.pushWord(new_word);
            alert.setHeaderText("Thêm từ thành công !");
            alert.show();
        }
    }

    //sửa từ
    @FXML
    public void editWord(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");

        String word1 = wordNeedEdit.getText();
        String word2 = editWordText1.getText();
        String word3 = editWordText2.getText();
        boolean check = false;
        for(int i = 0;i < newDictionary.getWords().size();i++) {
            if(newDictionary.getWords().get(i).getWordTarget().equals(word1)) {
                newDictionary.getWords().get(i).setWordTarget(word2);
                newDictionary.getWords().get(i).setWordExplain(word3);
                alert.setHeaderText("Sửa từ thành công !");
                alert.show();
                check = true;
                break;
            }
        }
        if(word1.equals("")) {
            alert.setHeaderText("Xin hãy nhập từ cần sửa !");
            alert.show();
        }
        else if(!check) {
            alert.setHeaderText("Không tìm thấy từ cần sửa !");
            alert.show();
        }
    }

    //xóa từ
    @FXML
    public void deleteWord(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");

        String word = deleteWordText.getText();
        boolean check = false;
        for(int i = newDictionary.getWords().size() - 1;i >= 0;i--) {
            if(newDictionary.getWords().get(i).getWordTarget().equals(word)) {
                check = true;
                newDictionary.getWords().remove(i);
                alert.setHeaderText("Xóa từ thành công !");
                alert.show();
                break;
            }
        }
        if(word.equals("")) {
            alert.setHeaderText("Xin hãy nhập từ cần xóa !");
            alert.show();
        }
        else if(!check) {
            alert.setHeaderText("Không tìm thấy từ cần xóa !");
            alert.show();
        }
    }

}
