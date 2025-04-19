/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.QueryFunctions;
import PojoClass.pojo;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author KL RAHUL
 */
public class Products_screenController implements Initializable {

    @FXML
    private TableView<?> products_detail_table_data;
    @FXML
    private TableColumn<?, ?> item_name_Table;
    @FXML
    private TableColumn<?, ?> rate_Table;
    @FXML
    private TableColumn<?, ?> item_code_Table;
    @FXML
    private Label item_name_Label;
    @FXML
    private Label rate_Label;
    @FXML
    private Label item_code_Label;
    @FXML
    private TextField item_name_Entry;
    @FXML
    private TextField rate_Entry;
    @FXML
    private TextField item_code_Entry;
    @FXML
    private Label product_details_label;

    /**
     * Initializes the controller class.
     */
    public void display() {
        ObservableList table_list = FXCollections.observableArrayList();
        QueryFunctions obj = new QueryFunctions();
        ArrayList<PojoClass.pojo> list = obj.select_All_products();
        products_detail_table_data.setItems(table_list);

        item_name_Table.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        rate_Table.setCellValueFactory(new PropertyValueFactory<>("item_rate"));
        item_code_Table.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        table_list.addAll(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        display();
    }

    @FXML
    private void add_button(ActionEvent event) {
        PojoClass.pojo obj_pojo = new pojo();
        obj_pojo.setItem_name(item_name_Entry.getText());
        obj_pojo.setItem_rate(Double.valueOf(rate_Entry.getText()));
        obj_pojo.setItem_code(Integer.parseInt(item_code_Entry.getText()));

        QueryFunctions obj = new QueryFunctions();
        obj.insert_products(obj_pojo);
        item_code_Entry.clear();
        rate_Entry.clear();
        item_code_Entry.clear();
        display();

    }

    @FXML
    private void update_button(ActionEvent event) {
        PojoClass.pojo obj_pojo = new pojo();
        obj_pojo.setItem_name(item_name_Entry.getText());
        obj_pojo.setItem_rate(Double.valueOf(rate_Entry.getText()));
        obj_pojo.setItem_code(Integer.parseInt(item_code_Entry.getText()));

        QueryFunctions obj = new QueryFunctions();
        obj.update_products(obj_pojo);
        item_code_Entry.clear();
        rate_Entry.clear();
        item_code_Entry.clear();
        display();
    }

    @FXML
    private void delete_button(ActionEvent event) {
        PojoClass.pojo obj_pojo = new pojo();
        obj_pojo.setItem_code(Integer.parseInt(item_code_Entry.getText()));

        QueryFunctions obj = new QueryFunctions();
        obj.delete_products(obj_pojo);
        item_code_Entry.clear();
        rate_Entry.clear();
        item_code_Entry.clear();
        display();
    }

    @FXML
    private void Enter1(KeyEvent event) {
        if(event.getCode().toString().equals("ENTER")){
            item_name_Entry.getScene().lookup("#rate_Entry").requestFocus();
        }
    }
     @FXML
    private void Enter2(KeyEvent event) {
        if(event.getCode().toString().equals("ENTER")){
            rate_Entry.getScene().lookup("#item_code_Entry").requestFocus();
        }
    } @FXML
    private void Enter3(KeyEvent event) {
        if(event.getCode().toString().equals("ENTER")){
            item_code_Entry.getScene().lookup("#item_name_Entry").requestFocus();
        }
    }
}
