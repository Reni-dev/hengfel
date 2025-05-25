/*
* File: MainController.java
* Author: Hanák Renáta
* Copyright: 2025, Hanák Renáta
* Group: Szoft 1/N
* Date: 2025-05-25
* Github: https://github.com/reni-dev/
* Licenc: MIT
*/

package com.example;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private TextField areaField;

    @FXML
    private AnchorPane calcPage;

    @FXML
    private TextField heightField;

    @FXML
    private AnchorPane namePage;

    @FXML
    private TextField radiusField;

    @FXML
    private Button calcButton;

    @FXML
    void onClickCalcButton(ActionEvent event) {
        startCalc();
    }

    private void startCalc(){
        if(heightField.getText().isEmpty() || radiusField.getText().isEmpty()){
            showMissingError();
        } else if (heightField.getText().matches("\\d+") && radiusField.getText().matches("\\d+")){
            Double radius = Double.parseDouble(radiusField.getText());
            Double height = Double.parseDouble(heightField.getText());            

            if(height <= 0 || radius <= 0){
                showZeroError();
            } else{
                Double area = 2 * Math.PI * radius * (radius + height);
                areaField.setText(area.toString());

                ArrayList<String> numberList = new ArrayList<>();
                numberList.add(radiusField.getText() + ":" + heightField.getText() + ":" + areaField.getText() + "\n");

                Storage.writeFile(numberList);
            }
        } else {
            showNotNumberError();
        }
    }

    private void showMissingError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(App._stage);
        alert.setTitle("Hiányzó adat!");
        alert.setHeaderText("Hiányzó adat!");
        alert.setContentText("A sugár vagy magasság nagysága hiányos!");
        alert.show();
    }

    private void showZeroError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(App._stage);
        alert.setTitle("Rossz adat!");
        alert.setHeaderText("Minusz vagy Nulla!");
        alert.setContentText("A sugár vagy magasság nem lehet nulla, vagy annál kisebb szám!");
        alert.show();
    }

    private void showNotNumberError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(App._stage);
        alert.setTitle("Nem szám!");
        alert.setHeaderText("Nem szám!");
        alert.setContentText("A sugárnak és a magasságnak csak számokat lehet megadni!");
        alert.show();
    }
}
