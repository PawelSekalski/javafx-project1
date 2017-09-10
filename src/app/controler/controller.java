package app.controler;

import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class controller {

    @FXML
    private MenuItem m_save;

    @FXML
    private MenuItem m_close;

    @FXML
    private TextField tf;

    @FXML
    private TextArea ta;

    @FXML
    private Button btn_BC;

    @FXML
    private Button btn_LC;

    @FXML
    private Button btn_EC;
    
    @FXML
    void saveFile(ActionEvent event) throws FileNotFoundException {
    	Frame frame = new Frame();
    	JOptionPane op = new JOptionPane();
    	if(tf.getText().equals("")) {
    		JOptionPane.showMessageDialog(frame, "Podaj nazwê pliku!!");
    	} else {
    	File file = new File("C:\\Users\\PS\\Desktop\\Java-programy\\zapisyZTest\\"+tf.getText()+".txt");
    	PrintWriter pw = new PrintWriter(file);
    	Scanner sc = new Scanner(ta.getText());
    	
    	
    	while (sc.hasNextLine()) {
    		String line = sc.nextLine();
    		pw.println(line);
    	}
    	
    	JOptionPane.showMessageDialog(frame, "You're saved!");
		ta.setText("");
		tf.setText("");
		pw.close();
    	}
    }

    @FXML
    void closeApp(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void upperCase(MouseEvent event) {
    	String text = ta.getText();
    	text = text.toUpperCase();
    	ta.setText(text);
    }

    @FXML
    void loweCase(MouseEvent event) {
    	String text = ta.getText();
    	text = text.toLowerCase();
    	ta.setText(text);
    }
    
    @FXML
    void Clear(MouseEvent event) {
    	ta.setText("");
    }

}

