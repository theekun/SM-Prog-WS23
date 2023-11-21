package aufgabe;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainContent extends JPanel {

    private GenericTest[] tests;        //  Array fuer 10 Objekte des Typs GenericTest
    private int numTests;               //  zaehler
    private GenericTest currentTest;    //  referenz zum aktuellen test

    
	public MainContent() {
        tests = new GenericTest[10];
        numTests = 0;
        //currentTest = null;
        addComponents();
    
    }	

    // methode um die inhalte dem panel hinzuzufuegen
    private void addComponents() {
        
        // Hier werden die Inhalte meines Panels definiert
		
        // Backgroundcolor
        //this.setBackground(new Color(255, 0, 255));
        this.setLayout(new BorderLayout());

		// Menüleiste erstellen
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0, 204, 0));
        this.add(menuBar, BorderLayout.NORTH);

        // Menüs erstellen
        JMenu testMenu = new JMenu("Test");
        menuBar.add(testMenu);

        JMenu dataMenu = new JMenu("Daten");
        menuBar.add(dataMenu);

        JMenu fileMenu = new JMenu("Datei");
        menuBar.add(fileMenu);

        // Füge hier ComboBox ein
        JComboBox<String> testComboBox = new JComboBox<String>();
        testComboBox.setBackground(new Color(204, 0, 0));
        //this.add(testComboBox, BorderLayout.EAST);
        testComboBox.setPreferredSize(new Dimension(200, 30));
        
		
        // Elemente der ComboBox hinzufuegen
        //testComboBox.addItem("Test1");
        //testComboBox.addItem("Test 2");

        // Menüelemente erstellen
        JMenuItem newTest = new JMenuItem("Neuer Test");
        testMenu.add(newTest);

        newTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (numTests < tests.length) {
                    if (numTests % 2 == 0) {
                        tests[numTests] = new FitnessTest("Test " + (numTests + 1));
                    } else {
                        tests[numTests] = new SchellongTest("Test " + (numTests + 1));
                    }
                    currentTest = tests[numTests];
                    testComboBox.addItem(currentTest.getName());
                    numTests++;
                    repaint();
                    
                    
                }
            }
        });

        JMenuItem startTest = new JMenuItem("Test starten");
        testMenu.add(startTest);

        startTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(startTest,"noch nicht implementiert");
            }
        });

        JMenuItem readData = new JMenuItem("Daten einlesen");
        dataMenu.add(readData);

        readData.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                currentTest.readValues();
                
                createMeasurementPanel(); // Erstelle das MeasurementPanel, nachdem ein Test erstellt wurde
            }
        });



        JMenuItem saveTests = new JMenuItem("Tests speichern");
        fileMenu.add(saveTests);

        saveTests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(saveTests,"noch nicht implementiert");
            }
        });

        JMenuItem loadTests = new JMenuItem("Tests laden");
        fileMenu.add(loadTests);

        loadTests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(loadTests,"noch nicht implementiert");
            }
        });

        JMenuItem changeName = new JMenuItem("Testnamen ändern");
        fileMenu.add(changeName);

        changeName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(changeName,"noch nicht implementiert");
            }
        });

        JMenuItem printTest = new JMenuItem("Test ausdrucken");
        fileMenu.add(printTest);

        printTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(printTest,"noch nicht implementiert");
            }
        });

        JMenuItem exitApp = new JMenuItem("Anwendung beenden");
        fileMenu.add(exitApp);

        exitApp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);

            }
        }); 

        // Button-Leiste erstellen
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(testComboBox);
        this.add(buttonPanel, BorderLayout.SOUTH);

        JButton startButton = new JButton("Test starten");
        buttonPanel.add(startButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(startButton,"noch nicht implementiert");
            }
        });


        JButton readButton = new JButton("Daten einlesen");
        buttonPanel.add(readButton);

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentTest.readValues();
                currentTest.print();
                System.out.print("Daten einlesen wurde geklickt!");
                
                createMeasurementPanel(); // Erstelle das MeasurementPanel, nachdem ein Test erstellt wurde
            }
        });

        JButton exitButton = new JButton("Anwendung beenden");
        buttonPanel.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        
       
        

        

        
    }

    // method to get reference to current test
    public GenericTest getCurrentTest() {
        return currentTest;
    }
    // Fügen Sie eine Methode hinzu, um die MeasurementPanel-Instanz zu erstellen und hinzuzufügen
    public void addMeasurementPanel() {
        MeasurementPanel measurementPanel = new MeasurementPanel(this);
        this.add(measurementPanel, BorderLayout.CENTER);
        this.revalidate(); // Aktualisieren Sie die Anzeige, um das neue Panel anzuzeigen
        //this.repaint();
    }

    // Verwenden Sie diese Methode, um die MeasurementPanel-Instanz zu erstellen und hinzuzufügen,
    // nachdem ein Test erstellt oder ausgewählt wurde
    private void createMeasurementPanel() {
        if (currentTest != null) {
            addMeasurementPanel();
        }
    }


}
