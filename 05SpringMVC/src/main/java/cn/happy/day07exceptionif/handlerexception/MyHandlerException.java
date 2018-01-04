package cn.happy.day07exceptionif.handlerexception;

import cn.happy.day07exceptionif.exceptions.AgeException;
import cn.happy.day07exceptionif.exceptions.NameException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/11/3.
 */
public class MyHandlerException implements HandlerExceptionResolver {
    /**
     *
     * @param request  请求对象
     * @param response  响应对象
     * @param handler   处理器
     * @param ex   异常
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv=new ModelAndView();
        //判断mv是否受NameException异常
        if (ex instanceof NameException){
            mv.addObject("ex",ex);
            mv.setViewName("/error/nameerrors.jsp");
        }
        if (ex instanceof AgeException){
            mv.addObject("ex",ex);
            mv.setViewName("/error/ageerrors.jsp");
        }
        return mv;
    }
}
