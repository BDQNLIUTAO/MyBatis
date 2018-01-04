package cn.hibernate.day05opensessioninview.filter;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import org.hibernate.Transaction;

import java.io.IOException;

/**
 * Created by Administrator on 2017/12/31.
 */
public class OpenSessionInViewFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        Transaction tx = HibernateUtil.getSession().beginTransaction();
        tx.commit();
        HibernateUtil.closeSession();
        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
