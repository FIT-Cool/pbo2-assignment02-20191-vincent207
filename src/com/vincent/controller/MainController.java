package com.vincent.controller;

import com.vincent.entity.Category;
import com.vincent.entity.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TableView<Item> tblData;
    @FXML
    private TableColumn<Item, String> colName;
    @FXML
    private TableColumn<Item, String> colPrice;
    @FXML
    private TableColumn<Item, String> colCategory;
    @FXML
    private TextField txtCatName;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private ComboBox<Category> catComboBox;
    private ObservableList<Item> items;
    private ObservableList<Category> categories;
    @FXML
    private Button updateBtn;
    @FXML
    private Button saveButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button saveCatBtn;

    @FXML
    private void resetAct(ActionEvent actionEvent) {
    }

    @FXML
    private void saveAct(ActionEvent actionEvent) {

    }

    @FXML
    private void updateAct(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        items = FXCollections.observableArrayList();
        tblData.setItems(items);
        colName.setCellValueFactory(data ->{
            Item i = data.getValue();
            return new SimpleStringProperty(i.getName());
        });
        colPrice.setCellValueFactory(data ->{
           Item i = data.getValue();
           return new SimpleStringProperty(String.valueOf(i.getPrice()));
        });
        colCategory.setCellValueFactory(data ->{
            Item i = data.getValue();
            return new SimpleStringProperty(i.getCategory().getCategoryName());
        });

        categories = FXCollections.observableArrayList();
        catComboBox.setItems(categories);
    }

    @FXML
    private void tblClicked(MouseEvent mouseEvent) {

        Item i = tblData.getSelectionModel().getSelectedItem();
        txtName.setText(i.getName());
        txtPrice.setText(String.valueOf(i.getPrice()));
        txtCatName.setText(i.getCategory().getCategoryName());

    }

    @FXML
    private void saveCatAct(ActionEvent actionEvent) {
        Category c = new Category();
        c.setCategoryName(txtCatName.getText());
        categories.add(c);
    }
}
