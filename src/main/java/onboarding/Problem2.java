/* 
## 기능 구현 목록

### 예외 처리
- 암호 문자열 길이 확인 

### 해독 기능
- 연속하는 중복 문자를 삭제하는 기능
	- 연속하는 중복 문자가 있는지 확인
		- 연속하는 중복 문자가 있는 경우 중복 문자만 삭제
		- 연속하는 중복 문자가 없는 경우 종료
*/

package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        answer = decrypt(cryptogram);
        return answer;
    }
    // 암호 해독
    public static String decrypt(String encrypted) {
        String decrypted = encrypted;
        String bool = getBool(decrypted);
        int index;
        while (bool == "true") {
            index = getIndex(decrypted);
            decrypted = removeDup(decrypted, index);
            bool = getBool(decrypted);
            if (bool == "false") break;
        }
        return decrypted;
    }
    // 중복 문자 제거
    public static String removeDup(String word, int idx) {
        String dupRemoved = word.substring(0, idx) + word.substring(idx+2);
        return dupRemoved;
    }
    // 중복 여부 및 중복 위치 확인
    public static String[] checkDup(String word) {
        String[] dupIndex = new String[2];
        dupIndex[0] = "false";
        dupIndex[1] = "1000";

        for (int i = 0; i < (word.length()-1); i++) {
            char prevChar = word.charAt(i);
            char nextChar = word.charAt(i+1);
            if (prevChar == nextChar) {
                dupIndex[0] = "true";
                dupIndex[1] = String.valueOf(i);
                break;
            }
        }
        return dupIndex;
    }
    public static String getBool(String word) {
        String bool;
        bool = checkDup(word)[0];
        return bool;
    }
    public static int getIndex(String word) {
        int index = 1000;
        index = Integer.valueOf(checkDup(word)[1]);
        return index;
    }
}
