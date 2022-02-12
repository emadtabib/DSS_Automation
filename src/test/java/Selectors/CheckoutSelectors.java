package Selectors;

public class CheckoutSelectors {
	
	public static final String Cart_OrderSubtotal = ".summary-items>div>div";
	public static final String checkoutButton = ".btn.btn-primary.btn-block.btn--continue-checkout.js-continue-checkout-button";
	public static final String closeOfferModal = ".close.float-right";
	public static final String emailAddress = "address.email";
	public static final String firstName = "address.firstName";
	public static final String surName = "address.surname";
	public static final String addressLine1 = "address.line1";
	public static final String addressTownCity = "address.townCity";
	public static final String addressRegion = "address.region";
	public static final String postCode = "address.postcode";
	public static final String addressPhone = "address.phone";
	
	public static final String shiipingAddress_continueToShippingMethod = "#addressSubmit";
	
	public static final String useEnteredAddressbtn =  ".use-entered-address";
	public static final String shippingMethods = ".radio-button.shipping-method-radio>input";
	
	public static final String shippingMethod_continueToPayment = "#deliveryMethodSubmit";
	public static final String card_nameOnCard = "card_nameOnCard";
	public static final String card_accountNumber = "card_accountNumber";
	public static final String ExpiryMonth = "ExpiryMonth";
	public static final String ExpiryYear = "ExpiryYear";
	public static final String card_cvNumber = "card_cvNumber";
	public static final String useDeliveryAddress = "useDeliveryAddress";
	
	public static final String poNumber = "#poNumber";
	public static final String placeOrder = ".checkout-next.continue-btn.progress-btn";

	public static final String globalMessage = ".row.checkout-header>div>p";
	public static final String orderComponents = ".item-group>.item-value";
	public static final String orderShipTo = ".account-orderdetail .well.well-quinary.well-xs>.order-ship-to";
	public static final String orderShipMethod = ".order-ship-method";
	public static final String orderPurhcaseOrderData = ".order-purhcase-order-data";
	
	public static final String cartItemsSummaryPage = ".cart-items.cart-items-summary-page";
	public static final String item_Code = ".item__code";
	public static final String summaryTitle = ".summary-title";
	public static final String summaryItems = ".summary-items>.item-row";
	
}
