
package Frontend;

import PojoClass.pojo;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login_ScreenController implements Initializable {

    @FXML
    private Label Login_Label;
    @FXML
    private Label User_Label;
    @FXML
    private Label Password_Label;
    @FXML
    private TextField User_Entry;
    @FXML
    private PasswordField Password_Entry;
    @FXML
    private DatePicker date_Entry;
    @FXML
    private Label wrong;
    @FXML
    private Label sucess;
   
    public static String date;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    static Stage stage1;
    @FXML
    private void Submit_Button(ActionEvent event) throws IOException {

        if (date_Entry.getValue() != null) {
            PojoClass.pojo obj_pojo = new pojo();

            date = date_Entry.getValue().toString();
            //System.out.println(date);
            if (User_Entry.getText().equalsIgnoreCase("admin") && Password_Entry.getText().equalsIgnoreCase("admin")) {
                //sucess.setText("Successfully..");
                User_Entry.clear();
                Password_Entry.clear();
                stage1 = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("firstscreen.fxml"));
               
                Scene scene = new Scene(root);
              
                stage1.setScene(scene);
                
               
                stage1.show();
            } else {
                wrong.setText("Wrong user or password!..");
                User_Entry.clear();
                Password_Entry.clear();

            }

        } else {
            System.out.println("No date selected.");
        }

    }

   
}