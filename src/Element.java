import java.util.ArrayList;

public class Element {
    private int number;
    private  boolean status;
    private ArrayList<Integer> expected;

    public Element(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isStatus() {
        return status;
    }

    public ArrayList<Integer> getExpected() {
        return expected;
    }
}
