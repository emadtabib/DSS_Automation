package com.generic.tests.DSS.checkout;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.page.HomePage;
import com.generic.page.PDP;
import com.generic.selector.CartSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class CartRegression extends SelTestCase {

	public static void startTest(String shippingMethod, int productsCount, LinkedHashMap<String, String> addressDetails,
			LinkedHashMap<String, String> paymentDetails) throws Exception {
		getCurrentFunctionName(true);

		try {
			
			String DropShirtItems = getCONFIG().getProperty("DropShipProductsID");
			String SingleItems = getCONFIG().getProperty("RandomItems");
		
			String orderSubtotal = "";
			String EstimatedOrder = "";
			String Tax = "";
			String Shipping = "";
			
			HomePage.closeSignUpModal();
			
			logs.debug("Add Bundle item");
			PDP.navigteToBundleLandingPage();
			PDP.navigteToRandomBundlePage();
			PDP.clickBundlesAddToCart();
			
			logs.debug("Add DropShip items");
			int productsNumber = DropShirtItems.split(",").length;
			for (int count = 0; count < productsNumber; count++) {
				String productID = DropShirtItems.split(",")[count];
				logs.debug("Add DropShip item: " + productID);
				HomePage.SearchByItemID(productID);
				if (PDP.verifyIfItemIsOutOfStock())
					continue;
				if (!PDP.verifyIfItemIsDropShip())
					continue;
				PDP.selectPDPOptionsifAnyAndValidate();
				PDP.clickAddToCartButton();
				PDP.clickMiniCartContinueCheckout();
				Thread.sleep(2500);
			}
			
			logs.debug("Add Single items");
			productsNumber = SingleItems.split(",").length;
			for (int count = 0; count < productsNumber; count++) {
				String searchTerm = SingleItems.split(",")[count];
				HomePage.SearchAndPickItem(searchTerm);
				if (PDP.verifyIfItemIsOutOfStock())
					continue;
				if (PDP.verifyIfItemIsDropShip())
					continue;
				PDP.selectPDPOptionsifAnyAndValidate();
				PDP.clickAddToCartButton();
				PDP.clickProceedToCheckout();
				break;
			}
			Cart.getGuestCartMessage();
			int numberOfCartItemsSections = Cart.getNumberOfCartItemsSections();
			int numerOfInStockitems = Cart.getNumerOfInStockItems();
			int numerOfDropShipitems = Cart.getNumerOfItems(1);

			int numberOfProductsInCart = Cart.getNumberOfProducts();

			for (int index = 0; index < numberOfProductsInCart; index++) {
				logs.debug("<font color=#f442cb>Items details for item in row: " + index + "</font>");
				Cart.getItemImg(index);
				Cart.getItemNameFromCartPage(index);
				Cart.getItemCode(index);
				Cart.getItemPrice(index);
				Cart.getItemQty(index);
				Cart.getItemTotal(index);
				Cart.verifyRemoveLinkDisplayedForItemIndex(index);
				Cart.verifySaveForLaterLinkDisplayedForItemIndex(index);
				Cart.verifyAddToFavoritesLinkDisplayedForItemIndex(index);
			}
			for (int index = 0; index < numberOfCartItemsSections; index++) {
				logs.debug("<font color=#f442cb>Sections details for cart section: " + index + "</font>");
				Cart.verifyRemoveAllLinkDisplayedForItemIndex(index);
				Cart.verifySaveAllItmsForLaterLinkDisplayedForItemIndex(index);
				Cart.verifyAddAllItemsToFavoritesLinkDisplayedForItemIndex(index);
				Cart.getCartTotalForIndex(index);
			}

			sassert().assertAll();
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
