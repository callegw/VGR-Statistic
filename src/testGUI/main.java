package testGUI;

import java.awt.BorderLayout;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/*
 * Calle Gosch-Wåhlander, Simon Peste, Andreas Skoglund.
 * Grupp G.
 * TIG063.
 * Göteborgs universitet VT-13.
 */

public class main extends javax.swing.JFrame {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public main() {
        initComponents();
        panelHome.setVisible(false);
    }


    /*
     * Metod som fyller listan med kommuner efter att man valt region
     * Just nu dock hårdkodad till VGR då vi inte fyllt andra regioner med deras
     * kommuner. 
     */
    public void fillListMuni(String inData) {
        DefaultListModel dlm = new DefaultListModel();
        try {
            String host = "jdbc:mysql://vm-06.ituniv.chalmers.se:3306/tig063g";
            String uName = "";
            String uPass = "";
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String sql = "select distinct Municipality "
                    + "from Location where Region = '" + inData + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dlm.addElement(rs.getString("Municipality"));
            }
            kommunlistan.setModel(dlm);
            rs.close();
            con.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }

    /*
     * Metod som fyller listan med sjukhus/vårdcentral efter att man valt kommun 
     */
    public void fillListHosp(String in) {

        DefaultListModel dlm = new DefaultListModel();
        try {
            String host = "jdbc:mysql://vm-06.ituniv.chalmers.se:3306/tig063g";
            String uName = "";
            String uPass = "";
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String sql = "select distinct HospitalName from "
                    + "Location where Municipality = '" + in + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dlm.addElement(rs.getString("HospitalName"));

            }
            sjukhusListan.setModel(dlm);
            rs.close();
            con.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }
    /*
     * Metod som fyller listan med utrustning efter att man valt sjukhus/vc
     */

