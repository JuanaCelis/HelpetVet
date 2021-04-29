package view.header;

import persistence.HandlerLanguage;
import presenter.Presenter;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPContainerHeader extends JPanel {

    private JPButtonsHeader jpButtons;
    private JPButtonsLanguages jpButtonsLanguages;
    private  JPBanner jpBanner;

    private Presenter myPresenter;

    public JPContainerHeader(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#ffffff"));
        initComponents();
    }

    private void initComponents() {
        jpButtonsLanguages = new JPButtonsLanguages(myPresenter);
        this.add(jpButtonsLanguages);

        jpButtons = new JPButtonsHeader(myPresenter);
        this.add(jpButtons);

        jpBanner = new JPBanner(myPresenter);
        this.add(jpBanner);

    }

    public void changeImageBannerNext(){
        jpBanner.changeImageBannerNext();
    }

    public void changeImageBannerBack(){
       jpBanner.changeImageBannerBack();
    }

    public void changeLanguage(){
        jpButtons.changeLanguage();
    }
}
