package com.example.ls.lsn11_meterialdesign_translucentscrolltoolbar;

import java.util.ArrayList;

/**
 * Created by 路很长~ on 2018/3/14.
 */

public class DataArray {
    public static void main(String[] argus) {
        ArrayList<String> baseArray = new ArrayList<>();
        for (int i = 1; i < 147; i++) {
            baseArray.add("" + i);
        }
        System.out.println(baseArray.toString());
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46]
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10,  a, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,  b, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46]
        ArrayList<String> charArray = new ArrayList<>();
        charArray.add("a");
        charArray.add("b");
        charArray.add("c");
        charArray.add("d");
        charArray.add("e");
        charArray.add("f");
        charArray.add("g");
        charArray.add("h");
        int zu = baseArray.size() / 10;
        for (int i = 1,j=0; i <=zu; i++,j++) {
                if(j==7){
                    j=0;
                }
                baseArray.add(10 * i + i - 1, charArray.get(j));

        }
       /* baseArray.add(10, "a");
        baseArray.add(10 * 2 + 1, "b");
        baseArray.add(10 * 3 + 2, "c");
        baseArray.add(10 * 4 + 3, "d");
        baseArray.add(10 * 5 + 4, "e");
        baseArray.add(10 * 6 + 5, "f");
        baseArray.add(10 * 7 + 6, "g");
        baseArray.add(10 * 8 + 7, "h");*/

        System.out.print(baseArray.toString());


    }
}
