package com.generic.runners;

import java.util.ArrayList;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;


import com.generic.setup.SelTestCase;
import com.generic.util.SASLogger;

public class BuildFullRegression extends SelTestCase {

	private static ArrayList<String> regressionsPathes = new ArrayList<String>();
	// used sheet in test
	public static final String testDataSheet = "";
	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();

	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {

	}

	@Test
	public void generateFinalRegressionXML() {

	}

}
