package view.footer;
import utilities.UploaderFontsResource;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class JPModelJLabels extends JLabel{
	
	public JPModelJLabels(String text, String Icon) {
		setText(text);
		setForeground(Color.WHITE);
		setMaximumSize(new Dimension(380,30));
		setBackground(null);
		setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Icon)).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBorder(null);
		
		try {
			setFont(UploaderFontsResource.uploadFont(ConstantGUI.FONT_OPEN_SANS_LIGHT, Font.PLAIN, 18));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
