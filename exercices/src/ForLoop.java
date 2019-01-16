import org.junit.Test;

public class ForLoop {

	public static void main(String[] args) {
		String[] scopeArray = {
				"https://api.ebay.com/oauth/api_scope/sell.marketing",
				"https://api.ebay.com/oauth/api_scope/sell.analytics.readonly",
				"https://api.ebay.com/oauth/api_scope/sell.account"};
		String scope = "";
		for(int i = 0; i < scopeArray.length; i++) {
			scope += scopeArray[i];
			if(i < scopeArray.length-1) {
				scope += " ";
			}
		}
		System.out.println(scope);
	}
	
}
