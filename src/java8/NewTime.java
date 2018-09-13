package java8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * @author zk
 * @Description:
Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
Local(本地) − 简化了日期时间的处理，没有时区的问题。
Zoned(时区) − 通过制定的时区处理日期时间。
新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作。
 * @date 2018-09-04 11:37
 */
public class NewTime {

    public static void main(String args[]){
        //jdk1.8之前的,有线程安全问题
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);

        //jdk 1.8
        NewTime java8tester = new NewTime();
        java8tester.testLocalDateTime();
        java8tester.testZonedDateTime();

        ZonedDateTime beijingOlympicOpenning = ZonedDateTime.of(2008, 8, 8, 20, 0, 0, 0, ZoneId.of("Asia/Shanghai"));
        String formattered = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(beijingOlympicOpenning);
        System.out.println(formattered);    //2008年8月8日 星期五 下午08时00分00秒 CST

        String formattered2 = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm").format(beijingOlympicOpenning);
        System.out.println(formattered2); // 星期五 2008-08-08 20:00

    }


    /**
     * LocalDate/LocalTime 和 LocalDateTime 类可以在处理时区不是必须的情况。代码如下：
     */
    public void testLocalDateTime(){

        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    /**
     * 如果我们需要考虑到时区，就可以使用时区的日期时间API：
     */
    public void testZonedDateTime(){

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

}
