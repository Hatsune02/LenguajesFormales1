package frontend;

import backend.Analyzer;
import backend.ReaderText;
import backend.Token;
import backend.TokenType;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UI extends javax.swing.JFrame {
    Analyzer analyzer;
    SimpleList simpleList;
    CreateHTML png;
    PNGFrame pngFrame;
    LineNumber lineNumber, lineNumber2;
    Reports reports;
    String comboBoxText;

    public UI() {

        initComponents();

        jPanelGraphviz = new JEditorPane();
        setTitle("Parser-Py");
        AutoCompleteDecorator.decorate(jComboBoxID);
        AutoCompleteDecorator.decorate(jComboBoxArithmetic);
        AutoCompleteDecorator.decorate(jComboBoxAssign);
        AutoCompleteDecorator.decorate(jComboBoxComment);
        AutoCompleteDecorator.decorate(jComboBoxKeyWords);
        AutoCompleteDecorator.decorate(jComboBoxComparison);
        AutoCompleteDecorator.decorate(jComboBoxInt);
        AutoCompleteDecorator.decorate(jComboBoxOthers);
        AutoCompleteDecorator.decorate(jComboBoxLogics);
        AutoCompleteDecorator.decorate(jComboBoxDecimal);
        AutoCompleteDecorator.decorate(jComboBoxString);
        AutoCompleteDecorator.decorate(jComboBoxErrors);
        jComboBoxComment.setPreferredSize(new Dimension());

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

        jPanelCentral = new JPanel();
        jTabbedPane1 = new JTabbedPane();
        jPanelFile = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextPaneAnalyze = new JTextPane();
        jPanelAnalyze = new JPanel();
        jLabelAnalyze = new JLabel();
        jScrollPane2 = new JScrollPane();
        jTextPaneError = new JTextPane();
        jLabel3 = new JLabel();
        jScrollPane3 = new JScrollPane();
        jPanelGraph = new JPanel();
        jPanel17 = new JPanel();
        jComboBoxID = new JComboBox<>();
        jLabel10 = new JLabel();
        //jPanelGraphviz = new JEditorPane();
        jButtonID = new JButton();
        jPanel18 = new JPanel();
        jComboBoxArithmetic = new JComboBox<>();
        jLabel11 = new JLabel();
        jPanel20 = new JPanel();
        jComboBoxComparison = new JComboBox<>();
        jLabel13 = new JLabel();
        jPanel21 = new JPanel();
        jComboBoxAssign = new JComboBox<>();
        jLabel14 = new JLabel();
        jPanel22 = new JPanel();
        jComboBoxLogics = new JComboBox<>();
        jLabel15 = new JLabel();
        jPanel23 = new JPanel();
        jComboBoxKeyWords = new JComboBox<>();
        jLabel16 = new JLabel();
        jPanel24 = new JPanel();
        jComboBoxComment = new JComboBox<>();
        jLabel17 = new JLabel();
        jPanel25 = new JPanel();
        jComboBoxInt = new JComboBox<>();
        jLabel18 = new JLabel();
        jPanel26 = new JPanel();
        jComboBoxOthers = new JComboBox<>();
        jLabel19 = new JLabel();
        jPanel27 = new JPanel();
        jComboBoxErrors = new JComboBox<>();
        jLabel20 = new JLabel();
        jPanel28 = new JPanel();
        jComboBoxDecimal = new JComboBox<>();
        jLabel21 = new JLabel();
        jPanel29 = new JPanel();
        jComboBoxString = new JComboBox<>();
        jLabel22 = new JLabel();
        jPanelReport = new JPanel();
        jPanelReportTable = new JPanel();
        jButtonReportAll = new JButton();
        jButtonReportID = new JButton();
        jButtonReportArithmetic = new JButton();
        jButtonReportCompare = new JButton();
        jButtonReportAssign = new JButton();
        jButtonReportKeyWord = new JButton();
        jButtonReportInt = new JButton();
        jButtonReportComment = new JButton();
        jButtonReportOthers = new JButton();
        jButtonReportErr = new JButton();
        jButtonReportLogics = new JButton();
        jButtonReportDecimal = new JButton();
        jButtonReportString = new JButton();
        jPanelHelp = new JPanel();
        jScrollPane5 = new JScrollPane();
        jTextAreaHelp = new JTextArea();
        jPanelAbout = new JPanel();
        jScrollPane4 = new JScrollPane();
        jTextAreaAbout = new JTextArea();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanelCentral.setBackground(new Color(51, 255, 255));
        jPanelCentral.setPreferredSize(new Dimension(880, 670));


        jPanelFile.setBackground(new Color(0, 105, 105));

        jScrollPane1.setViewportView(jTextPaneAnalyze);

        jPanelAnalyze.setBackground(new Color(51, 255, 204));

        jLabelAnalyze.setFont(new Font("Liberation Serif", 0, 18)); // NOI18N
        jLabelAnalyze.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelAnalyze.setText("Analizar");
        jLabelAnalyze.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelAnalyze.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabelAnalyzeMouseClicked(evt);
            }
        });

        GroupLayout jPanelAnalyzeLayout = new GroupLayout(jPanelAnalyze);
        jPanelAnalyze.setLayout(jPanelAnalyzeLayout);
        jPanelAnalyzeLayout.setHorizontalGroup(
                jPanelAnalyzeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelAnalyze, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        jPanelAnalyzeLayout.setVerticalGroup(
                jPanelAnalyzeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelAnalyze, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jTextPaneError);

        jLabel3.setFont(new Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel3.setText("ERROR");

        GroupLayout jPanelFileLayout = new GroupLayout(jPanelFile);
        jPanelFile.setLayout(jPanelFileLayout);
        jPanelFileLayout.setHorizontalGroup(
                jPanelFileLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanelFileLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(764, Short.MAX_VALUE))
                                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                                .addGroup(jPanelFileLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane2)
                                                        .addComponent(jScrollPane1))
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanelAnalyze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32))))
        );
        jPanelFileLayout.setVerticalGroup(
                jPanelFileLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                .addGroup(jPanelFileLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jPanelAnalyze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelFileLayout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Archivo", jPanelFile);

        jPanelGraph.setBackground(new Color(0, 51, 102));

        jPanel17.setBackground(new Color(0, 51, 102));
        jPanel17.setForeground(new Color(0, 51, 153));

        jComboBoxID.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxIDActionPerformed(evt);
            }
        });

        jLabel10.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel10.setForeground(new Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel10.setText("Identificadores");

        GroupLayout jPanel17Layout = new GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxID, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxID, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );


        jButtonID.setBackground(new Color(0, 0, 0));
        jButtonID.setForeground(new Color(255, 255, 255));
        jButtonID.setText("Crear");
        jButtonID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCreateGraphActionPerformed(evt);
            }
        });

        jPanel18.setBackground(new Color(0, 51, 102));
        jPanel18.setForeground(new Color(0, 51, 153));

        jComboBoxArithmetic.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxArithmetic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxArithmeticActionPerformed(evt);
            }
        });

        jLabel11.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel11.setForeground(new Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setText("Aritméticos");

        GroupLayout jPanel18Layout = new GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxArithmetic, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxArithmetic, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new Color(0, 51, 102));
        jPanel20.setForeground(new Color(0, 51, 153));

        jComboBoxComparison.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxComparison.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxComparisonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel13.setForeground(new Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel13.setText("Comparación");

        GroupLayout jPanel20Layout = new GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
                jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxComparison, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
                jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxComparison, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new Color(0, 51, 102));
        jPanel21.setForeground(new Color(0, 51, 153));

        jComboBoxAssign.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxAssign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxAssignActionPerformed(evt);
            }
        });

        jLabel14.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel14.setForeground(new Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel14.setText("Asignación");

        GroupLayout jPanel21Layout = new GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
                jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxAssign, 0, 217, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
                jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxAssign, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new Color(0, 51, 102));
        jPanel22.setForeground(new Color(0, 51, 153));

        jComboBoxLogics.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxLogics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxLogicsActionPerformed(evt);
            }
        });

        jLabel15.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel15.setForeground(new Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel15.setText("Lógicos");

        GroupLayout jPanel22Layout = new GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
                jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxLogics, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
                jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxLogics, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new Color(0, 51, 102));
        jPanel23.setForeground(new Color(0, 51, 153));

        jComboBoxKeyWords.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxKeyWords.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxKeyWordsActionPerformed(evt);
            }
        });

        jLabel16.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel16.setForeground(new Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel16.setText("Palabras clave");

        GroupLayout jPanel23Layout = new GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
                jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxKeyWords, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
                jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxKeyWords, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new Color(0, 51, 102));
        jPanel24.setForeground(new Color(0, 51, 153));

        jComboBoxComment.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxComment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxCommentActionPerformed(evt);
            }
        });

        jLabel17.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel17.setForeground(new Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel17.setText("Comentarios");

        GroupLayout jPanel24Layout = new GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
                jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxComment, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
                jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxComment, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new Color(0, 51, 102));
        jPanel25.setForeground(new Color(0, 51, 153));

        jComboBoxInt.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxInt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxIntActionPerformed(evt);
            }
        });

        jLabel18.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel18.setForeground(new Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel18.setText("Entero");

        GroupLayout jPanel25Layout = new GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
                jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxInt, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
                jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxInt, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new Color(0, 51, 102));
        jPanel26.setForeground(new Color(0, 51, 153));

        jComboBoxOthers.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxOthers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxOthersActionPerformed(evt);
            }
        });

        jLabel19.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel19.setForeground(new Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel19.setText("Otros");

        GroupLayout jPanel26Layout = new GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
                jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxOthers, 0, 217, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
                jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxOthers, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new Color(0, 51, 102));
        jPanel27.setForeground(new Color(0, 51, 153));

        jComboBoxErrors.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxErrors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxErrorsActionPerformed(evt);
            }
        });

        jLabel20.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel20.setForeground(new Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel20.setText("Errores");

        GroupLayout jPanel27Layout = new GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
                jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxErrors, 0, 229, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
                jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxErrors, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new Color(0, 51, 102));
        jPanel28.setForeground(new Color(0, 51, 153));

        jComboBoxDecimal.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDecimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxDecimalActionPerformed(evt);
            }
        });

        jLabel21.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel21.setForeground(new Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel21.setText("Decimal");

        GroupLayout jPanel28Layout = new GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
                jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDecimal, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
                jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel28Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxDecimal, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new Color(0, 51, 102));
        jPanel29.setForeground(new Color(0, 51, 153));

        jComboBoxString.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxString.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBoxStringActionPerformed(evt);
            }
        });

        jLabel22.setFont(new Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel22.setForeground(new Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel22.setText("Cadena");

        GroupLayout jPanel29Layout = new GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
                jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                                .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxString, 0, 229, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
                jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxString, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
        );

        GroupLayout jPanelGraphLayout = new GroupLayout(jPanelGraph);
        jPanelGraph.setLayout(jPanelGraphLayout);
        jPanelGraphLayout.setHorizontalGroup(
                jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelGraphLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPanel28, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel25, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPanel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel22, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel23, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel24, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(58, 58, 58))
                        .addGroup(jPanelGraphLayout.createSequentialGroup()
                                .addGap(425, 425, 425)
                                .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelGraphLayout.createSequentialGroup()
                                                //.addComponent(jPanelGraphviz, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanelGraphLayout.createSequentialGroup()
                                                .addComponent(jButtonID, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(403, 403, 403))))
        );
        jPanelGraphLayout.setVerticalGroup(
                jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelGraphLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelGraphLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(jButtonID, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                //.addComponent(jPanelGraphviz)
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Generar Grafico", jPanelGraph);

        jPanelReport.setBackground(new Color(0, 0, 0));

        GroupLayout jPanel1Layout = new GroupLayout(jPanelReportTable);
        jPanelReportTable.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 420, Short.MAX_VALUE)
        );

        jButtonReportAll.setBackground(new Color(0, 0, 0));
        jButtonReportAll.setForeground(new Color(255, 255, 255));
        jButtonReportAll.setText("Todos");
        jButtonReportAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportAllActionPerformed(evt);
            }
        });

        jButtonReportID.setBackground(new Color(0, 0, 0));
        jButtonReportID.setForeground(new Color(255, 255, 255));
        jButtonReportID.setText("Identificadores");
        jButtonReportID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportIDActionPerformed(evt);
            }
        });

        jButtonReportArithmetic.setBackground(new Color(0, 0, 0));
        jButtonReportArithmetic.setForeground(new Color(255, 255, 255));
        jButtonReportArithmetic.setText("Aritméticos");
        jButtonReportArithmetic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportArithmeticActionPerformed(evt);
            }
        });

        jButtonReportCompare.setBackground(new Color(0, 0, 0));
        jButtonReportCompare.setForeground(new Color(255, 255, 255));
        jButtonReportCompare.setText("Comparación");
        jButtonReportCompare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportCompareActionPerformed(evt);
            }
        });

        jButtonReportAssign.setBackground(new Color(0, 0, 0));
        jButtonReportAssign.setForeground(new Color(255, 255, 255));
        jButtonReportAssign.setText("Asignación");
        jButtonReportAssign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportAssignActionPerformed(evt);
            }
        });

        jButtonReportKeyWord.setBackground(new Color(0, 0, 0));
        jButtonReportKeyWord.setForeground(new Color(255, 255, 255));
        jButtonReportKeyWord.setText("Palabra clave");
        jButtonReportKeyWord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportKeyWordActionPerformed(evt);
            }
        });

        jButtonReportInt.setBackground(new Color(0, 0, 0));
        jButtonReportInt.setForeground(new Color(255, 255, 255));
        jButtonReportInt.setText("Entero");
        jButtonReportInt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportIntActionPerformed(evt);
            }
        });

        jButtonReportComment.setBackground(new Color(0, 0, 0));
        jButtonReportComment.setForeground(new Color(255, 255, 255));
        jButtonReportComment.setText("Comentarios");
        jButtonReportComment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportCommentActionPerformed(evt);
            }
        });

        jButtonReportOthers.setBackground(new Color(0, 0, 0));
        jButtonReportOthers.setForeground(new Color(255, 255, 255));
        jButtonReportOthers.setText("Otros");
        jButtonReportOthers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportOthersActionPerformed(evt);
            }
        });

        jButtonReportErr.setBackground(new Color(0, 0, 0));
        jButtonReportErr.setForeground(new Color(255, 255, 255));
        jButtonReportErr.setText("Errores");
        jButtonReportErr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportErrActionPerformed(evt);
            }
        });

        jButtonReportLogics.setBackground(new Color(0, 0, 0));
        jButtonReportLogics.setForeground(new Color(255, 255, 255));
        jButtonReportLogics.setText("Lógicos ");
        jButtonReportLogics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportLogicsActionPerformed(evt);
            }
        });

        jButtonReportDecimal.setBackground(new Color(0, 0, 0));
        jButtonReportDecimal.setForeground(new Color(255, 255, 255));
        jButtonReportDecimal.setText("Decimal");
        jButtonReportDecimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportDecimalActionPerformed(evt);
            }
        });

        jButtonReportString.setBackground(new Color(0, 0, 0));
        jButtonReportString.setForeground(new Color(255, 255, 255));
        jButtonReportString.setText("Cadena");
        jButtonReportString.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonReportStringActionPerformed(evt);
            }
        });

        GroupLayout jPanelReportLayout = new GroupLayout(jPanelReport);
        jPanelReport.setLayout(jPanelReportLayout);
        jPanelReportLayout.setHorizontalGroup(
                jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelReportTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelReportLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonReportErr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReportAll, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                        .addComponent(jButtonReportAssign, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonReportID, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                        .addComponent(jButtonReportKeyWord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonReportArithmetic, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                        .addComponent(jButtonReportLogics, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonReportInt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReportDecimal, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonReportCompare, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                        .addComponent(jButtonReportComment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonReportString, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                        .addComponent(jButtonReportOthers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30))
        );
        jPanelReportLayout.setVerticalGroup(
                jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelReportLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonReportAll)
                                        .addComponent(jButtonReportID)
                                        .addComponent(jButtonReportArithmetic, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonReportInt)
                                        .addComponent(jButtonReportComment)
                                        .addComponent(jButtonReportString))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelReportLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonReportKeyWord)
                                        .addComponent(jButtonReportAssign)
                                        .addComponent(jButtonReportLogics)
                                        .addComponent(jButtonReportCompare)
                                        .addComponent(jButtonReportDecimal, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonReportOthers, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jButtonReportErr)
                                .addGap(18, 18, 18)
                                .addComponent(jPanelReportTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("Reporte", jPanelReport);

        jPanelHelp.setBackground(new Color(0, 216, 118));

        jTextAreaHelp.setColumns(20);
        jTextAreaHelp.setRows(5);
        jScrollPane5.setViewportView(jTextAreaHelp);

        GroupLayout jPanelHelpLayout = new GroupLayout(jPanelHelp);
        jPanelHelp.setLayout(jPanelHelpLayout);
        jPanelHelpLayout.setHorizontalGroup(
                jPanelHelpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelHelpLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 832, GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
        );
        jPanelHelpLayout.setVerticalGroup(
                jPanelHelpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelHelpLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(212, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ayuda", jPanelHelp);

        jPanelAbout.setBackground(new Color(0, 216, 118));

        jTextAreaAbout.setColumns(20);
        jTextAreaAbout.setRows(5);
        jScrollPane4.setViewportView(jTextAreaAbout);

        GroupLayout jPanelAboutLayout = new GroupLayout(jPanelAbout);
        jPanelAbout.setLayout(jPanelAboutLayout);
        jPanelAboutLayout.setHorizontalGroup(
                jPanelAboutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelAboutLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 832, GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
        );
        jPanelAboutLayout.setVerticalGroup(
                jPanelAboutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelAboutLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(212, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Acerca de", jPanelAbout);

        GroupLayout jPanelCentralLayout = new GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
                jPanelCentralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        jPanelCentralLayout.setVerticalGroup(
                jPanelCentralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Cargar");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelCentral, GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelCentral, GroupLayout.PREFERRED_SIZE, 619, Short.MAX_VALUE)
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

    private void jComboBoxIntActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.INT, jComboBoxInt);
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

    private void jComboBoxDecimalActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.DECIMAL,jComboBoxDecimal);
    }

    private void jComboBoxStringActionPerformed(java.awt.event.ActionEvent evt) {
        createListGraph(TokenType.STRING,jComboBoxString);
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
        jComboBoxInt.removeAllItems();
        jComboBoxOthers.removeAllItems();
        jComboBoxErrors.removeAllItems();
        jComboBoxLogics.removeAllItems();
        jComboBoxDecimal.removeAllItems();
        jComboBoxString.removeAllItems();

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
        for (Token token : analyzer.filterArrayList(TokenType.INT)) {
            jComboBoxInt.addItem(token.getLexem());
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
        for (Token token : analyzer.filterArrayList(TokenType.DECIMAL)) {
            jComboBoxDecimal.addItem(token.getLexem());
        }
        for (Token token : analyzer.filterArrayList(TokenType.STRING)) {
            jComboBoxString.addItem(token.getLexem());
        }
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextPaneAnalyze.setText(ReaderText.Read());
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

    private void jButtonReportIntActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.INT));
    }

    private void jButtonReportOthersActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.OTHERS));
    }

    private void jButtonReportLogicsActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.LOGIC));
    }

    private void jButtonReportDecimalActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.DECIMAL));
    }

    private void jButtonReportStringActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.STRING));
    }

    private void jButtonReportCommentActionPerformed(java.awt.event.ActionEvent evt) {
        changeReport(analyzer.filterArrayList(TokenType.COMMENT));
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
    private javax.swing.JButton jButtonID;
    private javax.swing.JButton jButtonReportAll;
    private javax.swing.JButton jButtonReportArithmetic;
    private javax.swing.JButton jButtonReportAssign;
    private javax.swing.JButton jButtonReportComment;
    private javax.swing.JButton jButtonReportCompare;
    private javax.swing.JButton jButtonReportInt;
    private javax.swing.JButton jButtonReportDecimal;
    private javax.swing.JButton jButtonReportErr;
    private javax.swing.JButton jButtonReportID;
    private javax.swing.JButton jButtonReportKeyWord;
    private javax.swing.JButton jButtonReportLogics;
    private javax.swing.JButton jButtonReportOthers;
    private javax.swing.JButton jButtonReportString;
    private javax.swing.JComboBox<String> jComboBoxArithmetic;
    private javax.swing.JComboBox<String> jComboBoxAssign;
    private javax.swing.JComboBox<String> jComboBoxComment;
    private javax.swing.JComboBox<String> jComboBoxComparison;
    private javax.swing.JComboBox<String> jComboBoxInt;
    private javax.swing.JComboBox<String> jComboBoxErrors;
    private javax.swing.JComboBox<String> jComboBoxID;
    private javax.swing.JComboBox<String> jComboBoxKeyWords;
    private javax.swing.JComboBox<String> jComboBoxLogics;
    private javax.swing.JComboBox<String> jComboBoxOthers;
    private javax.swing.JComboBox<String> jComboBoxDecimal;
    private javax.swing.JComboBox<String> jComboBoxString;
    private javax.swing.JEditorPane jPanelGraphviz;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAnalyze;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanelReportTable;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
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