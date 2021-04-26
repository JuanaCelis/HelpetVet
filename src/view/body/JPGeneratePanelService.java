package view.body;

import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPGeneratePanelService {

    public JPanel generatePanel(String image, String pageEnd){

        JPanel generatePanel = new JPanel();
        generatePanel.setPreferredSize(new Dimension(280,390));
        generatePanel.setLayout(new BoxLayout(generatePanel, BoxLayout.Y_AXIS));
        generatePanel.setBackground(Color.decode(ConstantGUI.COLOR_BANNER_BLUE));
        generatePanel.setBorder(BorderFactory.createMatteBorder(40, 80, 40, 80, Color.white));

        JLabel exampleServiceImage = new JLabel();
        exampleServiceImage.setIcon(new ImageIcon(getClass().getResource(image)));
        exampleServiceImage.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        generatePanel.add(exampleServiceImage);

        JLabel pageEndDescriptionService = new JLabel(pageEnd);
        pageEndDescriptionService.setFont(new Font("Arial", Font.PLAIN, 15));
        pageEndDescriptionService.setForeground(Color.BLACK);
        pageEndDescriptionService.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pageEndDescriptionService.setBorder(BorderFactory.createEmptyBorder(0,40,20,0));
        generatePanel.add(pageEndDescriptionService);

        return generatePanel;


    }
}
