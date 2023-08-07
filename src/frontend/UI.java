package frontend;

import backend.Analyzer;
import backend.ReaderText;
import backend.Token;
import backend.TokenType;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends javax.swing.JFrame {
    Analyzer analyzer;
    SimpleList simpleList;
    CreateHTML png;
    PNGFrame pngFrame;
    LineNumber lineNumber, lineNumber2, lineNumber3;
    Reports reports;
    String comboBoxText;

    public UI() {

        initComponents();

        setTitle("Parser-Py");
        AutoCompleteDecorator.decorate(jComboBoxID);
        AutoCompleteDecorator.decorate(jComboBoxArithmetic);
        AutoCompleteDecorator.decorate(jComboBoxAssign);
        AutoCompleteDecorator.decorate(jComboBoxComment);
        AutoCompleteDecorator.decorate(jComboBoxKeyWords);
        AutoCompleteDecorator.decorate(jComboBoxComparison);
        AutoCompleteDecorator.decorate(jComboBoxConstant);
        AutoCompleteDecorator.decorate(jComboBoxOthers);
        AutoCompleteDecorator.decorate(jComboBoxLogics);
        AutoCompleteDecorator.decorate(jComboBoxErrors);

        jTextPaneError.setEditable(false );
        jTextAreaAbout.setText(about);
        jTextAreaHelp.setText(help);
        jTextAreaAbout.setBackground(new Color(0,216,118));
        jTextAreaHelp.setBackground(new Color(0,216,118));
        jTextAreaAbout.setForeground(Color.WHITE);
        jTextAreaHelp.setForeground(Color.WHITE);
        jTextAreaAbout.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jTextAreaHelp.setFont(new Font("Segoe UI", Font.BOLD, 17));
        jTextAreaAbout.setEditable(false);
        jTextAreaHelp.setEditable(false);

        jPanelGraphviz.setOpaque(false);

        jPanelReportTable.removeAll();
        jPanelReportTable.setLayout(new BorderLayout(0,0));
        jPanelReportTable.setBackground(Color.black);

        lineNumber = new LineNumber(jTextPaneAnalyze);
        lineNumber2 = new LineNumber(jTextPaneError);

        jScrollPane1.setRowHeaderView(lineNumber);
        jScrollPane2.setRowHeaderView(lineNumber2);
    }

    String about = "\n\nBienvenido a este analizador léxico llamado \"Parser-Py\".\n" +
            "\n" +
            "Esta es una primera version de un programa que analiza un lenguaje\n" +
            "de programación inspirado en Python y tambiés será la primera parte\n" +
            "de una serie de programas los cuales al final crearan un analizador\n" +
            "tanto léxico como sintáctico lo más asemejable posible a Phyton.\n" +
            "\n" +
            "Como bien se decía, esta parte solo se encargará de reconocer y \n" +
            "clasificar componentes léxicos presentes en el código fuente, \n" +
            "como identificadores, operadores, constantes y palabras clave.\n" +
            "\n" +
            "version 1.0";
    String help = "Este programa cuenta con ciertas opciones las cuales serian buenas\n" +
            "repasar:\n" +
            "\n" +
            "Cargar: La opción cargar aparece en el menú de la parte superior derecha\n" +
            "(File -> Cargar) y lo que hace es abrir un buscador en el cual podrá ingresar\n" +
            "solo archivos de texto (.txt). Se mostrará en un área de texto el cual podrá\n" +
            "ser editado en cualquier momento.\n" +
            "\n" +
            "Archivo: En la sección de archivo no encontraremos con 2 áreas de texto y un\n" +
            "botón. En la primer área de texto se cargará y se podrá editará el texto,\n" +
            "mientras que la segunda solo se mostrarán errores y no se podrá editar.\n" +
            "\n" +
            "Boton Analizar: Este boton hará un analisis del texto cargado, reconocerá y \n" +
            "organizará el tipo de texto que se este , además de pintar segun el respectivo\n" +
            "lexema de cada palabra.\n" +
            "\n" +
            "Generar Gráfico: En la sección de generar gráfico estarán 10 cajas de texto\n" +
            "las cuales estarán acompañados de sus respectivos identificadores para\n" +
            "reconocerlos, además habrá un botón.\n" +
            "\n" +
            "Boton Crear: Este boton abrirá una nueva ventana la cuál mostrará un gráfico,\n" +
            "creado por medio de Graphviz, del último objeto seleccionado de cualquier lista\n" +
            "\n" +
            "Reporte: En la sección de reporte encontraremos 11 botones, cada uno el cual \n" +
            "filtrará la tabla de reportes de tokens segun el nombre del botón. Abajo se \n" +
            "observará una tabla la cual contendra el token, lexema y posición en línea y\n" +
            "columna de los tokens.\n" +
            "\n" +
            "Ayuda: Esta misma sección :D \n" +
            "\n" +
            "Acerca de: Habrá una pequeña introducción sobre el programa";


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelFile = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneAnalyze = new javax.swing.JTextPane();
        jPanelAnalyze = new javax.swing.JPanel();
        jLabelAnalyze = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneError = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanelGraph = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jComboBoxID = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanelGraphviz = new javax.swing.JEditorPane();
        jButtonCreateGraph = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jComboBoxArithmetic = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jComboBoxComparison = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jComboBoxAssign = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jComboBoxLogics = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jComboBoxKeyWords = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jComboBoxComment = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jComboBoxConstant = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jComboBoxOthers = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jComboBoxErrors = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jPanelReport = new javax.swing.JPanel();
        jPanelReportTable = new javax.swing.JPanel();
        jButtonReportAll = new javax.swing.JButton();
        jButtonReportID = new javax.swing.JButton();
        jButtonReportArithmetic = new javax.swing.JButton();
        jButtonReportCompare = new javax.swing.JButton();
        jButtonReportAssign = new javax.swing.JButton();
        jButtonReportKeyWord = new javax.swing.JButton();
        jButtonReportConstant = new javax.swing.JButton();
        jButtonReportComment = new javax.swing.JButton();
        jButtonReportOthers = new javax.swing.JButton();
        jButtonReportErr = new javax.swing.JButton();
        jButtonReportLogics = new javax.swing.JButton();
        jPanelHelp = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaHelp = new javax.swing.JTextArea();
        jPanelAbout = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaAbout = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelCentral.setBackground(new java.awt.Color(51, 255, 255));
        jPanelCentral.setPreferredSize(new java.awt.Dimension(880, 670));

        jPanelFile.setBackground(new java.awt.Color(0, 105, 105));

        jScrollPane1.setViewportView(jTextPaneAnalyze);

        jPanelAnalyze.setBackground(new java.awt.Color(51, 255, 204));

        jLabelAnalyze.setFont(new java.awt.Font("Liberation Serif", 0, 18)); // NOI18N
        jLabelAnalyze.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAnalyze.setText("Analizar");
        jLabelAnalyze.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAnalyze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAnalyzeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelAnalyzeLayout = new javax.swing.GroupLayout(jPanelAnalyze);
        jPanelAnalyze.setLayout(jPanelAnalyzeLayout);
        jPanelAnalyzeLayout.setHorizontalGroup(
                jPanelAnalyzeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelAnalyze, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        jPanelAnalyzeLayout.setVerticalGroup(
                jPanelAnalyzeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelAnalyze, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jTextPaneError);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("ERROR");

        javax.swing.GroupLayout jPanelFileLayout = new javax.swing.GroupLayout(jPanelFile);
        jPanelFile.setLayout(jPanelFileLayout);
        jPanelFileLayout.setHorizontalGroup(
                jPanelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(819, Short.MAX_VALUE))
                                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                                .addGroup(jPanelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane2)
                                                        .addComponent(jScrollPane1))
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanelAnalyze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32))))
        );
        jPanelFileLayout.setVerticalGroup(
                jPanelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                .addGroup(jPanelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jPanelAnalyze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Archivo", jPanelFile);


        jPanelGraph.setBackground(new java.awt.Color(0, 51, 102));

        jPanel17.setBackground(new java.awt.Color(0, 51, 102));
        jPanel17.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Identificadores");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxID, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanelGraphviz.setText("jLabel1");

        jButtonCreateGraph.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCreateGraph.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCreateGraph.setText("Crear");
        jButtonCreateGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateGraphActionPerformed(evt);
            }
        });

        jPanel18.setBackground(new java.awt.Color(0, 51, 102));
        jPanel18.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxArithmetic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxArithmetic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxArithmeticActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Aritméticos");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxArithmetic, 0, 229, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxArithmetic, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(0, 51, 102));
        jPanel20.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxComparison.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxComparison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxComparisonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Comparación");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxComparison, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxComparison, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(0, 51, 102));
        jPanel21.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxAssign.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAssignActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Asignación");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxAssign, 0, 217, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxAssign, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(0, 51, 102));
        jPanel22.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxLogics.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxLogics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLogicsActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Lógicos");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxLogics, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxLogics, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(0, 51, 102));
        jPanel23.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxKeyWords.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxKeyWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKeyWordsActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Palabras clave");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxKeyWords, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxKeyWords, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(0, 51, 102));
        jPanel24.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxComment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCommentActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Comentarios");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxComment, 0, 229, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxComment, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new java.awt.Color(0, 51, 102));
        jPanel25.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxConstant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxConstant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxConstantActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Constantes");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxConstant, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxConstant, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(0, 51, 102));
        jPanel26.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxOthers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxOthers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOthersActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Otros");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxOthers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxOthers, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(0, 51, 102));
        jPanel27.setForeground(new java.awt.Color(0, 51, 153));

        jComboBoxErrors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxErrors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxErrorsActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Errores");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
                jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxErrors, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
                jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxErrors, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelGraphLayout = new javax.swing.GroupLayout(jPanelGraph);
        jPanelGraph.setLayout(jPanelGraphLayout);
        jPanelGraphLayout.setHorizontalGroup(
                jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelGraphLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addGroup(jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(58, 58, 58))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGraphLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelGraphviz, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                        .addGroup(jPanelGraphLayout.createSequentialGroup()
                                .addGap(425, 425, 425)
                                .addComponent(jButtonCreateGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(403, 403, 403))
        );
        jPanelGraphLayout.setVerticalGroup(
                jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelGraphLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jPanelGraphviz)
                                .addGap(8, 8, 8)
                                .addGroup(jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(jButtonCreateGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Generar Grafico", jPanelGraph);

        jPanelReport.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanelReportTable);
        jPanelReportTable.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 420, Short.MAX_VALUE)
        );

        jButtonReportAll.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportAll.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportAll.setText("Todos");
        jButtonReportAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportAllActionPerformed(evt);
            }
        });

        jButtonReportID.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportID.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportID.setText("Identificadores");
        jButtonReportID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportIDActionPerformed(evt);
            }
        });

        jButtonReportArithmetic.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportArithmetic.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportArithmetic.setText("Aritméticos");
        jButtonReportArithmetic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportArithmeticActionPerformed(evt);
            }
        });

        jButtonReportCompare.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportCompare.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportCompare.setText("Comparación");
        jButtonReportCompare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportCompareActionPerformed(evt);
            }
        });

        jButtonReportAssign.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportAssign.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportAssign.setText("Asignación");
        jButtonReportAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportAssignActionPerformed(evt);
            }
        });

        jButtonReportKeyWord.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportKeyWord.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportKeyWord.setText("Palabra clave");
        jButtonReportKeyWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportKeyWordActionPerformed(evt);
            }
        });

        jButtonReportConstant.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportConstant.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportConstant.setText("Constantes");
        jButtonReportConstant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportConstantActionPerformed(evt);
            }
        });

        jButtonReportComment.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportComment.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportComment.setText("Comentarios");
        jButtonReportComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportCommentActionPerformed(evt);
            }
        });

        jButtonReportOthers.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportOthers.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportOthers.setText("Otros");
        jButtonReportOthers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportOthersActionPerformed(evt);
            }
        });

        jButtonReportErr.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportErr.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportErr.setText("Errores");
        jButtonReportErr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportErrActionPerformed(evt);
            }
        });

        jButtonReportLogics.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReportLogics.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReportLogics.setText("Lógicos ");
        jButtonReportLogics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportLogicsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelReportLayout = new javax.swing.GroupLayout(jPanelReport);
        jPanelReport.setLayout(jPanelReportLayout);
        jPanelReportLayout.setHorizontalGroup(
                jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelReportTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelReportLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonReportAll, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(jButtonReportAssign, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonReportID, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(jButtonReportKeyWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonReportArithmetic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReportConstant, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonReportCompare, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                        .addComponent(jButtonReportComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonReportLogics, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                        .addComponent(jButtonReportOthers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(151, 151, 151))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReportLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonReportErr, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanelReportLayout.setVerticalGroup(
                jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReportLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonReportCompare)
                                                .addComponent(jButtonReportLogics))
                                        .addGroup(jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonReportAll)
                                                .addComponent(jButtonReportID)
                                                .addComponent(jButtonReportArithmetic, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addComponent(jButtonReportErr)
                                .addGap(7, 7, 7)
                                .addGroup(jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonReportComment)
                                        .addComponent(jButtonReportKeyWord)
                                        .addComponent(jButtonReportOthers, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonReportAssign)
                                        .addComponent(jButtonReportConstant))
                                .addGap(44, 44, 44)
                                .addComponent(jPanelReportTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Reporte", jPanelReport);

        jPanelHelp.setBackground(new java.awt.Color(0, 216, 118));

        jTextAreaHelp.setColumns(20);
        jTextAreaHelp.setRows(5);
        jScrollPane5.setViewportView(jTextAreaHelp);

        javax.swing.GroupLayout jPanelHelpLayout = new javax.swing.GroupLayout(jPanelHelp);
        jPanelHelp.setLayout(jPanelHelpLayout);
        jPanelHelpLayout.setHorizontalGroup(
                jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHelpLayout.createSequentialGroup()
                                .addContainerGap(61, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
        );
        jPanelHelpLayout.setVerticalGroup(
                jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelHelpLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ayuda", jPanelHelp);

        jPanelAbout.setBackground(new java.awt.Color(0, 216, 118));

        jTextAreaAbout.setColumns(20);
        jTextAreaAbout.setRows(5);
        jScrollPane4.setViewportView(jTextAreaAbout);

        javax.swing.GroupLayout jPanelAboutLayout = new javax.swing.GroupLayout(jPanelAbout);
        jPanelAbout.setLayout(jPanelAboutLayout);
        jPanelAboutLayout.setHorizontalGroup(
                jPanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAboutLayout.createSequentialGroup()
                                .addContainerGap(61, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
        );
        jPanelAboutLayout.setVerticalGroup(
                jPanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelAboutLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Acerca de", jPanelAbout);

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
                jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        jPanelCentralLayout.setVerticalGroup(
                jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Cargar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jButtonCreateGraphActionPerformed(java.awt.event.ActionEvent evt) {
        png = new CreateHTML();
        png.showHTML(jPanelGraphviz);
        pngFrame = new PNGFrame();
        pngFrame.init(jPanelGraphviz);
        SwingUtilities.updateComponentTreeUI(jPanelGraphviz);
    }

    private boolean isValidLexeme(TokenType type, String text){
        for (Token token : analyzer.filterArrayList(type)) {
            if(token.getLexem().equals(text)){
                return true;
            }
        }
        return false;
    }
    private void createListGraph(TokenType type, JComboBox comboBox){
        try {
            comboBoxText = comboBox.getSelectedItem().toString();
            if(isValidLexeme(type, comboBoxText)){
                simpleList = new SimpleList();
                simpleList.setNodes(comboBoxText);
                simpleList.drawGraphviz();
            }
        } catch (Exception e){}
    }
    private void jComboBoxIDActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.IDENTIFIER, jComboBoxID);
    }

    private void jComboBoxArithmeticActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.ARITHMETIC,jComboBoxArithmetic);
    }

    private void jComboBoxComparisonActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.COMPARASION,jComboBoxComparison);
    }

    private void jComboBoxAssignActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.ASSIGNMENT,jComboBoxAssign);
    }

    private void jComboBoxKeyWordsActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.KEYWORD,jComboBoxKeyWords);
    }

    private void jComboBoxConstantActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.CONSTANT,jComboBoxConstant);
    }

    private void jComboBoxCommentActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.COMMENT,jComboBoxComment);
    }

    private void jComboBoxLogicsActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.LOGIC,jComboBoxLogics);
    }

    private void jComboBoxOthersActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.OTHERS, jComboBoxOthers);
    }

    private void jComboBoxErrorsActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.ERROR,jComboBoxErrors);
    }

    private void jLabelAnalyzeMouseClicked(java.awt.event.MouseEvent evt) {
        //ANALIZAR TEXTO
        analyzer = new Analyzer(jTextPaneAnalyze.getText());
        analyzer.analyze();
        //MOSTRAR ERRORES
        jTextPaneError.setText(analyzer.filterArrayList(TokenType.ERROR).toString());
        //PINTAR TOKENS
        PaintWords paintWords = new PaintWords();
        paintWords.setStyle(jTextPaneAnalyze.getText());
        paintWords.paintTokens(analyzer);
        jTextPaneAnalyze.setDocument(paintWords.textPane.getDocument());
        //LLENAR LAS COMBO BOX DE LOS TOKENS
        fillComboBox();
        //LLENANDO LA TABLA DE REPORTES
        reports = new Reports(analyzer.getTokens());
        jPanelReportTable.removeAll();
        reports.table(jPanelReportTable);
    }

    private void fillComboBox(){
        jComboBoxID.removeAllItems();
        jComboBoxArithmetic.removeAllItems();
        jComboBoxAssign.removeAllItems();
        jComboBoxComment.removeAllItems();
        jComboBoxKeyWords.removeAllItems();
        jComboBoxComparison.removeAllItems();
        jComboBoxConstant.removeAllItems();
        jComboBoxOthers.removeAllItems();
        jComboBoxErrors.removeAllItems();
        jComboBoxLogics.removeAllItems();

        for (Token token : analyzer.filterArrayList(TokenType.IDENTIFIER)) {
            jComboBoxID.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.ARITHMETIC)) {
            jComboBoxArithmetic.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.COMPARASION)) {
            jComboBoxComparison.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.ASSIGNMENT)) {
            jComboBoxAssign.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.KEYWORD)) {
            jComboBoxKeyWords.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.CONSTANT)) {
            jComboBoxConstant.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.COMMENT)) {
            jComboBoxComment.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.OTHERS)) {
            jComboBoxOthers.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.ERROR)) {
            jComboBoxErrors.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.LOGIC)) {
            jComboBoxLogics.addItem(token.getLexem());
        }
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextPaneAnalyze.setText(ReaderText.Read());
    }

    private void jButtonReportCommentActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            reports = new Reports(analyzer.filterArrayList(TokenType.COMMENT));
            jPanelReportTable.removeAll();
            reports.table(jPanelReportTable);
            SwingUtilities.updateComponentTreeUI(jPanelReportTable);
        } catch (Exception e){

        }
    }

    private void changeReport(ArrayList<Token> tokens){
        try{
            reports = new Reports(tokens);
            jPanelReportTable.removeAll();
            reports.table(jPanelReportTable);
            SwingUtilities.updateComponentTreeUI(jPanelReportTable);
        } catch (Exception e){}
    }

    private void jButtonReportAllActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.getTokens());
    }

    private void jButtonReportIDActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.IDENTIFIER));
    }

    private void jButtonReportArithmeticActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.ARITHMETIC));
    }

    private void jButtonReportCompareActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.COMPARASION));
    }

    private void jButtonReportAssignActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.ASSIGNMENT));
    }

    private void jButtonReportKeyWordActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.KEYWORD));
    }

    private void jButtonReportConstantActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.CONSTANT));
    }

    private void jButtonReportOthersActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.OTHERS));
    }

    private void jButtonReportLogicsActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.LOGIC));
    }

    private void jButtonReportErrActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.ERROR));
    }

    public static void InitUI(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonCreateGraph;
    private javax.swing.JButton jButtonReportAll;
    private javax.swing.JButton jButtonReportArithmetic;
    private javax.swing.JButton jButtonReportAssign;
    private javax.swing.JButton jButtonReportComment;
    private javax.swing.JButton jButtonReportCompare;
    private javax.swing.JButton jButtonReportConstant;
    private javax.swing.JButton jButtonReportErr;
    private javax.swing.JButton jButtonReportID;
    private javax.swing.JButton jButtonReportKeyWord;
    private javax.swing.JButton jButtonReportLogics;
    private javax.swing.JButton jButtonReportOthers;
    private javax.swing.JComboBox<String> jComboBoxArithmetic;
    private javax.swing.JComboBox<String> jComboBoxAssign;
    private javax.swing.JComboBox<String> jComboBoxComment;
    private javax.swing.JComboBox<String> jComboBoxComparison;
    private javax.swing.JComboBox<String> jComboBoxConstant;
    private javax.swing.JComboBox<String> jComboBoxErrors;
    private javax.swing.JComboBox<String> jComboBoxID;
    private javax.swing.JComboBox<String> jComboBoxKeyWords;
    private javax.swing.JComboBox<String> jComboBoxLogics;
    private javax.swing.JComboBox<String> jComboBoxOthers;
    private javax.swing.JEditorPane jPanelGraphviz;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAnalyze;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanelReportTable;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanelAbout;
    private javax.swing.JPanel jPanelAnalyze;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelFile;
    private javax.swing.JPanel jPanelGraph;
    private javax.swing.JPanel jPanelHelp;
    private javax.swing.JPanel jPanelReport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaAbout;
    private javax.swing.JTextArea jTextAreaHelp;
    private javax.swing.JTextPane jTextPaneAnalyze;
    private javax.swing.JTextPane jTextPaneError;
    // End of variables declaration
}