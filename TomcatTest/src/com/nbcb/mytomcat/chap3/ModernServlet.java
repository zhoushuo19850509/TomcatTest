package com.nbcb.mytomcat.chap3;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 这本质上也是一个Servlet
 * 和之前PrimitiveServlet不同的是，这个Servlet拿到的request/response
 * 是HttpServletRequest/HttpServletResponse
 * 能够从request/response拿到更多的信息(Http header/cookies/parameters)
 */
public class ModernServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("servicing by the Modern servlet");
        PrintWriter out = servletResponse.getWriter();
        out.println("hello hello ,I'm the servlet");
        out.println("very glad to see you");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}


//public class ModernServlet extends HttpServlet{
//
//    public void service(HttpRequest servletRequest, HttpResponse servletResponse) throws ServletException, IOException {
//
//        /**
//         * do something here
//         */
//        System.out.println("servicing by the modern servlet");
//        PrintWriter out = servletResponse.getWriter();
//        out.println("hello hello ,I'm the modern servlet");
//        out.println("very glad to see you");
//
//    }
//
//}
