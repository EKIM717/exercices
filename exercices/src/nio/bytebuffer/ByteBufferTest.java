package nio.bytebuffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
	
	private static ByteBuffer byteBuffer = null;
	
	private static String testFile = "E:\\t.txt";

	public static void main(String[] args) {
		initialBuffer(1);
		putChar('a');
		setBufferNull();
	}
	
	/**
	 * 设置为null
	 */
	private static void setBufferNull() {
		byteBuffer = null;
	}

	private static void initialBuffer(int len) {
		byteBuffer = ByteBuffer.allocate(len);
	}

	/**
	 * 测试空间溢出
	 */
	private static void putChar(char c) {
		//申请一个字节的空间
		RandomAccessFile f = null;
		FileChannel channel = null;
		try {
			//定义一个字节长度
			byteBuffer = ByteBuffer.allocate(1);
			outputInfo();
			byteBuffer.clear();
			outputInfo();
			try {
				//如果buffer的长度小于两个字节,会抛异常
				//BufferOverflowException - If there are fewer than two bytes remaining in this buffer
				byteBuffer.putChar(c);
			} catch (java.nio.BufferOverflowException e) {//因为一个字符有8个字节
				e.printStackTrace();
				return;
			}
			byteBuffer.flip();
			f = new RandomAccessFile(testFile, "rw");
			channel = f.getChannel();
			while (byteBuffer.hasRemaining()) {
				channel.write(byteBuffer);
			}
			channel.close();
			f.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void outputInfo() {
		if (null == byteBuffer)
			return;
		
		System.out.println("---------------------------------");
		System.out.println("capacity: " + byteBuffer.capacity());
		System.out.println("limit: " + byteBuffer.limit());
		System.out.println("mark: " + byteBuffer.mark());
		System.out.println("remaining: " + byteBuffer.remaining());
		System.out.println("position: " + byteBuffer.position());
	}
	
	
}
