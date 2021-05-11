package view.body.reportsGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DoctorsByCategoryGraphic extends JPanel {

    private ArrayList<Double> values;

    public DoctorsByCategoryGraphic(ArrayList<Double> doubles) {
        setPreferredSize(new Dimension(500,350));
        setVisible(true);
        this.values = doubles;
    }

    public void paint(Graphics g) {
        super.paint(g);
        double surgery = values.get(0);
        double phisiotherapy = values.get(1);
        double oncology = values.get(2);
        double rehabilitation = values.get(3);
        double imaging = values.get(4);
        double wildLife = values.get(5);

        double sum = surgery + phisiotherapy + oncology + rehabilitation + wildLife + imaging;
        int gradeSurgery = (int) (surgery*360/sum);
        int gradePhisio = (int) (phisiotherapy*360/sum);
        int gradeOncology = (int) (oncology*360/sum);
        int gradeRehali = (int) (rehabilitation*360/sum);
        int gradeImagin = (int) (imaging*360/sum);
        int gradeWildLife = (int)(wildLife*360/sum);

        double percetageSurgery = surgery*100/sum;
        double percetagePhisi = phisiotherapy*100/sum;
        double percetageOncology = oncology*100/sum;
        double percetageRehabili = rehabilitation*100/sum;
        double percetageImagin = imaging*100/sum;
        double percetageWild = wildLife*100/sum;

        g.setColor(Color.decode("#004AAD"));
        g.fillArc(350,70,220,220,0,gradeSurgery);
        g.fillRect(20,70,20,20);
        g.drawString("surgery " + (int)percetageSurgery+"%",50,85);

        g.setColor(Color.decode("#03989E"));
        g.fillArc(350,70,220,220,gradeSurgery,gradePhisio);
        g.fillRect(20,100,20,20);
        g.drawString("Phisiotherapy " + (int)percetagePhisi+"%",50,115);

        g.setColor(new Color(0x51517F));
        g.fillArc(350,70,220,220,gradeSurgery+gradePhisio,gradeOncology);
        g.fillRect(20,130,20,20);
        g.drawString("Oncology " + (int)percetageOncology+"%",50,145);

        g.setColor(Color.decode("#072340"));
        g.fillArc(350,70,220,220,gradeSurgery+gradePhisio+gradeOncology,gradeRehali);
        g.fillRect(20,160,20,20);
        g.drawString("Rehabilitation " + (int)percetageRehabili+"%",50,175);

        g.setColor(Color.decode("#3274B8"));
        g.fillArc(350,70,220,220,gradeSurgery+gradePhisio+gradeOncology+gradeRehali,gradeImagin);
        g.fillRect(20,190,20,20);
        g.drawString("Imagin " + (int)percetageImagin+"%",50,205);

        g.setColor(new Color(0x00AEFF));
        g.fillArc(350,70,220,220,gradeSurgery+gradePhisio+gradeOncology+gradeRehali+gradeImagin,gradeWildLife);
        g.fillRect(20,220,20,20);
        g.drawString("Wildlife " + (int)percetageWild+"%",50,235);

    }
}
