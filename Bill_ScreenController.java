/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import org.w3c.dom.Node;

/**
 * FXML Controller class
 *
 * @author KL RAHUL
 */
public class Bill_ScreenController implements Initializable {

    @FXML
    private Label bill_head_label;
    @FXML
    private ScrollPane billarea_pane;
    String title = "\t\t\t\t\tKL RAHUL SOFTWARE\n"
            + "-----------------------------------------------------------------------------\n"
            + "\tItems\t\t\t\t\tQty\t\t\t\t\tPrice\n";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<PojoClass.pojo> list = FirstscreenController.arraylist;
        double amount = FirstscreenController.temp_amount;
        Double.toString(amount);
        String amt= "\nTotal";
        list.stream().forEach((i) -> {
            String data = "\t" + i.getItem_name() + "\t\t\t\t\t\t" + i.getQty() + "\t\t\t\t\t " + i.getNet_value() + " \n";
            Label name = new Label(title = title + data);
            billarea_pane.setContent(name);

        });
       
    }

    public void bill() {

    }

    @FXML
    private void OK_Button(ActionEvent event) {

    }

    @FXML
    private void Cancel_Button(ActionEvent event) {
    }

}
