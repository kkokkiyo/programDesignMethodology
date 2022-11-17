package Practice1;
// 점프 투 자바 연습문제 연습 메소드들

import java.util.*;

public class Practice1 {


    //@param - 정수형 숫자들을 받아서
    //@return - 받은 숫자들의 합의 평균을 반환
    public int average(int a, int b, int c) {
        int sum = a + b + c;
        int average = sum / 3;
        return average;
    }
    // @param arr - 정수형 배열을 받아서
    // @return - 배열속 숫자들의 평균을 반환
    public int average1(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int average1 = sum / arr.length;
        return average1;
    }
    // @param arr - 정수인 숫자를 받아서
    // @return - 이 숫자의 짝수 홀수 여부를 판단하여 반환
    public boolean oddeven(int a){
        if (a % 2 == 0){
            return true; //짝수
        }else {
            return false; //홀수
        }
    }


    public String oddEvenApplication(int a){
        if (oddeven(a)){
            return "짝수"; //짝수
        }else {
            return "홀수"; //홀수
        }
    }

    public String localSeparator(String a){
        return a.substring(0, 5);
    }

    public String sexDistinction(String a){
        return Character.toString(a.charAt(7));
    }

    //다음과 같은 문자열 a:b:c:d가 있다. 문자열의 replace 함수를 사용하여 a#b#c#d로 바꿔서 출력해 보자.
    public String replace(String a){
        return a.replace(":", "#");
    }

    //다음과 같은 [1, 3, 5, 4, 2] 리스트를 [5, 4, 3, 2, 1]로 만들어 보자.
    public List<Integer> sortedList(List<Integer> a){
        a.sort(Comparator.reverseOrder());
        return a;
    }

    //다음과 같은 문자열이 있다. 이 문자열을 공백을 기준으로 분리하여 리스트로 출력해 보자.
    public String joinPractice(List<String> a){
        String b = String.join(",", a);
        return b;
    }

     //완전 틀림
    public void removePractice(){
        HashMap<String, Integer> grade = new HashMap<>();
        grade.put("A", 90);
        grade.put("B", 80);
        grade.put("C", 70);
        int result = grade.remove("B");
        System.out.println(result);  // 80 출력
        System.out.println(grade);  // {A=90, C=70} 출력
    }

     //완전 틀림
    public void retainAllPractice(){
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5));
        HashSet<Integer> temp = new HashSet(numbers);  // List를 Set으로 변경
        ArrayList<Integer> result = new ArrayList<>(temp);  // Set을 다시 List로 변경
        System.out.println(result);  // [1, 2, 3, 4, 5] 출력
    }

    enum CoffeeType {
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE
    };

    static void printCoffeePrice(CoffeeType type) {
        HashMap<CoffeeType, Integer> priceMap = new HashMap<>();
        priceMap.put(CoffeeType.AMERICANO, 3000);  // 1: 아메리카노
        priceMap.put(CoffeeType.ICE_AMERICANO, 4000);  // 2: 아이스 아메리카노
        priceMap.put(CoffeeType.CAFE_LATTE, 5000);  // 3: 카페라떼
        int price = priceMap.get(type);
        System.out.println(String.format("가격은 %d원 입니다.", price));
    }


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
        printCoffeePrice(CoffeeType.AMERICANO);
        printCoffeePrice(CoffeeType.ICE_AMERICANO);
}




}
