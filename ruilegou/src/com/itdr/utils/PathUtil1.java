package com.itdr.utils;

public class PathUtil1 {
    public static String getPath(String path){
        String s1 = path.replace(".","/");
        System.out.println(s1);
        String []sar = s1.split("/");
        System.out.println(sar[3]);
        return sar[3];

    }
}
