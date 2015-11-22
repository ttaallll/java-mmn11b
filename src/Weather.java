import javax.swing.*;
import java.awt.*;

public class Weather extends JFrame {

    Temperature temps;

    Weather() {
        setSize(800, 400);
        setTitle("An Empty Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());
        add(new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);


                String yearStr = Integer.toString(temps.getYear());
                g.drawString(yearStr, getSize().width / 2, 10);

                for (int i = 1 ; i <= 10; ++i) {
                    g.drawString(Integer.toString(i * 10),
                            10,
                            (int)(getSize().height * (1.0f - (float)i/10)));
                }



                int widthForMonth = (getSize().width - 20) / 12 - 5;
                int heightForMonth = (getSize().height - 20);

                int[] minMax = temps.getMaxAndMin();

                for (int i = 0; i < temps.getTemps().length; ++i) {

                    if (i == minMax[0] || i == minMax[1])
                        continue;

                    int thisMonthHeight = (int)(getSize().height * (float)temps.getTemps()[i]/100.0f) - 10;

                    g.drawRect(
                            25 + i * widthForMonth + 5 * i,
                            heightForMonth - thisMonthHeight,
                            widthForMonth,
                            thisMonthHeight);

                    g.drawString(Integer.toString(temps.getTemps()[i]),
                            25 + i * widthForMonth + 5 * i,
                            heightForMonth + 15);
                }


                int minMonthHeight = (int)(getSize().height * (float)temps.getTemps()[minMax[0]]/100.0f) - 10;
                g.setColor(new Color(0,0,255));
                g.fillRect(25 + minMax[0] * widthForMonth + 5 * minMax[0],
                        heightForMonth - minMonthHeight,
                        widthForMonth,
                        minMonthHeight);
                g.drawString(Integer.toString(temps.getTemps()[minMax[0]]),
                        25 + minMax[0] * widthForMonth + 5 * minMax[0],
                        heightForMonth + 15);


                int maxMonthHeight = (int)(getSize().height * (float)temps.getTemps()[minMax[1]]/100.0f) - 10;
                g.setColor(new Color(255,0,0));
                g.fillRect(25 + minMax[1] * widthForMonth + 5 * minMax[1],
                        heightForMonth - maxMonthHeight,
                        widthForMonth,
                        maxMonthHeight);
                g.drawString(Integer.toString(temps.getTemps()[minMax[1]]),
                        25 + minMax[1] * widthForMonth + 5 * minMax[1],
                        heightForMonth + 15);
            }

        }, BorderLayout.CENTER);
    }

    public void setTemperature(Temperature temps) {
        this.temps = temps;
    }
}
