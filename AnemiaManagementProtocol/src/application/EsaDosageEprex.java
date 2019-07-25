package application;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EsaDosageEprex extends JPanel {
	
private ButtonGroup group;
	
	private JButton btnConfirm = new JButton("Next >");
	
	private JButton button = new JButton("< Back"); 

	private JRadioButton rdbtnTest_1 = new JRadioButton("1000 units every 1 week");

	private JRadioButton rdbtnTest_2 = new JRadioButton("2000 units every 1 week");

	private JRadioButton rdbtnTest_3 = new JRadioButton("3000 units every 1 week");

	private JRadioButton rdbtnTest_4 = new JRadioButton("2000 units 2 times per week");
	
	private JRadioButton rdbtnTest_5 = new JRadioButton("3000 units 2 times per week");
	
	private JRadioButton rdbtnTest_6 = new JRadioButton("4000 units 2 times per week");
	
	private JRadioButton rdbtnTest_7 = new JRadioButton("5000 units 2 times per week");
	
	private JRadioButton rdbtnTest_8 = new JRadioButton("6000 units 2 times per week");
	
	private JRadioButton rdbtnTest_9 = new JRadioButton("8000 units 2 times per week");

	private JRadioButton rdbtnTest_10 = new JRadioButton("10,000 units 2 times per week");
	
	private JRadioButton rdbtnTest_11 = new JRadioButton("8000 units 3 times per week");
	
	private JRadioButton rdbtnTest_12 = new JRadioButton("10,000 units 3 times per week");
	
	public String get_option() {
		
		if (rdbtnTest_1.isSelected()) return rdbtnTest_1.toString();
		else if (rdbtnTest_2.isSelected()) return rdbtnTest_2.getText();
		else if (rdbtnTest_3.isSelected()) return rdbtnTest_3.getText();
		
		else if (rdbtnTest_4.isSelected()) return rdbtnTest_4.getText();
		else if (rdbtnTest_5.isSelected()) return rdbtnTest_5.getText();
		else if (rdbtnTest_6.isSelected()) return rdbtnTest_6.getText();
		else if (rdbtnTest_7.isSelected()) return rdbtnTest_7.getText();
		else if (rdbtnTest_8.isSelected()) return rdbtnTest_8.getText();
		else if (rdbtnTest_9.isSelected()) return rdbtnTest_9.getText();
		else if (rdbtnTest_10.isSelected()) return rdbtnTest_10.getText();
		else if (rdbtnTest_10.isSelected()) return rdbtnTest_11.getText();
		else return rdbtnTest_12.getText();

		

	}
	
	public JRadioButton getRdbtnTest_1() {
		return rdbtnTest_1;
	}

	public JRadioButton getRdbtnTest_2() {
		return rdbtnTest_2;
	}

	public JRadioButton getRdbtnTest_3() {
		return rdbtnTest_3;
	}

	public JRadioButton getRdbtnTest_4() {
		return rdbtnTest_4;
	}

	public JRadioButton getRdbtnTest_5() {
		return rdbtnTest_5;
	}

	public JRadioButton getRdbtnTest_6() {
		return rdbtnTest_6;
	}

	public JRadioButton getRdbtnTest_7() {
		return rdbtnTest_7;
	}

	public JRadioButton getRdbtnTest_8() {
		return rdbtnTest_8;
	}

	public JRadioButton getRdbtnTest_9() {
		return rdbtnTest_9;
	}

	public JRadioButton getRdbtnTest_10() {
		return rdbtnTest_10;
	}

	public JRadioButton getRdbtnTest_11() {
		return rdbtnTest_11;
	}

	public JRadioButton getRdbtnTest_12() {
		return rdbtnTest_12;
	}

	public EsaDosageEprex() {
		//this.window = window;
		setBorder(null);
		setLayout(null);
		
		JLabel lblIsThePatient = new JLabel("Please select the Eprex Dosage: ");
		lblIsThePatient.setBounds(141, 11, 192, 24);
		add(lblIsThePatient);
		
		rdbtnTest_1.setBounds(25, 42, 250, 23);
		add(rdbtnTest_1);

		rdbtnTest_2.setBounds(25, 72, 250, 23);
		add(rdbtnTest_2);

		rdbtnTest_3.setBounds(25, 102, 250, 23);
		add(rdbtnTest_3);
		
		rdbtnTest_4.setBounds(25, 132, 250, 23);
		add(rdbtnTest_4);
		
		rdbtnTest_5.setBounds(25, 162, 250, 23);
		add(rdbtnTest_5);
		
		rdbtnTest_6.setBounds(25, 192, 250, 23);
		add(rdbtnTest_6);
		
		rdbtnTest_7.setBounds(25, 222, 250, 23);
		add(rdbtnTest_7);
		
		rdbtnTest_8.setBounds(25, 252, 250, 23);
		add(rdbtnTest_8);
		
		rdbtnTest_9.setBounds(25, 282, 228, 23);
		add(rdbtnTest_9);
		
		group = new ButtonGroup();		
		group.add(rdbtnTest_1);
		group.add(rdbtnTest_2);
		group.add(rdbtnTest_3);	
		group.add(rdbtnTest_4);
		group.add(rdbtnTest_5);
		group.add(rdbtnTest_6);
		group.add(rdbtnTest_7);
		group.add(rdbtnTest_8);
		group.add(rdbtnTest_9);

		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		
		button.setBounds(263, 296, 89, 23);
		add(button);
	
	}
	
	public JButton confirm() {
		return btnConfirm;
	}
	
	public JButton back() {
		return button;
	}

}
