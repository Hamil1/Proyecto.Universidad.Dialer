/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.*;
import model.model;

/**
 *
 * @author hamil
 */
public class CallScreen extends javax.swing.JFrame {

    /**
     * Creates new form CallScreen
     */
        // Instancias
        Date hora = new Date();
        
    
    // Variables e instancias
        Login login = new Login();
        private Timer cronometro;
	int seg,hor,min, random;
	boolean[] press = new boolean[5];
	int[] botones = new int[3];
        Random randomGenerator = new Random();
//        disposalScreenn ds = new disposalScreenn();
        disposalScreen dn = new disposalScreen(this, true);
        int conteo = 0;
        ArrayList<String> nombresDB = new ArrayList<String>();
        ArrayList<String> apellidosDB = new ArrayList<String>();
        ArrayList<String> telefono1DB = new ArrayList<String>();
        ArrayList<String> telefono2DB = new ArrayList<String>();
        ArrayList<String> telefono3DB = new ArrayList<String>();
        ArrayList<String> cedulaDB = new ArrayList<String>();
        Iterator iterNombre, iterApellido, iterTelefono1, iterTelefono2, iterTelefono3, iterCedula;
        //Variables para insertarlas en la tabla de CallBacks (cuando se desee guardan un Call Back)
        public static String nombreStr = null, apellidoStr = null, telefono1Str = null, telefono2Str = null, telefono3Str = null, descriptionStr = null, anotacionesStr = null, cedulaStr = null;
        public model modelo;
        boolean root = false;
        
    
    public CallScreen() {
        Date hora = new Date();
//        this.setUndecorated(false);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        //setSize(ancho / 2, alto / 2);
        initComponents();
        usuarioLabel.setText(login.nameUser);
        String where = "";
            

//        Pantalla completa
//        this.setSize(xsize, ysize);
 //       disposalScreen ds = new disposalScreen(this, true);
          
          modelo = new model();
          //Esta variable es para hacer que solo entre cuando ya se hayan traido los registros de la base de datos y no de indefinido
          int f = 0;  
            try {
                root = modelo.isRoot(login.nameUser);
                if(!root){
                    reportes.setEnabled(false);
                    manageClient.setEnabled(false);
                    verUsuarios.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CallScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        //Obtener registros
        try {
                
                ResultSet rs = modelo.selectAllClients(true,true,true,true,true,true,true,true,true,true,where);
                int i = 0;
                
                while(rs.next()){
                nombresDB.add(rs.getString("nombre"));
                apellidosDB.add(rs.getString("apellido"));
                telefono1DB.add(rs.getString("telefono1"));
                telefono2DB.add(rs.getString("telefono2"));
                telefono3DB.add(rs.getString("telefono3"));
                cedulaDB.add(rs.getString("cedula"));
                f++;
                }
                modelo.closeConnection();
                
            } catch (SQLException ex) {
                Logger.getLogger(CallScreen.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane optionPane = new JOptionPane("Error! Llamar al administrador.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error!");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
                if(f > 0){
                    iterNombre = nombresDB.iterator();
                iterApellido = apellidosDB.iterator();
                iterTelefono1 = telefono1DB.iterator();
                iterTelefono2 = telefono2DB.iterator();
                iterTelefono3 = telefono3DB.iterator();
                iterCedula = cedulaDB.iterator();
                nombre.setText((String) iterNombre.next());
                apellido.setText((String) iterApellido.next());
                phone1.setText((String) iterTelefono1.next());
                phone2.setText((String) iterTelefono2.next());
                phone3.setText((String) iterTelefono3.next());
                cedula.setText((String) iterCedula.next());
                }
                
                
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        recordindfile = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        recordid = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        reportes = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        phone2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        phone1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        phone3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        anotaciones = new javax.swing.JTextArea();
        viewCallBacks = new javax.swing.JButton();
        manageClient = new javax.swing.JButton();
        Current_time_hour = new javax.swing.JLabel();
        Current_time_min = new javax.swing.JLabel();
        Current_time_seg = new javax.swing.JLabel();
        Channel_of_call = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Current_time_hours = new javax.swing.JLabel();
        Current_time_mins = new javax.swing.JLabel();
        Current_time_segs = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addCallBack = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        usuarioLabel = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        verUsuarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 3, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dialer-icon.png"))); // NOI18N
        jLabel1.setText("ViciDial");

        jLabel2.setText("CUSTORMER TIME:");

        jLabel5.setText("CHANNEL:");

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel6.setText("STATUS: ");

        status.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        status.setText(".");

        jRadioButton1.setText("ALT PHONE DIAL");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("LOGGED IN AS USER:");

        jLabel10.setText("RECORD ID:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/microphone.png"))); // NOI18N
        jButton1.setText("GRABAR LLAMADA");
        jButton1.setToolTipText("GRABAR LLAMADA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/solicitud.png"))); // NOI18N
        jButton2.setText("SOLICITUD");
        jButton2.setToolTipText("SOLICITAR CREDITO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reportes.png"))); // NOI18N
        reportes.setText("REPORTES");
        reportes.setToolTipText("REPORTES");
        reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton4.setText("DATA CREDITO");
        jButton4.setToolTipText("DATA CREDITO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/phone-call.png"))); // NOI18N
        jButton5.setText("CERRAR LLAMADA");
        jButton5.setToolTipText("CERRAR LLAMADA");
        jButton5.setName("hang"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setText("DIALER desktop version 1.0 by Hamil");

        jLabel13.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel13.setText("CUSTORMER INFORMATION");

        jLabel14.setText("FIRST NAME:");

        jLabel15.setText("LAST NAME:");

        jButton7.setText("SECOND PHONE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("MAIN PHONE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("THIRD PHONE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        anotaciones.setColumns(20);
        anotaciones.setRows(5);
        jScrollPane1.setViewportView(anotaciones);

        viewCallBacks.setText("VIEW CALLBACKS");
        viewCallBacks.setBorder(null);
        viewCallBacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCallBacksActionPerformed(evt);
            }
        });

        manageClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manage_clients.png"))); // NOI18N
        manageClient.setText("VER CLIENTES");
        manageClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageClientActionPerformed(evt);
            }
        });

        Current_time_hour.setName("Current_time_hour"); // NOI18N

        Timer.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N

        jLabel16.setText("TIME:");

        Current_time_hours.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N

        Current_time_mins.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N

        Current_time_segs.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N

        jLabel3.setText(":");

        jLabel4.setText(":");

        addCallBack.setText("ADD CALLBACK");
        addCallBack.setBorder(null);
        addCallBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCallBackActionPerformed(evt);
            }
        });

        jButton6.setText("Siguiente >");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        usuarioLabel.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        usuarioLabel.setText("usuario");
        usuarioLabel.setName("usuarioLabel"); // NOI18N

        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });

        verUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        verUsuarios.setText("VER USUARIOS");
        verUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(487, 487, 487))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addCallBack, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addComponent(viewCallBacks, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Current_time_hours)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Current_time_hour))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Current_time_mins)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Current_time_segs)
                .addGap(34, 34, 34)
                .addComponent(Current_time_min)
                .addGap(25, 25, 25)
                .addComponent(Current_time_seg)
                .addGap(260, 260, 260)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Channel_of_call)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(recordindfile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(recordid))
                            .addComponent(reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status)
                                .addGap(429, 429, 429)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(verUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(manageClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(236, 236, 236)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Timer, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(417, 417, 417)
                                        .addComponent(jButton7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(387, 387, 387)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cedula)
                                            .addComponent(phone2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))))))
                        .addGap(282, 282, 282))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(297, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(phone3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(253, 253, 253))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(phone1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9)
                                .addGap(296, 296, 296))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(123, 123, 123))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Channel_of_call)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(Current_time_hour)
                        .addComponent(Current_time_min)
                        .addComponent(Current_time_seg)
                        .addComponent(Current_time_hours)
                        .addComponent(Current_time_mins)
                        .addComponent(Current_time_segs)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(status)
                    .addComponent(jLabel13))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(recordindfile)
                            .addComponent(usuarioLabel))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(recordid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(phone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(Timer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(21, 21, 21)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(reportes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phone1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jButton8)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(129, 129, 129)
                        .addComponent(jButton9)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(manageClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewCallBacks, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCallBack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.setBackground(Color.LIGHT_GRAY);
        activeButtons();
        cronometro.stop();
        status.setText("PAUSED");
        dn.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
    
    public class tiempo implements ActionListener
	{
        @Override
    	public void actionPerformed(ActionEvent e) {
        	GregorianCalendar calendario = new GregorianCalendar();
        	int seg1 = calendario.get(Calendar.SECOND),min1 = calendario.get(Calendar.MINUTE), hor1 = calendario.get(Calendar.HOUR_OF_DAY);
       	 

       	 
            	seg++;
            	if(min == 60)
            	{
                	hor++;
                	min = 0;
            	}
            	else
            	{
                	if(seg == 60)
                	{
                    	min++;
                    	seg=0;
                   	}
            	}
                
                Timer.setText("   	"+hor+":"+min+":"+seg);
        	Current_time_hours.setText(String.valueOf(hor1));
                Current_time_mins.setText(String.valueOf(min1));
                Current_time_segs.setText(String.valueOf(seg1));
                
                }
    }
    
    public int randomNumbers(int max, int min){
        int randomInt = (max - min) + min;
        randomInt = (int) (Math.random() * randomInt) + min;
        return randomInt;
    }
    
    public void voipChannel(int max, int min){
        
        int randomInt = randomNumbers(max, min);
        switch (randomInt) {
            case 1:
                Channel_of_call.setText("CLARO-DOMINICAN-PRIVILEGE");
                break;
            case 2:
                Channel_of_call.setText("ORANGE-DOMINICAN-PRIVILEGE");
                break;
            case 3:
                Channel_of_call.setText("VIVA-DOMINICAN-PRIVILEGE");
                break;
        }
    }
    
    public void randomFileAndId(){
        int[] randomInt = new int[2];
        randomInt[0] = randomNumbers(1000, 1);
        randomInt[1] = randomNumbers(10000, 1);
        status.setText("ACTIVE");
//        recordindfile.setText(String.valueOf(randomInt[0]));
        recordid.setText(String.valueOf(randomInt[1]));
    }
    
    public void disableButtons(){
        jButton8.setEnabled(false);
        jButton7.setEnabled(false);
        jButton9.setEnabled(false);
        manageClient.setEnabled(false);
        addCallBack.setEnabled(false);
        viewCallBacks.setEnabled(false);
        reportes.setEnabled(false);
    }
    
    public void activeButtons(){
        jButton8.setEnabled(true);
        jButton7.setEnabled(true);
        jButton9.setEnabled(true);
        if(root){manageClient.setEnabled(true);}
        addCallBack.setEnabled(true);
        viewCallBacks.setEnabled(true);
        if(root){reportes.setEnabled(true);}
    }
    
    public void resetTimer(){
        hor = 0;
        min =0;
        seg =0;
        Timer.setText("   	"+hor+":"+min+":"+seg);
    }
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cronometro = new Timer(1000, new tiempo());
        jButton5.setBackground(Color.red);
        resetTimer();
        voipChannel(3, 1);
        randomFileAndId();
        disableButtons();
        cronometro.start();
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cronometro = new Timer(1000, new tiempo());
        jButton5.setBackground(Color.red);
        resetTimer();
        voipChannel(3, 1);
        randomFileAndId();
        disableButtons();
        cronometro.start();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        cronometro = new Timer(1000, new tiempo());
        jButton5.setBackground(Color.red);
        resetTimer();
        voipChannel(3, 1);
        randomFileAndId();
        disableButtons();
        cronometro.start();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void manageClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageClientActionPerformed
        manageClients ms = new manageClients(this, true);
        ms.setVisible(true);
    }//GEN-LAST:event_manageClientActionPerformed

    private void addCallBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCallBackActionPerformed
        nombreStr = nombre.getText();
        apellidoStr = apellido.getText();
        telefono1Str = phone1.getText();
        telefono2Str = phone2.getText();
        telefono3Str = phone3.getText();
        anotacionesStr = anotaciones.getText();
        cedulaStr = cedula.getText();
        addCallBack addc = new addCallBack(this, true);
        addc.setVisible(true);
    }//GEN-LAST:event_addCallBackActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
        nombre.setText((String) iterNombre.next());
        apellido.setText((String) iterApellido.next());
        phone1.setText((String) iterTelefono1.next());
        phone2.setText((String) iterTelefono2.next());
        phone3.setText((String) iterTelefono3.next());
        cedula.setText((String) iterCedula.next());
        anotaciones.setText("");
        } catch (Exception e) {
            JOptionPane optionPane = new JOptionPane("Usted no dispone de más clientes (Hablar con su supervisor, ra).", JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog(this,"No hay clientes.");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            dialog.setAlwaysOnTop(true);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void viewCallBacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCallBacksActionPerformed
        manageCallBack cb = new manageCallBack(this, true);
        cb.setVisible(true);
    }//GEN-LAST:event_viewCallBacksActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cedulaStr = cedula.getText();
        datacredito dt = new datacredito(this,true);
        dt.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        chooseReport cr = new chooseReport(this, true);
        cr.setVisible(true);
    }//GEN-LAST:event_reportesActionPerformed

    private void verUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verUsuariosActionPerformed
        manageUsers mu = new manageUsers(this, true);
        mu.setVisible(true);
    }//GEN-LAST:event_verUsuariosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CallScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CallScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CallScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CallScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CallScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Channel_of_call;
    private javax.swing.JLabel Current_time_hour;
    private javax.swing.JLabel Current_time_hours;
    private javax.swing.JLabel Current_time_min;
    private javax.swing.JLabel Current_time_mins;
    private javax.swing.JLabel Current_time_seg;
    private javax.swing.JLabel Current_time_segs;
    private javax.swing.JLabel Timer;
    private javax.swing.JButton addCallBack;
    public static javax.swing.JTextArea anotaciones;
    public static javax.swing.JTextField apellido;
    public static javax.swing.JTextField cedula;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageClient;
    public static javax.swing.JTextField nombre;
    public static javax.swing.JTextField phone1;
    public static javax.swing.JTextField phone2;
    public static javax.swing.JTextField phone3;
    private javax.swing.JLabel recordid;
    private javax.swing.JLabel recordindfile;
    private javax.swing.JButton reportes;
    private javax.swing.JLabel status;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JButton verUsuarios;
    private javax.swing.JButton viewCallBacks;
    // End of variables declaration//GEN-END:variables
}
