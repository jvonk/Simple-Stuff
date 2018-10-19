import java.util.*;
import java.io.*;

public class Typer {
    private Scanner kb = new Scanner (System.in);
    private int total = 0;
    private List<String> strings = new LinkedList<String>();
    public void getLine() {
        String[] strs = kb.nextLine().split(" ");
        for (int ii = 0; ii < strs.length; ii++) {
            strings.add(strs[ii]);
        }
    }
    public int getTotal() {
        return total;
    }
    public List<String> getStrings() {
        return strings;
    }
}