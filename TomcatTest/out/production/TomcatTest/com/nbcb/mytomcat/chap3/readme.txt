介绍Connector的原理：

==========================================本章和之前的区别
Connector和之前的Java容器有啥不一样呢？
其实原理还是差不多的，无非就是启动一个ServerSocket，然后监听来自客户端的请求。
解析完客户端请求后，实例化一个本地的servlet类，进行处理，处理完后把结果返回给客户端。

和之前不同之处有：
1.Connector是启动一个新的线程，通过ServerSocket来监听客户端请求；

2.这次的Request/Response和之前的不太一样。之前是实现了ServletRequest/ServletResponse
这次是实现了HttpServletRequest/HttpServletResponse
那这个和之前有什么不一样呢？
这次包含了更多HTTP请求的信息，包括：Http header/Cookies from client/parameters from url

3.可以看到，这章很多业务逻辑，都放到Prcessor类了，而不像之前，放在Request/Response类中

==========================================本章代码解读
1.入口：
BootStrap

2.新起线程监听来自客户端的socket请求：
HttpConnector

3.处理来自客户端的socket请求
HttpProcessor

4.
SocketInputStream.java
这个类的逻辑最丰富，
包括：
parseRequest()   // 读取客户端Http请求第一行
readHeader()     // 读取客户端Http请求的Http headers


5.
HttpRequest.java
HttpResponse.java

这一对request/response和第一章/第二章的request/response有所不同
之前的是实现ServletRequest/ServletResponse接口
这里是实现HttpRequest/HttpResponse接口

具体有什么不同呢？
我们看一下HttpServletRequest类的定义就知道了：
HttpServletRequest extends ServletRequest
HttpServletRequest是继承自ServletRequest，很显然，
HttpServletRequest的功能比ServletRequest更加丰富

具体体现在我们这章实现的：
在应用层(HTTP)，新增了很多内容，包括
parameters(保存在ParameterMap)
http headers()
cookies
等等

后续我们的Servlet，只要继承HttpServlet类，就能享受到
HttpServletRequest/HttpServletResponse对象中更加丰富的内容

6.HttpRequestLine
保存客户端HTTP请求第一行

7.处理类
ServletProcessor.java  // 处理动态资源
StaticResourceProcessor.java // 处理静态资源


==========================================客户端静态资源请求(来自浏览器)

我们从浏览器发起一个静态资源请求：
http://127.0.0.1:8080/index.html

服务端接收到的内容为：
GET /index.html HTTP/1.1
Host: 127.0.0.1:8080
User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:66.0) Gecko/20100101 Firefox/66.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Upgrade-Insecure-Requests: 1

我们看到，内容非常丰富
除了静态资源：index.html
还有http header
本章，我们就要解析来自客户端的http header/Cookies/session id/


==========================================客户端动态资源请求(来自浏览器)
http://127.0.0.1:8080/servlet/PrimitiveServlet

服务端接收到的内容为：
GET /servlet/PrimitiveServlet?name=zhoushuo&company=nbcb HTTP/1.1
Host: 127.0.0.1:8080
User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:66.0) Gecko/20100101 Firefox/66.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Upgrade-Insecure-Requests: 1
Cache-Control: max-age=0


parsed url: /servlet/PrimitiveServlet
servletName: PrimitiveServlet
repository: file:/home/zhoushuo/Documents/testGit/TomcatTest/webroot/


我们看到，内容非常丰富
除了客户端要请求的servlet： PrimitiveServlet
还有parameter： name=zhoushuo&company=nbcb
还有cookies等字段(cookie需要客户端上送)


==========================================心得体会
这章开始明显开始有点吃力。为啥呢？因为这章的代码是不全的。
很多类只是用到了，但是没有实现。
别怕！
热心网友已经把完整代码贴出来了。参考：
https://github.com/Aresyi/HowTomcatWorks.git

我们已经clone到本地了：
$HOME/Document/testGit/HowTomcatWorks

我们随时可以参考这里的代码。






