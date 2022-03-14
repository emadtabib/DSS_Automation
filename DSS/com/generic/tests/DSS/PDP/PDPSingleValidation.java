package com.generic.tests.DSS.PDP;

import com.generic.page.HomePage;
import com.generic.page.PDP;
import com.generic.setup.SelTestCase;

public class PDPSingleValidation extends SelTestCase {

	public static void validate() throws Exception {
		getCurrentFunctionName(true);
		String SinglePDPHeadline;

		HomePage.closeSignUpModal();
		PDP.NavigteToColorationsSRP();
		String SelectedPDPTitle = PDP.navigteToRandomSingleColorationsPage();
		SinglePDPHeadline = PDP.getSinglePDPHeadline();
		sassert().assertEquals(SinglePDPHeadline, SelectedPDPTitle,
				"<font color=#f442cb>Selected PDP Title from the SRP: </font><font color=#b86d29>" + SelectedPDPTitle
						+ "</font><font color=#FF0000>Actual opened PDP Title is: </font><font color=#b86d29>"
						+ SinglePDPHeadline + "</font>");
		PDP.getBrandImg();
		PDP.getSinglePDPCode();
		PDP.validateWriteTheFirstReview();
		PDP.getSinglePDPRangePrice();
		PDP.getSinglePDPSKUimgSrc();
		PDP.selectPDPOptionsifAnyAndValidate();
		int qtyValue = PDP.getQtyValue();
		Double PDPpriceForTheSelectedOption = PDP.getSinglePDPPrice();
		PDP.getSinglePDPShareLinksDiv();
		for (int index = 0; index < 4; index++) {
			PDP.getSinglePDPShareLinks(index);
		}
		PDP.getSinglePDPProductOverviewHeader();
		PDP.getSinglePDPProductOverview();
		PDP.validateRecommendedForYouHeaderIsDisplayed();
		PDP.validateRecommendedForYouCarouselIsDisplayed();
		PDP.clickAddToCartButton();
		Thread.sleep(5000);
		Double priceInaddToCartModal = PDP.getPriceInaddToCartModal();
		sassert().assertEquals(PDP.getminiCartItemsNumbers(), qtyValue,
				"<font color=#f442cb>The Qty In qty input field is not matching the number of added qtys to cart. The number of added qtys to cart is: </font><font color=#b86d29>"
						+ PDP.getminiCartItemsNumbers()
						+ ". </font><font color=#f442cb>The Qty selected in qty field is:  </font><font color=#b86d29>"
						+ qtyValue + "</font>");
		sassert().assertEquals(priceInaddToCartModal, PDPpriceForTheSelectedOption,
				"<font color=#f442cb>The price In add To Cart Modal is not matching the PDP price For The Selected Option. TThe price In add To Cart Modal: </font><font color=#b86d29>"
						+ priceInaddToCartModal
						+ ". </font><font color=#f442cb>PDP price For The Selected Option:  </font><font color=#b86d29>"
						+ PDPpriceForTheSelectedOption + "</font>");
		sassert().assertAll();
	}
}