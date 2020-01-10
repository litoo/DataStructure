package com.example.datastructure

/**
 * leetcode
 */
class Solution {
    /**
     * 20
     */
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()
        for (i in 0 until s.length) {
            if (s[i] == '{' || s[i] == '[' || s[i] == '(') {
                stack.add(s[i])
            } else {
                if (stack.isEmpty())
                    return false
                val popStr = stack.last()
                stack.removeAt(stack.size - 1)
                if (s[i] == '}' && popStr != '{')
                    return false
                if (s[i] == ']' && popStr != '[')
                    return false
                if (s[i] == ')' && popStr != '(')
                    return false

            }
        }
        return stack.isEmpty()
    }
}