package view.footer;

import presenter.Presenter;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPContainerFooter extends JPanel{

	private JPpenultimate jpPenultimate;
	private JPLatest jpLatest;

	private Presenter myPresenter;
	
	public JPContainerFooter(Presenter presenter) {
		myPresenter = presenter;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(LEFT_ALIGNMENT);
		//setPreferredSize(new Dimension(1349,494));
		setBackground(Color.decode(ConstantGUI.COLOR_DARK_BLUE));
		initComponents();
	}
	
	
	private void initComponents() {
		
		jpPenultimate = new JPpenultimate(myPresenter);
		add(jpPenultimate);
		
		jpLatest = new JPLatest();
		add(jpLatest);
	}

}
