package view.footer;

import presenter.EVENTS;
import presenter.Presenter;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPpenultimate extends JPanel{

	private JPModelJLabels jmbcellPhone, jmbTelephone, jmbEmail, jmbEmailTwo, jmbLocation;
	private Presenter myPresenter;
	
	public JPpenultimate(Presenter presenter) {
		myPresenter = presenter;
		setLayout(new FlowLayout());
		setBackground(Color.decode("#00365b"));
		setPreferredSize(new Dimension(1349,290));
		setBorder(BorderFactory.createEmptyBorder(45,0,0,0));
		initComponents();
	}

	private void initComponents() {
		addInfoHelpet();
		addButtonIcon();
	}

	private void addInfoHelpet() {

		JPanel panelYInfoHelpet = new JPanel();
		panelYInfoHelpet.setLayout(new BoxLayout(panelYInfoHelpet, BoxLayout.Y_AXIS));
		panelYInfoHelpet.setBackground(Color.decode("#00365b"));
		panelYInfoHelpet.setBorder(BorderFactory.createEmptyBorder(10,0,0,200));

		jmbTelephone = new JPModelJLabels("Tel: 1 234567", ConstantGUI.PHONE_CALL_IMG);
		jmbTelephone.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		panelYInfoHelpet.add(jmbTelephone);

		jmbcellPhone = new JPModelJLabels("Cel.: 3209104956", ConstantGUI.ICON_CELLPHONE);
		jmbcellPhone.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		panelYInfoHelpet.add(jmbcellPhone);

		jmbEmail = new JPModelJLabels("juana.celis@uptc.edu.co", ConstantGUI.EMAIL_IMG);
		jmbEmail.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		panelYInfoHelpet.add(jmbEmail);

		jmbEmailTwo = new JPModelJLabels("julian.ardila@uptc.edu.co", ConstantGUI.EMAIL_IMG);
		jmbEmailTwo.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		panelYInfoHelpet.add(jmbEmailTwo);

		jmbLocation = new JPModelJLabels("Carrera 12 # 03 - 02 Tunja, Boyaca", ConstantGUI.ICON_UBICATION);
		jmbLocation.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		panelYInfoHelpet.add(jmbLocation);

		this.add(panelYInfoHelpet);
		
	}

	private void addButtonIcon() {
		
		JButton jbIcon = new JButton();
		jbIcon.setBackground(null);
		jbIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.LOGO_HELPET_FOOTER)).getImage().getScaledInstance(300,106,Image.SCALE_SMOOTH)));
		jbIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbIcon.setBorder(null);
		jbIcon.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		jbIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbIcon.addActionListener(myPresenter);
		jbIcon.setActionCommand(EVENTS.C_SHOW_HOMEPAGE.toString());
		add(jbIcon);	
		
	}

}
