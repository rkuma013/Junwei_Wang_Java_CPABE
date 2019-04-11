package co.junwei.cpabe;

public class Demo10 {
	final static boolean DEBUG = true;

	static String dir = "demo/cpabe";

    static String pubfile = dir + "/pub_key";
	static String mskfile = dir + "/master_key";
	static String prvfile = dir + "/prv_key";

	static String inputfile = dir + "/input.pdf";
	static String encfile = dir + "/input.pdf.cpabe";
	static String decfile = dir + "/input.pdf.new";

	static String[] attr = { "baf1", "fim1", "foo" };
	static String policy = "foo bar fim 2of3 baf 1of2";

	static String[] attr_kevin = {
			"business_staff",
			"executive_level_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"executive_level_flexint_7",
			"executive_level_ge_2^02",
			"executive_level_lt_2^04",
			"hire_date_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_flexint_1332945715",
			"hire_date_ge_2^02",
			"office_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_2362",
			};
	static String[] attr_sara = {
			"hire_date_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_flexint_1332980893",
			"hire_date_ge_2^02",
			"it_department",
			"office_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_1431",
			"office_ge_2^02", 
			"office_ge_2^04", "office_lt_2^32", "sysadmin" };
	static String policy_kevin_or_sara = "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxx "
			+ "2of2 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxx "
			+ "1of4 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxx "
			+ "3of3 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxx "
			+ "1of2 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxx "
			+ "4of4 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxx "
			+ "1of3 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxx "
			+ "2of2 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxx "
			+ "1of3 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxx "
			+ "2of2 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxx "
			+ "1of3 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxx "
			+ "5of5 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxx "
			+ "1of4 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx "
			+ "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx "
			+ "hire_date_lt_2^32 "
			+ "4of4 security_team 1of2 sysadmin "
			+ "2of2 executive_level_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1x "
			+ "executive_level_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1 "
			+ "1of2 executive_level_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1xx "
			+ "2of2 executive_level_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1xxx "
			+ "1of2 executive_level_ge_2^04 executive_level_ge_2^08 executive_level_ge_2^16 executive_level_ge_2^32 1of5 audit_group strategy_team 2of3 business_staff 2of2 1of2";

	static String student_attr = "objectClass:inetOrgPerson objectClass:organizationalPerson "
			+ "sn:student2 cn:student2 uid:student2 userPassword:student2 "
			+ "ou:idp o:computer mail:student2@sdu.edu.cn title:student";

	static String student_policy = "sn:student2 cn:student2 uid:student2 3of3";

	public static void main(String[] args) throws Exception {
		String attr_str;
		// attr = attr_kevin;
		// attr = attr_sara;
		// policy = policy_kevin_or_sara;
		//attr_str = array2Str(attr);

		attr_str = student_attr;
		policy = student_policy;

		Cpabe test = new Cpabe();
		//println("//start to setup");
		test.setup(pubfile, mskfile);
		//println("//end to setup");

		//println("//start to keygen");
 long startTimek = System.currentTimeMillis();
		test.keygen(pubfile, prvfile, mskfile, attr_str);
long endTimek = System.currentTimeMillis();
       System.out.println(endTimek-startTimek);
		//println("//end to keygen");

		//println("//start to enc");
 long startTimee = System.currentTimeMillis();
		test.enc(pubfile, policy, inputfile, encfile);
long endTimee = System.currentTimeMillis();
       System.out.println(endTimee-startTimee);
		//println("//end to enc");

		//println("//start to dec");
 long startTimed = System.currentTimeMillis();
		test.dec(pubfile, prvfile, encfile, decfile);
long endTimed = System.currentTimeMillis();
       System.out.println(endTimed-startTimed);
		//println("//end to dec");
	}

	/* connect element of array with blank */
	public static String array2Str(String[] arr) {
		int len = arr.length;
		String str = arr[0];

		for (int i = 1; i < len; i++) {
			str += " ";
			str += arr[i];
		}

		return str;
	}

	private static void println(Object o) {
		if (DEBUG)
			System.out.println(o);
	}
}
