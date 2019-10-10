public class Main {
    public static void main(String[] args) {
        Board board = new Board("100026039008700601000000200400900516000000000796004008009000000301002900640180003");
        board.setArray();
        //board.showArray();
        board.solve();
        System.out.println("");
        board.showArray();
    }
}
