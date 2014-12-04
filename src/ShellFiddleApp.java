import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class ShellFiddleApp extends JFrame {
	
	
	public ShellFiddleApp() {
		
		
		
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);

		
		getContentPane().add(toolbar, BorderLayout.PAGE_START);
		
		
		JTextArea input = new JTextArea();
		input.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		input.setForeground(new Color(0x00201000));
		input.setBackground(new Color(0x00FFF8F0));
		
		
		
		JTextArea output = new JTextArea();
		output.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		output.setForeground(new Color(0x00E0FFE0));
		output.setBackground(new Color(0x00002030));
		output.setEditable(false);
		
		
		JTextField cmd = new JTextField();

		RunAction runAction = new RunAction(this, input, output, cmd);
		
		
		toolbar.add(runAction);
			
		toolbar.add(cmd);

		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(input), new JScrollPane(output));
		splitPane.setResizeWeight(0.75);
		
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		
	}
	
	
	public static void main(String[] args) {
		ShellFiddleApp app = new ShellFiddleApp();
		app.setSize(800, 600);
		app.setTitle("ShellFiddle");
		app.setVisible(true);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}

}
