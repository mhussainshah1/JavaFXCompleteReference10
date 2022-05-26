package chat;

import java.util.ArrayList;
import java.util.List;

public class Test {
    //Java is pass by value language
    public static void main(String[] args) {
        //pass value
        int a = 1;
        checkPrimitive(a);
        System.out.println(a);

        //pass reference = make copy of reference
        List<String> list = new ArrayList<>();
        list.add("main");
        checkObject(list);
        System.out.println(list);
    }

    public static void checkPrimitive(Integer a) {
        a++;
    }

    public static void checkObject(List<String> list) {
        list.add("method");
    }
}