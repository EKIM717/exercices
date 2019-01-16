package enumTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StrManager {

	/**
	 * 鏄惁涓虹┖<br>
	 * 鍖呮嫭Null鍜�""
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str))
			return true;
		return false;
	}

	/**
	 * 鍘绘帀鍓嶅悗鏃犳剰涔夌殑瀛楃<br>
	 * 绌烘牸绛�
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		if (str == null)
			return null;
		return str.trim();
	}
	
	public static String dealNullStr(String str) {
		String ret = "";
		ret = str == null ? "" : str;
		return ret;
	}
	
	/**
	 * replaceAll("\\s*", "")鍙互鏇挎崲澶ч儴鍒嗙┖鐧藉瓧绗�<br>
	 * 涓嶉檺浜庣┖鏍� \s 鍙互鍖归厤绌烘牸銆佸埗琛ㄧ銆佹崲椤电绛夌┖鐧藉瓧绗︾殑鍏朵腑浠绘剰涓�涓�
	 * replaceAll("銆�", "")鐢ㄤ簬鏇挎崲鍏ㄨ鐨勭┖鏍煎瓧绗�
	 * @param str
	 * @return
	 */
	public static String replaceSpace(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("\\s*", "").replaceAll("銆�", "");
	}
	
	/**
	 * 鍒ゆ柇鏄惁鍚湁涓枃
	 * @param str
	 * @return
	 */
	public static boolean isChineseChar(String str) {
		boolean temp = false;
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			temp = true;
		}
		return temp;
	}

	/**
	 * 鍒ゆ柇鏄惁涓烘暟瀛楀瓧绗︼紝涓嶆槸鍒欒繑鍥瀟rue ,鏄垯杩斿洖false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean notNumberStr(String str) {
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (!isNumberic(c[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 鍒ゆ柇璇ュ瓧绗︽槸鍚︿负鏁板瀛楃锛堝惈灏忔暟鐐癸級锛屾槸鍒欒繑鍥瀟rue锛屼笉鏄垯杩斿洖false
	 * 
	 * @param c
	 * @return
	 */
	private static boolean isNumberic(char c) {
		if ((c >= '0' && c <= '9') || c == '.') {
			return true;
		}
		return false;
	}
	
	/**
	 * 鐢ㄤ簬dao鐨刬n璇彞<br>
	 * 杩斿洖涓�涓舰寮忓:'a','b','c'鐨勫瓧绗︿覆,<br>
	 * 濡傛灉Collection涓虹┖,鍒欒繑鍥�  ''
	 * @param subStr
	 * @return
	 */
	public static String constructInStatement(Collection<String> subStr) {
		StringBuffer sb = new StringBuffer("'");
		String[] array = new String[subStr.size()];
		subStr.toArray(array);//灏哻ollection鐨勫唴瀹瑰瓨鍏rray鏁扮粍涓�
		if(null != array && array.length > 0) {
			for(int i = 0; i < array.length; i++) {
				if(i == (array.length - 1)) {
					sb.append(array[i]);
				} else {
					sb.append(array[i] + "', '");
				}
			}
		}
		sb.append("'");
		return sb.toString();
	}

	/**
	 * 
	 * @param subStr 杈撳叆鐨勫瓧绗︿覆array
	 * @param limit 姣忔杈撳叆鐨勪釜鏁�
	 * @param from 浠庣鍑犱釜寮�濮�
	 * @return
	 */
//	public static String constructInStatement(Collection<String> subStr, int limit, int from) {
//		StringBuffer sb = new StringBuffer("'");
//		String[] array = new String[subStr.size()];
//		subStr.toArray(array);//灏哻ollection鐨勫唴瀹瑰瓨鍏rray鏁扮粍涓�
//		if(null != array && array.length > 0) {
//			//濡傛灉limit + from 瓒呰繃鎬荤殑瀛楃涓瞐rray闀垮害,鍒欎娇鐢ㄥ瓧绗︿覆闀垮害浣滀负寰幆缁撴潫鏍囧織
//			limit = (limit + from) > array.length ? array.length : (limit + from);
//			for(int i = from; i < limit; i++) {
//				if(i == (limit - 1)) {
//					sb.append(array[i]);
//				} else {
//					sb.append(array[i] + "', '");
//				}
//			}
//		}
//		sb.append("'");
//		return sb.toString();
//	}
	
	/**
	 * 杩斿洖涓�涓猻ize绛変簬page*pageCount鐨刢ollection瀵硅薄,size涓嶈冻灏变互""绌哄瓧绗︿覆琛ㄧず
	 * @param c (Collection瀵硅薄)
	 * @param page(椤垫暟)
	 * @param pageCount(姣忛〉鏁伴噺)
	 * @return
	 */
	public static List<String> constructInStatement(Collection<String> c, int page, int pageCount) {
		List<String> list = new ArrayList<String>();
		//鎶奡et鎴栬�匧ist鐨勫唴瀹硅祴鍊肩粰list
		for(String s : c) {
			list.add(s);
		}
		//灏戠殑鐢∟ULL琛ヤ笂
		for(int i = 0; i < page*pageCount-c.size(); i++) {
			list.add("NULL");
		}
		return list;
	}
	
	/**
	 * 鏋勯�燩reparedStatement鐨処N璇彞鐨勯棶鍙�
	 * @param limit
	 * @return
	 */
	public static String sqlInStatement(int limit) {
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < limit; i++) {
			sb.append("?,");
		}
		String s = sb.toString();
		return s.substring(0,s.lastIndexOf(','));//杩斿洖鍘绘帀鏈�鍚庝竴涓�楀彿鐨勫瓧绗︿覆
	}
}
