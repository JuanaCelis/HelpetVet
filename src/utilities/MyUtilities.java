package utilities;

import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

public class MyUtilities {

    public static void setFooterButtonsValues(JButton buttonToChange) {

        buttonToChange.setMaximumSize(new Dimension(169,52));
        buttonToChange.setFont(new Font("Arial", Font.BOLD, 15));
        buttonToChange.setForeground(Color.BLACK);
        buttonToChange.setBackground(null);
        buttonToChange.setBorder(null);
    }

    public static void setMainElementsButton(JButton jButton, ImageIcon imageIcon, int top, int left, int bottom, int right){
        jButton.setBackground(null);
        jButton.setIcon(imageIcon);
        jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButton.setBorder(null);
        jButton.setBorder(BorderFactory.createEmptyBorder(top,left,bottom,right));
    }

    public static void setTextAndIconButtons(JButton button, String text, ImageIcon imageIcon, int top, int left, int bottom, int right){
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setText(text);
        button.setForeground(Color.decode(ConstantGUI.COLOR_SKY_BLUE));
        button.setMaximumSize(new Dimension(380,60));
        button.setBackground(null);
        button.setIcon(imageIcon);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setBorder(null);
    }

    public static void setTextAndJLabel(JLabel jlabel,String text, ImageIcon logo) {
        jlabel.setText(text);
        jlabel.setFont(new Font("Arial", Font.PLAIN, 15));
        jlabel.setForeground(Color.BLACK);
        //jlabel.setMaximumSize(new Dimension(380,30));
        jlabel.setBackground(null);
        jlabel.setIcon(logo);
        //jlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        jlabel.setBorder(null);

    }

    public static LocalDate parseDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Properties generateProperties(String pathFile) throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream(pathFile);
        properties.load(input);
        return properties;
    }

    public static void saveProperties(Properties properties,String pathFile) throws IOException {
        FileOutputStream output = new FileOutputStream(pathFile);
        properties.store(output,null);
        output.close();

    }



}