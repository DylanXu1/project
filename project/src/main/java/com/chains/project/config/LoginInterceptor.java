package com.chains.project.config;

import com.chains.project.model.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xdx
 * @date 2020/4/14
 * @version 1.0
 */


  /*登录拦截器*/
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在请求被处理之前调用（Controller方法调用之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截请求：" + request.getRequestURL());
        // 检查每个到来的请求对应的session域中是否有登录标识
        User user =(User) request.getSession().getAttribute("loginUser");
        if (null == user ) {
            // 未登录，重定向到登录页
            response.sendRedirect("/login.html");
            System.out.println("返回false");
            return false;
        }
            System.out.println("返回true");
            return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截请求：" + request.getRequestURL());
        // 检查每个到来的请求对应的session域中是否有登录标识
        System.out.println("session中的user是："+"======");
        User user =(User) request.getSession().getAttribute("loginUser");
        System.out.println("session中的user是："+user);
        if (null == user ) {
            // 未登录，重定向到登录页
            response.sendRedirect("/login.html");
            System.out.println("返回false");
            //return false;
        }
        System.out.println("返回true");
        //return true;



    }

    /**
     * 在整个请求结束后调用
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}




