package com.generic.setup;

public class env {


	// Envs
	static String Prod = "prod";

	// URLS
	static String DSSURL = "discountschoolsupply.com";


	public static String get(String env) {
		String brandGetter = "https://";

		if (!env.contains(Prod))
			brandGetter += env + ".";
		else {
			brandGetter += "www.";
		}

		
			brandGetter += DSSURL;
	
		return brandGetter;
	}

}
