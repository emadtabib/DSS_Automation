package com.generic.tests.DSS.PDP;

import com.generic.page.HomePage;
import com.generic.page.PDP;
import com.generic.setup.SelTestCase;

public class PDPSingleValidation extends SelTestCase {

	public static void validate() throws Exception {
		getCurrentFunctionName(true);
		String SinglePDPHeadline;
		Double BundlePrice;
		Double BundleItemsPrice = 0.0;
		String SingleSKUimg;
		String SideBarNavImg;
		String SideBarNavTitle;
		int QtyInAddToCartButton;
		int NumOfBundleTabs;
		int availableQty;
		int outOfStuckQty;

		HomePage.closeSignUpModal();
		PDP.NavigteToColorationsSRP();
		PDP.navigteToRandomSingleColorationsPage();
		
		
		SinglePDPHeadline = PDP.getSinglePDPHeadline();
		BundlePrice = PDP.getSinglePDPPrice();
		PDP.getSinglePDPCode();
		SingleSKUimg = PDP.getBundleSKUimg();
		PDP.getSinglePDPShareLinksDiv();
		for (int index = 0; index < 4; index++) {
		PDP.getSinglePDPShareLinks(index);
		}
		
		PDP.getSinglePDPProductOverviewHeader();
		PDP.getSinglePDPProductOverview();
		PDP.validateRecommendedForYouHeaderIsDisplayed();
		PDP.validateRecommendedForYouCarouselIsDisplayed();
	
		sassert().assertAll();
	}
}