package jdk11.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SocketChannelDemo {
	
	public  static void startClient()throws Exception{
		
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("localhost", 8999));
//		socketChannel.configureBlocking(false);
		
		String request = "hello 夜行侠老师";
		ByteBuffer buf = ByteBuffer.wrap(request.getBytes("UTF-8"));
		socketChannel.write(buf);
		
		
	    ByteBuffer rbuf = ByteBuffer.allocate(48);
	       int size =  socketChannel.read(rbuf);
	       while(size>0){
	    	  rbuf.flip();
	    	  Charset charset = Charset.forName("UTF-8");
	    	  System.out.println(charset.newDecoder().decode(rbuf));
	    	  rbuf.clear();
	    	  size =  socketChannel.read(rbuf);
	       }
	       buf.clear();
	       rbuf.clear();
		socketChannel.close();
		
		Thread.sleep(50000);
		
	}

	public static void main(String[] args) throws Exception {
		startClient();
	}
}
