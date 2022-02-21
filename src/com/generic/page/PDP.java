package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.selector.PDPSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PDP extends SelTestCase {


	
	/////////////////DSS//////////////////
	
	public static void clickAddToCartButton() throws Exception {
		try {
			logs.debug("Click Add To Cart Button ");
			getDriver().findElement(By.cssSelector(PDPSelectors.addToCartButton)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Add To Cart Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void verifyAddToCartLayerIsDisplayed() throws Exception {
		try {
			logs.debug("Verify Add To Cart Layer Is Displayed");
			getDriver().findElement(By.cssSelector(PDPSelectors.addToCartLayer)).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Add To Cart Layer selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void clickProceedToCheckout() throws Exception {
		try {
			logs.debug("Click Proceed To Checkout");
			getDriver().findElement(By.cssSelector(PDPSelectors.proceedToCheckout)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Proceed To Checkout Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void clickMiniCartContinueCheckout() throws Exception {
		try {
			logs.debug("Click mini Cart Continue Checkout");
			getDriver().findElement(By.cssSelector(PDPSelectors.miniCartContinueCheckout)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Mini Cart Continue Checkout Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void navigteToBundleLandingPage() throws Exception {
		try {
			logs.debug("Navigte To Bundle Landing Page");
			getDriver().findElement(By.partialLinkText(PDPSelectors.budgetBundles)).click();
			getDriver().findElement(By.partialLinkText(PDPSelectors.budgetBundles)).click();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Budget Bundles link selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void navigteToBundlePage() throws Exception {
		try {
			logs.debug("Navigte To Bundle Page");
			List<WebElement> items = new ArrayList<WebElement>();
			items = SelectorUtil.getAllElements(PDPSelectors.BundlesLinks);
			items.remove(items.size() - 1);
			logs.debug("WebElement List Size = " + items.size());
			Random random = new Random();
			int index = random.nextInt(items.size() - 1);
			items.get(index).click();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Shop now links for bundle items selectors were not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	
	public static String getBundleHeadline() throws Exception {
		try {
			getCurrentFunctionName(true);
			String bundleHeadline = "";
			logs.debug("Get Bundle Headline: ");
			bundleHeadline = getDriver().findElement(By.cssSelector(PDPSelectors.BundleHeadline)).getText().replaceAll(" ", "").trim();
			logs.debug("Bundle Headline: " + bundleHeadline);
			getCurrentFunctionName(false);
			return bundleHeadline;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Headline selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static Double getBundlePrice() throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundlePrice = "";
			logs.debug("Get Bundle Price: ");

			BundlePrice = getDriver().findElement(By.cssSelector(PDPSelectors.BundlesPrice)).getText();
			logs.debug("Bundle Price: " + BundlePrice);
			Double BundlePrice2 = Double.parseDouble(BundlePrice.replace('$', ' ').trim());
			logs.debug("Bundle Price: " + BundlePrice);
			getCurrentFunctionName(false);
			return BundlePrice2;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Price selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static void clickBundlesAddToCart() throws Exception {
		try {
			logs.debug("Click on bundle Add To Cart");
			getDriver().findElement(By.cssSelector(PDPSelectors.BundlesAddToCart)).click();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart button for Bundle selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getQtysInAddToCartButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			String QtysInAddToCartButton = "";
			logs.debug("Get Qty In Add To Cart Button: ");
			QtysInAddToCartButton = getDriver().findElement(By.cssSelector(PDPSelectors.QtysInAddToCartButton)).getText();
			logs.debug("Qty In Add To Cart Button: " + QtysInAddToCartButton);
			int QtyInAddToCartButton = Integer.parseInt(QtysInAddToCartButton);
			logs.debug("Qty In Add To Cart Button: " + QtyInAddToCartButton);
			getCurrentFunctionName(false);
			return QtyInAddToCartButton;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Price selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundleSKUimg() throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundleSKUimg = "";
			logs.debug("Get Qty In Add To Cart Button: ");
			BundleSKUimg = getDriver().findElement(By.cssSelector(PDPSelectors.BundleSKUimg)).getAttribute("src");
			logs.debug("Bundle SKU img: " + BundleSKUimg);
			getCurrentFunctionName(false);
			return BundleSKUimg;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Price selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundleDescription() throws Exception {
		try {
			getCurrentFunctionName(true);
			String bundleDescription = "";
			logs.debug("Get Bundle Description: ");
			bundleDescription = getDriver().findElement(By.cssSelector(PDPSelectors.bundleDescription)).getText();
			logs.debug("Bundle Description: " + bundleDescription);
			getCurrentFunctionName(false);
			return bundleDescription;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Description selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundleDescriptionData() throws Exception {
		try {
			getCurrentFunctionName(true);
			String bundleDescription = "";
			logs.debug("Get Bundle Description Data: ");
			bundleDescription = getDriver().findElement(By.cssSelector(PDPSelectors.bundleDescriptionData)).getText();
			logs.debug("Bundle Description Data: " + bundleDescription);
			getCurrentFunctionName(false);
			return bundleDescription;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Description Data selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getSideBarNavImg() throws Exception {
		try {
			getCurrentFunctionName(true);
			String sideBarNavImg = "";
			logs.debug("Get Qty In Add To Cart Button: ");
			sideBarNavImg = getDriver().findElement(By.cssSelector(PDPSelectors.sideBarNavImg)).getAttribute("src");
			logs.debug("Side Bar Nav img: " + sideBarNavImg);
			getCurrentFunctionName(false);
			return sideBarNavImg;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Side Bar Nav Img selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getSideBarNavTitle() throws Exception {
		try {
			getCurrentFunctionName(true);
			String sideBarNavTitle = "";
			logs.debug("Get Side Bar Nav Title: ");
			sideBarNavTitle = getDriver().findElement(By.cssSelector(PDPSelectors.sideBarNavTitle)).getText();
			logs.debug("Side Bar Nav Title: " + sideBarNavTitle);
			getCurrentFunctionName(false);
			return sideBarNavTitle;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Side Bar Nav Title selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getsideBarResetTitle() throws Exception {
		try {
			getCurrentFunctionName(true);
			String sideBarResetTitle = "";
			logs.debug("Get Side Bar Reset Title: ");
			sideBarResetTitle = getDriver().findElement(By.cssSelector(PDPSelectors.sideBarResetTitle)).getText();
			logs.debug("Side Bar Reset Title: " + sideBarResetTitle);
			getCurrentFunctionName(false);
			return sideBarResetTitle;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Side Bar Reset Title selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static int getNumOfBundleTabs() throws Exception {
		try {
			getCurrentFunctionName(true);
			int BundleTabs = 0;
			logs.debug("Get Bundle Tabs Number: ");
			BundleTabs = getDriver().findElements(By.cssSelector(PDPSelectors.BundleTabs)).size();
			logs.debug("Bundle Tabs Number: " + BundleTabs);
			getCurrentFunctionName(false);
			return BundleTabs;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Tabs selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundlesImgs(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundlesImgs = "";
			logs.debug("Get Bundle Img index: " + index );
			BundlesImgs = getDriver().findElements(By.cssSelector(PDPSelectors.BundlesImgs)).get(index).getAttribute("src");
			logs.debug("Bundle Img index: " + index + " : " + BundlesImgs);
			getCurrentFunctionName(false);
			return BundlesImgs;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundles Imgs selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundlesTitle(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundlesTitle = "";
			logs.debug("Get Bundle Title index: " + index );
			BundlesTitle = getDriver().findElements(By.cssSelector(PDPSelectors.BundlesTitle)).get(index).getText();
			logs.debug("Bundle Title index: " + index + " : " + BundlesTitle);
			getCurrentFunctionName(false);
			return BundlesTitle;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundles Title selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getBundleItemsCode(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundleItemsCode = "";
			logs.debug("Get Bundle Items Code index: " + index );
			BundleItemsCode = getDriver().findElements(By.cssSelector(PDPSelectors.BundleItemsCode)).get(index).getText();
			logs.debug("Bundle Items Code index: " + index + " : " + BundleItemsCode);
			getCurrentFunctionName(false);
			return BundleItemsCode;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Items Code selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	
	public static Double getBundleItemsPrice(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String BundleItemsPrice = "";
			logs.debug("Get Bundle Items Price index: " + index);
			BundleItemsPrice = getDriver().findElements(By.cssSelector(PDPSelectors.BundleItemsPrice)).get(index)
					.getText().replace('$', ' ').trim().replace("/ea", " ").trim();
			logs.debug("Bundle Items Price index: " + index + " : " + BundleItemsPrice);

			Double BundleItemsPrices = Double.parseDouble(BundleItemsPrice);
			logs.debug("Bundle Items Price index: " + index + " : " + BundleItemsPrices);
			getCurrentFunctionName(false);
			return BundleItemsPrices;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Items Price selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static int BundlesQty() throws Exception {
		try {
			logs.debug("Bundles Qtys are: ");
			int bundlesQty = 0;
			bundlesQty = getDriver().findElements(By.id(PDPSelectors.BundlesQtys)).size();
			logs.debug("Bundles Qtys are: "+ bundlesQty);
			return bundlesQty;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle Qtys selectors were not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static int outOFStuckQty() throws Exception {
		try {
			logs.debug("Out of Stuck Qtys are:  ");
			int outOfStuckQtys = 0;
			if (!SelectorUtil.isNotDisplayed(PDPSelectors.outOfStuckQtys))
				outOfStuckQtys = getDriver().findElements(By.cssSelector(PDPSelectors.outOfStuckQtys)).size();

			logs.debug("Out of Stuck Qtys are:  " + outOfStuckQtys);
			return outOfStuckQtys;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Out Of Stuck selectors were not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
}
