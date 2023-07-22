package com.green.smart_grade.utils;

public class PagingUtils {
    public static int startIdx(int page){
        int result = page - 1;
        return  result*10;
    }

    public static int maxPage(int maxPage){
        return(int) Math.ceil((double) maxPage / 10);
    }

    public static int isMore(int maxPage,int page){
        return maxPage>page ? 1:0;
    }
}
