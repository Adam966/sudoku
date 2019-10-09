import java.util.ArrayList;

public class Board {
    private String input;
    private int[][] array = new int[9][9];


    public Board(String string) {
        this.input = string;
    }

    public void setArray() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = Character.getNumericValue(input.charAt(i*9 + j));
            }
        }
    }

    public void solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (checkElement(array[i][j]))
                    array[i][j] = tryElement(j,i);
            }
        }
    }

    public void showArray() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    //******************************* ELEMENT FUNCTIONS *************************************************************//
    public boolean checkElement(int element) {
        if (element == 0)
            return true;
        else
            return false;
    }

    public int tryElement(int x, int y) {
        ArrayList<Integer> expected = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            if (checkSquare(x,y,array[y][x]) && checkRow(x,y,array[y][x]) && checkColumn(x,y,array[y][x]))
                expected.add(i);
        }

        if (expected.size() == 1)
            return expected.get(0);
        else
            return 0;
    }

    //******************************** CHECK FUNCTIONS **************************************************************//
    public boolean checkSquare(int x, int y, int num) {
        for(int i=getCornerY(y); i<getCornerY(y) + 3; i++) {
            for(int j=getCornerX(x); j<getCornerX(x) + 3; j++) {
                //System.out.print(array[i][j] + " ");
                if (array[j][i] != num)
                    return true;
            }
            //System.out.println(" ");
        }
        return false;
    }

    public int getCornerX(int x) {
        return (x/3) * 3;
    }

    public int getCornerY(int y) {
        return (y/3) * 3;
    }

    public boolean checkRow(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            //System.out.print(array[y][i] + " ");
            if (array[y][i] != num)
                return true;
        }
        return false;
    }

    public boolean checkColumn(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            //System.out.print(array[i][x] + " ");
            if (array[i][x] != num)
                return true;
        }
        return false;
    }
}
