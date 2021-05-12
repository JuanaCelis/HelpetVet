package view.body.reportsGraphics;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TypesOfMedicines extends JPanel {

    private ArrayList<Double> values;
    private ArrayList<Double> grades;
    private ArrayList<Integer> percentages;

    public TypesOfMedicines(ArrayList<Double> values) {
        setPreferredSize(new Dimension(500,350));
        setVisible(true);
        this.values = values;
    }

    public void paint(Graphics g){
        super.paint(g);

        getGrades();

        double gVaccine = grades.get(0);
        double gAntibiotics = grades.get(1);
        double gAntiparasitics = grades.get(2);
        double gAintiInflamatories = grades.get(3);
        double gDesifectants = grades.get(4);

        getPercentages();

        g.setColor(Color.decode("#004AAD"));
        g.fillArc(350,70,220,220,0, (int) gVaccine);
        g.fillRect(20,70,20,20);
        g.drawString("Vaccine " + percentages.get(0)+"%",50,85);

        g.setColor(Color.decode("#03989E"));
        g.fillArc(350,70,220,220,(int)gVaccine,(int)gAntibiotics);
        g.fillRect(20,100,20,20);
        g.drawString("Antibiotics " + percentages.get(1)+"%",50,115);

        g.setColor(new Color(0x51517F));
        g.fillArc(350,70,220,220,(int)gVaccine+(int)gAntibiotics,(int)gAntiparasitics);
        g.fillRect(20,130,20,20);
        g.drawString("Antiparasitics " + percentages.get(2)+"%",50,145);

        g.setColor(Color.decode("#072340"));
        g.fillArc(350,70,220,220,(int)gVaccine+(int)gAntibiotics+(int)gAntiparasitics,(int)gAintiInflamatories);
        g.fillRect(20,160,20,20);
        g.drawString("Ainti-Inflamatories " + percentages.get(3)+"%",50,175);

        g.setColor(Color.decode("#3274B8"));
        g.fillArc(350,70,220,220,(int)gVaccine+(int)gAntibiotics+(int)gAntiparasitics+(int)gAintiInflamatories, (int)gDesifectants+3);
        g.fillRect(20,190,20,20);
        g.drawString("Desifectants " + percentages.get(4)+"%",50,205);

    }

    public void getGrades(){
        grades = new ArrayList<>();
        double sum = sum();
        for (int i = 0; i < values.size(); i++) {
            grades.add(values.get(i)*360/sum);
        }
    }

    public void getPercentages(){
        percentages = new ArrayList<>();
        double sum = sum();
        for (int i = 0; i < values.size(); i++) {
            percentages.add((int) (values.get(i)*100/sum));
        }
    }

    public double sum(){
        double result = 0;
        for (int i = 0; i < values.size(); i++) {
            result += values.get(i);
        }
        return result;
    }
}
