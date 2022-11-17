package jumpToJava;

import java.util.*;

public class jumpToJava {


    public static void main(String[] args) {
        Practice1 practice1 = new Practice1();
        System.out.println(practice1.average(80, 75, 55));
        System.out.println(practice1.average1(new int[]{80, 75, 55}));
        System.out.println(practice1.oddeven(13));
        System.out.println(practice1.oddEvenApplication(13));
        System.out.println(practice1.localSeparator("881120-1068234"));
        System.out.println(practice1.sexDistinction("881120-1068234"));
        System.out.println(practice1.replace("a:b:c:d"));
        System.out.println(practice1.sortedList(new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2))));
        System.out.println(practice1.joinPractice(new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        practice1.removePractice();
        practice1.retainAllPractice();
        practice1.printCoffeePrice(Practice1.CoffeeType.AMERICANO);
        practice1.printCoffeePrice(Practice1.CoffeeType.ICE_AMERICANO);
    }

}
