/*
## 기능 구현 목록

- 숫자별로 3, 6, 9 가 들어가는 횟수 count 하는 기능
- 1 ~ number 의 숫자별 3, 6, 9 개수 합산하는 기능
 */


package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = total369(number);
        return answer;
    }
    // Count Total 3, 6, 9 
    public static int total369(int number) {
        int total = 0;
        for (int i = 1; i <= number; i++) {
            total = total + count369(i);
        }
        return total;
    }
    public static int count369(int number) {
        int count = 0;
        String numString = String.valueOf(number);
        char digit;
        for (int i = 0; i < numString.length(); i++) {
            digit = numString.charAt(i);
            count = count + compare369(digit);
        }
        return count;
    }
    public static int compare369(char digit) {
        char[] compareList = {'3', '6', '9'};
        int count = 0;
        for(char c : compareList) {
            if(c == digit) {
                count = 1;
                break;
            }
        }
        return count;
    }
}
