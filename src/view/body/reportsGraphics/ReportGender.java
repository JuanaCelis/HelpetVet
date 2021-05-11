package view.body.reportsGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReportGender extends JPanel {

    private ArrayList<Integer> values;

    public ReportGender(ArrayList<Integer> values) {
        setPreferredSize(new Dimension(100,240));
        setVisible(true);
        this.values = values;
    }

    public void paint(Graphics g){
        super.paint(g);

        int male = values.get(0);
        int female = values.get(1);

        int sum = male + female;

        double longMale = male *600/sum;
        double longFemale = female *600/sum;

        double perMale = male*100/sum;
        double perFemale = female*100/sum;

        g.setColor(Color.decode("#072340"));
        g.fillRect(100,100, (int) longMale,70);
        g.setColor(Color.white);
        g.drawString("Male " + (int)+ perMale+"%",105,130);

        g.setColor(Color.decode("#3274B8"));
        g.fillRect((int) (100+longMale),100, (int) longFemale,70);
        g.setColor(Color.white);
        g.drawString("Female " + (int)perFemale +"%", (int) (105+longMale),130);
    }
}
