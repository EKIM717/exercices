package util;

/**
 * å¿«é?Ÿæž„é€ SQL
 * @author Administrator
 *
 */
public class SeqUtil {
	public static void main(String[] args) {
		Object[][] list = {{	"BS1501",	"US",	1	}};
		
		for (Object[] str : list) {
			replace("product_local_area", str);
		}
	}
	
	public static void replace(String table, Object[] values) {
		StringBuilder sb = new StringBuilder();
		sb.append("REPLACE INTO " + table + " ")
		.append(" VALUES (");
		for (int i = 0; i < values.length; i++) {
			Object o = values[i];
			sb.append(value(o));
		}
		sb = sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		System.out.println(sb);
	}

	public static void Update(String table, String[] columns, Object[] values, String[] conditions, Object[] conValues) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + table + " ")
		.append(" SET ");
		for (int i = 0; i < columns.length; i++) {
			sb.append(columns[i] + "=");
			Object o = values[i];
			sb.append(value(o));
		}
		sb = sb.deleteCharAt(sb.length()-1);
		sb.append(" WHERE 1=1 ");
		for (int i = 0; i < conditions.length; i++) {
			sb.append(" AND " + conditions[i] + "=");
			Object o = conValues[i];
			sb.append(value(o));
		}
		System.out.println(sb);
	}
	
	private static String value(Object o) {
		StringBuilder sb = new StringBuilder();
		if (o instanceof String)
			sb.append("'" + o + "',");
		else if (o instanceof Integer) {
			o = (Integer)o;
			sb.append(o + ",");
		} else if (o instanceof Double) {
			o = (Double)o;
			sb.append(o + ",");
		} else if (o instanceof Float) {
			o = (Float)o;
			sb.append(o + ",");
		}
		return sb.toString();
	}
}
