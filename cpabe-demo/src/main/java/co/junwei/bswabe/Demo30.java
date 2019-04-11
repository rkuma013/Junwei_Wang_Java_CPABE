package co.junwei.bswabe;

import co.junwei.bswabe.*;

public class Demo30 {
	final static boolean DEBUG = true;

	final static String dir = "demo/bswabe";

	final static String inputfile = dir + "/input.txt";
	final static String encfile = dir + "input.txt.cpabe";
	final static String decfile = dir + "input.txt.new";

	/* come test data, choose attr and policy */
	/* TODO attr is alphabetic order */
	static String[] attr = { "baf", "fim1", "fim", "foo" };
	static String[] attr_delegate_ok = {"fim", "foo"};
	static String[] attr_delegate_ko = {"fim"};
	static String policy = "foo bar fim 2of3 baf 1of2";

	static String[] attr_kevin = {
			"business_staff",
			"executive_level_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"executive_level_flexint_7",
			"executive_level_flexint_x0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"executive_level_flexint_xxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"executive_level_flexint_xxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"executive_level_flexint_xxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"executive_level_flexint_xxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"executive_level_ge_2^02",
			"executive_level_lt_2^04",
			"executive_level_lt_2^08",
			"executive_level_lt_2^16",
			"executive_level_lt_2^32",
			"hire_date_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_flexint_1332945715",
			"hire_date_flexint_x0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1x",
			"hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1",
			"hire_date_ge_2^02",
			"hire_date_ge_2^04",
			"hire_date_ge_2^08",
			"hire_date_ge_2^16",
			"hire_date_lt_2^32",
			"office_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_2362",
			"office_flexint_x0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_xx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_xxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_ge_2^02", 
			"strategy_team" };
	static String[] attr_sara = {
			"hire_date_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_flexint_1332980893",
			"hire_date_flexint_x0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_flexint_xx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_flexint_xxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_flexint_xxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_flexint_xxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"hire_date_ge_2^02",
			"hire_date_ge_2^04",
			"hire_date_ge_2^08",
			"hire_date_ge_2^16",
			"hire_date_lt_2^32",
			"it_department",
			"office_flexint_0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_1431",
			"office_flexint_1432",
			"office_flexint_x0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_xx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_xxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_xxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_xxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_xxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_xxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_flexint_xxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
			"office_ge_2^02", "office_ge_2^04", "office_ge_2^08",
			"office_lt_2^16", "office_lt_2^32", "sysadmin" };
	static String policy_kevin_or_sara = "hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxx 2of2 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxx 1of4 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxx 3of3 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxx 1of2 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxx 4of4 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxx 1of3 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxx 2of2 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxx 1of3 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxx 2of2 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxx 1of3 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxx 5of5 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxx 1of4 hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx hire_date_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx hire_date_lt_2^32 4of4 security_team 1of2 sysadmin 2of2 executive_level_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1x executive_level_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1 1of2 executive_level_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1xx 2of2 executive_level_flexint_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1xxx 1of2 executive_level_ge_2^04 executive_level_ge_2^08 executive_level_ge_2^16 executive_level_ge_2^32 1of5 audit_group strategy_team 2of3 business_staff 2of2 1of2";

	public static void main(String[] args) throws Exception {
		BswabePub pub = new BswabePub();
		BswabeMsk msk = new BswabeMsk();
		BswabePrv prv, prv_delegate_ok, prv_delegate_ko;
		BswabeCph cph;
		BswabeElementBoolean result;

		//attr = attr_kevin;
		//attr = attr_sara;
		//policy = policy_kevin_or_sara;

		//println("//demo for co.junwei.bswabe: start to setup");
		Bswabe.setup(pub, msk);
		//println("//demo for co.junwei.bswabe: end to setup");

		//println("\n//demo for co.junwei.bswabe: start to keygen");
		long startTimek = System.currentTimeMillis();
		prv = Bswabe.keygen(pub, msk, attr);
		long endTimek = System.currentTimeMillis();
       		System.out.println(endTimek-startTimek);
		//println("//demo for co.junwei.bswabe: end to keygen");

		//println("\n//demo for co.junwei.bswabe: start to delegate_ok");
		
		prv_delegate_ok = Bswabe.delegate(pub, prv, attr_delegate_ok);
		
		//println("//demo for co.junwei.bswabe: end to delegate_ok");

		//println("\n//demo for co.junwei.bswabe: start to delegate_ko");
		
		prv_delegate_ko = Bswabe.delegate(pub, prv, attr_delegate_ko);
		
		//println("//demo for co.junwei.bswabe: end to delegate_ko");

		//println("\n//demo for co.junwei.bswabe: start to enc");
		long startTimee = System.currentTimeMillis();
		BswabeCphKey crypted = Bswabe.enc(pub, policy);
		cph = crypted.cph;
		long endTimee = System.currentTimeMillis();
       		System.out.println(endTimee-startTimee);
		//println("//demo for co.junwei.bswabe: end to enc");

		//println("\n//demo for co.junwei.bswabe: start to dec");
		long startTimed = System.currentTimeMillis();		
		result = Bswabe.dec(pub, prv, cph);
		long endTimed = System.currentTimeMillis();
      		System.out.println(endTimed-startTimed);

		//println("//demo for co.junwei.bswabe: end to dec");
		//if ((result.b == true) && (result.e.equals(crypted.key) == true))
			//System.out.println("succeed in decrypt");
		//else
			//System.err.println("failed to decrypting");

		/*//println("\n//demo for co.junwei.bswabe: start to dec with ok delegated key");
		result = Bswabe.dec(pub, prv_delegate_ok, cph);
		//println("//demo for co.junwei.bswabe: end to dec with ok delegated key");
		if ((result.b == true) && (result.e.equals(crypted.key) == true))
		    //System.out.println("succeed in decrypt with ok delegated key");
		else
		    //System.err.println("failed to decrypting with ok delegated key");

		//println("\n//demo for co.junwei.bswabe: start to dec");
		result = Bswabe.dec(pub, prv, cph);
		//println("//demo for co.junwei.bswabe: end to dec");
		if ((result.b == true) && (result.e.equals(crypted.key) == true))
			//System.out.println("succeed in decrypt");
		else
			//System.err.println("failed to decrypting");

		//println("\n//demo for co.junwei.bswabe: start to dec with ko delegated key");
		result = Bswabe.dec(pub, prv_delegate_ko, cph);
		//println("//demo for co.junwei.bswabe: end to dec with ko delegated key");
		if ((result.b == true) && (result.e.equals(crypted.key) == true))
		    //System.err.println("succeed in decrypt with ko delegated key (should not happen)");
		else
		    //System.out.println("failed to decrypting with ko delegated key");*/
	}

	private static void println(Object o) {
		if (DEBUG)
			System.out.println(o);
	}
}
