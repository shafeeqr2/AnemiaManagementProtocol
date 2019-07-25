package application;


import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.itextpdf.text.Paragraph;


public class Hgb_lt_85_or_dc_gt_15 extends JPanel {

	/**
	 * Create the panel.
	 */
	
	//AMP_View window;
	private JButton btnGeneratePDF = new JButton("Generate PDF");
		
	private JButton button = new JButton("< Back");
	
	private JLabel text = new JLabel("");
	private JLabel text2 = new JLabel("");
	private JLabel text3 = new JLabel("Notify MD");
	
	public JLabel get_text() {
		return text;
	}
	
	public JLabel get_text2() {
		return text2;
	}
	
	public JLabel get_text3() {
		return text3;
	}

	public void set_text(String string) {
		this.text.setText(string);
	}
	
	public void set_text2(String string) {
		this.text2.setText(string);
	}
	
	public Hgb_lt_85_or_dc_gt_15() {
		//this.window = window
		setLayout(null);
		
		text.setBounds(12, 40, 400, 40);
		add(text);
		
		
		text2.setBounds(12, 83, 400, 40);
		add(text2);
		
		text3.setBounds(12, 126, 400, 40);
		text3.setVisible(false);
		add(text3);
				
		button.setBounds(351, 296, 89, 23);
		add(button);
		
		btnGeneratePDF.setBounds(253, 296, 99, 23);
		add(btnGeneratePDF);
		btnGeneratePDF.setVisible(true);
	
	}

	public JButton back() {
		return button;
	}
	
	public JButton generate_pdf(){
		return btnGeneratePDF;
	}
	
}
