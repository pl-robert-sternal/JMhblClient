package com.rstenal.mhbl.jmhblclient.gui;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
        
        scpBloodPressure.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scpBloodPressure.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panBloodPressuresGridSplitPanel = new javax.swing.JSplitPane();
        panLoginPanel = new javax.swing.JPanel();
        lblServiceUrl = new javax.swing.JLabel();
        txtServiceUrl = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        panBloodPressuresGridPanel = new javax.swing.JPanel();
        scpBloodPressure = new javax.swing.JScrollPane();
        tblBloodPressure = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mnuGetDataBloodPressures = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panBloodPressuresGridSplitPanel.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        panBloodPressuresGridSplitPanel.setOneTouchExpandable(true);

        panLoginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Login data"));

        lblServiceUrl.setText("Service URL");

        txtServiceUrl.setText("https://stately-forest-830.appspot.com/mhbl/measure");
        txtServiceUrl.addActionListener(evt -> txtServiceUrlActionPerformed(evt));

        lblUserName.setText("User name");

        txtLogin.setText("demo@mhbl.pl");

        txtPassword.setText("demo123");

        lblPassword.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panLoginPanel);
        panLoginPanel.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblServiceUrl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServiceUrl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServiceUrl)
                    .addComponent(txtServiceUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addContainerGap())
        );

        panBloodPressuresGridSplitPanel.setTopComponent(panLoginPanel);

        tblBloodPressure.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scpBloodPressure.setViewportView(tblBloodPressure);

        javax.swing.GroupLayout layBloodPressuresPanelLayout = new javax.swing.GroupLayout(panBloodPressuresGridPanel);
        panBloodPressuresGridPanel.setLayout(layBloodPressuresPanelLayout);
        layBloodPressuresPanelLayout.setHorizontalGroup(
                layBloodPressuresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scpBloodPressure, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layBloodPressuresPanelLayout.setVerticalGroup(
            layBloodPressuresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layBloodPressuresPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpBloodPressure, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        panBloodPressuresGridSplitPanel.setRightComponent(panBloodPressuresGridPanel);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Data");

        mnuGetDataBloodPressures.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M,
                java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.META_MASK));
        mnuGetDataBloodPressures.setText("Get blood pressures");
        mnuGetDataBloodPressures.addActionListener(MainWindow.this::mnuGetDataBloodPressuresActionPerformed);
        jMenu2.add(mnuGetDataBloodPressures);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBloodPressuresGridSplitPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBloodPressuresGridSplitPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }

    private void mnuGetDataBloodPressuresActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(txtPassword.getPassword());
            BloodPressureTM model = new BloodPressureTM(txtServiceUrl.getText(), txtLogin.getText(),
                    strBuilder.toString());
            tblBloodPressure.setModel(model);
            tblBloodPressure.setRowSorter(new TableRowSorter<>(model));
            TableCellRenderer dateCellRenderer = new DefaultTableCellRenderer() {

                private static final String COMMON_TIME_FORMAT = "MM/dd-yyyy HH:mm";

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                               int row, int column) {
                    SimpleDateFormat sdf = new SimpleDateFormat(COMMON_TIME_FORMAT);
                    if (value instanceof Date) {
                        value = sdf.format((Date) value);
                    }

                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }

            };
            tblBloodPressure.getColumnModel().getColumn(4).setCellRenderer(dateCellRenderer);
        } catch (Exception ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void txtServiceUrlActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private javax.swing.JLabel lblServiceUrl;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel panLoginPanel;
    private javax.swing.JPanel panBloodPressuresGridPanel;
    private javax.swing.JSplitPane panBloodPressuresGridSplitPanel;
    private javax.swing.JMenuItem mnuGetDataBloodPressures;
    private javax.swing.JScrollPane scpBloodPressure;
    private javax.swing.JTable tblBloodPressure;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtServiceUrl;
}
