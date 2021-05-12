package view.body.reportsGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrequenPetsBySize extends JPanel {

    private ArrayList<Double> values;

    public FrequenPetsBySize(ArrayList<Double> values) {
        setPreferredSize(new Dimension(100,240));
        setVisible(true);
        this.values = values;
    }

    public void paint(Graphics g){
        super.paint(g);
        double sizeBig = values.get(0);
        double sizeMedium = values.get(1);
        double sizeLittle = values.get(2);

        double sum = sizeBig + sizeMedium + sizeLittle;
        double longOne = sizeBig * 600/sum;
        double longTwo = sizeMedium * 600/sum;
        double longThree = sizeLittle * 600/sum;

        g.setColor(Color.decode("#072340"));
        g.fillRect(50,100, (int) longOne,60);
        g.setColor(Color.white);
        g.drawString("Big " + (int)sizeBig+ "%",55,130);

        g.setColor(Color.decode("#3274B8"));
        g.fillRect((int) (50+longOne),100, (int) longTwo,60);
        g.setColor(Color.white);
        g.drawString("Medium " + (int)sizeMedium +"%", (int) (55+longOne),130);

        g.setColor(Color.decode("#1735BD"));
        g.fillRect((int) (50+longOne+longTwo),100, (int) longThree,60);
        g.setColor(Color.white);
        g.drawString("Little " + (int)sizeLittle+"%", (int) (55+longOne+longTwo),130);
    }
}
