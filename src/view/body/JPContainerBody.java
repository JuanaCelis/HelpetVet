package view.body;

import presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class JPContainerBody extends JPanel {

    private Presenter myPresenter;

    public JPContainerBody(Presenter presenter) {
        //this.setLayout(new BorderLayout());
        myPresenter = presenter;
        initViews();

    }

    private void initViews() {

    }
}
