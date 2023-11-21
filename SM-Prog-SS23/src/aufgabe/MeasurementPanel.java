package aufgabe;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MeasurementPanel extends JPanel {

     // Definieren Sie die Beschriftungen für die Achsen
    private final String xAxisLabel = "Messwert";
    private final String yAxisLabel = "Puls / Blutdruck";
    
    // Referenz auf MainContent
    private MainContent content;
    
    // Konstruktor
    public MeasurementPanel(MainContent content){
        this.content = content;

        setDoubleBuffered(true);
    }

    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Die Größe des Panels abrufen
        int width = getWidth();
        int height = getHeight();

        // Die Achsenlinien zeichnen
        g.drawLine(50, height - 50, width - 50, height - 50); // x-Achse
        g.drawLine(50, height - 50, 50, 50); // y-Achse

        // Die Achsenbeschriftungen zeichnen
        FontMetrics fontMetrics = g.getFontMetrics();
        int xAxisLabelWidth = fontMetrics.stringWidth(xAxisLabel);
        int yAxisLabelWidth = fontMetrics.stringWidth(yAxisLabel);

        // x-Achse Beschriftung
        g.drawString(xAxisLabel, (width - xAxisLabelWidth) / 2, height - 20);

        // y-Achse Beschriftungen
        int yAxisLabelX = 10;
        int yAxisLabelY = (height + yAxisLabelWidth) / 2;
        g.drawString(yAxisLabel, yAxisLabelX, yAxisLabelY);

        // Die zweite y-Achse Beschriftung (für Blutdruck)
        String bloodPressureLabel = "Blutdruck";
        int bloodPressureLabelWidth = fontMetrics.stringWidth(bloodPressureLabel);
        g.drawString(bloodPressureLabel, yAxisLabelX, yAxisLabelY - bloodPressureLabelWidth);

         // Hier könnten Sie die Messwerte abrufen und als Punkte zeichnen
        Measurement[] measurementsArray = content.getCurrentTest().getMeasurements();
        drawMeasurementPoints(measurementsArray);
        repaint();
    }

    
     // Methode zum Zeichnen der Messwerte als Punkte
    public void drawMeasurementPoints(Measurement[] measurements) {
        if (measurements == null) {
            // Wenn die Messwerte null sind, keine Punkte zeichnen
            return;
        }

        Graphics g = getGraphics();
        int height = getHeight() - 100; // Berücksichtigen Sie den Abstand der Achsen

        // Schleife über alle Messwerte und Zeichnen der Punkte
        for (int i = 0; i < measurements.length; i++) {
            int x = 50 + i * 20; // Horizontaler Abstand zwischen den Punkten
            int y = height - measurements[i].getPulse(); // Umkehren der y-Koordinate, da y nach unten zunimmt
            g.fillOval(x, y, 5, 5); // Zeichnen des Punkts (Durchmesser: 5x5)
        }
    }
    
    
}
