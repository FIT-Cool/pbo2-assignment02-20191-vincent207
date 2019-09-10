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

/**
 *
 * @author : Vincent Gunaeri (1772001)
 * Program: Controller untuk tampilan MainForm.fxml
 *
 */
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

    /**
     * resetAct berfungsi untuk melakukan reset pada textField yang ada pada program
     * @param actionEvent
     */
    @FXML
    private void resetAct(ActionEvent actionEvent) {
        txtName.clear();
        txtPrice.clear();
        txtCatName.clear();
        catComboBox.getSelectionModel().clearSelection();
    }

    /**
     * saveAct berfungsi untuk mencatat input user ke TableView tblData
     * @param actionEvent
     */
    @FXML
    private void saveAct(ActionEvent actionEvent) {
        if ((!txtName.getText().isEmpty() && !txtPrice.getText().isEmpty()) && !categories.isEmpty()) {
            Item i = new Item();
            i.setName(txtName.getText());
            i.setPrice(Double.parseDouble(txtPrice.getText()));
            Category c = new Category();
            c.setCategoryName(catComboBox.getSelectionModel().getSelectedItem().toString());
            i.setCategory(c);
            items.add(i);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please fill name/price/category");
            alert.show();

        }
    }

    /**
     * method updateAct berfungsi untuk melakukan update dari TableView dengan input dari user yang baru
     * @param actionEvent
     */
    @FXML
    private void updateAct(ActionEvent actionEvent) {
        if ((!txtName.getText().isEmpty() && !txtPrice.getText().isEmpty()) && !categories.isEmpty()) {

            items.remove(tblData.getSelectionModel().getSelectedItem());
            Item i = new Item();
            i.setName(txtName.getText());
            i.setPrice(Double.parseDouble(txtPrice.getText()));
            Category c = catComboBox.getSelectionModel().getSelectedItem();
            i.setCategory(c);
            if(items.isEmpty())
            {
                items.add(i);
            }
            else
            {
                items.add(tblData.getSelectionModel().getSelectedIndex(), i);
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please fill name/price/category");
            alert.show();

        }
        updateBtn.setDisable(true);
    }

    /**
     * method initialize berfungsi untuk melakukan link observableArrayList ke TableView dan/atau comboBox pada program
     * @param location
     * @param resources
     */
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

    /**
     * tableClicked method berfungsi untuk membuka buttonUpdate yang akan berfungsi untuk proses update
     * @param mouseEvent
     */
    @FXML
    private void tblClicked(MouseEvent mouseEvent) {
        if (items.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Can't read data");
            alert.setContentText("Please insert data first before editing");
            alert.show();
        }
        else
        {
            updateBtn.setDisable(false);
            Item i = tblData.getSelectionModel().getSelectedItem();
            txtName.setText(i.getName());
            txtPrice.setText(String.valueOf(i.getPrice()));
            txtCatName.setText(i.getCategory().getCategoryName());
        }
    }

    /**
     * saveCatAct method berfungsi untuk mencatat input Category ke comboBox
     * @param actionEvent
     */
    @FXML
    private void saveCatAct(ActionEvent actionEvent) {

        if (!txtCatName.getText().equals("")) {
            Category c = new Category();
            c.setCategoryName(txtCatName.getText());
            int iterator = 0;
            for(Category category : categories)
            {
                if(category.getCategoryName().equals(c.getCategoryName()))
                {
                    iterator++;
                }
            }
            if(iterator >= 1)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Duplicate category name");
                alert.show();
            }
            else
            {
                categories.add(c);
            }

            txtCatName.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please fill category name");
            alert.show();
        }
    }
}
