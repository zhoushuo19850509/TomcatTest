����Connector��ԭ��

==========================================���º�֮ǰ������
Connector��֮ǰ��Java������ɶ��һ���أ�
��ʵԭ���ǲ��ģ��޷Ǿ�������һ��ServerSocket��Ȼ��������Կͻ��˵�����
������ͻ��������ʵ����һ�����ص�servlet�࣬���д����������ѽ�����ظ��ͻ��ˡ�

��֮ǰ��֮ͬ���У�
1.Connector������һ���µ��̣߳�ͨ��ServerSocket�������ͻ�������

2.��ε�Request/Response��֮ǰ�Ĳ�̫һ����֮ǰ��ʵ����ServletRequest/ServletResponse
�����ʵ����HttpServletRequest/HttpServletResponse
�������֮ǰ��ʲô��һ���أ�
��ΰ����˸���HTTP�������Ϣ��������Http header/Cookies from client/parameters from url

3.���Կ��������ºܶ�ҵ���߼������ŵ�Prcessor���ˣ�������֮ǰ������Request/Response����

==========================================���´�����
1.��ڣ�
BootStrap

2.�����̼߳������Կͻ��˵�socket����
HttpConnector

3.�������Կͻ��˵�socket����
HttpProcessor

4.
SocketInputStream.java
�������߼���ḻ��
������
parseRequest()   // ��ȡ�ͻ���Http�����һ��
readHeader()     // ��ȡ�ͻ���Http�����Http headers


5.
HttpRequest.java
HttpResponse.java

��һ��request/response�͵�һ��/�ڶ��µ�request/response������ͬ
֮ǰ����ʵ��ServletRequest/ServletResponse�ӿ�
������ʵ��HttpRequest/HttpResponse�ӿ�

������ʲô��ͬ�أ�
���ǿ�һ��HttpServletRequest��Ķ����֪���ˣ�
HttpServletRequest extends ServletRequest
HttpServletRequest�Ǽ̳���ServletRequest������Ȼ��
HttpServletRequest�Ĺ��ܱ�ServletRequest���ӷḻ

������������������ʵ�ֵģ�
��Ӧ�ò�(HTTP)�������˺ܶ����ݣ�����
parameters(������ParameterMap)
http headers()
cookies
�ȵ�

�������ǵ�Servlet��ֻҪ�̳�HttpServlet�࣬�������ܵ�
HttpServletRequest/HttpServletResponse�����и��ӷḻ������

6.HttpRequestLine
����ͻ���HTTP�����һ��

7.������
ServletProcessor.java  // ����̬��Դ
StaticResourceProcessor.java // ����̬��Դ


==========================================�ͻ��˾�̬��Դ����(���������)

���Ǵ����������һ����̬��Դ����
http://127.0.0.1:8080/index.html

����˽��յ�������Ϊ��
GET /index.html HTTP/1.1
Host: 127.0.0.1:8080
User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:66.0) Gecko/20100101 Firefox/66.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Upgrade-Insecure-Requests: 1

���ǿ��������ݷǳ��ḻ
���˾�̬��Դ��index.html
����http header
���£����Ǿ�Ҫ�������Կͻ��˵�http header/Cookies/session id/


==========================================�ͻ��˶�̬��Դ����(���������)
http://127.0.0.1:8080/servlet/PrimitiveServlet

����˽��յ�������Ϊ��
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


���ǿ��������ݷǳ��ḻ
���˿ͻ���Ҫ�����servlet�� PrimitiveServlet
����parameter�� name=zhoushuo&company=nbcb
����cookies���ֶ�(cookie��Ҫ�ͻ�������)


==========================================�ĵ����
���¿�ʼ���Կ�ʼ�е������Ϊɶ�أ���Ϊ���µĴ����ǲ�ȫ�ġ�
�ܶ���ֻ���õ��ˣ�����û��ʵ�֡�
���£�
���������Ѿ������������������ˡ��ο���
https://github.com/Aresyi/HowTomcatWorks.git

�����Ѿ�clone�������ˣ�
$HOME/Document/testGit/HowTomcatWorks

������ʱ���Բο�����Ĵ��롣






