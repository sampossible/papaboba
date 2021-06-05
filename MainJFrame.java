/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.sql.*;
import java.awt.Color;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author ajiaa
 */
public class MainJFrame extends javax.swing.JFrame {

    private static String dbURL = "jdbc:derby://localhost:1527//finalC;user=test;password=test";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ArrayList<Order> masterOrders;
    private static ArrayList<Order> curOrders;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        connect();
        masterOrders = getMasterOrders();
        readMasterOrders(masterOrders);
    }

    private static void connect() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e){
            System.out.println("No jdbc driver");
            e.printStackTrace();
        }
        try{
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception e){
            System.out.println("Connection error");
        }
        try {
            stmt = conn.createStatement();
        } catch (Exception e){
            System.out.println("Statement error");
        }
    }

    private static void disconnect(){
       try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Shutdown error");
        }
    }

    private static ArrayList<Order> getMasterOrders(){
        ArrayList<Order> record = new ArrayList<>();
        try {
            String query = "SELECT * FROM TEST.NCP";
            Statement st = (Statement) conn.createStatement();
            try (ResultSet rs = st.executeQuery(query)){
                while (rs.next()) {
                    Order c = new Order();
                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    c.setCloser(rs.getBoolean("closer"));
                    c.setSmall(rs.getBoolean("size"));
                    c.setLarge(!Boolean.valueOf(c.small));
                    c.setFlavor(rs.getString("tea"));
                    c.setSweet(rs.getInt("sugar"));
                    c.setIce(rs.getInt("ice"));
                    c.setAdd(rs.getString("adds"));
                    record.add(c);
                }
            } catch (SQLException e) {
                System.out.println("Retrival error");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Connection error");
        }
        return record;
    }

    public void readMasterOrders(ArrayList<Order> s){
        for (int i = 0; i < s.size(); i++) {
            String fin = String.valueOf(s.get(i).id) + " "
                    + s.get(i).name + " " 
                    + String.valueOf(s.get(i).closer) + " "
                    + String.valueOf(s.get(i).small) + " "
                    + String.valueOf(s.get(i).large) + " "
                    + s.get(i).flavor + " "
                    + String.valueOf(s.get(i).sweet) + " "
                    + String.valueOf(s.get(i).ice) + " "
                    + s.get(i).add;
            System.out.println(fin);
        }
    }

    private static void getRanOrder(){
        Random r = new Random();
        int n = r.nextInt(masterOrders.size());
        System.out.println(n);
        Order chosen = new Order();
        chosen.setId(masterOrders.get(n).id);
        chosen.setName(masterOrders.get(n).name);
        chosen.setCloser(masterOrders.get(n).closer);
        chosen.setSmall(masterOrders.get(n).small);
        chosen.setLarge(masterOrders.get(n).large);
        chosen.setFlavor(masterOrders.get(n).flavor);
        chosen.setSweet(masterOrders.get(n).sweet);
        chosen.setIce(masterOrders.get(n).ice);
        chosen.setAdd(masterOrders.get(n).add);
        printOrder(chosen);
        ArrayList<Order> temp = new ArrayList();
        temp.add(chosen);
        curOrders = temp;
   }

    private static void removeOrder(int n){
        curOrders.remove(n);
    }

    private static void getSpecOrder(int n){
        Order chosen = new Order();
        chosen.setId(masterOrders.get(n).id);
        chosen.setName(masterOrders.get(n).name);
        chosen.setCloser(masterOrders.get(n).closer);
        chosen.setSmall(masterOrders.get(n).small);
        chosen.setLarge(masterOrders.get(n).large);
        chosen.setFlavor(masterOrders.get(n).flavor);
        chosen.setSweet(masterOrders.get(n).sweet);
        chosen.setIce(masterOrders.get(n).ice);
        chosen.setAdd(masterOrders.get(n).add);
        printOrder(chosen);
        curOrders.add(chosen);
   }

    private static void printOrder(Order x){
        String fin = String.valueOf(x.id) + " "
                    + x.name + " " 
                    + String.valueOf(x.closer) + " "
                    + String.valueOf(x.small) + " "
                    + String.valueOf(x.large) + " "
                    + x.flavor + " "
                    + String.valueOf(x.sweet) + " "
                    + String.valueOf(x.ice) + " "
                    + x.add;
            System.out.println(fin);
    }

    private static int evaluateOrder(Order x) {
        int fin = 100;
        
        if (x.closer == true) {
            if (largeCup && (x.large = true)){
            } else {
                fin -= 10;
            }
            if (smallCup && (x.small = true)){
            } else {
                fin -= 10;
            }
            if (flavor != x.flavor){
                fin -= 20;
            }
            if (fill != 90){
                fin -= 20;
            }
            if (sweetness != x.sweet){
                fin -= 10;
            }
            if (top != x.add){
                fin -=15;
            }
        } else {
            if (largeCup && (x.large = true)){
                
            } else {
                fin -= 10;
            }
            if (smallCup && (x.small = true)){
                
            } else {
                fin -= 10;
            }
            if (flavor != x.flavor){
                fin -= 20;
            }
            if (fill != 90){
                fin -= 20;
            }
            if (sweetness != x.sweet){
                fin -= 10;
            }
            if (top != x.add){
                fin -=15;
            }
            fin += 25;
        }
        return fin;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        forwardBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        orderNumField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        smallCheckBox = new javax.swing.JCheckBox();
        largeCheckBox = new javax.swing.JCheckBox();
        flavorField = new javax.swing.JTextField();
        iceField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sweetField = new javax.swing.JTextField();
        addField = new javax.swing.JTextField();
        orderBtn = new javax.swing.JButton();
        finBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("<");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        forwardBtn.setText(">");
        forwardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forwardBtnMouseClicked(evt);
            }
        });

        jLabel1.setText("Order #");

        orderNumField.setText("0");
        orderNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderNumFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        nameField.setText("______");

        smallCheckBox.setText("Small");

        largeCheckBox.setText("Large");

        flavorField.setText("Flavor");

        iceField.setText("___");

        jLabel3.setText("Ice Level");

        jLabel4.setText("Sweetness");

        sweetField.setText("___");

        addField.setText("Add on");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(forwardBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(orderNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(addField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(smallCheckBox)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(largeCheckBox, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sweetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(flavorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(orderNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smallCheckBox)
                    .addComponent(largeCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(flavorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sweetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(addField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forwardBtn)
                    .addComponent(backBtn)))
        );

        orderBtn.setText("Take Order");
        orderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderBtnMouseClicked(evt);
            }
        });

        finBtn.setText("Finish Order");
        finBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderBtn)
                    .addComponent(finBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(orderBtn)
                        .addGap(47, 47, 47)
                        .addComponent(finBtn)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void forwardBtnMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        System.out.println("Registered next order button clicked");
        if (curOrders != null || curOrders.size() == Integer.valueOf(orderNumField.getText())) {
            int num = Integer.valueOf(orderNumField.getText());
            Order temp = curOrders.get(num);
            num ++;
            System.out.println(num);
            
            orderNumField.setText(String.valueOf(num));
            nameField.setText(temp.name);
            smallCheckBox.setSelected(temp.small);
            largeCheckBox.setSelected(temp.large);
            flavorField.setText(temp.flavor);
            iceField.setText(String.valueOf(temp.ice));
            sweetField.setText(String.valueOf(temp.sweet));
            addField.setText(temp.add);
        } else {
            System.out.println("No orders to be fulfilled");
        }

    }                                       

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        System.out.println("Registered previous order button clicked");
        if (curOrders != null || Integer.valueOf(orderNumField.getText()) == 1) {
            int num = Integer.valueOf(orderNumField.getText());
            Order temp = curOrders.get(num);
            num --;
            System.out.println(num);
            orderNumField.setText(String.valueOf(num));
            nameField.setText(temp.name);
            smallCheckBox.setEnabled(temp.small);
            largeCheckBox.setEnabled(temp.large);
            flavorField.setText(temp.flavor);
            iceField.setText(String.valueOf(temp.ice));
            sweetField.setText(String.valueOf(temp.sweet));
            addField.setText(temp.add);
        } else {
            System.out.println("No orders to be fulfilled");
        }
    }                                    

    private void orderBtnMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        System.out.println("Registered get order button clicked");
        getRanOrder();
    }                                     

    private void finBtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        System.out.println("Registered finish order button clicked");
        int n = Integer.valueOf(orderNumField.getText());
        Order chosen = new Order();
        chosen.setId(curOrders.get(n).id);
        chosen.setName(curOrders.get(n).name);
        chosen.setCloser(curOrders.get(n).closer);
        chosen.setSmall(curOrders.get(n).small);
        chosen.setLarge(curOrders.get(n).large);
        chosen.setFlavor(curOrders.get(n).flavor);
        chosen.setSweet(curOrders.get(n).sweet);
        chosen.setIce(curOrders.get(n).ice);
        chosen.setAdd(curOrders.get(n).add);
        removeOrder(n);
        System.out.println(evaluateOrder(chosen));
    }                                   

    private void orderNumFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    // Variables declaration - do not modify                     
    private javax.swing.JTextField addField;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton finBtn;
    private javax.swing.JTextField flavorField;
    private javax.swing.JButton forwardBtn;
    private javax.swing.JTextField iceField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox largeCheckBox;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton orderBtn;
    private javax.swing.JTextField orderNumField;
    private javax.swing.JCheckBox smallCheckBox;
    private javax.swing.JTextField sweetField;
    // End of variables declaration                   
}
