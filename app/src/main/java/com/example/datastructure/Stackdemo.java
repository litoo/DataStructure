package com.example.datastructure;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

/**
 * 栈
 */
public class Stackdemo<E> extends Vector {

    public Stackdemo() {
    }

    public int size() {
        return size();
    }

    public void push() {
    }


    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char str = s.charAt(i);
                if ('(' == str || '{' == str || '[' == str) {
                    stack.push(str);
                    continue;
                }
                char pops = stack.pop();
                if (pops == '(' && str != ')') {
                    return false;
                }
                if (pops == '{' && str != '}') {
                    return false;
                }
                if (pops == '[' && str != ']') {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

}
