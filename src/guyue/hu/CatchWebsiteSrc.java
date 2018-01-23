package guyue.hu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CatchWebsiteSrc {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("61.135.169.125", 80);//"61.135.169.125"是百度的主机IP，后面是端口
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		/**
		 * 下面3行内容是http协议，发往百度服务器端，以获取网站源代码
		 * (还有其他协议方式可以获取源代码，马士兵老师视频中提供了两种)
		 */
		pw.println("GET / HTTP/1.1");
		pw.println("Host:www.baidu.com");
		pw.println("Content-Type:text/html;charset=utf-8");
		pw.println();
		pw.flush();
		
		/**
		 * 构造InputStreamReader时，指定后面的charset，与网站编码一致
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
		String str = "";
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
		pw.close();
		s.close();
	}

}
