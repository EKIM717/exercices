package javaSE.enumTest;

/**
 * 
 */

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for Country similar com.ebay.soap.eBLBaseComponents.CountryCodeType
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Country">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="AF"/>
 *     &lt;enumeration value="AL"/>
 *     &lt;enumeration value="DZ"/>
 *     &lt;enumeration value="AS"/>
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="AO"/>
 *     &lt;enumeration value="AI"/>
 *     &lt;enumeration value="AQ"/>
 *     &lt;enumeration value="AG"/>
 *     &lt;enumeration value="AR"/>
 *     &lt;enumeration value="AM"/>
 *     &lt;enumeration value="AW"/>
 *     &lt;enumeration value="AU"/>
 *     &lt;enumeration value="AT"/>
 *     &lt;enumeration value="AZ"/>
 *     &lt;enumeration value="BS"/>
 *     &lt;enumeration value="BH"/>
 *     &lt;enumeration value="BD"/>
 *     &lt;enumeration value="BB"/>
 *     &lt;enumeration value="BY"/>
 *     &lt;enumeration value="BE"/>
 *     &lt;enumeration value="BZ"/>
 *     &lt;enumeration value="BJ"/>
 *     &lt;enumeration value="BM"/>
 *     &lt;enumeration value="BT"/>
 *     &lt;enumeration value="BO"/>
 *     &lt;enumeration value="BA"/>
 *     &lt;enumeration value="BW"/>
 *     &lt;enumeration value="BV"/>
 *     &lt;enumeration value="BR"/>
 *     &lt;enumeration value="IO"/>
 *     &lt;enumeration value="BN"/>
 *     &lt;enumeration value="BG"/>
 *     &lt;enumeration value="BF"/>
 *     &lt;enumeration value="BI"/>
 *     &lt;enumeration value="KH"/>
 *     &lt;enumeration value="CM"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="CV"/>
 *     &lt;enumeration value="KY"/>
 *     &lt;enumeration value="CF"/>
 *     &lt;enumeration value="TD"/>
 *     &lt;enumeration value="CL"/>
 *     &lt;enumeration value="CN"/>
 *     &lt;enumeration value="CX"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="CO"/>
 *     &lt;enumeration value="KM"/>
 *     &lt;enumeration value="CG"/>
 *     &lt;enumeration value="CD"/>
 *     &lt;enumeration value="CK"/>
 *     &lt;enumeration value="CR"/>
 *     &lt;enumeration value="CI"/>
 *     &lt;enumeration value="HR"/>
 *     &lt;enumeration value="CU"/>
 *     &lt;enumeration value="CY"/>
 *     &lt;enumeration value="CZ"/>
 *     &lt;enumeration value="DK"/>
 *     &lt;enumeration value="DJ"/>
 *     &lt;enumeration value="DM"/>
 *     &lt;enumeration value="DO"/>
 *     &lt;enumeration value="TP"/>
 *     &lt;enumeration value="EC"/>
 *     &lt;enumeration value="EG"/>
 *     &lt;enumeration value="SV"/>
 *     &lt;enumeration value="GQ"/>
 *     &lt;enumeration value="ER"/>
 *     &lt;enumeration value="EE"/>
 *     &lt;enumeration value="ET"/>
 *     &lt;enumeration value="FK"/>
 *     &lt;enumeration value="FO"/>
 *     &lt;enumeration value="FJ"/>
 *     &lt;enumeration value="FI"/>
 *     &lt;enumeration value="FR"/>
 *     &lt;enumeration value="GF"/>
 *     &lt;enumeration value="PF"/>
 *     &lt;enumeration value="TF"/>
 *     &lt;enumeration value="GA"/>
 *     &lt;enumeration value="GM"/>
 *     &lt;enumeration value="GE"/>
 *     &lt;enumeration value="DE"/>
 *     &lt;enumeration value="GH"/>
 *     &lt;enumeration value="GI"/>
 *     &lt;enumeration value="GR"/>
 *     &lt;enumeration value="GL"/>
 *     &lt;enumeration value="GD"/>
 *     &lt;enumeration value="GP"/>
 *     &lt;enumeration value="GU"/>
 *     &lt;enumeration value="GT"/>
 *     &lt;enumeration value="GN"/>
 *     &lt;enumeration value="GW"/>
 *     &lt;enumeration value="GY"/>
 *     &lt;enumeration value="HT"/>
 *     &lt;enumeration value="HM"/>
 *     &lt;enumeration value="VA"/>
 *     &lt;enumeration value="HN"/>
 *     &lt;enumeration value="HK"/>
 *     &lt;enumeration value="HU"/>
 *     &lt;enumeration value="IS"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="ID"/>
 *     &lt;enumeration value="IR"/>
 *     &lt;enumeration value="IQ"/>
 *     &lt;enumeration value="IE"/>
 *     &lt;enumeration value="IM"/>
 *     &lt;enumeration value="IL"/>
 *     &lt;enumeration value="IT"/>
 *     &lt;enumeration value="JM"/>
 *     &lt;enumeration value="JP"/>
 *     &lt;enumeration value="JO"/>
 *     &lt;enumeration value="KZ"/>
 *     &lt;enumeration value="KE"/>
 *     &lt;enumeration value="KI"/>
 *     &lt;enumeration value="KP"/>
 *     &lt;enumeration value="KR"/>
 *     &lt;enumeration value="KW"/>
 *     &lt;enumeration value="KG"/>
 *     &lt;enumeration value="LA"/>
 *     &lt;enumeration value="LV"/>
 *     &lt;enumeration value="LB"/>
 *     &lt;enumeration value="LS"/>
 *     &lt;enumeration value="LR"/>
 *     &lt;enumeration value="LY"/>
 *     &lt;enumeration value="LI"/>
 *     &lt;enumeration value="LT"/>
 *     &lt;enumeration value="LU"/>
 *     &lt;enumeration value="MO"/>
 *     &lt;enumeration value="MK"/>
 *     &lt;enumeration value="MG"/>
 *     &lt;enumeration value="MW"/>
 *     &lt;enumeration value="MY"/>
 *     &lt;enumeration value="MV"/>
 *     &lt;enumeration value="ML"/>
 *     &lt;enumeration value="MT"/>
 *     &lt;enumeration value="MH"/>
 *     &lt;enumeration value="MQ"/>
 *     &lt;enumeration value="MR"/>
 *     &lt;enumeration value="MU"/>
 *     &lt;enumeration value="YT"/>
 *     &lt;enumeration value="MX"/>
 *     &lt;enumeration value="FM"/>
 *     &lt;enumeration value="MD"/>
 *     &lt;enumeration value="MC"/>
 *     &lt;enumeration value="MN"/>
 *     &lt;enumeration value="MS"/>
 *     &lt;enumeration value="MA"/>
 *     &lt;enumeration value="MZ"/>
 *     &lt;enumeration value="MM"/>
 *     &lt;enumeration value="NA"/>
 *     &lt;enumeration value="NR"/>
 *     &lt;enumeration value="NP"/>
 *     &lt;enumeration value="NL"/>
 *     &lt;enumeration value="AN"/>
 *     &lt;enumeration value="NC"/>
 *     &lt;enumeration value="NZ"/>
 *     &lt;enumeration value="NI"/>
 *     &lt;enumeration value="NE"/>
 *     &lt;enumeration value="NG"/>
 *     &lt;enumeration value="NU"/>
 *     &lt;enumeration value="NF"/>
 *     &lt;enumeration value="MP"/>
 *     &lt;enumeration value="NO"/>
 *     &lt;enumeration value="OM"/>
 *     &lt;enumeration value="PK"/>
 *     &lt;enumeration value="PW"/>
 *     &lt;enumeration value="PS"/>
 *     &lt;enumeration value="PA"/>
 *     &lt;enumeration value="PG"/>
 *     &lt;enumeration value="PY"/>
 *     &lt;enumeration value="PE"/>
 *     &lt;enumeration value="PH"/>
 *     &lt;enumeration value="PN"/>
 *     &lt;enumeration value="PL"/>
 *     &lt;enumeration value="PT"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="QA"/>
 *     &lt;enumeration value="RE"/>
 *     &lt;enumeration value="RO"/>
 *     &lt;enumeration value="RU"/>
 *     &lt;enumeration value="RW"/>
 *     &lt;enumeration value="SH"/>
 *     &lt;enumeration value="KN"/>
 *     &lt;enumeration value="LC"/>
 *     &lt;enumeration value="PM"/>
 *     &lt;enumeration value="VC"/>
 *     &lt;enumeration value="WS"/>
 *     &lt;enumeration value="SM"/>
 *     &lt;enumeration value="ST"/>
 *     &lt;enumeration value="SA"/>
 *     &lt;enumeration value="SN"/>
 *     &lt;enumeration value="SC"/>
 *     &lt;enumeration value="SL"/>
 *     &lt;enumeration value="SG"/>
 *     &lt;enumeration value="SK"/>
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="SB"/>
 *     &lt;enumeration value="SO"/>
 *     &lt;enumeration value="ZA"/>
 *     &lt;enumeration value="GS"/>
 *     &lt;enumeration value="ES"/>
 *     &lt;enumeration value="LK"/>
 *     &lt;enumeration value="SD"/>
 *     &lt;enumeration value="SR"/>
 *     &lt;enumeration value="SJ"/>
 *     &lt;enumeration value="SZ"/>
 *     &lt;enumeration value="SE"/>
 *     &lt;enumeration value="CH"/>
 *     &lt;enumeration value="SY"/>
 *     &lt;enumeration value="TW"/>
 *     &lt;enumeration value="TJ"/>
 *     &lt;enumeration value="TZ"/>
 *     &lt;enumeration value="TH"/>
 *     &lt;enumeration value="TG"/>
 *     &lt;enumeration value="TK"/>
 *     &lt;enumeration value="TO"/>
 *     &lt;enumeration value="TT"/>
 *     &lt;enumeration value="TN"/>
 *     &lt;enumeration value="TR"/>
 *     &lt;enumeration value="TM"/>
 *     &lt;enumeration value="TC"/>
 *     &lt;enumeration value="TV"/>
 *     &lt;enumeration value="UG"/>
 *     &lt;enumeration value="UA"/>
 *     &lt;enumeration value="AE"/>
 *     &lt;enumeration value="GB"/>
 *     &lt;enumeration value="US"/>
 *     &lt;enumeration value="UM"/>
 *     &lt;enumeration value="UY"/>
 *     &lt;enumeration value="UZ"/>
 *     &lt;enumeration value="VU"/>
 *     &lt;enumeration value="VE"/>
 *     &lt;enumeration value="VN"/>
 *     &lt;enumeration value="VG"/>
 *     &lt;enumeration value="VI"/>
 *     &lt;enumeration value="WF"/>
 *     &lt;enumeration value="EH"/>
 *     &lt;enumeration value="YE"/>
 *     &lt;enumeration value="YU"/>
 *     &lt;enumeration value="ZM"/>
 *     &lt;enumeration value="ZW"/>
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="QM"/>
 *     &lt;enumeration value="QN"/>
 *     &lt;enumeration value="QO"/>
 *     &lt;enumeration value="QP"/>
 *     &lt;enumeration value="JE"/>
 *     &lt;enumeration value="GG"/>
 *     &lt;enumeration value="ZZ"/>
 *     &lt;enumeration value="RS"/>
 *     &lt;enumeration value="ME"/>
 *     &lt;enumeration value="CustomCode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * Note: Per JAXB standards, underscores are added to separate words in enumerations (e.g., PayPal becomes PAY_PAL).
 */
