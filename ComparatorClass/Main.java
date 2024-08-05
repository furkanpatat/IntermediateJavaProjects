
//Here I developed a sorting algorithm using Comparator Class.

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };

        List<String> list = new ArrayList<>();

        list.add("Furkan");
        list.add("Telusko");
        list.add("Java");
        list.add("Python-OpenCV");
        list.add("Spring Boot");
        list.add("Angle");

        Collections.sort(list,comparator);
        System.out.println(list);
    }
}