package cn.happy.day09typeconverter.converter;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/11/4.
 */
public class MyDateConverter implements Converter<String,Date> {
    //网线传入的字符串加工成Date
    public Date convert(String source) {
        //类型转换工作一定是在真正的handler方法执行前执行的
        SimpleDateFormat sdf=getDateFormat(source);
        try {
            Date date = sdf.parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SimpleDateFormat getDateFormat(String source) {
        SimpleDateFormat sdf=null;
        if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",source)){
            sdf=new SimpleDateFormat("yyyy-MM-dd");
        }else if (Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$",source)){
            sdf=new SimpleDateFormat("yyyy/MM/dd");
        }else if (Pattern.matches("^\\d{4}年\\d{2}月\\d{2}日$",source)){
            sdf=new SimpleDateFormat("yyyy年MM月dd日");
        }else {
            throw new TypeMismatchException("",Date.class);
        }
        return sdf;
    }
}
