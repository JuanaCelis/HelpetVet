package presenter;

import model.VetManager;
import view.JFrameMainWindow;
import view.body.JPTableElements;

import java.awt.event.ActionEvent;

public class Presenter {

    private VetManager vetManager;
    private JFrameMainWindow mainWindow;

    public Presenter(){
        vetManager = new VetManager();
        mainWindow = new JFrameMainWindow(this);
    }

}
