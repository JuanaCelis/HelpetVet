package view.body.reportsGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrequenPetsBySize extends JPanel {

    private ArrayList<Double> values;

    public FrequenPetsBySize(ArrayList<Double> values) {
        setPreferredSize(new Dimension(100,550));
        setVisible(true);
        this.values = values;
    }

    public void paint(Graphics g){
        super.paint(g);
        double sizeBig = values.get(0);
        double sizeMedium = values.get(1);
        double sizeLittle = values.get(2);

        double sum = sizeBig + sizeMedium + sizeLittle;
        double longOne = sizeBig * 400/sum;
        double longTwo = sizeMedium * 400/sum;
        double longThree = sizeLittle * 400/sum;

        g.setColor(Color.BLUE);
        g.fillRect(50,250, (int) longOne,50);
        g.setColor(Color.white);
        g.drawString("Big " + (int)sizeBig+ "%",55,270);

        g.setColor(Color.GREEN);
        g.fillRect((int) (50+longOne),250, (int) longTwo,50);
        g.setColor(Color.white);
        g.drawString("Medium " + (int)sizeMedium +"%", (int) (55+longOne),270);

        g.setColor(Color.RED);
        g.fillRect((int) (50+longOne+longTwo),250, (int) longThree,50);
        g.setColor(Color.white);
        g.drawString("Little " + (int)sizeLittle+"%", (int) (55+longOne+longTwo),270);
    }
}
