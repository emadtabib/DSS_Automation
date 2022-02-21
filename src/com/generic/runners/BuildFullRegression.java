package com.generic.runners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import org.xml.sax.SAXException;

import com.generic.setup.Common;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.SASLogger;
import com.generic.util.TestUtilities;

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
