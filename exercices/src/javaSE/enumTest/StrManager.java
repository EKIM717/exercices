package javaSE.enumTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StrManager {

	/**
	 * 閺勵垰鎯佹稉铏光敄<br>
	 * 閸栧懏瀚璑ull閸滐拷""
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str))
			return true;
		return false;
	}

	/**
	 * 閸樼粯甯�閸撳秴鎮楅弮鐘冲壈娑斿娈戠�涙顑�<br>
	 * 缁岀儤鐗哥粵锟�
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
	 * replaceAll("\\s*", "")閸欘垯浜掗弴鎸庡床婢堆囧劥閸掑棛鈹栭惂钘夌摟缁楋拷<br>
	 * 娑撳秹妾烘禍搴ｂ敄閺嶏拷 \s 閸欘垯浜掗崠褰掑帳缁岀儤鐗搁妴浣稿煑鐞涖劎顑侀妴浣瑰床妞ょ數顑佺粵澶屸敄閻ц棄鐡х粭锔炬畱閸忔湹鑵戞禒缁樺壈娑擄拷娑擄拷
	 * replaceAll("閵嗭拷", "")閻€劋绨弴鎸庡床閸忋劏顫楅惃鍕敄閺嶇厧鐡х粭锟�
	 * @param str
	 * @return
	 */
	public static String replaceSpace(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("\\s*", "").replaceAll("閵嗭拷", "");
	}
	
	/**
	 * 閸掋倖鏌囬弰顖氭儊閸氼偅婀佹稉顓熸瀮
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
	 * 閸掋倖鏌囬弰顖氭儊娑撶儤鏆熺�涙鐡х粭锔肩礉娑撳秵妲搁崚娆掔箲閸ョ�焤ue ,閺勵垰鍨潻鏂挎礀false
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
	 * 閸掋倖鏌囩拠銉ョ摟缁楋附妲搁崥锔胯礋閺佹澘顒熺�涙顑侀敍鍫濇儓鐏忓繑鏆熼悙鐧哥礆閿涘本妲搁崚娆掔箲閸ョ�焤ue閿涘奔绗夐弰顖氬灟鏉╂柨娲杅alse
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
	 * 閻€劋绨琩ao閻ㄥ埇n鐠囶厼褰�<br>
	 * 鏉╂柨娲栨稉锟芥稉顏勮埌瀵繐顩�:'a','b','c'閻ㄥ嫬鐡х粭锔胯,<br>
	 * 婵″倹鐏塁ollection娑撹櫣鈹�,閸掓瑨绻戦崶锟�  ''
	 * @param subStr
	 * @return
	 */
	public static String constructInStatement(Collection<String> subStr) {
		StringBuffer sb = new StringBuffer("'");
		String[] array = new String[subStr.size()];
		subStr.toArray(array);//鐏忓摶ollection閻ㄥ嫬鍞寸�圭懓鐡ㄩ崗顧ray閺佹壆绮嶆稉锟�
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
	 * @param subStr 鏉堟挸鍙嗛惃鍕摟缁楋缚瑕哸rray
	 * @param limit 濮ｅ繑顐兼潏鎾冲弳閻ㄥ嫪閲滈弫锟�
	 * @param from 娴犲海顑囬崙鐘遍嚋瀵拷婵拷
	 * @return
	 */
//	public static String constructInStatement(Collection<String> subStr, int limit, int from) {
//		StringBuffer sb = new StringBuffer("'");
//		String[] array = new String[subStr.size()];
//		subStr.toArray(array);//鐏忓摶ollection閻ㄥ嫬鍞寸�圭懓鐡ㄩ崗顧ray閺佹壆绮嶆稉锟�
//		if(null != array && array.length > 0) {
//			//婵″倹鐏塴imit + from 鐡掑懓绻冮幀鑽ゆ畱鐎涙顑佹稉鐬恟ray闂�鍨,閸掓瑤濞囬悽銊ョ摟缁楋缚瑕嗛梹鍨娴ｆ粈璐熷顏嗗箚缂佹挻娼弽鍥х箶
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
	 * 鏉╂柨娲栨稉锟芥稉鐚籭ze缁涘绨琾age*pageCount閻ㄥ垻ollection鐎电钖�,size娑撳秷鍐荤亸鍙樹簰""缁屽搫鐡х粭锔胯鐞涖劎銇�
	 * @param c (Collection鐎电钖�)
	 * @param page(妞ゅ灚鏆�)
	 * @param pageCount(濮ｅ繘銆夐弫浼村櫤)
	 * @return
	 */
	public static List<String> constructInStatement(Collection<String> c, int page, int pageCount) {
		List<String> list = new ArrayList<String>();
		//閹跺ァet閹存牞锟藉導ist閻ㄥ嫬鍞寸�圭绁撮崐鑲╃舶list
		for(String s : c) {
			list.add(s);
		}
		//鐏忔垹娈戦悽鈭烾LL鐞涖儰绗�
		for(int i = 0; i < page*pageCount-c.size(); i++) {
			list.add("NULL");
		}
		return list;
	}
	
	/**
	 * 閺嬪嫰锟界嚛reparedStatement閻ㄥ嚘N鐠囶厼褰為惃鍕６閸欙拷
	 * @param limit
	 * @return
	 */
	public static String sqlInStatement(int limit) {
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < limit; i++) {
			sb.append("?,");
		}
		String s = sb.toString();
		return s.substring(0,s.lastIndexOf(','));//鏉╂柨娲栭崢缁樺竴閺堬拷閸氬簼绔存稉顏堬拷妤�褰块惃鍕摟缁楋缚瑕�
	}
}
