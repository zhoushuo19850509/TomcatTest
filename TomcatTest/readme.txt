this project follows the famous book: <How Tomcat works>


============================================总体概念
关于什么是Tomcat
Tomcat其实就是Java容器，所谓的Java容器，和web server不一样的地方，就是能够执行Java代码。
并且将Java代码执行结果返回给客户端。

关于什么是Servlet
Servlet就是定义在服务端的Java类，这个Java类只要实现了javax.servlet.Servlet接口
客户端就能够直接通过HTTP服务来调用这个Servlet，服务端能够把这个Servlet的执行结果返回给客户端

============================================github源码示例
https://github.com/Aresyi/HowTomcatWorks


============================================代码说明
主入口:
HttpServer.java

chap1 A Simple Web Server
就像题目说的一样，这章主要是创建了一个简单的web server
我们启动HttpServer.java之后，客户端能够通过如下url:
http://localhost:8080/index.html
获取到一个静态页面








