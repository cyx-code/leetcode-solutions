package cyx.solution.leetcode.array;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 生成杨辉三角
 */
public class Generate {
    public static void main(String[] args) {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
//        try {
//            String dateStr = sdf.format(date);
//            Date hourTime = sdf.parse(dateStr);
//            System.out.println(hourTime);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar calendar = Calendar.getInstance();
//        int minute = calendar.get(Calendar.MINUTE);
//        int i = minute % 5 == 0 ? minute : (minute / 5) * 5;
//        System.out.println(i + ":0");
//        Date dateutil = new Date();
//        System.out.println(dateutil);
//        java.sql.Date datesql = new java.sql.Date(dateutil.getTime());
//        java.sql.Timestamp datesql2 = new Timestamp(dateutil.getTime());
//        System.out.println(datesql);
//        System.out.println(datesql2);
      /*  Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 7);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        try {
            String dateStr = sdf.format(calendar.getTime());
            Date hourTime = sdf.parse(dateStr);
            System.out.println(sdf.format(hourTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        //System.out.println(generate(6));
       /* Date now = new Date();
        int minute = 60000000 / 60;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, minute);
        Date invalidTime = new Date(calendar.getTime().getTime());
        System.out.println(invalidTime);*/

//        double i = Double.parseDouble("1.1");
//        int hourScope = (int) (i / 1);
//
//        System.out.println(hourScope);

//        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>(10);
//        map.put("1", "1");
//        System.out.println(map.size());
//        map.clear();
//        System.out.println(map == null);
//        System.out.println(map.size());
        try {
            return;
        } catch (Exception e) {

        } finally {
            System.out.println(11234567);
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    rows.add(1);
                } else {
                    rows.add(list.get(i - 2).get(j - 2) + list.get(i - 2).get(j - 1));
                }
            }
            list.add(rows);
        }
        return list;
    }
}
