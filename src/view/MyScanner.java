package view;
import java.util.Scanner;
public class MyScanner {
    private static Scanner instance=null;

    private MyScanner()
    {

    }
    public static Scanner getScanner()
    {
        if(instance== null)
        {
            instance=new Scanner(System.in);
        }
        return instance;
    }

}
