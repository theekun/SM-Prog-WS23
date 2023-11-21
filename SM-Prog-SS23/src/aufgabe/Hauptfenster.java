package aufgabe;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Hauptfenster {
	
	public static void main(String[] args) {
		
        JFrame frame = new JFrame("Meine Anwendung");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Aktivieren Sie Double Buffering für den JFrame
        ((JComponent) frame.getContentPane()).setDoubleBuffered(true);
        
        MainContent content = new MainContent();
        frame.setContentPane(content);
        frame.setVisible(true);
    }
}


