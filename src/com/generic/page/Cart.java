package com.generic.page;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;

import com.generic.selector.CartSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class Cart extends SelTestCase {

	public static void addRandomProductTocart(int prodCount) throws Exception {
		try {
			getCurrentFunctionName(true);
			String searchTerms = getCONFIG().getProperty("RandomItems");
			if (searchTerms.contains(",")) {
				String[] options = searchTerms.split(",");
				for (int count = 0; count < prodCount; count++) {
					Thread.sleep(3000);

					logs.debug("Items to search on" + options);
					Random random = new Random();
					int randomIndex = random.nextInt(options.length - 1);
					String item = options[randomIndex];
					logs.debug("<font color=#f442cb>Search on: </font><font color=#b86d29>" + item + "</font>");
					HomePage.SearchAndPickItem(item);
					PDP.selectPDPOptionsifAnyAndValidate();
					PDP.clickAddToCartButton();
					PDP.verifyAddToCartLayerIsDisplayed();
					if (count < prodCount - 1)
						PDP.clickMiniCartContinueCheckout();
					else
						PDP.clickProceedToCheckout();
				}
			} else {
				HomePage.SearchAndPickItem(searchTerms);
				PDP.selectPDPOptionsifAnyAndValidate();
				PDP.clickAddToCartButton();
				PDP.verifyAddToCartLayerIsDisplayed();
				PDP.clickProceedToCheckout();
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add random product to cart selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void addRandomProductTocart(String searchTerms) throws Exception {
		try {
			getCurrentFunctionName(true);
			if (!searchTerms.contains(",")) {
				int itemsCount = searchTerms.split(",").length;
				logs.debug("<font color=#f442cb>Number of items to add to cart is: </font><font color=#b86d29>"
						+ itemsCount + "</font>");
				String[] options = searchTerms.split(",");
				for (int count = 0; count < itemsCount; count++) {
					Thread.sleep(3000);
					String item = options[count];
					logs.debug("<font color=#f442cb>Search on: </font><font color=#b86d29>" + item + "</font>");
					HomePage.SearchAndPickItem(item);
					PDP.selectPDPOptionsifAnyAndValidate();
					PDP.clickAddToCartButton();
					PDP.verifyAddToCartLayerIsDisplayed();
					if (count < itemsCount - 1)
						PDP.clickMiniCartContinueCheckout();
					else
						PDP.clickProceedToCheckout();
				}
			} else {
				HomePage.SearchAndPickItem(searchTerms);
				PDP.selectPDPOptionsifAnyAndValidate();
				PDP.clickAddToCartButton();
				PDP.verifyAddToCartLayerIsDisplayed();
				PDP.clickProceedToCheckout();
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add random product to cart selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void getGuestCartMessage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Guest Cart Message");
			String guestCartMessage = getDriver().findElement(By.cssSelector(CartSelectors.guestCartMessage)).getText();
			logs.debug("<font color=#f442cb>Guest Cart Message: </font><font color=#b86d29>" + guestCartMessage
					+ "</font>");
			sassert().assertTrue(guestCartMessage.contains("not signed in"),
					"Expected: You are currently not signed in. To ensure the best online experience, please Sign In or Create an Account. Actual header: "
							+ guestCartMessage);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Guest Cart Message selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void checkCartHeader() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate Cart Header");
			String CartHeader = getDriver().findElement(By.cssSelector(CartSelectors.CartHeader)).getText();
			logs.debug("<font color=#f442cb>Cart Header: </font><font color=#b86d29>" + CartHeader + "</font>");
			sassert().assertEquals(CartHeader, "Your Cart", "Actual header: " + CartHeader);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Cart Header selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static int getNumberOfCartItemsSections() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get number of displayed item sections in Cart Page</font>");
			int numberOfItemSections = getDriver().findElements(By.cssSelector(CartSelectors.productCount)).size();
			logs.debug("Number Of Item Sections are: <font color=#f442cb>" + numberOfItemSections + "</font>");
			getCurrentFunctionName(false);
			return numberOfItemSections;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "product Count selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getNumerOfInStockItems() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get product In Stock Count in Cart Page</font>");
			String productInStockCount = getDriver().findElement(By.cssSelector(CartSelectors.productCount)).getText();
			logs.debug("Items In Stock Count: <font color=#f442cb>" + productInStockCount + "</font>");
			int ProductInStockCount = Integer.parseInt(productInStockCount.substring(productInStockCount.indexOf('(')+1, productInStockCount.indexOf(')')));
			logs.debug("In Stock items: <font color=#f442cb>" + ProductInStockCount + "</font>");
			getCurrentFunctionName(false);
			return ProductInStockCount;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Items In Stock in cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getNumerOfItems(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Number of items in section: " + index +"</font>");
			String productsCount = getDriver().findElements(By.cssSelector(CartSelectors.productCount)).get(index).getText();
			logs.debug("Items Count: <font color=#f442cb>" + productsCount + "</font>");
			int ProductInStockCount = Integer.parseInt(productsCount.substring(productsCount.indexOf('(')+1, productsCount.indexOf(')')));
			logs.debug("In Stock items: <font color=#f442cb>" + ProductInStockCount + "</font>");
			getCurrentFunctionName(false);
			
			return ProductInStockCount;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Items In Stock in cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getNumberOfSaveForLater() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Number of Save For Later buttons </font>");
			int SaveForLater = getDriver().findElements(By.partialLinkText(CartSelectors.SaveForLater)).size();
			logs.debug("Save for later: <font color=#f442cb>" + SaveForLater + "</font>");
			getCurrentFunctionName(false);
			return SaveForLater;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Items In Stock in cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getNumberOfProducts() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get number of products sections in the Cart Page</font>");
			int numberOfProducts = getDriver().findElements(By.cssSelector(CartSelectors.productDivs)).size();
			logs.debug("number of item lists: <font color=#f442cb>" + numberOfProducts + "</font>");
			getCurrentFunctionName(false);
			return numberOfProducts;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "item code From cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemImg(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item img From Cart Page for item in index: </font>" + index);
			String imgsrc = getDriver().findElements(By.cssSelector(CartSelectors.Cart_productImg)).get(index).getAttribute("src");
			String imgalt = getDriver().findElements(By.cssSelector(CartSelectors.Cart_productImg)).get(index).getAttribute("alt");
			logs.debug("img src: <font color=#f442cb>" + imgsrc + "</font>");
			logs.debug("img alt: <font color=#f442cb>" + imgalt + "</font>");
			getCurrentFunctionName(false);
			return imgsrc;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "item code From cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemNameFromCartPage(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item name From Cart Page for item in index: </font>" + index);
			String itemName = getDriver().findElements(By.cssSelector(CartSelectors.Cart_productTitle)).get(index)
					.getText();
			logs.debug("item name: <font color=#f442cb>" + itemName + "</font>");
			getCurrentFunctionName(false);
			return itemName;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "item name From cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getItemCode(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item code From Cart Page for item in index: </font>" + index);
			String itemName = getDriver().findElements(By.cssSelector(CartSelectors.Cart_ProductCode)).get(index)
					.getText();
			logs.debug("item code: <font color=#f442cb>" + itemName + "</font>");
			getCurrentFunctionName(false);
			return itemName;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "item code From cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemPrice(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item price From Cart Page for item in index: </font>" + index);
			String itemprice = getDriver().findElements(By.cssSelector(CartSelectors.Cart_ProductPrice)).get(index)
					.getText();
			logs.debug("item price: <font color=#f442cb>" + itemprice + "</font>");
			getCurrentFunctionName(false);
			return itemprice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "item price From cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemQty(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item qty From Cart Page for item in index: </font>" + index);
			String itemQty = getDriver().findElements(By.name(CartSelectors.Cart_ProductQuantity)).get(index)
					.getAttribute("value");
			logs.debug("item qty: <font color=#f442cb>" + itemQty + "</font>");
			getCurrentFunctionName(false);
			return itemQty;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "item qty From cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemTotal(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item Total price From Cart Page for item in index: </font>" + index);
			String itemName = getDriver().findElements(By.cssSelector(CartSelectors.Cart_ProductTotal)).get(index)
					.getText();
			logs.debug("item total price: <font color=#f442cb>" + itemName + "</font>");
			getCurrentFunctionName(false);
			return itemName;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "item total price From cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getCartTotalForIndex(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Cart Total price for all items in section: </font>" + index);
			String cartTotal = getDriver().findElements(By.cssSelector(CartSelectors.cartTotal)).get(index)
					.getText();
			logs.debug("Cart Total price for all items in section: " + index + "is: <font color=#f442cb>" + cartTotal + "</font>");
			getCurrentFunctionName(false);
			return cartTotal;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "cart total price From cart Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyRemoveLinkDisplayedForItemIndex(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify remove link is displayed for item in index: </font>" + index);
			boolean itemprice = getDriver().findElement(By.id(CartSelectors.itemRemove + index)).isDisplayed();
			logs.debug("Remove link is displayed for item in index: <font color=#f442cb>" + index + "</font>");
			getCurrentFunctionName(false);
			return itemprice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "remove link selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyRemoveAllLinkDisplayedForItemIndex(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify Ramove All link is displayed for item in index: </font>" + index);
			boolean itemprice = getDriver().findElements(By.partialLinkText(CartSelectors.RemoveAll)).get(index).isDisplayed();
			logs.debug("Remove All link is displayed for item in index: <font color=#f442cb>" + index + "</font>");
			getCurrentFunctionName(false);
			return itemprice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Remove all link selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	public static void clickItemRemove(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click remove for the item in index: </font>" + index);
			getDriver().findElement(By.id(CartSelectors.itemRemove + index)).click();
			getDriver().findElement(By.id(CartSelectors.itemRemove + index)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "remove item selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifySaveForLaterLinkDisplayedForItemIndex(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify Save for later link is displayed for item in index: </font>" + index);
			boolean itemprice = getDriver().findElements(By.partialLinkText(CartSelectors.SaveForLater)).get(index).isDisplayed();
			logs.debug("Save for later link is displayed for item in index: <font color=#f442cb>" + index + "</font>");
			getCurrentFunctionName(false);
			return itemprice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Save for later link selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyAddToFavoritesModalHeader(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify Add To Favorites Modal Header item in index: </font>" + index);
			boolean itemprice = getDriver().findElement(By.cssSelector(CartSelectors.AddToFavoritesModalHeader)).isDisplayed();
			logs.debug("Add To Favorites Modal Header is displayed for item in index: <font color=#f442cb>" + index + "</font>");
			getCurrentFunctionName(false);
			return itemprice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add To Favorites Modal Header selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	public static boolean verifySaveAllItmsForLaterLinkDisplayedForItemIndex(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify Save All Items for later link is displayed for item in index: </font>" + index);
			boolean itemprice = getDriver().findElements(By.partialLinkText(CartSelectors.SaveAllItemsForLater)).get(index).isDisplayed();
			logs.debug("Save All Items for later link is displayed for item in index: <font color=#f442cb>" + index + "</font>");
			getCurrentFunctionName(false);
			return itemprice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Save All for later link selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyAddToFavoritesLinkDisplayedForItemIndex(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify Add To Favorites link is displayed for item in index: </font>" + index);
			boolean itemprice = getDriver().findElements(By.partialLinkText(CartSelectors.AddToFavorites)).get(index).isDisplayed();
			logs.debug("Add To Favorites link is displayed for item in index: <font color=#f442cb>" + index + "</font>");
			getCurrentFunctionName(false);
			return itemprice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add To Favorites link selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyAddAllItemsToFavoritesLinkDisplayedForItemIndex(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify Add All items To Favorites link is displayed for item in index: </font>" + index);
			boolean itemprice = getDriver().findElements(By.partialLinkText(CartSelectors.AddAllItemsToFavorites)).get(index).isDisplayed();
			logs.debug("Add All items To Favorites link is displayed for item in index: <font color=#f442cb>" + index + "</font>");
			getCurrentFunctionName(false);
			return itemprice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add all items To Favorites link selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickItemSaveForLAter(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click Save for later for the item in index: </font>" + index);
			getDriver().findElement(By.partialLinkText(CartSelectors.SaveForLater)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "save for later item selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifySaveForLaterLoginModalIsDisplayed(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify Save for later Login modal is displayed for item in index: </font>" + index);
			boolean isDisplayed = getDriver().findElement(By.id(CartSelectors.saveForLaterModal)).isDisplayed();
			logs.debug("Save for later login modal is displayed for item in index: <font color=#f442cb>" + index + "</font>");
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Save for later login modal selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickAddToFavorites(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click Add To Favorites for the item in index: </font>" + index);
			getDriver().findElement(By.partialLinkText(CartSelectors.AddToFavorites)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add To Favorites selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickSaveForLaterModalClose(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click Close for Save for Later login modal for the item in index: </font>" + index);
			getDriver().findElement(By.cssSelector(CartSelectors.saveForLaterModalClose)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Close button for Save for Later login modal selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
//	
//	public static void clickItemRemove(int index) throws Exception {
//		try {
//			getCurrentFunctionName(true);
//			logs.debug("Click remove for the item in index: </font>" + index);
//			getDriver().findElement(By.id(CartSelectors.itemRemove + index));
//			getCurrentFunctionName(false);
//		} catch (NoSuchElementException e) {
//			logs.debug(MessageFormat.format(
//					ExceptionMsg.PageFunctionFailed + "remove item selector was not found by selenuim",
//					new Object() {
//					}.getClass().getEnclosingMethod().getName()));
//			throw e;
//		}
//	}

	public static int getNumberOfOrderSummaryLines() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Summary Item numbers");
			int count = getDriver().findElements(By.cssSelector(CartSelectors.Cart_OrderSubtotal)).size();
			logs.debug("<font color=#f442cb>Number of ordersummary lines are" + count / 2 + "</font>");
			getCurrentFunctionName(false);
			return count / 2;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order Summary Item selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static String getOrderSummaryItems(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String item = "";
			String total = "";
			logs.debug("Get Order Summary Item:" + index/2 + 1);
			item = getDriver().findElements(By.cssSelector(CartSelectors.Cart_OrderSubtotal)).get(index)
					.getText();
			total = getDriver().findElements(By.cssSelector(CartSelectors.Cart_OrderSubtotal)).get(index+1)
					.getText();
			logs.debug("<font color=#f442cb>" + item + ": </font><font color=#b86d29>" + total
					+ "</font>");
			getCurrentFunctionName(false);
			return total;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Order Summary Item: " + index
					+ " selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static String getEstimatedTotalInFromOrderSummary(Boolean Guest) throws Exception {
		try {
			getCurrentFunctionName(true);
			String estimatedTotal = "";
			logs.debug("Get Estimated Total from Cart page");
			estimatedTotal = getDriver().findElements(By.cssSelector(CartSelectors.Cart_OrderSubtotal)).get(5)
					.getText();
			System.out.println("order Estimated: " + estimatedTotal);
			logs.debug("order Estimated: " + estimatedTotal);
			getCurrentFunctionName(false);
			return estimatedTotal;
		} catch (Exception e) {
			System.out.println("estimatedTotal selector was not found by selenuim");
			String estimatedTotal = getDriver().findElements(By.cssSelector(CartSelectors.Cart_OrderSubtotal)).get(3)
					.getText();
			return estimatedTotal;
		}
	}

	public static void clickCheckout() throws Exception {
		try {
			getCurrentFunctionName(true);
			System.out.println("Click Checkout in Cart Page");
			getDriver().findElement(By.cssSelector(CartSelectors.checkoutButton)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("Checkout Button selector was not found by selenuim");
			throw e;
		}
	}
}
