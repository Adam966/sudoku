import java.util.ArrayList;

public class Element {
    private int number;
    private  boolean status;
    private ArrayList<Integer> expected = new ArrayList<>();

    public Element(int number) {
        this.number = number;
        if (this.number == 0)
            this.status = false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setExpected(ArrayList<Integer> expected) {
        this.expected = expected;
    }

    public boolean isStatus() {
        return status;
    }

    public ArrayList<Integer> getExpected() {
        return expected;
    }

    public void removeExpected() {
        expected.removeAll(expected);
    }
}
