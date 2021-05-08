package view.footer;

import utilities.UploaderFontsResource;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JPLatest extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public JPLatest() {
		setLayout(new FlowLayout());
		setBackground(Color.decode(ConstantGUI.COLOR_DARK_BLUE));
		setPreferredSize(new Dimension(1349,55));
		setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
		initComponents();
	}

	private void initComponents() {
		addJLCopyRight();
		//addIconFb();
		//addIconTw();
		
	}

	private void addIconTw() {
		
		JButton jbIcon = new JButton();
		jbIcon.setBackground(null);
		jbIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.TWITTER_IMG)).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
		jbIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbIcon.setBorder(null);
		jbIcon.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
		jbIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(jbIcon);	
		
	}

	private void addJLCopyRight() {
		
		JLabel jlInfoServiware = new JLabel("HELPET VET POR JULIAN ARDILA Y JUANA CELIS © TODOS LOS DERECHOS RESERVADOS");
		jlInfoServiware.setForeground(Color.WHITE);
		
		try {
			jlInfoServiware.setFont(UploaderFontsResource.uploadFont(ConstantGUI.FONT_OPEN_SANS_LIGHT, Font.PLAIN, 15));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jlInfoServiware.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		jlInfoServiware.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		add(jlInfoServiware);
		
	}

	private void addIconFb() {
		
		JButton jbIcon = new JButton();
		jbIcon.setBackground(null);
		jbIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.FACEBOOK_IMG)).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
		jbIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbIcon.setBorder(null);
		jbIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(jbIcon);	
		
	}

}
