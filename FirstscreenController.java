package Frontend;

import Backend.QueryFunctions;
import PojoClass.pojo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KL RAHUL
 */
public class FirstscreenController implements Initializable {

    @FXML
    private Label salsebillheading;
    @FXML
    private Label salseman_label;
    @FXML
    private TextField salseman_Entry;
    @FXML
    private Label qtry_label;
    @FXML
    private TextField qty_Entry;
    @FXML
    private Label itemid_label;
    @FXML
    private TextField itemid_Entry;
    @FXML
    private Label itemrate_label;
    @FXML
    private TextField itemrate_Entry;
    @FXML
    private Label billdate_label;
    @FXML
    private DatePicker date_Entry;

    @FXML
    private TableView<PojoClass.pojo> table_data;
    @FXML
    private TableColumn<PojoClass.pojo, Integer> sno_Table;
    @FXML
    private TableColumn<PojoClass.pojo, String> itemname_Table;
    @FXML
    private TableColumn<PojoClass.pojo, Double> rate_Table;
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
    private Label stock_Label;
    @FXML
    private TextField stoc_Entry;
    @FXML
    private Label mrp_Label;
    @FXML
    private TextField mrp_Entry;
    @FXML
    private Label Salseman_Name_Show_Label;
    @FXML
    private Label Total_Amount_Label;
    @FXML
    private Label cus_name_Label;
    @FXML
    private Label mobileno_Label;
    @FXML
    private TextField cus_name_Entry;
    @FXML
    private TextField mobileno_Entry;
    @FXML
    private ScrollPane billpane;
    @FXML
    private Label billarea_label;

    public static String date;

    public static double temp_amount = 0;
    ObservableList table_list = FXCollections.observableArrayList();
    public static ArrayList<PojoClass.pojo> arraylist = new ArrayList<>();
    int count_file = 0;

    /**
     * Initializes the controller class.
     */
    public void add() {
        ObservableList table_list = FXCollections.observableArrayList();
        QueryFunctions obj = new QueryFunctions();
        ArrayList<PojoClass.pojo> list = obj.select_All();
        table_list.addAll(list);
        table_data.setItems(table_list);

        itemname_Table.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        rate_Table.setCellValueFactory(new PropertyValueFactory<>("item_rate"));
        qty_Table.setCellValueFactory(new PropertyValueFactory<>("qty"));
        netvalue_Table.setCellValueFactory(new PropertyValueFactory<>("net_value"));
        discount_Table.setCellValueFactory(new PropertyValueFactory<>("discount"));
        discamount_Table.setCellValueFactory(new PropertyValueFactory<>("disc_amount"));
        gst_Table.setCellValueFactory(new PropertyValueFactory<>("gst"));
        gstamount_Table.setCellValueFactory(new PropertyValueFactory<>("gst_amount"));
        itemcode_Table.setCellValueFactory(new PropertyValueFactory<>("item_code"));

    }

    public void insert() {
        PojoClass.pojo obj_pojo = new pojo();
        int qty = Integer.parseInt(qty_Entry.getText());
        int item_code = Integer.parseInt(itemid_Entry.getText());
        obj_pojo.setQty(qty);
        obj_pojo.setItem_code(item_code);

        ObservableList table_list = FXCollections.observableArrayList();
        QueryFunctions obj = new QueryFunctions();
        ArrayList<PojoClass.pojo> list = obj.select_All();
        table_list.addAll(list);
        table_data.setItems(table_list);

        itemname_Table.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        rate_Table.setCellValueFactory(new PropertyValueFactory<>("item_rate"));
        qty_Table.setCellValueFactory(new PropertyValueFactory<>("qty"));
        netvalue_Table.setCellValueFactory(new PropertyValueFactory<>("net_value"));
        discount_Table.setCellValueFactory(new PropertyValueFactory<>("discount"));
        discamount_Table.setCellValueFactory(new PropertyValueFactory<>("disc_amount"));
        gst_Table.setCellValueFactory(new PropertyValueFactory<>("gst"));
        gstamount_Table.setCellValueFactory(new PropertyValueFactory<>("gst_amount"));
        itemcode_Table.setCellValueFactory(new PropertyValueFactory<>("item_code"));

    }
    int count_sno = 0;

    public void add1() {

        PojoClass.pojo obj_ojo = new pojo();

        count_sno++;

        obj_ojo.sno_count = count_sno;

        int qty = Integer.parseInt(qty_Entry.getText());
        int item_code = Integer.parseInt(itemid_Entry.getText());
        //obj_ojo.setCus_name(cus_name_Entry.getText());
        //obj_ojo.setCus_mobile(Long.parseLong(mobileno_Entry.getText()));
        String curdate = Login_ScreenController.date;
        obj_ojo.setDate(curdate);
        QueryFunctions obj = new QueryFunctions();
        int id = Integer.parseInt(salseman_Entry.getText());
        obj_ojo.setId(id);
        obj.select_one(obj_ojo);

        obj_ojo.setItem_code(item_code);

        PojoClass.pojo list = obj.select_one_item(obj_ojo);

        obj_ojo.setQty(qty);
        double tot = qty * obj_ojo.getItem_rate();

        temp_amount += tot;
        obj_ojo.setNet_value(tot);
        itemrate_Entry.setText(Double.toString(tot));

        QueryFunctions obj1 = new QueryFunctions();
        obj1.insert(obj_ojo);
        arraylist.add(list);
        table_list.add(list);

        table_data.setItems(table_list);

        itemname_Table.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        rate_Table.setCellValueFactory(new PropertyValueFactory<>("item_rate"));
        qty_Table.setCellValueFactory(new PropertyValueFactory<>("qty"));
        netvalue_Table.setCellValueFactory(new PropertyValueFactory<>("net_value"));
        discount_Table.setCellValueFactory(new PropertyValueFactory<>("discount"));
        discamount_Table.setCellValueFactory(new PropertyValueFactory<>("disc_amount"));
        gst_Table.setCellValueFactory(new PropertyValueFactory<>("gst"));
        gstamount_Table.setCellValueFactory(new PropertyValueFactory<>("gst_amount"));
        itemcode_Table.setCellValueFactory(new PropertyValueFactory<>("item_code"));

        Total_Amount_Label.setText(Double.toString(temp_amount) + "0Rs");

        //PojoClass.pojo obj_pojo = new pojo();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        qty_Entry.requestFocus();

    }

