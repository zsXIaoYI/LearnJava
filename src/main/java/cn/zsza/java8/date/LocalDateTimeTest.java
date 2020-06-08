package cn.zsza.java8.date;

import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * package: cn.zsza.java8.date
 * Time: 2020/6/5 9:06
 * Author: zs
 */
public class LocalDateTimeTest {
    /**
     * 把字符串日期转换成LocalDate对象,打印改对象则返回年月日
     */
    @Test
    public void test1(){
        LocalDate localDate = LocalDate.parse("2017-12-02");
        System.out.println(localDate);

        LocalDate now = LocalDate.now();
        System.out.println(now);
    }
    /**
     * LocalDateTime.parse()参数：2019-06-05T16:19:43.123(只能是这样的参数)
     */
    @Test
    public void test2(){
        LocalDateTime dateTime = LocalDateTime.parse("2019-06-05T16:19:43.123");
        System.out.println(dateTime);

        // 字符串日期转换成localDateTime对象
        String strDate = "2018-01-05 12:30:05";
        LocalDateTime localDateTime = LocalDateTime.parse(strDate,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateTime);
    }
    /**
     * LocalDateTime格式化输出日期
     */
    @Test
    public void test3(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String strDateTime = format.format(dateTime);
        System.out.println(strDateTime);
        // 格式化输出年月日: DateTimeFormatter.ISO_LOCAL_DATEx`
        // 输出第几周,周几(2020-W23-5):DateTimeFormatter.ISO_WEEK_DATE
        String strDate = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(strDate);
    }
}
