package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 24-05-2020. */
public class Counter {
    private int counter = 0;
    /**
     * add number to current count.
     * @param number - the number that will be added to current count. */
    public void increase(int number) {
        counter = counter + number;
    }
    /**
     * subtract number to current count.
     * @param number - the number that will be subtracted from current count. */
    public void decrease(int number) {
        counter = counter - number;
    }
    /**
     * the method returns the value of the counter.
     * @return - the value of the counter. */
    public int getValue() {
        return counter;
    }
}