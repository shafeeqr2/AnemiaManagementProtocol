package application;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class AMP {
	
	public static void main(String[] args) {

	  AMP_Model theModel = new AMP_Model();	
	  	
	  EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
				
				//To activate the Title Bar from the Look and Feel
				JFrame.setDefaultLookAndFeelDecorated(true);
				JDialog.setDefaultLookAndFeelDecorated(true);
				
				//To prevent the Title Bar from flickering upon resize
				System.setProperty("sun.awt.noerasebackground", "true");

				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceNebulaLookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceOfficeBlack2007LookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel");
				UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceRavenLookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceChallengerDeepLookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceMagellanLookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteAquaLookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel");
				//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel");

				AMP_View theView = new AMP_View();
				AMP_Controller theController = new AMP_Controller(theModel, theView);

					
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		});	
	}
}
