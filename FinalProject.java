/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.awt.*;
/**
 *
 * @author ajiaa
 */
public class FinalProject {

    private static String dbURL = "jdbc:derby://localhost:1527/papa [username on USERNAME]";
    private static Connection conn = null;
    private static Statement stmt = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainJFrame main = new MainJFrame();
        main.setVisible(true);
    }
    
}
