import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RunAction extends AbstractAction {

	private JTextArea input;
	private JTextArea output;
	private JFrame frame;
	private JTextField cmd;

	public RunAction(JFrame frame, JTextArea input, JTextArea output, JTextField cmd) {
		super("Run");
		this.frame = frame;
		this.input = input;
		this.output = output;
		this.cmd = cmd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		try {
			Process r = Runtime.getRuntime().exec(cmd.getText());
			OutputStream processIn = r.getOutputStream();
			InputStream processOut = r.getInputStream();
			InputStream processErr = r.getErrorStream();
			
			processIn.write(input.getText().getBytes("UTF-8"));
			processIn.close();
			
			
			r.waitFor();
			
			ByteArrayOutputStream s2 = new ByteArrayOutputStream();
			int c;
			while ((c = processOut.read()) != -1) {
				s2.write(c);
			}
			output.setText(s2.toString("UTF-8"));
				
			ByteArrayOutputStream s3 = new ByteArrayOutputStream();
			while ((c = processErr.read()) != -1) {
				s3.write(c);
			}
			
			String err = s3.toString("UTF-8");
			
			if (!err.equals("")) {
				JOptionPane.showMessageDialog(frame, err);
			}
			
			
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, e1.getMessage());
		}

	}

}
