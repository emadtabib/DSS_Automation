package com.generic.tests.DSS.PDP;

import com.generic.page.HomePage;
import com.generic.page.PDP;
import com.generic.setup.SelTestCase;

public class PDPBundleValidation extends SelTestCase {

	public static void validate() throws Exception {
		getCurrentFunctionName(true);
		String BundleHeadline;
		Double BundlePrice;
		Double BundleItemsPrice = 0.0;
		String BundleSKUimg;
		String SideBarNavImg;
		String SideBarNavTitle;
		int QtyInAddToCartButton;
		int NumOfBundleTabs;
		int availableQty;
		int outOfStuckQty;

		HomePage.closeSignUpModal();
		PDP.navigteToBundleLandingPage();
		PDP.navigteToRandomBundlePage();
		BundleHeadline = PDP.getBundleHeadline();
		BundlePrice = PDP.getBundlePrice();
		PDP.clickBundlesAddToCart();
		QtyInAddToCartButton = PDP.getQtysInAddToCartButton();
		BundleSKUimg = PDP.getBundleSKUimg();
		sassert().assertTrue(BundleSKUimg.contains(BundleHeadline),
				"The SKU image is not correct, it is not matching the bundle headline. The bundle headline: "
						+ BundleHeadline + "Bundle SKU img src" + BundleSKUimg);
		PDP.getBundleDescription();
		PDP.getBundleDescriptionData();
		SideBarNavImg = PDP.getSideBarNavImg();
		sassert().assertTrue(SideBarNavImg.contains(BundleHeadline),
				"The Side Bar Nav image is not correct, it is not matching the bundle headline. The bundle headline: "
						+ BundleHeadline + "Side Bar Nav Img" + SideBarNavImg);
		SideBarNavTitle = PDP.getSideBarNavTitle();
		sassert().assertEquals(SideBarNavTitle, BundleHeadline,
				"Side Bar Nav Title is not matching the title of the bundle. SideBarNavTitle: " + SideBarNavTitle
						+ ". BundleHeadline" + BundleHeadline);
		PDP.getsideBarResetTitle();
		NumOfBundleTabs = PDP.getNumOfBundleTabs();
		for (int index = 0; index < NumOfBundleTabs; index++) {
			PDP.getBundlesImgs(index);
			PDP.getBundlesTitle(index);
			PDP.getBundleItemsCode(index);
			BundleItemsPrice = BundleItemsPrice + PDP.getBundleItemsPrice(index);
		}

		sassert().assertEquals(BundleItemsPrice, BundlePrice,
				"The total Bundle Items Price is not matching the top price displayed for the bundle. The total Bundle Items Price is: "
						+ BundleItemsPrice + ".  the top price displayed for the bundle: " + BundlePrice);
		availableQty = PDP.BundlesQty();
		sassert().assertEquals(QtyInAddToCartButton, availableQty,
				"The Qty In Add To Cart Button is not matching the number of the available items for the bundle. The Qty-In-Add-To-Cart-Button is: "
						+ QtyInAddToCartButton + ". The availabe items qty is: " + availableQty);
		outOfStuckQty = PDP.outOFStuckQty();
		sassert().assertEquals(availableQty + outOfStuckQty, NumOfBundleTabs,
				"Num Of Bundle Tabs is not matching the number of the available and outofstuck items for the bundle. The Num Of Bundle Tabs is: "
						+ NumOfBundleTabs + ". The availabe and outOfStuckQty items qtys are: " + availableQty
						+ outOfStuckQty);
		sassert().assertEquals(PDP.getminiCartItemsNumbers(), availableQty,
				"The Qty In Add To Cart Button is not matching the number of added items to cart. The number of added items to cart is: "
						+ PDP.getminiCartItemsNumbers() + ". The availabe items qty is: " + availableQty);
		
		sassert().assertAll();
	}
}