    public void fillListEq(String in) {

        DefaultListModel dlm = new DefaultListModel();
        try {
            String host = "jdbc:mysql://vm-06.ituniv.chalmers.se:3306/tig063g";
            String uName = "";
            String uPass = "";
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String sql = "select Equipment.name from Equipment, Location "
                    + "where Equipment.LID = Location.LID "
                    + "and Location.HospitalName = '" + in + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dlm.addElement(rs.getString("Name"));
            }
            utrustningsListan.setModel(dlm);
            rs.close();
            con.close();
            stmt.close();


        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        panelLogin = new javax.swing.JPanel();
        anvandarnamnField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        anvandarnamnLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        inloggButton = new javax.swing.JButton();
        vgrLogo = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        welcometextLabel = new javax.swing.JLabel();
        homePanel = new javax.swing.JPanel();
        vansterPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        LabelName = new javax.swing.JLabel();
        LabelCost = new javax.swing.JLabel();
        LabelUse = new javax.swing.JLabel();
        LabelSupplier = new javax.swing.JLabel();
        LabelAge = new javax.swing.JLabel();
        LabelExpektedEND = new javax.swing.JLabel();
        laggtillButton = new javax.swing.JButton();
        anvandingButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        Labelcomparison1 = new javax.swing.JTextArea();
        undersokningsButton = new javax.swing.JButton();
        jamforelseDataButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        hogerPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        databasList = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kommunlistan = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        sjukhusListan = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        utrustningsListan = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jamforelseDataPanel = new javax.swing.JPanel();
        jamPanel1 = new javax.swing.JPanel();
        jamPanel2 = new javax.swing.JPanel();
        mittScroll = new javax.swing.JScrollPane();
        mittenPanel = new javax.swing.JPanel();
        GrafPanel1 = new javax.swing.JPanel();
        GrafPanel2 = new javax.swing.JPanel();
        GrafPanel3 = new javax.swing.JPanel();
        panelUtlogg = new javax.swing.JPanel();
        namnLabel = new javax.swing.JLabel();
        utloggButton = new javax.swing.JButton();
        systemnamnLabel = new javax.swing.JLabel();
        installningButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        hemButton = new javax.swing.JButton();
        installningsPanel = new javax.swing.JPanel();
        startsidePanel = new javax.swing.JPanel();
        lanPanel = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        lanButton = new javax.swing.JButton();
        kommunButton = new javax.swing.JButton();
        orgButton = new javax.swing.JButton();
        maskButton = new javax.swing.JButton();
        granssnittPanel = new javax.swing.JPanel();
        fargblindCheckbox = new javax.swing.JCheckBox();
        textstorlekCombobox = new javax.swing.JComboBox();
        startsidaLabel = new javax.swing.JLabel();
        filhanteringsLabel = new javax.swing.JLabel();
        granssnittLabel = new javax.swing.JLabel();
        installningsLabel = new javax.swing.JLabel();
        instOkButton = new javax.swing.JButton();
        instAvButton = new javax.swing.JButton();
        instDefButton = new javax.swing.JButton();
        filPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pdfTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jpgTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textTextField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VGR Statistics");
        setName("backFrame"); // NOI18N

        panelLogin.setPreferredSize(new java.awt.Dimension(1024, 800));

        anvandarnamnLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        anvandarnamnLabel.setText("Användarnamn: ");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordLabel.setText("Lösenord: ");

        inloggButton.setText("Logga in");
        inloggButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inloggButtonActionPerformed(evt);
            }
        });

        vgrLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testGUI/vg_logo.jpg"))); // NOI18N

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inloggButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vgrLogo)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(anvandarnamnField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anvandarnamnLabel))
                        .addGap(18, 18, 18)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(385, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(vgrLogo)
                .addGap(28, 28, 28)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(anvandarnamnLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anvandarnamnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(passwordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(inloggButton)
                .addContainerGap(545, Short.MAX_VALUE))
        );

        welcometextLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        welcometextLabel.setText("VGR Statistics");

        homePanel.setPreferredSize(new java.awt.Dimension(1024, 800));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Information");

        jLabel8.setText("Namn:");

        jLabel10.setText("Kostnad:");

        jLabel11.setText("Användning/år:");

        jLabel12.setText("Leverantör:");

        jLabel13.setText("Ålder:");

        jLabel14.setText("Förväntad avslut:");

        LabelName.setText("Inget Valt");

        LabelCost.setText("Inget Valt");

        LabelUse.setText("Inget Valt");

        LabelSupplier.setText("Inget Valt");

        LabelAge.setText("Inget Valt");

        LabelExpektedEND.setText("Inget Valt");

        laggtillButton.setText("Lägg Till för Jämförelse");
        laggtillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laggtillButtonActionPerformed(evt);
            }
        });

        anvandingButton.setText("Användning / Leasing");
        anvandingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anvandingButtonActionPerformed(evt);
            }
        });

        Labelcomparison1.setEditable(false);
        Labelcomparison1.setBackground(new java.awt.Color(204, 204, 204));
        Labelcomparison1.setColumns(2);
        Labelcomparison1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        Labelcomparison1.setRows(4);
        jScrollPane6.setViewportView(Labelcomparison1);

        undersokningsButton.setText("Undersökningar");
        undersokningsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undersokningsButtonActionPerformed(evt);
            }
        });

        jamforelseDataButton.setText("Jämförelsedata (Kommuner)");
        jamforelseDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jamforelseDataButtonActionPerformed(evt);
            }
        });

        jButton5.setText("Jämförelsedata (Sjukhus)");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Rensa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vansterPanelLayout = new javax.swing.GroupLayout(vansterPanel);
        vansterPanel.setLayout(vansterPanelLayout);
        vansterPanelLayout.setHorizontalGroup(
            vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vansterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vansterPanelLayout.createSequentialGroup()
                        .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vansterPanelLayout.createSequentialGroup()
                                .addComponent(LabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11))
                            .addGroup(vansterPanelLayout.createSequentialGroup()
                                .addComponent(LabelCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(vansterPanelLayout.createSequentialGroup()
                                .addComponent(LabelUse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(vansterPanelLayout.createSequentialGroup()
                                .addComponent(LabelSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(vansterPanelLayout.createSequentialGroup()
                                .addComponent(LabelAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(vansterPanelLayout.createSequentialGroup()
                                .addComponent(LabelExpektedEND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vansterPanelLayout.createSequentialGroup()
                        .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jamforelseDataButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(undersokningsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(anvandingButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(laggtillButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(26, 26, 26))))
        );
        vansterPanelLayout.setVerticalGroup(
            vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vansterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelCost, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelUse, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelAge, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelExpektedEND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(laggtillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vansterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anvandingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(undersokningsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jamforelseDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );

        jScrollPane5.setBorder(null);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        databasList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Dalarna", "Norrland", "Småland", "Stockholm", "Gotland", "Närke", "Skåne", "Västra Götaland", "Östra Götaland" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        databasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                databasListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(databasList);

        jLabel9.setText("Region");

        kommunlistan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kommunlistanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(kommunlistan);

        sjukhusListan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sjukhusListanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(sjukhusListan);

        utrustningsListan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                utrustningsListanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                utrustningsListanMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(utrustningsListan);

        jLabel5.setText("Kommun");

        jLabel6.setText("Sjukhus");

        jLabel7.setText("Utrustning");

        javax.swing.GroupLayout hogerPanelLayout = new javax.swing.GroupLayout(hogerPanel);
        hogerPanel.setLayout(hogerPanelLayout);
        hogerPanelLayout.setHorizontalGroup(
            hogerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hogerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hogerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(hogerPanelLayout.createSequentialGroup()
                        .addGroup(hogerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        hogerPanelLayout.setVerticalGroup(
            hogerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hogerPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(hogerPanel);

        jamPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jamPanel1.setPreferredSize(new java.awt.Dimension(400, 350));
        jamPanel1.setLayout(new java.awt.GridBagLayout());

        jamPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jamPanel2.setPreferredSize(new java.awt.Dimension(400, 350));
        jamPanel2.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jamforelseDataPanelLayout = new javax.swing.GroupLayout(jamforelseDataPanel);
        jamforelseDataPanel.setLayout(jamforelseDataPanelLayout);
        jamforelseDataPanelLayout.setHorizontalGroup(
            jamforelseDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jamforelseDataPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jamforelseDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jamPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jamPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(148, 148, 148))
        );
        jamforelseDataPanelLayout.setVerticalGroup(
            jamforelseDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jamforelseDataPanelLayout.createSequentialGroup()
                .addComponent(jamPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jamPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 160, Short.MAX_VALUE))
        );

        mittScroll.setBorder(null);
        mittScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mittScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        GrafPanel1.setPreferredSize(new java.awt.Dimension(400, 350));
        GrafPanel1.setLayout(new java.awt.GridBagLayout());

        GrafPanel2.setPreferredSize(new java.awt.Dimension(400, 350));
        GrafPanel2.setLayout(new java.awt.GridBagLayout());

        GrafPanel3.setPreferredSize(new java.awt.Dimension(400, 350));
        GrafPanel3.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout mittenPanelLayout = new javax.swing.GroupLayout(mittenPanel);
        mittenPanel.setLayout(mittenPanelLayout);
        mittenPanelLayout.setHorizontalGroup(
            mittenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mittenPanelLayout.createSequentialGroup()
                .addGroup(mittenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GrafPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GrafPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GrafPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 98, Short.MAX_VALUE))
        );
        mittenPanelLayout.setVerticalGroup(
            mittenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mittenPanelLayout.createSequentialGroup()
                .addComponent(GrafPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrafPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrafPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 833, Short.MAX_VALUE))
        );

        mittScroll.setViewportView(mittenPanel);

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mittScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(vansterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homePanelLayout.createSequentialGroup()
                    .addGap(228, 228, 228)
                    .addComponent(jamforelseDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(232, Short.MAX_VALUE)))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vansterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mittScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jamforelseDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(23, 23, 23)))
        );

        panelUtlogg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        panelUtlogg.setPreferredSize(new java.awt.Dimension(1024, 31));

        namnLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        namnLabel.setToolTipText("Inloggad som");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, anvandarnamnField, org.jdesktop.beansbinding.ELProperty.create("${text}"), namnLabel, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        utloggButton.setText("Logga ut");
        utloggButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utloggButtonActionPerformed(evt);
            }
        });

        systemnamnLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        systemnamnLabel.setText("VGR Statistics");

        installningButton.setText("Inställningar");
        installningButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                installningButtonActionPerformed(evt);
            }
        });

        helpButton.setText("Hjälp");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        hemButton.setText("Statistikjämförelse");
        hemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUtloggLayout = new javax.swing.GroupLayout(panelUtlogg);
        panelUtlogg.setLayout(panelUtloggLayout);
        panelUtloggLayout.setHorizontalGroup(
            panelUtloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtloggLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(systemnamnLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
                .addComponent(hemButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(installningButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpButton)
                .addGap(51, 51, 51)
                .addComponent(utloggButton)
                .addGap(18, 18, 18)
                .addComponent(namnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelUtloggLayout.setVerticalGroup(
            panelUtloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtloggLayout.createSequentialGroup()
                .addGroup(panelUtloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUtloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(utloggButton)
                        .addComponent(systemnamnLabel)
                        .addComponent(installningButton)
                        .addComponent(helpButton)
                        .addComponent(hemButton))
                    .addComponent(namnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        installningsPanel.setPreferredSize(new java.awt.Dimension(1024, 800));

        jCheckBox1.setText("Blekinge");

        jCheckBox2.setText("Dalarna");

        jCheckBox3.setText("Gävleborg");

        jCheckBox4.setText("Norrbotten");

        jCheckBox5.setText("Län");

        jCheckBox6.setText("Småland");

        javax.swing.GroupLayout lanPanelLayout = new javax.swing.GroupLayout(lanPanel);
        lanPanel.setLayout(lanPanelLayout);
        lanPanelLayout.setHorizontalGroup(
            lanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lanPanelLayout.createSequentialGroup()
                .addGroup(lanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(lanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5)))
                    .addGroup(lanPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox2))
                    .addGroup(lanPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox6)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        lanPanelLayout.setVerticalGroup(
            lanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lanPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lanButton.setText("Län");
        lanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lanButtonActionPerformed(evt);
            }
        });

        kommunButton.setText("Kommun");
        kommunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kommunButtonActionPerformed(evt);
            }
        });

        orgButton.setText("Maskiner");

        maskButton.setText("Organisationer");

        javax.swing.GroupLayout startsidePanelLayout = new javax.swing.GroupLayout(startsidePanel);
        startsidePanel.setLayout(startsidePanelLayout);
        startsidePanelLayout.setHorizontalGroup(
            startsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startsidePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(startsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kommunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orgButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        startsidePanelLayout.setVerticalGroup(
            startsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startsidePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lanButton)
                .addGap(2, 2, 2)
                .addComponent(kommunButton)
                .addGap(1, 1, 1)
                .addComponent(maskButton)
                .addGap(2, 2, 2)
                .addComponent(orgButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(startsidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        fargblindCheckbox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fargblindCheckbox.setText("Färgblindsläge");

        textstorlekCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Var god välj textstorlek.", "Storlek: 12 ptn.", "Storlek: 14 ptn.", "Storlek: 16 ptn.", "Storlek: 18 ptn.", "Storlek: 20 ptn." }));

        javax.swing.GroupLayout granssnittPanelLayout = new javax.swing.GroupLayout(granssnittPanel);
        granssnittPanel.setLayout(granssnittPanelLayout);
        granssnittPanelLayout.setHorizontalGroup(
            granssnittPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(granssnittPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(granssnittPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fargblindCheckbox)
                    .addComponent(textstorlekCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        granssnittPanelLayout.setVerticalGroup(
            granssnittPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(granssnittPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(fargblindCheckbox)
                .addGap(18, 18, 18)
                .addComponent(textstorlekCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        startsidaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        startsidaLabel.setText("Startsida");

        filhanteringsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        filhanteringsLabel.setText("Filhantering");

        granssnittLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        granssnittLabel.setText("Gränssnitt");

        installningsLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        installningsLabel.setText("Inställningar");

        instOkButton.setText("Acceptera");

        instAvButton.setText("Avbryt");

        instDefButton.setText("Default");
        instDefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instDefButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Sparplats PDF");

        jButton1.setText("Bläddra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Sparplats JPG");

        jButton2.setText("Bläddra");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Sparplats Text");

        jButton3.setText("Bläddra");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filPanelLayout = new javax.swing.GroupLayout(filPanel);
        filPanel.setLayout(filPanelLayout);
        filPanelLayout.setHorizontalGroup(
            filPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(pdfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jpgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel3)
                    .addComponent(textTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filPanelLayout.setVerticalGroup(
            filPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pdfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout installningsPanelLayout = new javax.swing.GroupLayout(installningsPanel);
        installningsPanel.setLayout(installningsPanelLayout);
        installningsPanelLayout.setHorizontalGroup(
            installningsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(installningsPanelLayout.createSequentialGroup()
                .addGroup(installningsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(installningsPanelLayout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(installningsLabel))
                    .addGroup(installningsPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(granssnittLabel))
                    .addGroup(installningsPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(granssnittPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(instOkButton)
                        .addGap(18, 18, 18)
                        .addComponent(instAvButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(instDefButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(installningsPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(installningsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startsidaLabel)
                            .addComponent(startsidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(167, 167, 167)
                        .addGroup(installningsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filhanteringsLabel)
                            .addComponent(filPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(163, 163, 163))
        );
        installningsPanelLayout.setVerticalGroup(
            installningsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(installningsPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(installningsLabel)
                .addGap(18, 18, 18)
                .addGroup(installningsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startsidaLabel)
                    .addComponent(filhanteringsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(installningsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startsidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(granssnittLabel)
                .addGap(11, 11, 11)
                .addGroup(installningsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(installningsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(instOkButton)
                        .addComponent(instAvButton)
                        .addComponent(instDefButton))
                    .addComponent(granssnittPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addComponent(installningsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addComponent(panelUtlogg, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHomeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
            .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHomeLayout.createSequentialGroup()
                    .addGap(353, 353, 353)
                    .addComponent(welcometextLabel)
                    .addContainerGap(396, Short.MAX_VALUE)))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUtlogg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(installningsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHomeLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
            .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHomeLayout.createSequentialGroup()
                    .addGap(406, 406, 406)
                    .addComponent(welcometextLabel)
                    .addContainerGap(407, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Metod för att logga in. User + PW hårdkodat atm.
     */
    private void inloggButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inloggButtonActionPerformed
        String user = anvandarnamnField.getText();
        String pw = new String(passwordField.getPassword());
        if (user.equals("admin")
                && pw.equals("admin")) {
            panelLogin.setVisible(false);
            installningsPanel.setVisible(false);
            panelHome.setVisible(true);
            homePanel.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(main.this, "Fel användarnamn eller lösenord.\nVar god försök igen.");
        }
    }//GEN-LAST:event_inloggButtonActionPerformed

    /*
     * Metod för att logga ut. 
     */
    private void utloggButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utloggButtonActionPerformed
        panelHome.setVisible(false);
        panelLogin.setVisible(true);
        anvandarnamnField.setText("");
        passwordField.setText("");
        pdfTextField.setText("");
        jpgTextField.setText("");
        textTextField.setText("");
    }//GEN-LAST:event_utloggButtonActionPerformed
    /*
     * Framtida metod för att visa hjälpsidan. Inte implementerad atm.
     */
    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
//        helpPanel.setVisible(true);
//        panelLogin.setVisible(false);
//        panelHome.setVisible(false);
//        installningsLabel.setVisible(false);
//        panelUtlogg.setVisible(true);
    }//GEN-LAST:event_helpButtonActionPerformed
    /*
     * Metod för att nå inställningar.
     */
    private void installningButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_installningButtonActionPerformed
        installningsPanel.setVisible(true);
        homePanel.setVisible(false);

    }//GEN-LAST:event_installningButtonActionPerformed
    /*
     * Metod för att sätta default vid inställningar.
     */
    private void instDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instDefButtonActionPerformed
        pdfTextField.setText("");
        jpgTextField.setText("");
        textTextField.setText("");
    }//GEN-LAST:event_instDefButtonActionPerformed
    /*
     * Hårdkodad metod för att visa kommuner under inställningar.
     */
    private void kommunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kommunButtonActionPerformed
        jCheckBox1.setText("Göteborg");
        jCheckBox2.setText("Mölndal");
        jCheckBox3.setText("Lerum");
        jCheckBox4.setText("Partille");
        jCheckBox5.setText("Kommun");
        jCheckBox6.setText("Härryda");

    }//GEN-LAST:event_kommunButtonActionPerformed
    /*
     * Hårdkodad metod för att visa län under inställningar.
     */
    private void lanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanButtonActionPerformed
        jCheckBox1.setText("Skåne");
        jCheckBox2.setText("Närke");
        jCheckBox3.setText("Norrland");
        jCheckBox4.setText("Småland");
        jCheckBox5.setText("Dalarna");
        jCheckBox6.setText("Län");

    }//GEN-LAST:event_lanButtonActionPerformed
    /*
     * Öpnnar ett filväljarfönster, sparar adressen till var filen ligger och 
     * skriver ut det i en TextField.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        String filNamn = file.getAbsolutePath();
        pdfTextField.setText(filNamn);
    }//GEN-LAST:event_jButton1ActionPerformed
    /*
     * Öpnnar ett filväljarfönster, sparar adressen till var filen ligger och 
     * skriver ut det i en TextField.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        String filNamn = file.getAbsolutePath();
        jpgTextField.setText(filNamn);
    }//GEN-LAST:event_jButton2ActionPerformed
    /*
     * Öpnnar ett filväljarfönster, sparar adressen till var filen ligger och 
     * skriver ut det i en TextField.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        String filNamn = file.getAbsolutePath();
        textTextField.setText(filNamn);
    }//GEN-LAST:event_jButton3ActionPerformed
    /*
     * Metod för att komma till jämförelsefönstret.
     */
    private void hemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hemButtonActionPerformed
        installningsPanel.setVisible(false);
        homePanel.setVisible(true);
        jamforelseDataPanel.setVisible(false);
    }//GEN-LAST:event_hemButtonActionPerformed

    /*
     * Hårdkodat för att hämta VGR-kolumen från databasen, skickar till metoden;
     * fillListMuni(); med parametern "VGR".
     */
    private void databasListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databasListMouseClicked

        fillListMuni("VGR");
    }//GEN-LAST:event_databasListMouseClicked

    /*
     * 'Pekar' ut var i listen man har klickat, får ett value som görs om till
     * en String, skickar Stringen till metoden fillListHosp som hämtar 
     * valt sjukhus från databasen.
     */
    private void kommunlistanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kommunlistanMouseClicked
        String selectedKommun = kommunlistan.getSelectedValue().toString();
        fillListHosp(selectedKommun);
    }//GEN-LAST:event_kommunlistanMouseClicked
    /*
     * 'Pekar' ut var i listan man har klickat, får ett value som görs om till 
     * en String, skickar Stringen till metoden MakeInfoLabel som tar emot
     * två st parametrar.
     */
    private void utrustningsListanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_utrustningsListanMouseClicked
        String selectedUtrustning = utrustningsListan.getSelectedValue().toString();
        String selectedHospital = sjukhusListan.getSelectedValue().toString();
        MakeInfoLabel(selectedUtrustning, selectedHospital);

    }//GEN-LAST:event_utrustningsListanMouseClicked
    /*
     * 'Pekar' ut var i listen man har klickat, får ett value som görs om till
     * en String, skickar Stringen till metoden fillListEq som hämtar 
     * vald utrustning från databasen.
     */
    private void sjukhusListanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sjukhusListanMouseClicked
        String selectedSjukhus = sjukhusListan.getSelectedValue().toString();
        fillListEq(selectedSjukhus);
    }//GEN-LAST:event_sjukhusListanMouseClicked
    /*
     * Inaktiv atm.
     */
    private void utrustningsListanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_utrustningsListanMouseEntered
    }//GEN-LAST:event_utrustningsListanMouseEntered
    /*
     * Metod vid tryck på en knapp, lägger till vald utrustning i listan.
     */
    private void laggtillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laggtillButtonActionPerformed

        String add = "";
        if (Labelcomparison1.getText().length() != 0) {
            add = Labelcomparison1.getText()
                    + sjukhusListan.getSelectedValue().toString()
                    + "\n" + utrustningsListan.getSelectedValue().toString()
                    + "\n" + kommunlistan.getSelectedValue().toString() + "\n";
            Labelcomparison1.setText(add);
        } else {
            add = sjukhusListan.getSelectedValue().toString() + " \n"
                    + utrustningsListan.getSelectedValue().toString()
                    + "\n" + kommunlistan.getSelectedValue().toString() + "\n";
            Labelcomparison1.setText(add);
        }

    }//GEN-LAST:event_laggtillButtonActionPerformed
    /*
     * Metod vid tryck av knapp som visar en JTable med grafer om användning.
     */
    private void anvandingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anvandingButtonActionPerformed

        mittScroll.setVisible(true);
        mittenPanel.setVisible(true);
        GrafPanel1.setVisible(true);
        GrafPanel2.setVisible(true);
        GrafPanel3.setVisible(true);
        jamforelseDataPanel.setVisible(false);
        jamPanel1.setVisible(false);
        jamPanel2.setVisible(false);
        makeComparisonOfUsage();
    }//GEN-LAST:event_anvandingButtonActionPerformed
    /*
     * Metod vid tryck av knapp som visar en JTable med grafer om undersökningar.
     */
    private void undersokningsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undersokningsButtonActionPerformed
        makeComparisonOfExam();
    }//GEN-LAST:event_undersokningsButtonActionPerformed
    /*
     * Tar bort all data och nollställer metoderna.
     */
    private void jamforelseDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jamforelseDataButtonActionPerformed
        jamPanel1.removeAll();
        jamPanel2.removeAll();
        jamforelseDataPanel.setVisible(true);
        mittenPanel.setVisible(false);
        mittScroll.setVisible(false);
        makeComparisonOfMunicipality();
        GrafPanel1.setVisible(false);
        GrafPanel2.setVisible(false);
        GrafPanel3.setVisible(false);
        jamPanel1.setVisible(true);
        jamPanel2.setVisible(true);
    }//GEN-LAST:event_jamforelseDataButtonActionPerformed
    /*
     * Tar bort all data och nollställer metoderna.
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jamPanel1.removeAll();
        jamPanel2.removeAll();
        jamforelseDataPanel.setVisible(true);
        mittenPanel.setVisible(false);
        mittScroll.setVisible(false);
        makeComparisonOfHospital();
        GrafPanel1.setVisible(false);
        GrafPanel2.setVisible(false);
        GrafPanel3.setVisible(false);
        jamPanel1.setVisible(true);
        jamPanel2.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
    /*
     * Nollställer informationsrutorna.
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Labelcomparison1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GrafPanel1;
    private javax.swing.JPanel GrafPanel2;
    private javax.swing.JPanel GrafPanel3;
    private javax.swing.JLabel LabelAge;
    private javax.swing.JLabel LabelCost;
    private javax.swing.JLabel LabelExpektedEND;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelSupplier;
    private javax.swing.JLabel LabelUse;
    private javax.swing.JTextArea Labelcomparison1;
    private javax.swing.JTextField anvandarnamnField;
    private javax.swing.JLabel anvandarnamnLabel;
    private javax.swing.JButton anvandingButton;
    private javax.swing.JList databasList;
    private javax.swing.JCheckBox fargblindCheckbox;
    private javax.swing.JPanel filPanel;
    private javax.swing.JLabel filhanteringsLabel;
    private javax.swing.JLabel granssnittLabel;
    private javax.swing.JPanel granssnittPanel;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton hemButton;
    private javax.swing.JPanel hogerPanel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton inloggButton;
    private javax.swing.JButton instAvButton;
    private javax.swing.JButton instDefButton;
    private javax.swing.JButton instOkButton;
    private javax.swing.JButton installningButton;
    private javax.swing.JLabel installningsLabel;
    private javax.swing.JPanel installningsPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel jamPanel1;
    private javax.swing.JPanel jamPanel2;
    private javax.swing.JButton jamforelseDataButton;
    private javax.swing.JPanel jamforelseDataPanel;
    private javax.swing.JTextField jpgTextField;
    private javax.swing.JButton kommunButton;
    public static javax.swing.JList kommunlistan;
    private javax.swing.JButton laggtillButton;
    private javax.swing.JButton lanButton;
    private javax.swing.JPanel lanPanel;
    private javax.swing.JButton maskButton;
    private javax.swing.JScrollPane mittScroll;
    private javax.swing.JPanel mittenPanel;
    private javax.swing.JLabel namnLabel;
    private javax.swing.JButton orgButton;
    public static javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelUtlogg;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField pdfTextField;
    private javax.swing.JList sjukhusListan;
    private javax.swing.JLabel startsidaLabel;
    private javax.swing.JPanel startsidePanel;
    private javax.swing.JLabel systemnamnLabel;
    private javax.swing.JTextField textTextField;
    private javax.swing.JComboBox textstorlekCombobox;
    private javax.swing.JButton undersokningsButton;
    private javax.swing.JButton utloggButton;
    private javax.swing.JList utrustningsListan;
    private javax.swing.JPanel vansterPanel;
    private javax.swing.JLabel vgrLogo;
    private javax.swing.JLabel welcometextLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    /*
     * Metod som skapar infoPanelen
     * ändrar osynliga labels med värden
     */
    private void MakeInfoLabel(String selectedUtrustning, String selectedHospital) {
        try {
            String host = "jdbc:mysql://vm-06.ituniv.chalmers.se:3306/tig063g";
            String uName = "";
            String uPass = "";
            Double use = 0.00;
            String SupplierName = "";
            String EquipmentName = "";
            Double LeasePris = 0.00;
            int Age = 0;
            int ExpektedAge = 0;
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String sql =
                    "SELECT count(Examination.EXID) as uses ,Supplier.Name as SupplierName,Equipment.Name as EquipmentName, "
                    + "Equipment.LeasePris, Equipment.Age, Equipment.ExpektedAge"
                    + " from Examination, Equipment,Location,Supplier "
                    + " Where Equipment.name = '" + selectedUtrustning + "'"
                    + " and Examination.LID = Location.LID  "
                    + " and Equipment.EID = Examination.EID "
                    + " and Equipment.SID = Supplier.SID "
                    + " and Location.HospitalName = '" + selectedHospital + "'";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                use = rs.getDouble("uses");
                SupplierName = rs.getString("SupplierName");
                EquipmentName = rs.getString("EquipmentName");
                LeasePris = rs.getDouble("LeasePris");
                Age = rs.getInt("Age");
                ExpektedAge = rs.getInt("ExpektedAge");
            }
            LabelUse.setText(use.toString());
            LabelCost.setText(LeasePris.toString());
            LabelAge.setText(Integer.toString(Age));
            LabelExpektedEND.setText(Integer.toString(ExpektedAge));
            LabelSupplier.setText(SupplierName);
            LabelName.setText(EquipmentName);

            con.close();
            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }

    }

    /*
     * Metod som tar emot data från databasen, läser av vald data, loopar igenom
     * vald data, skriver ut det i Strings och ritar upp diagram.
     */
    private void makeComparisonOfUsage() {
        int use1 = 0;
        int use2 = 0;
        int use3 = 0;
        int use4 = 0;
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        String kommun1 = "";
        String kommun2 = "";
        try {
            String host = "jdbc:mysql://vm-06.ituniv.chalmers.se:3306/tig063g";
            String uName = "";
            String uPass = "";
            String comparison = Labelcomparison1.getText();
            Scanner sc = new Scanner(comparison);


            while (sc.hasNextLine()) {
                line1 = sc.nextLine();
                line2 = sc.nextLine();
                kommun1 = sc.nextLine();
                line3 = sc.nextLine();
                line4 = sc.nextLine();
                kommun2 = sc.nextLine();
            }

            Double use = 0.00;
            String SupplierName = "";
            String EquipmentName = "";
            Double LeasePris = 0.00;
            int Age = 0;
            int ExpektedAge = 0;
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);


            //Den långa delvis hårdkodade SQL-satsen för att räkna ut undersökningar.
            String sql = "SELECT Location.HospitalName, count(Examination.EXID)"
                    + " as uses, Supplier.Name as SupplierName, Equipment.Name as "
                    + "EquipmentName, Equipment.LeasePris, Equipment.Age, "
                    + "Equipment.ExpektedAge from Examination, Equipment,Location, "
                    + "Supplier where (Equipment.name = " + "'" + line2 + "'" + " "
                    + "and Location.HospitalName = " + "'" + line1 + "'" + " "
                    + "and Examination.LID = Location.LID and "
                    + "Equipment.EID = Examination.EID and "
                    + "Equipment.SID = Supplier.SID) or (Equipment.name = "
                    + "'" + line4 + "'" + " and Location.HospitalName = " + "'"
                    + line3 + "'" + " and Examination.LID = Location.LID and "
                    + "Equipment.EID = Examination.EID and "
                    + "Equipment.SID = Supplier.SID) group by Equipment.EID";

            System.out.println(sql);
            rs = stmt.executeQuery(sql);


            while (rs.next()) {
                rs.absolute(1);
                use3 = Integer.parseInt(rs.getString(2));
                use1 = Integer.parseInt(rs.getString(5));
                rs.absolute(2);
                use4 = Integer.parseInt(rs.getString(2));
                use2 = Integer.parseInt(rs.getString(5));

            }
            System.out.println(" use1: " + use1 + " use2:" + use2 + " use3:" + use3 + " use4:" + use4);
            con.close();
            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }

        DefaultCategoryDataset barData = new DefaultCategoryDataset();

        barData.setValue(use3, "Användning av " + line2 + " på " + line1, line1);
        barData.setValue(use4, "Användning av " + line4 + " på " + line3, line3);
        JFreeChart chart = ChartFactory.createBarChart("Jämförelse av användning på " + line2 + " på :" + line1
                + "\n och " + line4 + " på:" + line3, "Sjukhusnamn", "Användning", barData,
                PlotOrientation.VERTICAL, false, true, false);
        GrafPanel1.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        CP.setSize(400, 400);
        GrafPanel1.add(CP, BorderLayout.CENTER);
        GrafPanel1.validate();
        GrafPanel1.setSize(400, 400);

        DefaultCategoryDataset barData2 = new DefaultCategoryDataset();

       
        barData2.setValue(use1, "LeaseKostnad", line1);
        barData2.setValue(use2, "LeaseKostnad ", line3);
        JFreeChart chart2 = ChartFactory.createBarChart("Jämförelse av "
                + "LeaseKostnad på " + line2 + " på :" + line1 + " och \n " 
                + line4 + " på :" + line3, "Sjukhusnamn", "LeasePris", barData2,
                PlotOrientation.VERTICAL, false, true, false);
        GrafPanel2.setLayout(new java.awt.BorderLayout());
        ChartPanel CP2 = new ChartPanel(chart2);
        CP2.setSize(400, 400);
        GrafPanel2.add(CP2, BorderLayout.CENTER);
        GrafPanel2.validate();
        GrafPanel2.setSize(400, 400);

    }

    /*
     * Liknande metod som ovan, fast visar på undersökningar.
     */
    private void makeComparisonOfExam() {
        int use3 = 0;
        int use4 = 0;
        int use1 = 0;
        int use2 = 0;
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        String kommun1 = "";
        String kommun2 = "";
        try {
            String host = "jdbc:mysql://vm-06.ituniv.chalmers.se:3306/tig063g";
            String uName = "";
            String uPass = "";
            String comparison = Labelcomparison1.getText();
            Scanner sc = new Scanner(comparison);


            while (sc.hasNextLine()) {
                line1 = sc.nextLine();
                line2 = sc.nextLine();
                kommun1 = sc.nextLine();
                line3 = sc.nextLine();
                line4 = sc.nextLine();
                kommun2 = sc.nextLine();
            }

            Double use = 0.00;
            String SupplierName = "";
            String EquipmentName = "";
            Double LeasePris = 0.00;
            int Age = 0;
            int ExpektedAge = 0;
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            String sql =
                    "SELECT Examination.LID, Location.HospitalName, "
                    + "count(Examination.EXID) as uses from Location, "
                    + "Examination where (Examination.LID = Location.LID and "
                    + "(Location.HospitalName= " + "'" + line1 + "'" + " or "
                    + "Location.HospitalName = " + " '" + line3 + "')) "
                    + "Group by Location.HospitalName";

            System.out.println(sql);
            rs = stmt.executeQuery(sql);


            while (rs.next()) {
                rs.absolute(1);
                use3 = Integer.parseInt(rs.getString(3));

                System.out.println(use3);
                rs.absolute(2);
                use4 = Integer.parseInt(rs.getString(3));

                System.out.println(use4);
            }
            con.close();
            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }

        DefaultCategoryDataset barData = new DefaultCategoryDataset();

        barData.setValue(use3, "Markus", line1);
        barData.setValue(use4, "Markus2", line3);

        JFreeChart chart = ChartFactory.createBarChart("Jämförelse av "
                + "undersökning", "Sjukhusnamn", "Undersökning", barData,
                PlotOrientation.VERTICAL, false, true, false);
        GrafPanel3.setLayout(new java.awt.BorderLayout());
        GrafPanel3.setSize(400, 400);

        ChartPanel CP = new ChartPanel(chart);
        CP.setSize(400, 400);
        GrafPanel3.add(CP, BorderLayout.CENTER);
        GrafPanel3.validate();
    }

    /*
     * Metod som visar på skillnader mellan kommuner.
     */
    private void makeComparisonOfMunicipality() {
        double TotalLeasePrice1 = 0;
        double TotalLeasePrice2 = 0;
        int TotalUse1 = 0;
        int TotalUse2 = 0;
        double AvgLeasePrice1 = 0;
        double AvgLeasePrice2 = 0;
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        String kommun1 = "";
        String kommun2 = "";
        try {
            String host = "jdbc:mysql://vm-06.ituniv.chalmers.se:3306/tig063g";
            String uName = "";
            String uPass = "";
            String comparison = Labelcomparison1.getText();
            Scanner sc = new Scanner(comparison);

            while (sc.hasNextLine()) {
                line1 = sc.nextLine();
                line2 = sc.nextLine();
                kommun1 = sc.nextLine();
                line3 = sc.nextLine();
                line4 = sc.nextLine();
                kommun2 = sc.nextLine();
            }

            Double use = 0.00;
            String SupplierName = "";
            String EquipmentName = "";
            Double LeasePris = 0.00;
            int Age = 0;
            int ExpektedAge = 0;
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT count(Examination.EXID) as uses,"
                    + "sum(Equipment.LeasePris) as Leasekostnader, "
                    + "avg(Equipment.Age) as MedelÅrgång, "
                    + "avg(Equipment.ExpektedAge) as MedelFörväntadÅlder"
                    + ", avg(Equipment.LeasePris) as MedelvärdeLeasePris"
                    + " from Examination, "
                    + "Equipment,Location, Supplier "
                    + "where "
                    + "(Location.Municipality = '" + kommun1 + "' "
                    + "and Examination.LID = Location.LID "
                    + "and Equipment.EID = Examination.EID and "
                    + "Equipment.SID = Supplier.SID) "
                    + "or (Location.Municipality = '" + kommun2 + "' and"
                    + " Examination.LID = Location.LID "
                    + "and Equipment.EID = Examination.EID and"
                    + " Equipment.SID = Supplier.SID) "
                    + "group by Location.Municipality";
            
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                rs.absolute(1);
                TotalLeasePrice1 = Double.parseDouble(rs.getString(2));
                TotalUse1 = Integer.parseInt(rs.getString(1));
                AvgLeasePrice1 = Double.parseDouble(rs.getString(5));
                rs.absolute(2);
                TotalLeasePrice2 = Double.parseDouble(rs.getString(2));
                TotalUse2 = Integer.parseInt(rs.getString(1));
                AvgLeasePrice2 = Double.parseDouble(rs.getString(5));
            }
            con.close();
            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }

        DefaultCategoryDataset barData = new DefaultCategoryDataset();
        barData.setValue(TotalLeasePrice1, "Total LeasePris för " + kommun1, kommun1);
        barData.setValue(AvgLeasePrice1, "Medel LeasePris för " + kommun1, kommun1);
        barData.setValue(TotalLeasePrice2, "Total LeasePris för " + kommun2, kommun2);
        barData.setValue(AvgLeasePrice2, "Medel LeasePris för " + kommun2, kommun2);
        JFreeChart chart = ChartFactory.createBarChart("Jämförelse av "
                + "Kommunerna \n " + kommun1 + " och " + kommun2, "Kommunnamn ,"
                + " TotalKostnader och Medelkostnad", "Leasekostnader", barData,
                PlotOrientation.VERTICAL, false, true, false);
        jamPanel1.setLayout(new java.awt.BorderLayout());
        jamPanel1.setSize(450, 400);
        ChartPanel CP = new ChartPanel(chart);
        CP.setSize(350, 200);
        jamPanel1.add(CP, BorderLayout.CENTER);
        jamPanel1.validate();


        DefaultCategoryDataset barData2 = new DefaultCategoryDataset();
        barData2.setValue(TotalUse1, kommun1, kommun1);
        barData2.setValue(TotalUse2, kommun2, kommun2);

        JFreeChart chart2 = ChartFactory.createBarChart("Jämförelse av "
                + "Undersökningar på Kommunerna \n " + kommun1 + " och " + 
                kommun2, "Kommunnamn", "Undersökning", barData2,
                PlotOrientation.VERTICAL, false, true, false);
        jamPanel2.setLayout(new java.awt.BorderLayout());
        jamPanel2.setSize(450, 400);
        ChartPanel CP2 = new ChartPanel(chart2);
        CP2.setSize(350, 200);
        jamPanel2.add(CP2, BorderLayout.CENTER);
        jamPanel2.validate();
    }

    /*
     * Metod vid undersökning av sjukhus.
     */
    private void makeComparisonOfHospital() {
        double TotalLeasePrice1 = 0;
        double TotalLeasePrice2 = 0;
        int TotalUse1 = 0;
        int TotalUse2 = 0;
        double AvgLeasePrice1 = 0;
        double AvgLeasePrice2 = 0;
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        String kommun1 = "";
        String kommun2 = "";
        try {
            String host = "jdbc:mysql://vm-06.ituniv.chalmers.se:3306/tig063g";
            String uName = "";
            String uPass = "";
            String comparison = Labelcomparison1.getText();
            Scanner sc = new Scanner(comparison);


            while (sc.hasNextLine()) {
                line1 = sc.nextLine();
                line2 = sc.nextLine();
                kommun1 = sc.nextLine();
                line3 = sc.nextLine();
                line4 = sc.nextLine();
                kommun2 = sc.nextLine();
            }

            Double use = 0.00;
            String SupplierName = "";
            String EquipmentName = "";
            Double LeasePris = 0.00;
            int Age = 0;
            int ExpektedAge = 0;
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT count(Examination.EXID) as uses,"
                    + "sum(Equipment.LeasePris) as Leasekostnader, "
                    + "avg(Equipment.Age) as MedelÅrgång, "
                    + "avg(Equipment.ExpektedAge) as MedelFörväntadÅlder"
                    + ", avg(Equipment.LeasePris) as MedelvärdeLeasePris"
                    + " from Examination, "
                    + "Equipment,Location, Supplier "
                    + "where "
                    + "(Location.HospitalName = '" + line1 + "' "
                    + "and Examination.LID = Location.LID "
                    + "and Equipment.EID = Examination.EID and "
                    + "Equipment.SID = Supplier.SID) "
                    + "or (Location.HospitalName = '" + line3 + "' "
                    + "and Examination.LID = Location.LID "
                    + "and Equipment.EID = Examination.EID and "
                    + "Equipment.SID = Supplier.SID)"
                    + " group by Location.HospitalName";
            
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                rs.absolute(1);
                TotalLeasePrice1 = Double.parseDouble(rs.getString(2));
                TotalUse1 = Integer.parseInt(rs.getString(1));
                AvgLeasePrice1 = Double.parseDouble(rs.getString(5));
                rs.absolute(2);
                TotalLeasePrice2 = Double.parseDouble(rs.getString(2));
                TotalUse2 = Integer.parseInt(rs.getString(1));
                AvgLeasePrice2 = Double.parseDouble(rs.getString(5));
            }
            con.close();
            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }

        DefaultCategoryDataset barData = new DefaultCategoryDataset();
        barData.setValue(TotalLeasePrice1, "Sjukhus:" + line2, line1);
        barData.setValue(AvgLeasePrice1, "sjukhusLease" + line2, line1);
        barData.setValue(TotalLeasePrice2, "Sjukhus" + line4, line3);
        barData.setValue(AvgLeasePrice2, "sjukhusLease" + line4, line3);
        JFreeChart chart = ChartFactory.createBarChart("Jämförelse av Sjukhus "
                + "\n " + line1 + " och " + line3, "Sjukhusnamn , "
                + "TotalKostnad och MedelKostnad", "Leasekostnader", barData,
                PlotOrientation.VERTICAL, false, true, false);
        jamPanel1.setLayout(new java.awt.BorderLayout());
        jamPanel1.setSize(350, 300);
        ChartPanel CP = new ChartPanel(chart);
        CP.setSize(350, 200);
        jamPanel1.add(CP, BorderLayout.CENTER);
        jamPanel1.validate();


        DefaultCategoryDataset barData2 = new DefaultCategoryDataset();
        barData2.setValue(TotalUse1, "Sjukhus:" + line2, line1);
        barData2.setValue(TotalUse2, "Sjukhus" + line4, line3);

        JFreeChart chart2 = ChartFactory.createBarChart("Jämförelse av "
                + "Undersökningar på Sjukhusen \n " + line1 + " och " + line3, 
                "sjukhusnamn", "Undersökning", barData2,
                PlotOrientation.VERTICAL, false, true, false);
        jamPanel2.setLayout(new java.awt.BorderLayout());
        jamPanel2.setSize(350, 300);
        ChartPanel CP2 = new ChartPanel(chart2);
        CP2.setSize(350, 200);
        jamPanel2.add(CP2, BorderLayout.CENTER);
        jamPanel2.validate();

    }
}
