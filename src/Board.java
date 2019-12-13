public class Board {
    private String input;
    private Element[][] array = new Element[9][9];

    public Board(String string) {
        this.input = string;
    }

    public void setArray() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (input.charAt(i * 9 + j) == '0')
                    array[i][j] = (new Element(Character.getNumericValue(input.charAt(i * 9 + j)), false));
                else
                    array[i][j] = (new Element(Character.getNumericValue(input.charAt(i * 9 + j)), true));
            }
        }
    }

    public void showArray() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(array[i][j].getNumber() + " ");
            }
            System.out.println(" ");
        }
    }

    public boolean checkBoard() {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (array[i][j].isStatus())
                    count++;
            }
        }

        if (count < 80)
            return true;
        else
            return false;
    }

    public void solve() {
        while (checkBoard()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    //System.out.println(array[i][j].isStatus());
                    if (checkElement(array[i][j])) {
                        array[i][j].setNumber(tryElement(j, i));
                        //System.out.println("x: " + j + "y: " + i + " ");
                    }
                }
            }
        }
    }

    //******************************* ELEMENT FUNCTIONS *************************************************************//
    public boolean checkElement(Element element) {
        if (element.isStatus())
            return false;
        else
            return true;
    }

    public int tryElement(int x, int y) {
        array[y][x].removeExpected();
        for (int i = 1; i < 10; i++) {
            if (checkSquare(x, y, i) && checkRow(y, i) && checkColumn(x, i)) {
                array[y][x].getExpected().add(i);
            }
        }
        //System.out.println(array[y][x].getExpected().toString());

        if (array[y][x].getExpected().size() == 1) {
            array[y][x].setStatus(true);
            return array[y][x].getExpected().get(0);
        } else {
            return 0;
        }
    }

    //******************************** CHECK FUNCTIONS **************************************************************//
    public boolean checkSquare(int x, int y, int num) {
        int count = 0;
        for (int i = getCornerY(y); i < getCornerY(y) + 3; i++) {
            for (int j = getCornerX(x); j < getCornerX(x) + 3; j++) {
                //System.out.print(array[i][j] + " ");
                if (!(array[i][j].getNumber() != num))
                    count++;
            }
            //System.out.println(" ");
        }

        if (count == 0)
            return true;
        else
            return false;
    }

    public int getCornerX(int x) {
        return (x / 3) * 3;
    }

    public int getCornerY(int y) {
        return (y / 3) * 3;
    }

    public boolean checkRow(int y, int num) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            //System.out.print(array[y][i] + " ");
            if (!(array[y][i].getNumber() != num))
                count++;
        }
        if (count == 0)
            return true;
        else
            return false;
    }

    public boolean checkColumn(int x, int num) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            //System.out.print(array[i][x] + " ");
            if (!(array[i][x].getNumber() != num))
                count++;
        }
        if (count == 0)
            return true;
        else
            return false;
    }
}
