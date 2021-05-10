package view.body.reportsGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AppointmentForCategory extends JPanel {

    private List<Double> values;

    public AppointmentForCategory(List<Double> doubles) {
        setPreferredSize(new Dimension(100,550));
        setVisible(true);
        this.values = doubles;
    }

    public void paint(Graphics g){


        super.paint(g);
        double surgery = values.get(0);
        double oncology = values.get(1);
        double phisiotherapy = values.get(2);
        double rehabilitation = values.get(3);
        double imaging = values.get(4);
        double wildlife = values.get(5);

        double tempMajor = getMajorValue(surgery,oncology,phisiotherapy);
        double tempMajorSecond = getMajorValue(rehabilitation,imaging,wildlife);

        double major = (tempMajor > tempMajorSecond)?tempMajor : tempMajorSecond;

        int longOne = (int) (surgery*400/major);
        int longTwo = (int) (oncology*400/major);
        int longThree = (int) (phisiotherapy*400/major);
        int longFour = (int) (rehabilitation*400/major);
        int longFive = (int) (imaging*400/major);
        int longSix = (int) (wildlife*400/major);

        g.setColor(Color.CYAN);
        g.fillRect(150,70,longOne,35);
        g.drawString("Cirugia",30,100);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(150,120,longTwo,35);
        g.drawString("Oncología",30,150);

        g.setColor(Color.BLUE);
        g.fillRect(150,180,longThree,35);
        g.drawString("Fisoperapia",30,210);

        g.setColor(Color.BLUE);
        g.fillRect(150,240,longFour,35);
        g.drawString("Rehabilitacion",30,270);

        g.setColor(Color.MAGENTA);
        g.fillRect(150,300,longFive,35);
        g.drawString("imagen",30,300);

        g.setColor(Color.pink);
        g.fillRect(150,350,longSix,35);
        g.drawString("Fauna",30,350);

    }

    public double getMajorValue(double valueOne, double valueTwo, double valueThree){
        double result = 0;
        if (valueOne > valueTwo && valueOne > valueThree){
            result = valueOne;
        }
        else if (valueTwo > valueOne && valueTwo > valueThree){
            result = valueTwo;
        }
        else {
            result = valueThree;
        }
        return result;
    }


}
