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
	 * ����Ϊnull
	 */
	private static void setBufferNull() {
		byteBuffer = null;
	}

	private static void initialBuffer(int len) {
		byteBuffer = ByteBuffer.allocate(len);
	}

	/**
	 * ���Կռ����
	 */
	private static void putChar(char c) {
		//����һ���ֽڵĿռ�
		RandomAccessFile f = null;
		FileChannel channel = null;
		try {
			//����һ���ֽڳ���
			byteBuffer = ByteBuffer.allocate(1);
			outputInfo();
			byteBuffer.clear();
			outputInfo();
			try {
				//���buffer�ĳ���С�������ֽ�,�����쳣
				//BufferOverflowException - If there are fewer than two bytes remaining in this buffer
				byteBuffer.putChar(c);
			} catch (java.nio.BufferOverflowException e) {//��Ϊһ���ַ���8���ֽ�
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
