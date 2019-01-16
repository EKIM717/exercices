package nio.bytebuffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class OutputLog {
	
	public static void main(String[] args) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder("bbbbbbbbb");
		createLog(sb, true);
	}
	
	private static void createLog(StringBuilder sb, boolean del) throws FileNotFoundException {
		RandomAccessFile f = null;
		FileChannel channel = null;
		ByteBuffer buf = null;
		try {
			File file = new File("E:\\log.txt");
			//�����Ҫɾ�������ļ��Ѵ���
			if (del && file.exists()) {
				file.delete();
				file = null;
			}
			f = new RandomAccessFile("E:\\log.txt", "rw");
			//�ļ�����
			long fileLength = f.length();
			channel = f.getChannel();
			//����Ϊ�ļ�ָ�����ļ�ĩβ,����׷��
			channel.position(fileLength);
			buf = ByteBuffer.allocate(48);
		
			String str = sb.toString();
			byte[] bytes = str.getBytes();
			//�ֶ��ٴδ�buffer��ȡ����
			int times = bytes.length / buf.capacity();
			times += bytes.length % buf.capacity() == 0? 0 : 1;
			int capacity = buf.capacity();
			for (int i = 0; i < times ; i++) {
				buf.clear();
				int offset = i * capacity;
				int dest = (i + 1) * capacity;
				dest = dest > (bytes.length -1)? bytes.length : dest;
				int len = dest - offset;
				buf.put(bytes, offset, len);
				buf.flip();
				while(buf.hasRemaining()) {
					
				    channel.write(buf);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (null != f) {
			try {
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
