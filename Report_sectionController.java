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
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author KL RAHUL
 */
public class Report_sectionController implements Initializable {

    @FXML
    private Label Report_Section_Label;
    @FXML
    private TableView<PojoClass.pojo> Table_data;
    @FXML
    private TableColumn<PojoClass.pojo, String> itemname_Table;
    @FXML
    private TableColumn<PojoClass.pojo, String> Date_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Integer> rate_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Integer> qty_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Double> netvalue_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Double> discount_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Double> discamount_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Double> gst_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Double> gstamount_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Integer> itemcode_Table;
    @FXML
    private TableColumn<PojoClass.pojo, String> Cus_name_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Long> Mobile_no_Table;
    @FXML
    private TableColumn<PojoClass.pojo, String> Salse_man_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Double> gstamount_Table1111;
    @FXML
    private Label Total_Amount_Label;

    @FXML
    private DatePicker StartDate;
    @FXML
    private DatePicker EndDate;

    public String date;

    public String startdate = "";
    public String enddate = "";

    /**
     * Initializes the controller class.
     */
    public void display() {
        ObservableList<PojoClass.pojo> table_list = FXCollections.observableArrayList();
        QueryFunctions obj = new QueryFunctions();
        ArrayList<PojoClass.pojo> list = obj.report_select_All();
        Table_data.setItems(table_list);
        table_list.addAll(list);
        itemname_Table.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        rate_Table.setCellValueFactory(new PropertyValueFactory<>("item_rate"));
        qty_Table.setCellValueFactory(new PropertyValueFactory<>("qty"));
        netvalue_Table.setCellValueFactory(new PropertyValueFactory<>("net_value"));
        discount_Table.setCellValueFactory(new PropertyValueFactory<>("discount"));
        discamount_Table.setCellValueFactory(new PropertyValueFactory<>("discount_amount"));
        gst_Table.setCellValueFactory(new PropertyValueFactory<>("gst"));
        gstamount_Table.setCellValueFactory(new PropertyValueFactory<>("gst_amount"));
        itemcode_Table.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        Cus_name_Table.setCellValueFactory(new PropertyValueFactory<>("cus_name"));
        Mobile_no_Table.setCellValueFactory(new PropertyValueFactory<>("cus_mobile"));
        Salse_man_Table.setCellValueFactory(new PropertyValueFactory<>("salse_man_name"));
        Date_Table.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        display();
        amount();
    }

    public void amount() {
        QueryFunctions obj = new QueryFunctions();

        PojoClass.pojo obj_pojo = new pojo();
        Double total = obj_pojo.getNet_value();
        obj.Total_Amount(obj_pojo);
        String full_amount = PojoClass.pojo.full_amount;
        Total_Amount_Label.setText(full_amount + "Rs");
    }

    @FXML
    private void OK_Button(ActionEvent event) {
        if (StartDate.getValue() != null && EndDate.getValue() != null) {
            String sdate = StartDate.getValue().toString();
            String edate = EndDate.getValue().toString();

            System.out.println("Ok button date 1:" + sdate);
            System.out.println("Ok button date 2:" +date);
            PojoClass.pojo obj_pojo = new pojo();
            obj_pojo.setStartDate(sdate);
            obj_pojo.setEndDate(edate);
            QueryFunctions obj = new QueryFunctions();

            ArrayList<PojoClass.pojo> list = obj.From_Date_to_Date(obj_pojo);

            ObservableList<PojoClass.pojo> table_list = FXCollections.observableArrayList();
            Table_data.setItems(table_list);
            table_list.addAll(list);
            itemname_Table.setCellValueFactory(new PropertyValueFactory<>("item_name"));
            rate_Table.setCellValueFactory(new PropertyValueFactory<>("item_rate"));
            qty_Table.setCellValueFactory(new PropertyValueFactory<>("qty"));
            netvalue_Table.setCellValueFactory(new PropertyValueFactory<>("net_value"));
            discount_Table.setCellValueFactory(new PropertyValueFactory<>("discount"));
            discamount_Table.setCellValueFactory(new PropertyValueFactory<>("discount_amount"));
            gst_Table.setCellValueFactory(new PropertyValueFactory<>("gst"));
            gstamount_Table.setCellValueFactory(new PropertyValueFactory<>("gst_amount"));
            itemcode_Table.setCellValueFactory(new PropertyValueFactory<>("item_code"));
            Cus_name_Table.setCellValueFactory(new PropertyValueFactory<>("cus_name"));
            Mobile_no_Table.setCellValueFactory(new PropertyValueFactory<>("cus_mobile"));
            Salse_man_Table.setCellValueFactory(new PropertyValueFactory<>("salse_man_name"));
            Date_Table.setCellValueFactory(new PropertyValueFactory<>("date"));
            PojoClass.pojo obj_sum = obj.SumOf_From_Date_to_Date(obj_pojo);
            Total_Amount_Label.setText(Double.toString(obj_sum.getNet_value()) + "Rs");

        }
    }

