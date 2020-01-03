package com.example.datastructure;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text =  findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Solution().isValid("[([]])");
            }
        });

    }

//    class Solution {
//        public boolean isValid(String s) {
//            Stack<Character> stack = new Stack<>();
//            for (int i = 0; i < s.length(); i++) {
//                char str = s.charAt(i);
//                if ('(' == str || '{' == str || '[' == str) {
//                    stack.push(str);
//                    continue;
//                }
//                char pops = stack.pop();
//                if (pops == '(' && str != ')') {
//                    return false;
//                }
//                if (pops == '{' && str != '}') {
//                    return false;
//                }
//                if (pops == '[' && str != ']') {
//                    return false;
//                }
//            }
//            return stack.isEmpty();
//        }
//    }
}
