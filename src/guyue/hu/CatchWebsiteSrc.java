package guyue.hu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CatchWebsiteSrc {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("61.135.169.125", 80);//"61.135.169.125"�ǰٶȵ�����IP�������Ƕ˿�
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		/**
		 * ����3��������httpЭ�飬�����ٶȷ������ˣ��Ի�ȡ��վԴ����
		 * (��������Э�鷽ʽ���Ի�ȡԴ���룬��ʿ����ʦ��Ƶ���ṩ������)
		 */
		pw.println("GET / HTTP/1.1");
		pw.println("Host:www.baidu.com");
		pw.println("Content-Type:text/html;charset=utf-8");
		pw.println();
		pw.flush();
		
		/**
		 * ����InputStreamReaderʱ��ָ�������charset������վ����һ��
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
