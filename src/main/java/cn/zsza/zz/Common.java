package cn.zsza.zz;

import java.util.ArrayList;
import java.util.List;

/**
 * package: cn.zsza.zz
 * Time: 2020/4/13 17:31
 * Author: zs
 */
public class Common {
    /**
     * 生成26个字母表
     * @return
     */
    public static List<String> getDataLetters(){
        List<String> resultList = new ArrayList<>();

        int n = 97;
        while (n <= 122){
            char c = (char) n;
            resultList.add(String.valueOf(c));
            n++;
        }
        return resultList;
    }
}
