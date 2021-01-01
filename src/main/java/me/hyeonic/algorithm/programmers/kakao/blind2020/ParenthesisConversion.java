package me.hyeonic.algorithm.programmers.kakao.blind2020;

public class ParenthesisConversion {

    static boolean isCorrectParenthesis(String parenthesis) {
        int count = 0;
        for (char c : parenthesis.toCharArray()) {
            if (c == '(') ++count;
            else if (c == ')') --count;

            if (count < 0) return false;
        }
        return count == 0;
    }

    static String getCorrectParenthesis(String parenthesis) {

        /** 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환한다. */
        if (parenthesis.equals("")) {
            return parenthesis;
        } else {
            /** 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리한다.
             * 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있다. */
            int count = 0, index = 0;
            for (int i = 0; i <= parenthesis.length(); i++) {
                if (parenthesis.charAt(i) == '(') ++count;
                else if (parenthesis.charAt(i) == ')') --count;
                if (count == 0) {
                    index = i;
                    break;
                }
            }
            String u = parenthesis.substring(0, index + 1);
            String v = parenthesis.substring(index + 1);

            /** 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행한다. */
            if (isCorrectParenthesis(u)) {
                /** 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환한다. */
                return u + getCorrectParenthesis(v);
            } else { /** 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면  */
                /** 4-1. 빈 문자열에 첫 번째 문자로 '('을 붙인다. */
                StringBuilder stringBuilder = new StringBuilder("(");
                /** 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙인다. */
                stringBuilder.append(getCorrectParenthesis(v));
                /** 4-3. ')'를 다시 붙인다. */
                stringBuilder.append(")");

                /** 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙인다. */
                for (int i = 1; i < u.length() - 1; i++) {
                    if (u.charAt(i) == '(') {
                        stringBuilder.append(")");
                    } else if (u.charAt(i) == ')') {
                        stringBuilder.append("(");
                    }
                }

                /** 4-5. 생성된 문자열을 반환한다. */
                return stringBuilder.toString();
            }
        }
    }

    static String solution(String p) {
        String answer = getCorrectParenthesis(p);

        return answer;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "(()())()",
                ")(",
                "()))((()"
        };

        for (String p : inputs) {
            System.out.println(solution(p));
        }
    }
}
