package javaSE.string;

public class ConcatStr {

	
	public static  void main(String[] args) {
		String s = "SKU	平台	站点	公司	发货仓库	销售类型	销售属性	平台费率	汇兑损益率	退换货率	VAT率	利润率	利润额	采购价	国际运费	邮费	税费	结果1	结果2	最低售价	货币";
				String[] str = s.split("\t");
		System.out.println("\"");
		for (String ss : str) {
			System.out.print(ss);
			System.out.print(",");
		}
		System.out.println("\"");
	}
}
