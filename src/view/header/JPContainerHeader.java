package view.header;

import presenter.Presenter;

import javax.swing.*;

public class JPContainerHeader extends JPanel {


    private Presenter myPresenter;

    public JPContainerHeader(Presenter presenter){
        myPresenter = presenter;
        initViews();
    }

    private void initViews() {
    }
}
