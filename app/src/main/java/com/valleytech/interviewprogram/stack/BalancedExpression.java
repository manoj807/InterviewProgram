package com.valleytech.interviewprogram.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedExpression {

    static Map<Character, Character> map = new HashMap<Character, Character>();

    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    static String validateExpression(String expression) {

        if(expression.length()%2 == 1) {
            return "NO";
        }
        Stack<Character> stack = new Stack<Character>();
        for(char c:expression.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(c);
            } else if(stack.isEmpty() || map.get(stack.pop()) != c) {
                return "NO";
            }
        }

        return stack.isEmpty()?"YES":"NO";
    }

    public static void main(String a[]) {
        System.out.println(BalancedExpression.validateExpression("{()}[]{([)]()}"));
    }
}
