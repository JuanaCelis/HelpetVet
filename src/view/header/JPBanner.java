package view.header;

import presenter.EVENTS;
import presenter.Presenter;
import view.ConstantGUI;
import utilities.*;
import javax.swing.*;
import java.awt.*;

public class JPBanner extends JPanel {

    private JPanel panelSlider;
    private JLabel jlBanner;
    private JButton buttonNext, buttonBack;

    private Presenter myPresenter;

    public JPBanner (Presenter presenter){
        myPresenter = presenter;
        setLayout(new BorderLayout());
        setAlignmentX(LEFT_ALIGNMENT);
        setBackground(Color.decode(ConstantGUI.COLOR_BANNER_BLUE));
        setPreferredSize(new Dimension(1351, 358));
        initComponents();
    }

    private void initComponents() {

        addFirstBannerImage();
        addButtons();
    }

    private void addFirstBannerImage() {
        jlBanner = new JLabel();
        jlBanner.setHorizontalTextPosition(JLabel.CENTER);
        jlBanner.setVerticalAlignment(JLabel.BOTTOM);
        jlBanner.setPreferredSize(new Dimension(1351,441));
        jlBanner.setIcon(new ImageIcon(JPBanner.class.getResource(ConstantGUI.BANNER_CENTER)));
        jlBanner.setBorder(null);

        add(jlBanner,BorderLayout.CENTER);


    }

    private void addButtons() {
        buttonBack = new JButton();
        ImageIcon tempButtonBack  = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_BACK)).getImage());
        MyUtilities.setMainElementsButton(buttonBack,tempButtonBack,0,0,0,0);
        buttonBack.addActionListener(myPresenter);
        buttonBack.setActionCommand(EVENTS.C_BACK_IMAGE_BANNER.toString());
        add(buttonBack,BorderLayout.LINE_START);

        buttonNext = new JButton();
        ImageIcon tempButtonNext  = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_NEXT)).getImage());
        MyUtilities.setMainElementsButton(buttonNext,tempButtonNext,0,0,0,0);
        buttonNext.addActionListener(myPresenter);
        buttonNext.setActionCommand(EVENTS.C_NEXT_IMAGE_BANNER.toString());
        add(buttonNext,BorderLayout.LINE_END);


    }

    public void changeImageBannerNext(){
        jlBanner.removeAll();
        jlBanner.setIcon(new ImageIcon(JPBanner.class.getResource(ConstantGUI.BANER_RIGHT)));
        add(jlBanner,BorderLayout.CENTER);
        jlBanner.revalidate();
        jlBanner.repaint();
    }

    public void changeImageBannerBack(){
        jlBanner.removeAll();
        jlBanner.setIcon(new ImageIcon(JPBanner.class.getResource(ConstantGUI.BANNER_CENTER)));
        add(jlBanner,BorderLayout.CENTER);
        jlBanner.revalidate();
        jlBanner.repaint();
    }


}
