package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.*;

public class Controller {
    @FXML
    TextField Text1;
    @FXML
    TextField Text2;
    @FXML
    public void exit(ActionEvent e){
        System.exit(0);
    }
    @FXML
    public void id(MouseEvent e) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
        Statement stmt = con.createStatement();
        ResultSet rs;
        String q = "select max(StudentID) from student;";
        rs=stmt.executeQuery(q);
        while(rs.next()) {
            int i = rs.getInt("max(StudentID)")+1;
            Text1.setText(""+i);
        }
    }
    @FXML
    public void insert(ActionEvent e) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
        Statement stmt = con.createStatement();
        int i = Integer.parseInt(Text1.getText());
        String a = Text2.getText();
        String q = "insert into student values("+i+",'"+a+"');";
        stmt.executeUpdate(q);
        Text1.setText("");
        Text2.setText("");
    }
}



