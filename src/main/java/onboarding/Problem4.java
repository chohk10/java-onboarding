/*
## 기능 구현 목록
- 청개구리 사전 (대소문자 각각)
- 알파벳 외 문자에 대한 처리
 */

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += treeFrog(word.charAt(i));
        }
        return answer;
    }
    public static char treeFrog(char alpha) {
        char frogAlpha;
        if ('A' <= alpha && alpha <= 'Z') {
            frogAlpha = (char)('A' + 'Z' - alpha);
        } else if ('a' <= alpha && alpha <= 'z') {
            frogAlpha = (char)('a' + 'z' - alpha);
        } else frogAlpha = alpha;
        return frogAlpha;
    }
}
