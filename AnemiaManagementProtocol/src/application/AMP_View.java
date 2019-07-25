package application;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
//import javax.swing.BorderLayout;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.GeminiSkin;
import org.pushingpixels.substance.api.skin.GraphiteAquaSkin;
import org.pushingpixels.substance.internal.utils.SubstanceTitlePane;

import com.itextpdf.text.Paragraph;

/*
import PatientInfo;
import VenoferDosage;
import onESA;
import onIronMed;
import whichESAMed;
import whichIronMed;
*/


public class AMP_View extends JFrame {
	

	
	public Hgb_lt_85_or_dc_gt_15 Hgb_lt_85_or_dc_gt_15 = new Hgb_lt_85_or_dc_gt_15();
	
	public OnESA_greater_than_115 OnESA_greater_than_115 = new OnESA_greater_than_115();
	
	public OnESA_95_115 OnESA_95_115 = new OnESA_95_115();

	public onESA onESA = new onESA();
	
	public OnESA_85_94 OnESA_85_94 = new OnESA_85_94();
	
	public EsaDosageAranesp EsaDosageAranesp = new EsaDosageAranesp();
	
	public EsaDosageEprex EsaDosageEprex = new EsaDosageEprex();
	
	public onIronMed onIronMed = new onIronMed();
	
	public PatientInfo PatientInfo = new PatientInfo();
	
	public whichESAMed whichESAMed = new whichESAMed();
	
	public whichIronMed whichIronMed = new whichIronMed();
	
	public VenoferDosage venoferDosage = new VenoferDosage();
	
	public ferricitDosage ferricitDosage = new ferricitDosage();
	
	public last_three_hgb last_three_hgb = new last_three_hgb();
	
	public last_two_tsats last_two_tsats = new last_two_tsats();
	
	public hgb_tsat_ferritin_dates hgb_tsat_ferritin_dates = new hgb_tsat_ferritin_dates();
	
	public ESAHoldDate ESAHoldDate = new ESAHoldDate();
	
	public all_info all_info = new all_info();
	
	private JSplitPane splitPane = new JSplitPane();
	
	public JSplitPane getSplitPane () {
		return this.splitPane;
	}
	
	public AMP_View() {
		//SubstanceLookAndFeel.setSkin(new GraphiteAquaSkin());
		//SubstanceLookAndFeel.setSkin(new GeminiSkin());
		//SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.MarinerSkin");
		//SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.BusinessSkin");
		//SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin");
		//SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.GeminiSkin");
		//SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.DustSkin");
		//SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin");
		//SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin");
		setTitle("Anemia Management Protocol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBackground( Color.gray );
		setBounds(100, 100, 450, 350);
		setSize(new Dimension(925, 378));
		setVisible(true);
		
		JPanel contentPane = new JPanel();	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		splitPane.setResizeWeight(0.5);
		splitPane.setBounds(5, 5, 900, 330);
		contentPane.add(splitPane);
		

		//JPanel panel = new JPanel();
		//PatientInfo PatientInfo = new PatientInfo();
		
		splitPane.setLeftComponent(PatientInfo);
		//panel.setLayout(null);
	    
	    splitPane.setRightComponent(all_info);
		splitPane.setDividerLocation(this.getWidth()/2);

	    
	    
	}

	public void OnESA_Select(AMP_Model theModel) {
		
		//0 <= Hgb <= 84 or Decrease in Hgb greater than 15
		//HGB/ESA Protocol ends
		if (theModel.hgb_decrease_greater_than_15() || 
			(theModel.isBetween(theModel.get_current_hgb(),0,84))) {
				
				if (theModel.hgb_decrease_greater_than_15() && 
					(theModel.isBetween(theModel.get_current_hgb(),0,84))) {
						
					Hgb_lt_85_or_dc_gt_15.set_text("The current Hgb is below 85. \n");
					
					Hgb_lt_85_or_dc_gt_15.set_text2("<html> The decrease between current Hgb and <br> previous Hgb is greater than 15. \n" +
							"</html>");
					
					Hgb_lt_85_or_dc_gt_15.get_text3().setVisible(true);
					
					
				} else if (theModel.hgb_decrease_greater_than_15()) {
				
					Hgb_lt_85_or_dc_gt_15.set_text("<html> The decrease between current Hgb and <br> previous Hgb is greater than 15. \n" +
							"</html>");
					
					Hgb_lt_85_or_dc_gt_15.set_text2("Notify MD.");
					
				} else if (theModel.isBetween(theModel.get_current_hgb(),0,84)) {
					
					Hgb_lt_85_or_dc_gt_15.set_text("The current Hgb is below 85.");
					
					Hgb_lt_85_or_dc_gt_15.set_text2("Notify MD.");
					
				}
				
				this.getSplitPane().setLeftComponent(this.Hgb_lt_85_or_dc_gt_15);
								
		} else {
			//The HGB/ESA Protocol continues
			
			//85 <= Hgb <= 94
			if (theModel.isBetween(theModel.get_current_hgb(),85,94)) {
			
				this.getSplitPane().setLeftComponent(this.OnESA_85_94);
			//95 <= Hgb <= 115	
			} else if (theModel.isBetween(theModel.get_current_hgb(),95,115)) {
									
				this.getSplitPane().setLeftComponent(this.OnESA_95_115);
			//115 < Hgb
			} else if (theModel.get_current_hgb() > 115) {
				
				this.getSplitPane().setLeftComponent(this.OnESA_greater_than_115);
				
			}		
		}
		
		if (theModel.hgb_decrease_greater_than_15() && 
				(theModel.isBetween(theModel.get_current_hgb(),0,84))) {
			
			JLabel lblIsThePatient = new JLabel("The decrease between current Hgb and previous Hgb is greater than 15. \n" +
												"The current Hgb is below 85. \n" + 
												"Notify MD.");
			lblIsThePatient.setBounds(102, 12, 288, 14);
			add(lblIsThePatient);
			
		} else if (theModel.hgb_decrease_greater_than_15()) {
			
			JLabel lblIsThePatient = new JLabel("The current Hgb is below 85. \n" + 
					"Notify MD.");
			lblIsThePatient.setBounds(102, 12, 288, 14);
			add(lblIsThePatient);
		} else if (theModel.isBetween(theModel.get_current_hgb(),0,84)) {
			
			JLabel lblIsThePatient = new JLabel("The decrease between current Hgb and previous Hgb is greater than 15. \n" +
					"Notify MD.");
			lblIsThePatient.setBounds(102, 12, 288, 14);
			add(lblIsThePatient);
		}
	}

}
