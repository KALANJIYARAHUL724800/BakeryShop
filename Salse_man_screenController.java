/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.QueryFunctions;
import PojoClass.pojo;
import java.awt.Desktop.Action;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author KL RAHUL
 */
public class Salse_man_screenController implements Initializable {

    @FXML
    private TableView<PojoClass.pojo> salse_man_table_data;
    @FXML
    private TableColumn<PojoClass.pojo, String> salse_man_table;
    @FXML
    private TableColumn<PojoClass.pojo, Integer> salse_man_id_table;
    @FXML
    private Label Salse_man_details_dead_label;
    @FXML
    private TextField sman_Entry;
    @FXML
    private Label sname_label;
    @FXML
    private Label sman_id_label;
    @FXML
    private TextField sman_id_Entry;

    /**
     * Initializes the controller class.
     */
    public void display() {
        ObservableList table_list = FXCollections.observableArrayList();
        QueryFunctions obj = new QueryFunctions();
        ArrayList<PojoClass.pojo> list = obj.salse_man_All();
        salse_man_table_data.setItems(table_list);
        salse_man_table.setCellValueFactory(new PropertyValueFactory<>("salse_man_name"));
        salse_man_id_table.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_list.addAll(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        display();
    }

    @FXML
    private void sman_add_button(ActionEvent event) {
        PojoClass.pojo obj_pojo = new pojo();
        obj_pojo.setSalse_man_name(sman_Entry.getText());
        obj_pojo.setId(Integer.parseInt(sman_id_Entry.getText()));
        QueryFunctions obj = new QueryFunctions();
        obj.insert_salse_man(obj_pojo);
        sman_Entry.clear();
        sman_Entry.clear();
        display();

    }

    @FXML
    private void sman_update_button(ActionEvent event) {
        PojoClass.pojo obj_pojo = new pojo();
        obj_pojo.setSalse_man_name(sman_Entry.getText());
        obj_pojo.setId(Integer.parseInt(sman_id_Entry.getText()));
        QueryFunctions obj = new QueryFunctions();
        obj.update_salse_man(obj_pojo);
        sman_Entry.clear();
        sman_Entry.clear();
        display();
    }

    @FXML
    private void sman_delete_button(ActionEvent event) {
        PojoClass.pojo obj_pojo = new pojo();
        obj_pojo.setSalse_man_name(sman_Entry.getText());
        obj_pojo.setId(Integer.parseInt(sman_id_Entry.getText()));
        QueryFunctions obj = new QueryFunctions();
        obj.delete_salse_man(obj_pojo);
        sman_id_Entry.clear();
        sman_Entry.clear();
        display();
        System.out.println("heloo");
    }

    public void Enter1(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            sman_Entry.getScene().lookup("#sman_id_Entry").requestFocus();
        }
    }

    public void Enter2(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            /*PojoClass.pojo obj_pojo = new pojo();
            obj_pojo.setSalse_man_name(sman_Entry.getText());
            obj_pojo.setId(Integer.parseInt(sman_id_Entry.getText()));
            QueryFunctions obj = new QueryFunctions();
            obj.insert_salse_man(obj_pojo);
            sman_Entry.clear();
            sman_id_Entry.clear();
            display();*/
            sman_id_Entry.getScene().lookup("#sman_Entry").requestFocus();

        }
    }
}
