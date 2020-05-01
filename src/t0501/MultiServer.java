package t0501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer extends DBConImpl{
	
	public MultiServer() {
		super("kosmo","1234");
	}
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String s = "";
		String name = "";
		DBInsert db;
		
		
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");

			socket = serverSocket.accept();
			
			//서버에서 클라이언트쪽으로 메세지를 출력하기위한 스트림이다.
			out = new PrintWriter(socket.getOutputStream(), true);
			
			//클라이언트로부터 메세지를 받기 위한 스트림
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			if(in != null) {
				name = in.readLine();
				System.out.println(name +" 접속");
				out.println("> "+ name +"님이 접속했습니다.");
			}

			while(in != null) {
				s = in.readLine();
				if(s==null) {
					break;
				}
				System.out.println(name +" ==> "+ s);
				out.println(">  "+ name +" ==> "+ s);
				db = new DBInsert(name,s);
				db.execute();
			}

			System.out.println("Bye...!!!");
		}
		catch (Exception e) {
			System.out.println("예외1:"+ e);
		}
		finally {
			try {
				in.close();
				out.close();
				socket.close();
				serverSocket.close();
			}
			catch (Exception e) {
				System.out.println("예외2:"+ e);
			}
		}
	}
}