    public void displayItems(ArrayList<PojoClass.pojo> list) {

        ObservableList<PojoClass.pojo> table_list = FXCollections.observableArrayList();
        Table_data.setItems(table_list);
        table_list.addAll(list);
        itemname_Table.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        rate_Table.setCellValueFactory(new PropertyValueFactory<>("item_rate"));
        qty_Table.setCellValueFactory(new PropertyValueFactory<>("qty"));
        netvalue_Table.setCellValueFactory(new PropertyValueFactory<>("net_value"));
        discount_Table.setCellValueFactory(new PropertyValueFactory<>("discount"));
        discamount_Table.setCellValueFactory(new PropertyValueFactory<>("discount_amount"));
        gst_Table.setCellValueFactory(new PropertyValueFactory<>("gst"));
        gstamount_Table.setCellValueFactory(new PropertyValueFactory<>("gst_amount"));
        itemcode_Table.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        Cus_name_Table.setCellValueFactory(new PropertyValueFactory<>("cus_name"));
        Mobile_no_Table.setCellValueFactory(new PropertyValueFactory<>("cus_mobile"));
        Salse_man_Table.setCellValueFactory(new PropertyValueFactory<>("salse_man_name"));
        Date_Table.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    @FXML
    public void Current_day_Button(ActionEvent event) {
        QueryFunctions obj = new QueryFunctions();
        String date = Login_ScreenController.date;
        PojoClass.pojo obj_pojo = new pojo();
        obj_pojo.setDate(date);
        ArrayList<PojoClass.pojo> list = obj.Current_Date(obj_pojo);

        obj.Current_Day_Total_Amount();
        ObservableList<PojoClass.pojo> table_list = FXCollections.observableArrayList();
        Table_data.setItems(table_list);
        table_list.addAll(list);
        itemname_Table.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        rate_Table.setCellValueFactory(new PropertyValueFactory<>("item_rate"));
        qty_Table.setCellValueFactory(new PropertyValueFactory<>("qty"));
        netvalue_Table.setCellValueFactory(new PropertyValueFactory<>("net_value"));
        discount_Table.setCellValueFactory(new PropertyValueFactory<>("discount"));
        discamount_Table.setCellValueFactory(new PropertyValueFactory<>("discount_amount"));
        gst_Table.setCellValueFactory(new PropertyValueFactory<>("gst"));
        gstamount_Table.setCellValueFactory(new PropertyValueFactory<>("gst_amount"));
        itemcode_Table.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        Cus_name_Table.setCellValueFactory(new PropertyValueFactory<>("cus_name"));
        Mobile_no_Table.setCellValueFactory(new PropertyValueFactory<>("cus_mobile"));
        Salse_man_Table.setCellValueFactory(new PropertyValueFactory<>("salse_man_name"));
        Date_Table.setCellValueFactory(new PropertyValueFactory<>("date"));
        Total_Amount_Label.setText(PojoClass.pojo.amount + "Rs");

    }
}