    @FXML
    private void ENTER(KeyEvent event) {
        PojoClass.pojo obj_pojo = new pojo();
        QueryFunctions obj = new QueryFunctions();

        if (event.getCode().toString().equals("ENTER")) {

            int id = Integer.parseInt(salseman_Entry.getText());
            obj_pojo.setId(id);
            PojoClass.pojo obj_pojo2 = obj.select_one(obj_pojo);

            Salseman_Name_Show_Label.setText(obj_pojo2.getSalse_man_name());
            salseman_Entry.getScene().lookup("#qty_Entry").requestFocus();

        }

    }

    @FXML
    private void ENTER1(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            qty_Entry.getScene().lookup("#itemid_Entry").requestFocus();

        }

    }

    @FXML
    private void ENTER2(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            itemid_Entry.getScene().lookup("#qty_Entry").requestFocus();
            add1();

        }

    }

    @FXML
    private void SPACE(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.SPACE) {

            ObservableList<PojoClass.pojo> list = table_data.getItems();
            list.removeAll(list);

            salseman_Entry.setText("");
            qty_Entry.setText("");
            itemid_Entry.setText("");
            Salseman_Name_Show_Label.setText("");
            Total_Amount_Label.setText("0.00Rs");
            QueryFunctions obj = new QueryFunctions();
            obj.truncate();
            temp_amount = 0;

            qty_Entry.getScene().lookup("#salseman_Entry").requestFocus();
            itemrate_Entry.clear();
            count_sno = 0;
//            for (PojoClass.pojo i : arraylist) {
//                System.out.println(i.getSalse_man_name() + " " + i.getQty() + " " + i.getItem_code() + " " + i.getNet_value());
//            }

            Parent root = FXMLLoader.load(getClass().getResource("Bill_Screen.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void Add_button(ActionEvent event) {
        add1();
    }

    @FXML
    private void Print_Button(ActionEvent event) {

    }

    @FXML
    private void Save_Button(ActionEvent event) {

        ObservableList<PojoClass.pojo> list = table_data.getItems();
        list.removeAll(list);

        salseman_Entry.setText("");
        qty_Entry.setText("");
        itemid_Entry.setText("");
        Salseman_Name_Show_Label.setText("");
        Total_Amount_Label.setText("0.00Rs");
        QueryFunctions obj = new QueryFunctions();
        obj.truncate();
        temp_amount = 0;

        /*if (obj_pojo != null) {
  
         ObservableList<PojoClass.pojo> list = table_data.getItems();
         list.removeAll(obj_pojo);
         }*/
    }

    @FXML
    private void Clear_Button(ActionEvent event) {

    }

    @FXML
    private void Total_Button(ActionEvent event) throws IOException {

        count_file += 1;

        String baseDir = "C:\\Users\\KL RAHUL\\OneDrive\\Documents\\NetBeansProjects\\MyBillSoftware\\src\\MyBill";
        File directory = new File(baseDir);

        // Ensure the directory exists
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + baseDir);
            } else {
                System.err.println("Failed to create directory: " + baseDir);
                return;
            }
        }

        String location = baseDir + "\\billno_" + count_file + ".txt";
        File file = new File(location);

        try {
            if (file.createNewFile()) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("-----------------------------\n");
                    writer.write("--------Bill Software--------\n");
                    writer.write("Name          :  Rahul       \n");
                    writer.write("Mobile no     :  8754859090  \n");
                    writer.write("-----------------------------\n");
                    writer.write("Products       Qty       Rate\n");
                    writer.write("-----------------------------\n");
                    writer.write("Milk Bread     1         40Rs\n");
                    writer.write("Tea            1         15Rs\n");
                    writer.write("Coffee         1         20Rs\n");
                    writer.write("-----------------------------\n");
                    writer.write("              Total   :  75Rs\n");
                    writer.write("-----------------------------");
                }
                System.out.println("File created successfully: " + location);
            } else {
                System.err.println("File already exists: " + location);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating or writing to the file.");
            e.printStackTrace();
        }

    }

    @FXML
    private void menu_new_button(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("firstscreen.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menu_open_button(ActionEvent event) throws IOException {
        /*Parent root = FXMLLoader.load(getClass().getResource("ChartScreen.fxml"));
         Stage stage = new Stage();
         Scene scene = new Scene(root);

         stage.setScene(scene);
         stage.show();*/
    }

    @FXML
    private void menu_delete_button(ActionEvent event) {
        System.out.println("your clicked menu delete button.");

        PojoClass.pojo obj = table_data.getSelectionModel().getSelectedItem();

        if (obj != null) {

            ObservableList<PojoClass.pojo> list = table_data.getItems();
            list.removeAll(obj);
        }
    }

    @FXML
    private void salse_man_menu(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("salse_man_screen.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void chart_details(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ChartScreen.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void products_menu_button(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("products_screen.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Report_Button(ActionEvent event) throws IOException {
        //LocalDate c_date = date_Entry.getValue();
        //date = c_date.toString();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("report_section.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

}
