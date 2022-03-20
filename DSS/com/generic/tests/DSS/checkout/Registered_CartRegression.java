package com.generic.tests.DSS.checkout;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.page.HomePage;
import com.generic.page.Login;
import com.generic.page.PDP;
import com.generic.selector.CartSelectors;
import com.generic.setup.ActionDriver;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class Registered_CartRegression extends SelTestCase {

	public static void startTest(String email) throws Exception {
		getCurrentFunctionName(true);

		try {
			String DropShirtItems = getCONFIG().getProperty("DropShipProductsID");
			String SingleItems = getCONFIG().getProperty("RandomItems");
			String orderSubtotal = "";
			String EstimatedOrder = "";
			int numberOfCartItemsSections;
			int numberOfInStockitems;
			int numberOfDropShipitems;
			int numberOfSavedItemsToLater;
			
			HomePage.closeSignUpModal();
			HomePage.clickSignIn();
			Login.Login(email);
			Assert.assertTrue(Login.verifyIfUserLoggedIn(), "User is not logged in Successfully");
			
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
				if (!isDesktop())
					Thread.sleep(4000);
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
				if (!isDesktop())
					Thread.sleep(4000);
				PDP.clickProceedToCheckout();
				break;
			}
			numberOfCartItemsSections = Cart.getNumberOfCartItemsSections();
			logs.debug("<font color=#f442cb> Get Number Of In Stock items: </font>");
			numberOfInStockitems = Cart.getNumberOfInStockItems();
			logs.debug("<font color=#f442cb> Get Number Of Drop Ship Items: </font>");
			numberOfDropShipitems = Cart.getNumberOfItems(1);
			if (numberOfCartItemsSections == 3) {
				logs.debug("<font color=#f442cb> Get Number Of Saved Items To Later: </font>");
				numberOfSavedItemsToLater = Cart.getNumberOfItems(2);
			}

			int numberOfProductsInCart = Cart.getNumberOfProducts();
			int numberOfItemQtyInputs = Cart.getNumberOfItemQtyInputs();
			int numberOfItemQtyDivs = Cart.getNumberOfItemQtyDivs();
			if (numberOfCartItemsSections == 3)
				sassert().assertEquals(numberOfItemQtyDivs, numberOfProductsInCart + 3,
						"Some products do not have item qty label");
			for (int index = 0; index < numberOfProductsInCart; index++) {
				logs.debug("<font color=#f442cb>Items details for item in row: " + index + "</font>");
				Cart.getItemImg(index);
				Cart.getItemNameFromCartPage(index);
				Cart.getItemCode(index);
				Cart.getItemPrice(index);
				if (index < numberOfItemQtyInputs)
					Cart.getItemQty(index);
				else
					Cart.getItemQtyForSavedForLater(index + 3);
				Cart.getItemTotal(index);
				if (index < numberOfItemQtyInputs) {
					Cart.verifyRemoveLinkDisplayedForItemIndex(index);
					Cart.verifySaveForLaterLinkDisplayedForItemIndex(index);
				}
				if (isMobile() && index == numberOfItemQtyInputs )
					Cart.expandSaveForLater(); 
				Cart.verifyAddToFavoritesLinkDisplayedForItemIndex(index);
			}
			for (int index = 0; index < 2; index++) {
				logs.debug("<font color=#f442cb>Sections details for cart section: " + index + "</font>");
				Cart.verifyRemoveAllLinkDisplayedForItemIndex(index);
				Cart.verifySaveAllItmsForLaterLinkDisplayedForItemIndex(index);
				Cart.verifyAddAllItemsToFavoritesLinkDisplayedForItemIndex(index);
				Cart.getCartTotalForIndex(index);
			}
			
			int numberOfOrderSummaryLines = Cart.getNumberOfOrderSummaryLines();
			orderSubtotal = Cart.getOrderSummaryItems(0);
			if (numberOfOrderSummaryLines < 3)
				EstimatedOrder = Cart.getOrderSummaryItems(2);
			else
				EstimatedOrder = Cart.getOrderSummaryItems(4);
			HomePage.closeNotReadyToBuyModal();
			Cart.clickItemSaveForLAter(0);
			Thread.sleep(4500);
			numberOfCartItemsSections = Cart.getNumberOfCartItemsSections();
			numberOfInStockitems = Cart.getNumberOfInStockItems();
			numberOfDropShipitems = Cart.getNumberOfItems(1);
			logs.debug("<font color=#f442cb> Get Number Of Saved Items To Later: </font>");
			numberOfSavedItemsToLater = Cart.getNumberOfItems(2);
			numberOfProductsInCart = Cart.getNumberOfProducts();
			numberOfItemQtyInputs = Cart.getNumberOfItemQtyInputs();
			for (int index = 0; index < numberOfProductsInCart; index++) {
				logs.debug("<font color=#f442cb>Items details for item in row: " + index + "</font>");
				Cart.getItemImg(index);
				Cart.getItemNameFromCartPage(index);
				Cart.getItemCode(index);
				Cart.getItemPrice(index);
				if (index < numberOfItemQtyInputs)
					Cart.getItemQty(index);
				else
					Cart.getItemQtyForSavedForLater(index + 3);
				Cart.getItemTotal(index);
				if (index < numberOfItemQtyInputs) {
					Cart.verifyRemoveLinkDisplayedForItemIndex(index);
					Cart.verifySaveForLaterLinkDisplayedForItemIndex(index);
				}
				if (isMobile() && index == numberOfItemQtyInputs )
					Cart.expandSaveForLater(); 
				Cart.verifyAddToFavoritesLinkDisplayedForItemIndex(index);
			}
			for (int index = 0; index < 2; index++) {
				logs.debug("<font color=#f442cb>Sections details for cart section: " + index + "</font>");
				Cart.verifyRemoveAllLinkDisplayedForItemIndex(index);
				Cart.verifySaveAllItmsForLaterLinkDisplayedForItemIndex(index);
				Cart.verifyAddAllItemsToFavoritesLinkDisplayedForItemIndex(index);
				Cart.getCartTotalForIndex(index);
			}
			HomePage.closeNotReadyToBuyModal();
			Cart.clickAddToFavorites(1);
			Thread.sleep(2500);
			Cart.verifyAddToFavoritesModalHeader(1);
			Cart.clickSaveForLaterModalClose(0);
			
			Cart.clickItemRemove(1);
			Thread.sleep(4500);
			numberOfInStockitems = Cart.getNumberOfInStockItems();
			numberOfDropShipitems = Cart.getNumberOfItems(1);
			logs.debug("<font color=#f442cb> Get Number Of Saved Items To Later: </font>");
			numberOfSavedItemsToLater = Cart.getNumberOfItems(2);
			numberOfProductsInCart = Cart.getNumberOfProducts();
			numberOfItemQtyInputs = Cart.getNumberOfItemQtyInputs();
			sassert().assertAll();
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
