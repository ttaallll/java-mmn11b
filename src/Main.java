import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Temperature t = new Temperature(2015, new int[]{10,10,10,10,10,10,10,10,10,10,10,10});
        Weather m = new Weather();
        m.setTemperature(t);


        Scanner s = new Scanner(System.in);

        String inputResult = "";
        while (!inputResult.equals("exit")) {

            System.out.println("enter year");
            inputResult = s.nextLine();

            if (inputResult.equals("exit"))
                break;

            t.setYear(Integer.parseInt(inputResult));
            m.setTemperature(t);
            m.repaint();

            for (int i = 0; i < 12; ++i) {
                System.out.format("enter temperature for month %d", i + 1);
                System.out.println();
                inputResult = s.nextLine();

                if (inputResult.equals("exit"))
                    break;

                t.setTemp(Integer.parseInt(inputResult), i);
                m.setTemperature(t);
                m.repaint();
            }



            System.out.println("to exit press exit, continue any key");
            inputResult = s.nextLine();
        }



        m.dispatchEvent(new WindowEvent(m, WindowEvent.WINDOW_CLOSING));
    }
}