@XmlType(name = "Country")
@XmlEnum
public enum Country {


	/**
	 * 
	 * 						Afghanistan.
	 * 					
	 * 
	 */
	AF("Afghanistan", Continent.ASIA),

	/**
	 * 
	 * 						Albania.
	 * 					
	 * 
	 */
	AL("Albania", Continent.EUROPE),

	/**
	 * 
	 * 						Algeria.
	 * 					
	 * 
	 */
	DZ("Algeria", Continent.AFRICA),

	/**
	 * 
	 * 						American Samoa.
	 * 					
	 * 
	 */
	AS("American Samoa", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Andorra.
	 * 					
	 * 
	 */
	AD("Andorra", Continent.EUROPE),

	/**
	 * 
	 * 						Angola.
	 * 					
	 * 
	 */
	AO("Angola", Continent.AFRICA),

	/**
	 * 
	 * 						Anguilla.
	 * 					
	 * 
	 */
	AI("Anguilla", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Antarctica.
	 * 					
	 * 
	 */
	AQ("Antarctica", Continent.ANTARCTICA),

	/**
	 * 
	 * 						Antigua and Barbuda.
	 * 					
	 * 
	 */
	AG("Antigua and Barbuda", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Argentina.
	 * 					
	 * 
	 */
	AR("Argentina", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Armenia.
	 * 					
	 * 
	 */
	AM("Armenia", Continent.ASIA),

	/**
	 * 
	 * 						Aruba.
	 * 					
	 * 
	 */
	AW("Aruba", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Australia.
	 * 					
	 * 
	 */
	AU("Australia", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Austria.
	 * 					
	 * 
	 */
	AT("Austria", Continent.EUROPE),

	/**
	 * 
	 * 						Azerbaijan.
	 * 					
	 * 
	 */
	AZ("Azerbaijan", Continent.ASIA),

	/**
	 * 
	 * 						Bahamas.
	 * 					
	 * 
	 */
	BS("Bahamas", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Bahrain.
	 * 					
	 * 
	 */
	BH("Bahrain", Continent.ASIA),

	/**
	 * 
	 * 						Bangladesh.
	 * 					
	 * 
	 */
	BD("Bangladesh", Continent.ASIA),

	/**
	 * 
	 * 						Barbados.
	 * 					
	 * 
	 */
	BB("Barbados", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Belarus.
	 * 					
	 * 
	 */
	BY("Belarus", Continent.EUROPE),

	/**
	 * 
	 * 						Belgium.
	 * 					
	 * 
	 */
	BE("Belgium", Continent.EUROPE),

	/**
	 * 
	 * 						Belize .
	 * 					
	 * 
	 */
	BZ("Belize", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Benin.
	 * 					
	 * 
	 */
	BJ("Benin", Continent.AFRICA),

	/**
	 * 
	 * 						Bermuda.
	 * 					
	 * 
	 */
	BM("Bermuda", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Bhutan.
	 * 					
	 * 
	 */
	BT("Bhutan", Continent.ASIA),

	/**
	 * 
	 * 						Bolivia.
	 * 					
	 * 
	 */
	BO("Bolivia", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Bosnia and Herzegovina.
	 * 					
	 * 
	 */
	BA("Bosnia and Herzegovina", Continent.EUROPE),

	/**
	 * 
	 * 						Botswana.
	 * 					
	 * 
	 */
	BW("Botswana", Continent.AFRICA),

	/**
	 * 
	 * 						Bouvet Island.
	 * 					
	 * 
	 */
	BV("Bouvet Island", Continent.UNKNOWN),

	/**
	 * 
	 * 						Brazil.
	 * 					
	 * 
	 */
	BR("Brazil", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						British Indian Ocean Territory.
	 * 					
	 * 
	 */
	IO("British Indian Ocean Territory", Continent.UNKNOWN),

	/**
	 * 
	 * 						Brunei Darussalam.
	 * 					
	 * 
	 */
	BN("Brunei Darussalam", Continent.ASIA),

	/**
	 * 
	 * 						Bulgaria.
	 * 					
	 * 
	 */
	BG("Bulgaria", Continent.EUROPE),

	/**
	 * 
	 * 						Burkina Faso.
	 * 					
	 * 
	 */
	BF("Burkina Faso", Continent.AFRICA),

	/**
	 * 
	 * 						Burundi.
	 * 					
	 * 
	 */
	BI("Burundi", Continent.AFRICA),

	/**
	 * 
	 * 						Cambodia.
	 * 					
	 * 
	 */
	KH("Cambodia", Continent.ASIA),

	/**
	 * 
	 * 						Cameroon.
	 * 					
	 * 
	 */
	CM("Cameroon", Continent.AFRICA),

	/**
	 * 
	 * 						Canada.
	 * 					
	 * 
	 */
	CA("Canada", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Cape Verde.
	 * 					
	 * 
	 */
	CV("Cape Verde", Continent.AFRICA),

	/**
	 * 
	 * 						Cayman Islands.
	 * 					
	 * 
	 */
	KY("Cayman Islands", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Central African Republic.
	 * 					
	 * 
	 */
	CF("Central African Republic", Continent.AFRICA),

	/**
	 * 
	 * 						Chad.
	 * 					
	 * 
	 */
	TD("Chad", Continent.AFRICA),

	/**
	 * 
	 * 						Chile.
	 * 					
	 * 
	 */
	CL("Chile", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						China.
	 * 					
	 * 
	 */
	CN("China", Continent.ASIA),

	/**
	 * 
	 * 						Christmas Island.
	 * 					
	 * 
	 */
	CX("Christmas Island", Continent.UNKNOWN),

	/**
	 * 
	 * 						Cocos (Keeling) Islands.
	 * 					
	 * 
	 */
	CC("Cocos (Keeling) Islands", Continent.UNKNOWN),

	/**
	 * 
	 * 						Colombia.
	 * 					
	 * 
	 */
	CO("Colombia", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Comoros.
	 * 					
	 * 
	 */
	KM("Comoros", Continent.AFRICA),

	/**
	 * 
	 * 						Congo.
	 * 					
	 * 
	 */
	CG("Congo", Continent.AFRICA),

	/**
	 * 
	 * 						Congo, The Democratic Republic of the.
	 * 					
	 * 
	 */
	CD("The Democratic Republic of Congo", Continent.AFRICA),

	/**
	 * 
	 * 						Cook Islands.
	 * 					
	 * 
	 */
	CK("Cook Islands", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Costa Rica.
	 * 					
	 * 
	 */
	CR("Costa Rica", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Cote d'Ivoire.
	 * 					
	 * 
	 */
	CI("Cote d'Ivoire", Continent.AFRICA),

	/**
	 * 
	 * 						Croatia.
	 * 					
	 * 
	 */
	HR("Croatia", Continent.EUROPE),

	/**
	 * 
	 * 						Cuba.
	 * 					
	 * 
	 */
	CU("Cuba", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Cyprus.
	 * 					
	 * 
	 */
	CY("Cyprus", Continent.EUROPE),

	/**
	 * 
	 * 						Czech Republic.
	 * 					
	 * 
	 */
	CZ("Czech Republic", Continent.EUROPE),

	/**
	 * 
	 * 						Denmark.
	 * 					
	 * 
	 */
	DK("Denmark", Continent.EUROPE),

	/**
	 * 
	 * 						Djibouti.
	 * 					
	 * 
	 */
	DJ("Djibouti", Continent.AFRICA),

	/**
	 * 
	 * 						Dominica.
	 * 					
	 * 
	 */
	DM("Dominica", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Dominican Republic.
	 * 					
	 * 
	 */
	DO("Dominican Republic", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						No longer in use.
	 * 					
	 * 
	 */
	TP("TP", Continent.UNKNOWN),

	/**
	 * 
	 * 						Ecuador.
	 * 					
	 * 
	 */
	EC("Ecuador", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Egypt.
	 * 					
	 * 
	 */
	EG("Egypt", Continent.AFRICA),

	/**
	 * 
	 * 						El Salvador.
	 * 					
	 * 
	 */
	SV("El Salvador", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Equatorial Guinea.
	 * 					
	 * 
	 */
	GQ("Equatorial Guinea", Continent.AFRICA),

	/**
	 * 
	 * 						Eritrea.
	 * 					
	 * 
	 */
	ER("Eritrea", Continent.AFRICA),

	/**
	 * 
	 * 						Estonia.
	 * 					
	 * 
	 */
	EE("Estonia", Continent.EUROPE),

	/**
	 * 
	 * 						Ethiopia.
	 * 					
	 * 
	 */
	ET("Ethiopia", Continent.AFRICA),

	/**
	 * 
	 * 						Falkland Islands (Malvinas).
	 * 					
	 * 
	 */
	FK("Falkland Islands", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Faroe Islands.
	 * 					
	 * 
	 */
	FO("Faroe Islands", Continent.EUROPE),

	/**
	 * 
	 * 						Fiji.
	 * 					
	 * 
	 */
	FJ("Fiji", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Finland.
	 * 					
	 * 
	 */
	FI("Finland", Continent.EUROPE),

	/**
	 * 
	 * 						France.
	 * 					
	 * 
	 */
	FR("France", Continent.EUROPE),

	/**
	 * 
	 * 						French Guiana.
	 * 					
	 * 
	 */
	GF("French Guiana", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						French Polynesia. Includes Tahiti.
	 * 					
	 * 
	 */
	PF("French Polynesia", Continent.AUSTRALIA),

	/**
	 * 
	 * 						French Southern Territories.
	 * 					
	 * 
	 */
	TF("French Southern Territories", Continent.UNKNOWN),

	/**
	 * 
	 * 						Gabon.
	 * 					
	 * 
	 */
	GA("Gabon", Continent.AFRICA),

	/**
	 * 
	 * 						Gambia.
	 * 					
	 * 
	 */
	GM("Gambia", Continent.AFRICA),

	/**
	 * 
	 * 						Georgia.
	 * 					
	 * 
	 */
	GE("Georgia", Continent.ASIA),

	/**
	 * 
	 * 						Germany.
	 * 					
	 * 
	 */
	DE("Germany", Continent.EUROPE),

	/**
	 * 
	 * 						Ghana.
	 * 					
	 * 
	 */
	GH("Ghana", Continent.AFRICA),

	/**
	 * 
	 * 						Gibraltar.
	 * 					
	 * 
	 */
	GI("Gibraltar", Continent.UNKNOWN),

	/**
	 * 
	 * 						Greece.
	 * 					
	 * 
	 */
	GR("Greece", Continent.EUROPE),

	/**
	 * 
	 * 						Greenland.
	 * 					
	 * 
	 */
	GL("Greenland", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Grenada.
	 * 					
	 * 
	 */
	GD("Grenada", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Guadeloupe.
	 * 					
	 * 
	 */
	GP("Guadeloupe", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Guam.
	 * 					
	 * 
	 */
	GU("Guam", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Guatemala.
	 * 					
	 * 
	 */
	GT("Guatemala", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Guinea.
	 * 					
	 * 
	 */
	GN("Guinea", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Guinea-Bissau.
	 * 					
	 * 
	 */
	GW("Guinea-Bissau", Continent.AFRICA),

	/**
	 * 
	 * 						Guyana.
	 * 					
	 * 
	 */
	GY("Guyana", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Haiti.
	 * 					
	 * 
	 */
	HT("Haiti", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Heard Island and Mcdonald Islands.
	 * 					
	 * 
	 */
	HM("Heard Island and Mcdonald Islands", Continent.UNKNOWN),

	/**
	 * 
	 * 						Holy See (Vatican City state).
	 * 					
	 * 
	 */
	VA("Vatican City state", Continent.EUROPE),

	/**
	 * 
	 * 						Honduras.
	 * 					
	 * 
	 */
	HN("Honduras", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Hong Kong.
	 * 					
	 * 
	 */
	HK("Hong Kong", Continent.ASIA),

	/**
	 * 
	 * 						Hungary.
	 * 					
	 * 
	 */
	HU("Hungary", Continent.EUROPE),

	/**
	 * 
	 * 						Iceland.
	 * 					
	 * 
	 */
	IS("Iceland", Continent.EUROPE),

	/**
	 * 
	 * 						India.
	 * 					
	 * 
	 */
	IN("India", Continent.ASIA),

	/**
	 * 
	 * 						Indonesia.
	 * 					
	 * 
	 */
	ID("Indonesia", Continent.ASIA),

	/**
	 * 
	 * 						Iran, Islamic Republic of.
	 * 					
	 * 
	 */
	IR("Iran, Islamic Republic of", Continent.ASIA),

	/**
	 * 
	 * 						Iraq.
	 * 					
	 * 
	 */
	IQ("Iraq", Continent.ASIA),

	/**
	 * 
	 * 						Ireland.
	 * 					
	 * 
	 */
	IE("Ireland", Continent.EUROPE),

	/**
	 * 
	 * 						Isle of Man.
	 * 					
	 * 
	 */
	IM("Isle of Man", Continent.EUROPE),

	/**
	 * 
	 * 						Israel.
	 * 					
	 * 
	 */
	IL("Israel", Continent.ASIA),

	/**
	 * 
	 * 						Italy.
	 * 					
	 * 
	 */
	IT("Italy", Continent.EUROPE),

	/**
	 * 
	 * 						Jamaica.
	 * 					
	 * 
	 */
	JM("Jamaica", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Japan.
	 * 					
	 * 
	 */
	JP("Japan", Continent.ASIA),

	/**
	 * 
	 * 						Jordan.
	 * 					
	 * 
	 */
	JO("Jordan", Continent.ASIA),

	/**
	 * 
	 * 						Kazakhstan.
	 * 					
	 * 
	 */
	KZ("Kazakhstan", Continent.ASIA),

	/**
	 * 
	 * 						Kenya.
	 * 					
	 * 
	 */
	KE("Kenya", Continent.AFRICA),

	/**
	 * 
	 * 						Kiribati.
	 * 					
	 * 
	 */
	KI("Kiribati", Continent.UNKNOWN),

	/**
	 * 
	 * 						Korea, Democratic People's Republic of.
	 * 					
	 * 
	 */
	KP("Korea, Democratic People's Republic of", Continent.ASIA),

	/**
	 * 
	 * 						Korea, Republic of.
	 * 					
	 * 
	 */
	KR("Korea, Republic of", Continent.ASIA),

	/**
	 * 
	 * 						Kuwait.
	 * 					
	 * 
	 */
	KW("Kuwait", Continent.ASIA),

	/**
	 * 
	 * 						Kyrgyzstan.
	 * 					
	 * 
	 */
	KG("Kyrgyzstan", Continent.ASIA),

	/**
	 * 
	 * 						Lao People's Democratic Republic.
	 * 					
	 * 
	 */
	LA("Lao People's Democratic Republic", Continent.ASIA),

	/**
	 * 
	 * 						Latvia.
	 * 					
	 * 
	 */
	LV("Latvia", Continent.EUROPE),

	/**
	 * 
	 * 						Lebanon.
	 * 					
	 * 
	 */
	LB("Lebanon", Continent.ASIA),

	/**
	 * 
	 * 						Lesotho.
	 * 					
	 * 
	 */
	LS("Lesotho", Continent.AFRICA),

	/**
	 * 
	 * 						Liberia.
	 * 					
	 * 
	 */
	LR("Liberia", Continent.AFRICA),

	/**
	 * 
	 * 						Libyan Arab Jamahiriya.
	 * 					
	 * 
	 */
	LY("Libyan Arab Jamahiriya", Continent.AFRICA),

	/**
	 * 
	 * 						Liechtenstein.
	 * 					
	 * 
	 */
	LI("Liechtenstein", Continent.EUROPE),

	/**
	 * 
	 * 						Lithuania.
	 * 					
	 * 
	 */
	LT("Lithuania", Continent.EUROPE),

	/**
	 * 
	 * 						Luxembourg.
	 * 					
	 * 
	 */
	LU("Luxembourg", Continent.EUROPE),

	/**
	 * 
	 * 						Macao.
	 * 					
	 * 
	 */
	MO("Macao", Continent.ASIA),

	/**
	 * 
	 * 						Macedonia, the Former Yugoslav Republic of.
	 * 					
	 * 
	 */
	MK("Macedonia", Continent.EUROPE),

	/**
	 * 
	 * 						Madagascar.
	 * 					
	 * 
	 */
	MG("Madagascar", Continent.AFRICA),

	/**
	 * 
	 * 						Malawi.
	 * 					
	 * 
	 */
	MW("Malawi", Continent.AFRICA),

	/**
	 * 
	 * 						Malaysia.
	 * 					
	 * 
	 */
	MY("Malaysia", Continent.ASIA),

	/**
	 * 
	 * 						Maldives.
	 * 					
	 * 
	 */
	MV("Maldives", Continent.ASIA),

	/**
	 * 
	 * 						Mali.
	 * 					
	 * 
	 */
	ML("Mali", Continent.AFRICA),

	/**
	 * 
	 * 						Malta.
	 * 					
	 * 
	 */
	MT("Malta", Continent.EUROPE),

	/**
	 * 
	 * 						Marshall Islands.
	 * 					
	 * 
	 */
	MH("Marshall Islands", Continent.UNKNOWN),

	/**
	 * 
	 * 						Martinique.
	 * 					
	 * 
	 */
	MQ("Martinique", Continent.ASIA),

	/**
	 * 
	 * 						Mauritania.
	 * 					
	 * 
	 */
	MR("Mauritania", Continent.AFRICA),

	/**
	 * 
	 * 						Mauritius.
	 * 					
	 * 
	 */
	MU("Mauritius", Continent.AFRICA),

	/**
	 * 
	 * 						Mayotte.
	 * 					
	 * 
	 */
	YT("Mayotte", Continent.AFRICA),

	/**
	 * 
	 * 						Mexico.
	 * 					
	 * 
	 */
	MX("Mexico", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Micronesia, Federated States of.
	 * 					
	 * 
	 */
	FM("Micronesia, Federated States of", Continent.ASIA),

	/**
	 * 
	 * 						Moldova, Republic of.
	 * 					
	 * 
	 */
	MD("Moldova, Republic of", Continent.EUROPE),

	/**
	 * 
	 * 						Monaco.
	 * 					
	 * 
	 */
	MC("Monaco", Continent.EUROPE),

	/**
	 * 
	 * 						Mongolia.
	 * 					
	 * 
	 */
	MN("Mongolia", Continent.ASIA),

	/**
	 * 
	 * 						Montserrat.
	 * 					
	 * 
	 */
	MS("Montserrat", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Morocco.
	 * 					
	 * 
	 */
	MA("Morocco", Continent.AFRICA),

	/**
	 * 
	 * 						Mozambique.
	 * 					
	 * 
	 */
	MZ("Mozambique", Continent.AFRICA),

	/**
	 * 
	 * 						Myanmar.
	 * 					
	 * 
	 */
	MM("Myanmar", Continent.ASIA),

	/**
	 * 
	 * 						Namibia.
	 * 					
	 * 
	 */
	NA("Namibia", Continent.AFRICA),

	/**
	 * 
	 * 						Nauru.
	 * 					
	 * 
	 */
	NR("Nauru", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Nepal.
	 * 					
	 * 
	 */
	NP("Nepal", Continent.ASIA),

	/**
	 * 
	 * 						Netherlands.
	 * 					
	 * 
	 */
	NL("Netherlands", Continent.EUROPE),

	/**
	 * 
	 * 						Netherlands Antilles.
	 * 					
	 * 
	 */
	AN("Netherlands Antilles", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						New Caledonia.
	 * 					
	 * 
	 */
	NC("New Caledonia", Continent.AUSTRALIA),

	/**
	 * 
	 * 						New Zealand.
	 * 					
	 * 
	 */
	NZ("New Zealand", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Nicaragua.
	 * 					
	 * 
	 */
	NI("Nicaragua", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Niger.
	 * 					
	 * 
	 */
	NE("Niger", Continent.AFRICA),

	/**
	 * 
	 * 						Nigeria.
	 * 					
	 * 
	 */
	NG("Nigeria", Continent.AFRICA),

	/**
	 * 
	 * 						Niue.
	 * 					
	 * 
	 */
	NU("Niue", Continent.UNKNOWN),

	/**
	 * 
	 * 						Norfolk Island.
	 * 					
	 * 
	 */
	NF("Norfolk Island", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Northern Mariana Islands.
	 * 					
	 * 
	 */
	MP("Northern Mariana Islands", Continent.ASIA),

	/**
	 * 
	 * 						Norway.
	 * 					
	 * 
	 */
	NO("Norway", Continent.EUROPE),

	/**
	 * 
	 * 						Oman.
	 * 					
	 * 
	 */
	OM("Oman", Continent.ASIA),

	/**
	 * 
	 * 						Pakistan.
	 * 					
	 * 
	 */
	PK("Pakistan", Continent.ASIA),

	/**
	 * 
	 * 						Palau.
	 * 					
	 * 
	 */
	PW("Palau", Continent.ASIA),

	/**
	 * 
	 * 						Palestinian territory, Occupied.
	 * 					
	 * 
	 */
	PS("Palestinian territory, Occupied", Continent.UNKNOWN),

	/**
	 * 
	 * 						Panama.
	 * 					
	 * 
	 */
	PA("Panama", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Papua New Guinea.
	 * 					
	 * 
	 */
	PG("Papua New Guinea", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Paraguay.
	 * 					
	 * 
	 */
	PY("Paraguay", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Peru.
	 * 					
	 * 
	 */
	PE("Peru", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Philippines.
	 * 					
	 * 
	 */
	PH("Philippines", Continent.ASIA),

	/**
	 * 
	 * 						Pitcairn.
	 * 					
	 * 
	 */
	PN("Pitcairn", Continent.UNKNOWN),

	/**
	 * 
	 * 						Poland.
	 * 					
	 * 
	 */
	PL("Poland", Continent.EUROPE),

	/**
	 * 
	 * 						Portugal.
	 * 					
	 * 
	 */
	PT("Portugal", Continent.EUROPE),

	/**
	 * 
	 * 						Puerto Rico.
	 * 					
	 * 
	 */
	PR("Puerto Rico", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Qatar.
	 * 					
	 * 
	 */
	QA("Qatar", Continent.ASIA),

	/**
	 * 
	 * 						Reunion.
	 * 					
	 * 
	 */
	RE("Reunion", Continent.AFRICA),

	/**
	 * 
	 * 						Romania.
	 * 					
	 * 
	 */
	RO("Romania", Continent.EUROPE),

	/**
	 * 
	 * 						Russian Federation.
	 * 					
	 * 
	 */
	RU("Russian Federation", Continent.EUROPE),

	/**
	 * 
	 * 						Rwanda.
	 * 					
	 * 
	 */
	RW("Rwanda", Continent.AFRICA),

	/**
	 * 
	 * 						Saint Helena.
	 * 					
	 * 
	 */
	SH("Saint Helena", Continent.UNKNOWN),

	/**
	 * 
	 * 						Saint Kitts and Nevis.
	 * 					
	 * 
	 */
	KN("Saint Kitts and Nevis", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Saint Lucia.
	 * 					
	 * 
	 */
	LC("Saint Lucia", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Saint Pierre and Miquelon.
	 * 					
	 * 
	 */
	PM("Saint Pierre and Miquelon", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Saint Vincent and the Grenadines.
	 * 					
	 * 
	 */
	VC("Saint Vincent and the Grenadines", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Samoa.
	 * 					
	 * 
	 */
	WS("Samoa", Continent.UNKNOWN),

	/**
	 * 
	 * 						San Marino.
	 * 					
	 * 
	 */
	SM("San Marino", Continent.EUROPE),

	/**
	 * 
	 * 						Sao Tome and Principe.
	 * 					
	 * 
	 */
	ST("Sao Tome and Principe", Continent.AFRICA),

	/**
	 * 
	 * 						Saudi Arabia.
	 * 					
	 * 
	 */
	SA("Saudi Arabia", Continent.ASIA),

	/**
	 * 
	 * 						Senegal.
	 * 					
	 * 
	 */
	SN("Senegal", Continent.AFRICA),

	/**
	 * 
	 * 						Seychelles.
	 * 					
	 * 
	 */
	SC("Seychelles", Continent.AFRICA),

	/**
	 * 
	 * 						Sierra Leone.
	 * 					
	 * 
	 */
	SL("Sierra Leone", Continent.AFRICA),

	/**
	 * 
	 * 						Singapore.
	 * 					
	 * 
	 */
	SG("Singapore", Continent.ASIA),

	/**
	 * 
	 * 						Slovakia.
	 * 					
	 * 
	 */
	SK("Slovakia", Continent.EUROPE),

	/**
	 * 
	 * 						Slovenia.
	 * 					
	 * 
	 */
	SI("Slovenia", Continent.EUROPE),

	/**
	 * 
	 * 						Solomon Islands.
	 * 					
	 * 
	 */
	SB("Solomon Islands", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Somalia.
	 * 					
	 * 
	 */
	SO("Somalia", Continent.AFRICA),

	/**
	 * 
	 * 						South Africa.
	 * 					
	 * 
	 */
	ZA("South Africa", Continent.AFRICA),

	/**
	 * 
	 * 						South Georgia and the South Sandwich Islands.
	 * 					
	 * 
	 */
	GS("South Georgia and the South Sandwich Islands", Continent.UNKNOWN),

	/**
	 * 
	 * 						Spain.
	 * 					
	 * 
	 */
	ES("Spain", Continent.EUROPE),

	/**
	 * 
	 * 						Sri Lanka.
	 * 					
	 * 
	 */
	LK("Sri Lanka", Continent.ASIA),

	/**
	 * 
	 * 						Sudan.
	 * 					
	 * 
	 */
	SD("Sudan", Continent.AFRICA),

	/**
	 * 
	 * 						Suriname.
	 * 					
	 * 
	 */
	SR("Suriname", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Svalbard and Jan Mayen.
	 * 					
	 * 
	 */
	SJ("Svalbard and Jan Mayen", Continent.EUROPE),

	/**
	 * 
	 * 						Swaziland.
	 * 					
	 * 
	 */
	SZ("Swaziland", Continent.AFRICA),

	/**
	 * 
	 * 						Sweden.
	 * 					
	 * 
	 */
	SE("Sweden", Continent.EUROPE),

	/**
	 * 
	 * 						Switzerland.
	 * 					
	 * 
	 */
	CH("Switzerland", Continent.EUROPE),

	/**
	 * 
	 * 						Syrian Arab Republic.
	 * 					
	 * 
	 */
	SY("Syrian Arab Republic", Continent.ASIA),

	/**
	 * 
	 * 						Taiwan, Province of China.
	 * 					
	 * 
	 */
	TW("Taiwan", Continent.ASIA),

	/**
	 * 
	 * 						Tajikistan.
	 * 					
	 * 
	 */
	TJ("Tajikistan", Continent.ASIA),

	/**
	 * 
	 * 						Tanzania, United Republic of.
	 * 					
	 * 
	 */
	TZ("Tanzania, United Republic of", Continent.AFRICA),

	/**
	 * 
	 * 						Thailand.
	 * 					
	 * 
	 */
	TH("Thailand", Continent.ASIA),

	/**
	 * 
	 * 						Togo.
	 * 					
	 * 
	 */
	TG("Togo", Continent.AFRICA),

	/**
	 * 
	 * 						Tokelau.
	 * 					
	 * 
	 */
	TK("Tokelau", Continent.UNKNOWN),

	/**
	 * 
	 * 						Tonga.
	 * 					
	 * 
	 */
	TO("Tonga", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Trinidad and Tobago.
	 * 					
	 * 
	 */
	TT("Trinidad and Tobago", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Tunisia.
	 * 					
	 * 
	 */
	TN("Tunisia", Continent.AFRICA),

	/**
	 * 
	 * 						Turkey.
	 * 					
	 * 
	 */
	TR("Turkey", Continent.EUROPE),

	/**
	 * 
	 * 						Turkmenistan.
	 * 					
	 * 
	 */
	TM("Turkmenistan", Continent.ASIA),

	/**
	 * 
	 * 						Turks and Caicos Islands.
	 * 					
	 * 
	 */
	TC("Turks and Caicos Islands", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						Tuvalu.
	 * 					
	 * 
	 */
	TV("Tuvalu", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Uganda.
	 * 					
	 * 
	 */
	UG("Uganda", Continent.AFRICA),

	/**
	 * 
	 * 						Ukraine.
	 * 					
	 * 
	 */
	UA("Ukraine", Continent.EUROPE),

	/**
	 * 
	 * 						United Arab Emirates.
	 * 					
	 * 
	 */
	AE("United Arab Emirates", Continent.ASIA),

	/**
	 * 
	 * 						United Kingdom.
	 * 					
	 * 
	 */
	GB("United Kingdom", Continent.EUROPE),

	/**
	 * 
	 * 						United States.
	 * 					
	 * 
	 */
	US("United States", Continent.NORTH_AMERICA),

	/**
	 * 
	 * 						NOTE: United States Minor Outlying Islands was
	 * 						defined in the eBay list previously
	 * 						but is no longer a viable option. This country
	 * 						will remain on eBay country list for backward
	 * 						compatibility. Use 'US' instead.
	 * 					
	 * 
	 */
	UM("UM", Continent.UNKNOWN),

	/**
	 * 
	 * 						Uruguay.
	 * 					
	 * 
	 */
	UY("Uruguay", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Uzbekistan.
	 * 					
	 * 
	 */
	UZ("Uzbekistan", Continent.ASIA),

	/**
	 * 
	 * 						Vanuatu.
	 * 					
	 * 
	 */
	VU("Vanuatu", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Venezuela.
	 * 					
	 * 
	 */
	VE("Venezuela", Continent.SOUTH_AMERICA),

	/**
	 * 
	 * 						Viet Nam.
	 * 					
	 * 
	 */
	VN("Viet Nam", Continent.ASIA),

	/**
	 * 
	 * 						Virgin Islands, British.
	 * 					
	 * 
	 */
	VG("Virgin Islands, British", Continent.ASIA),

	/**
	 * 
	 * 						Virgin Islands, U.S.
	 * 					
	 * 
	 */
	VI("Virgin Islands, U.S", Continent.ASIA),

	/**
	 * 
	 * 						Wallis and Futuna.
	 * 					
	 * 
	 */
	WF("Wallis and Futuna", Continent.AUSTRALIA),

	/**
	 * 
	 * 						Western Sahara.
	 * 					
	 * 
	 */
	EH("Western Sahara", Continent.AFRICA),

	/**
	 * 
	 * 						Yemen.
	 * 					
	 * 
	 */
	YE("Yemen", Continent.ASIA),

	/**
	 * 
	 * 						No longer in use. See RS for Serbia and ME for Montenegro.
	 * 					
	 * 
	 */
	YU("Serbia or Montenegro(No longer in use)", Continent.EUROPE),

	/**
	 * 
	 * 						Zambia.
	 * 					
	 * 
	 */
	ZM("Zambia", Continent.AFRICA),

	/**
	 * 
	 * 						Zimbabwe.
	 * 					
	 * 
	 */
	ZW("Zimbabwe", Continent.AFRICA),

	/**
	 * 
	 * 						NOTE: APO/FPO was defined in eBay list previously
	 * 						but they are not defined in ISO 3166. This country
	 * 						will remain on eBay country code list for backward
	 * 						compatibility.
	 * 					
	 * 
	 */
	AA("AA", Continent.UNKNOWN),

	/**
	 * 
	 * 						NOTE	: Guernsey was defined in eBay list previously
	 * 						but they are not defined in ISO 3166. This country
	 * 						will remain on eBay country list for backward
	 * 						compatibility.
	 * 					
	 * 
	 */
	QM("QM", Continent.UNKNOWN),

	/**
	 * 
	 * 						NOTE: Jan Mayen was defined in eBay list previously
	 * 						but they are not defined in ISO 3166. This country
	 * 						will remain on eBay country list for backward
	 * 						compatibility.
	 * 					
	 * 
	 */
	QN("Jan Mayen", Continent.EUROPE),

	/**
	 * 
	 * 						NOTE: Jersey was defined in eBay list previously
	 * 						but they are not defined in ISO 3166. This country
	 * 						will remain on eBay country list for backward
	 * 						compatibility.
	 * 					
	 * 
	 */
	QO("Jersey", Continent.EUROPE),

	/**
	 * 
	 * 						NOTE: Tahiti was defined in eBay list previously
	 * 						but they are not defined in ISO 3166. This country
	 * 						will remain on eBay country list for backward
	 * 						compatibility. This Code is currently deprecated
	 * 					
	 * 
	 */
	QP("Tahiti", Continent.UNKNOWN),

	/**
	 * 
	 * 						Jersey
	 * 					
	 * 
	 */
	JE("Jersey", Continent.EUROPE),

	/**
	 * 
	 * 						Guernsey
	 * 					
	 * 
	 */
	GG("Guernsey", Continent.EUROPE),

	/**
	 * 
	 * 						Unknown country
	 * 					
	 * 
	 */
	ZZ("ZZ", Continent.UNKNOWN),

	/**
	 * 
	 * 						Serbia
	 * 					
	 * 
	 */
	RS("Serbia", Continent.EUROPE),

	/**
	 * 
	 * 						Montenegro.
	 * 					
	 * 
	 */
	ME("Montenegro", Continent.EUROPE),

	/**
	 * 
	 * 						(out) Reserved for internal or future use
	 * 					
	 * 
	 */
	@XmlEnumValue("CustomCode")
	CUSTOM_CODE("CustomCode", Continent.UNKNOWN);

	private String value;

	private Continent continent;

	Country(String value, Continent continent) {
		this.value = value;
		this.continent = continent;
	}
	
	Country(String value) {
		this.value = value;
		Continent t = null;
		for (Country c: Country.values()) {
			if (c.value.equals(value)) {
				 t = c.continent;
				 break;
			}
		}
		this.continent = t;
	}

	public String value() {
		return value;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return this.name();
	}

	public String continent() {
		return continent.value();
	}

	public static Country fromName(String v) {
		if(StrManager.isEmpty(v)) {
			return null;
		}
		for (Country c: Country.values()) {
			if (c.name().equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

	public static Country fromValue(String v) {
		if(StrManager.isEmpty(v)) {
			return null;
		}
		for (Country c: Country.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

	public static Set<Country> fromContinent(Continent ct) {
		Set<Country> set = new HashSet<Country>();
		for (Country c: Country.values()) {
			if (c.continent.equals(ct)) {
				set.add(c);
			}
		}
		return set;
	}

}
