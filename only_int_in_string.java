package test;
import java.util.*;
public class scratch_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char c;
        Vector<Integer> list = new Vector<>();
        System.out.println("Input a letter"); 
        String temp1 = "";
        String line = in.nextLine();
    for (int i = 0;i<line.length();i++){
        c = line.charAt(i);
        if( Character.isDigit(c)){
           System.out.println(c + " Is a digit");
           temp1 += String.valueOf(c);
        }
        else{
            if(!"".equals(temp1)){// ( temp1 != "" )
            list.add(Integer.parseInt(temp1));
        }
            temp1 = "";
        }
    }
    if( !"".equals(temp1)){// ( temp1 != "" )
       list.add(Integer.parseInt(temp1));
    }
    Integer[] numbers = list.toArray(new Integer[list.size()]);
    System.out.println(list + "\n " + "\nArray " + temp1);
    for (int i: numbers){
        System.out.println(i);
    }
    }
}
