package javaSE.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile f1 = new RandomAccessFile("F:\\t1.txt", "rw");
		RandomAccessFile f2 = new RandomAccessFile("F:\\t2.txt", "rw");
		RandomAccessFile[] files = new RandomAccessFile[]{f1, f2};
		ByteBuffer buf = ByteBuffer.allocate(48);
		int capacity = buf.capacity();
		FileChannel channel = null;
		for (RandomAccessFile f : files) {
			channel = f.getChannel();
			String s = "testing1testing2testing3testing4testing5testing6testing7testing8";
			byte[] b = s.getBytes();
			boolean over = s.length() % capacity == 0? false : true;
			int page = s.length()/capacity;
			if (over)
				page++;
			for (int i = 0; i < page; i++) {
				buf.clear();
				buf.rewind();
				if (i == (page - 1))
					buf.put(b, i * capacity, b.length - i * capacity);
				else
					buf.put(b, i * capacity, capacity);
				buf.flip();
				System.out.println("before write--" + buf.position());
				while(buf.hasRemaining()) {
					//read the next two bytes
					System.out.println(buf.getChar());
					channel.write(buf);
				}
				System.out.println("after write--" + buf.position());
			}
		}
		if (null != channel)
			channel.close();
	}
}
