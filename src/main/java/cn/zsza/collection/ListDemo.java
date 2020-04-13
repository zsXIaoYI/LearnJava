package cn.zsza.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * package: cn.zsza.collection
 * Time: 2020/4/13 10:38
 * Author: zs
 */
public class ListDemo {
    /**
     *  [1, 2, 3, 4, 5]
     *  当前元素之前的元素进行累加并赋值给当前元素
     */
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> resultList = new ArrayList<>();

        int temp = 0;
        for (int i = 0; i < list.size(); i++){
            Integer ele = list.get(i);
            temp += ele;
            if (i == 0){
                resultList.add(ele);
            }else {
                resultList.add(temp);
            }
        }
        System.out.println(resultList);
    }
}
