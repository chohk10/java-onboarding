/* 
## 기능 구현 목록

### 예외 처리
- 페이지 번호 리스트 길이 확인
- 페이지 번호 범위 확인
- 페이지 번호 연속성 확인
- 페이지 번호 홀/짝 확인

### 게임 구현
- 페이지 번호의 각 자리 숫자를 더하는 기능
- 페이지 번호의 각 자리 숫자를 곱하는 기능
- 페이지 별로 구한 값의 큰 수를 구하는 기능
- 플레이어 별 점수를 구하는 기능
- 게임 결과값 도출
*/


package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = -1;

        // Input Validation
        if (!isPageValid(pobi) || !isPageValid(crong)) {
            answer = -1;
        } else {
            // Get Player Scores
            int pobiScore = getScore(pobi);
            int crongScore = getScore(crong);        
            
            // Game Results
            if (pobiScore > crongScore) answer = 1;
            if (pobiScore < crongScore) answer = 2;
            if (pobiScore == crongScore) answer = 0;
        }
        
        return answer;
    }
    // Calculate Score
    public static int getScore(List<Integer> list) {
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        int maxLeft = Math.max(sumDigits(leftPage), mulDigits(leftPage));
        int maxRight = Math.max(sumDigits(rightPage), mulDigits(rightPage));
        int score = Math.max(maxLeft, maxRight);
        return score;
    }
    public static int sumDigits(int pageNum) {
        int sum = 0;
        int num = pageNum;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static int mulDigits(int page_num) {
        int mul = 1;
        int num = page_num;
        while(num != 0) {
            mul *= num % 10;
            num /= 10;
        }
        return mul;
    }  
    // Page Number Validation
    public static boolean isPageValid(List<Integer> list) {
        return isPageWithinRange(list) && isPageContinuous(list) && isPageEven(list) && isPageTwo(list);
    }
    public static boolean isPageWithinRange(List<Integer> list) {
        return (1 <= list.get(0) && list.get(0) <= 400 && 1<= list.get(1) && list.get(1) <= 400);
    }
    public static boolean isPageContinuous(List<Integer> list) {
        return list.get(1) == list.get(0) + 1;
    }
    public static boolean isPageEven(List<Integer> list) {
        return list.get(1) % 2 == 0;
    }   
    public static boolean isPageTwo(List<Integer> list) {
        return list.size() == 2;
    }
}
