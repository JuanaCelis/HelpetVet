package view.body.reportsGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PetsForMounth extends JPanel {

    private ArrayList<Integer> values;
    private ArrayList<Integer> lengths;

    public PetsForMounth(ArrayList<Integer> values) {
        setPreferredSize(new Dimension(500,350));
        setVisible(true);
        this.values = values;
    }

    public void paint(Graphics g){
        super.paint(g);

        getLengths();

        g.setColor(Color.BLUE);
        g.fillRect(50,50, 40,lengths.get(0)+5);
        g.drawString("Janu: "+values.get(0),55,30);

        g.setColor(Color.BLUE);
        g.fillRect(150,50, 40,lengths.get(1)+5);
        g.drawString("Febru: "+values.get(1),153,30);

        g.setColor(Color.BLUE);
        g.fillRect(250,50, 40,lengths.get(2)+5);
        g.drawString("March: "+values.get(2),253,30);

        g.setColor(Color.BLUE);
        g.fillRect(350,50, 40,lengths.get(3)+5);
        g.drawString("April: "+values.get(3),355,30);

        g.setColor(Color.BLUE);
        g.fillRect(450,50, 40,lengths.get(4)+5);
        g.drawString("May: "+values.get(4),455,30);

        g.setColor(Color.BLUE);
        g.fillRect(550,50, 40,lengths.get(5)+5);
        g.drawString("June: "+values.get(5),555,30);

        g.setColor(Color.BLUE);
        g.fillRect(650,50, 40,lengths.get(6)+5);
        g.drawString("July: "+values.get(6),655,30);

        g.setColor(Color.BLUE);
        g.fillRect(750,50, 40,lengths.get(7)+5);
        g.drawString("Agus: "+values.get(7),755,30);

        g.setColor(Color.BLUE);
        g.fillRect(850,50, 40,lengths.get(8)+5);
        g.drawString("Sept: "+values.get(8),853,30);

        g.setColor(Color.BLUE);
        g.fillRect(950,50, 40,lengths.get(9)+5);
        g.drawString("Oct: "+values.get(9),955,30);

        g.setColor(Color.BLUE);
        g.fillRect(1050,50, 40,lengths.get(10)+5);
        g.drawString("Nove: "+values.get(10),1053,30);

        g.setColor(Color.BLUE);
        g.fillRect(1150,50, 40,lengths.get(11)+5);
        g.drawString("Dece: "+values.get(11),1153,30);
    }

    public void getLengths(){
        lengths = new ArrayList<>();
        int major = getMajor();
        for (int i = 0; i < values.size(); i++) {
            lengths.add(values.get(i)*200/major);
        }
    }

    public int getMajor(){
        int major = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) >= major){
                major = values.get(i);
            }
        }
        return major;
    }
}
