package club.chatnt.interceptor;

import club.chatnt.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 时间:20:26
 * 作者：Maibenben
 **/
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            response.setContentType("text/html;charset=UTF-8");
      response.sendRedirect("/service/login");
            return  true;
        }
        return  true;
    }
}
