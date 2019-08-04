Chap2 A Simple Servlet Container
一个简单的Servlet容器，能够处理来自客户端的servlet请求
为啥说这个容器是简单的呢？
因为这里执行的servlet是我们自己定义的(PrimitiveServlet.java)
而不是从war包自动解析的。

这个package下的代码：
PrimitiveServlet.java 我们自定义的servlet
客户端正是要请求这个servlet的执行结果。
ServletProcessor1/ServletProcessor2分别是两个版本的HttpServer处理客户端servlet请求的处理类

其他package下的代码：
Request.java
  为了能够处理servlet请求，需要实现ServletRequest interface
Response.java
  为了能够处理servlet响应，需要实现ServletResponse interface


