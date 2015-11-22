public class Temperature {

    int year;
    int[] temps;

    Temperature(int year, int[] temps) {
        this.year = year;
        this.temps = temps;
    }

    public int getYear() {
        return year;
    }

    public int[] getTemps() {
        return temps;
    }

    public void setTemp(int temp, int index) {
        this.temps[index] = temp;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int[] getMaxAndMin() {
        int min = temps[0];
        int minIndex = 0;
        int max = temps[1];
        int maxIndex = 1;

        for (int i = 0; i < temps.length; ++i) {
            if (temps[i] < min) {
                min = temps[i];
                minIndex = i;
            }

            if (temps[i] > max) {
                max = temps[i];
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }
}
