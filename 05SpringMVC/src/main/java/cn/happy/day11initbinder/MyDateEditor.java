package cn.happy.day11initbinder;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/11/5.
 */
public class MyDateEditor extends PropertiesEditor {
    @Override
    public void setAsText(String source) throws IllegalArgumentException {
        //类型转换工作一定是在真正的handler方法执行前执行的
        SimpleDateFormat sdf = getDateFormat(source);
        try {
            Date date = sdf.parse(source);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private SimpleDateFormat getDateFormat(String source) {
        SimpleDateFormat sdf=new SimpleDateFormat();
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