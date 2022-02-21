package com.generic.selector;

import com.generic.setup.cselector;

public class CheckOutSelectors
{
	///////////////////////////// DSS
	
	public static final String Cart_OrderSubtotal = ".summary-items>div>div";
	public static final String checkoutButton = ".btn.btn-primary.btn-block.btn--continue-checkout.js-continue-checkout-button";
	public static final String closeOfferModal = "css,.close.float-right";
	public static final String emailAddress = "address.email";
	public static final String firstName = "address.firstName";
	public static final String surName = "address.surname";
	public static final String addressLine1 = "address.line1";
	public static final String addressTownCity = "address.townCity";
	public static final String addressRegion = "address.region";
	public static final String postCode = "address.postcode";
	public static final String addressPhone = "address.phone";
	
	public static final String shiipingAddress_continueToShippingMethod = "addressSubmit";
	public static final String productContainerInCheckout = "css,.summary-product-items>.summary-product";
	public static final String itemsQuantityInCheckoutPages = ".product-qty>span>b";
	public static final String productContainerInOrderConfirmationPage = "css,.item__list.item__list__cart>.item__list--item";
	public static final String itemQuantityInOrderConfirmationPage = ".item__list.item__list__cart>.item__list--item>.item__quantity";
	
	public static final String useEnteredAddressbtn =  ".use-entered-address";
	public static final String shippingMethods = ".radio-button.shipping-method-radio>input";
	
	public static final String shippingMethod_continueToPayment = "#deliveryMethodSubmit";
	public static final String CCPaymentButton = "PaymentTypeSelection_CARD";
	public static final String PayPalPaymentButton = "PaymentTypeSelection_PAYPAL";
	public static final String PaymentTypeSelectionNONE =	"PaymentTypeSelection_NONE";
	public static final String card_nameOnCard = "card_nameOnCard";
	public static final String card_accountNumber = "card_accountNumber";
	public static final String ExpiryMonth = "ExpiryMonth";
	public static final String ExpiryYear = "ExpiryYear";
	public static final String card_cvNumber = "card_cvNumber";
	public static final String useDeliveryAddress = "useDeliveryAddress";
	
	public static final String poNumber = "#poNumber";
	public static final String placeOrder = ".checkout-next.continue-btn.progress-btn";

	public static final String globalMessage = ".row.checkout-header>div>p";
	public static final String FeedbackModal_NoThanks = "css,.smcx-btn.smcx-btn-secondary.smcx-pull-left";
	public static final String orderComponents = ".item-group>.item-value";
	public static final String orderShipTo = ".account-orderdetail .well.well-quinary.well-xs>.order-ship-to";
	public static final String orderShipMethod = ".order-ship-method";
	public static final String orderPurhcaseOrderData = ".order-purhcase-order-data";
	
	public static final String cartItemsSummaryPage = ".cart-items.cart-items-summary-page";
	public static final String item_Code = ".item__code";
	public static final String summaryTitle = ".summary-title";
	public static final String summaryItems = ".summary-items>.item-row";
	
	///////////////////////////////////DSS//////////////////////////
	
	
	public static final cselector GHConfirmationTotal=new cselector("css,.estimated-total > div>span:nth-child(2)");
	public static final cselector BDConfirmationTotal=new cselector("css,.estimated-total > div>span:nth-child(2)","css,div:nth-child(1) > div.estimated-total.u-padding-md.u-padding-top-0.u-padding-bottom-lg.u-text-size-medium.u-flexbox.u-justify-between.u-bg-color-alto > span:nth-child(2)");
	public static final cselector GHPaypalSubmitConfermationMessage=new cselector("css,p.t-checkout-confirmation__header-confirm-message:last-child");
	public static final cselector BDPaypalSubmitConfermationMessage=new cselector("css,p.t-checkout-confirmation__header-confirm-message:last-child","css,p.t-checkout-confirmation__header-confirm-message");
	//Done CBI
	//Navigation
	public static final cselector beginSecureCheckoutButton = new cselector("css,.secure-checkout-button","css,.c-checkout-buttons__checkout .pw--primary");
	public static final cselector guestCheckoutButton = new cselector("css,.guest-checkout-button-panel > button","css,.guest-checkout-form > button");
	public static final cselector stepLoaderButton = new cselector("button.pw-button.pw--primary.u-width-full>div>div.c-custom-loader");	
	//Step 1 Multiple Addresses
	public static final cselector multipleAddressesTab = new cselector("css,.shipping-address .gwt-TabBarItem","css,.shipping-address .gwt-TabBarItem","css,.t-checkout-step1__tabs .pw-tabs__tab a");
	public static final cselector addAddressButton = new cselector( "css,.order-item-shipping-panel .button","css,.t-cart__product-list .add-address-button");
	public static final cselector saveAddressButton = new cselector("css,.okCancelPanel .button.primary","css,.m-address_widget_modal button.pw--primary");
	public static final cselector firstStepNextButton = new cselector( "css,.next-botton-panel .primary-button","css,.c-checkout-accordion__next-cancel-panel .pw--primary");
	public static final cselector firstNameC =new cselector( "css,.add-address-dialog .AddrFNameSpot input","css,.m-address_widget_modal .c-custom-input-fname input");
	public static final cselector lastName= new cselector("css,.add-address-dialog .AddrLNameSpot input","css,.m-address_widget_modal .c-custom-input-lname input"); 
	public static final cselector streetAddress =new cselector( "css,.add-address-dialog .addrStreet1Spot input","css,#checkout-add-address-modal-form > div > div > div.address-search.c-custom-input-container.c-custom-redux-container.c-custom-input-street1 > div.u-position-relative.u-width-full.input-label-container>input.c-custom-input");
	public static final cselector suggestedAddress=new cselector("css,#checkout-add-address-modal-form > div > div >div>ul");
	public static final cselector city =new cselector( "css,.add-address-dialog .addrCitySpot input","css,#checkout-add-address-modal-form > div > div > div:nth-child(5) > div.c-custom-input-container.c-custom-redux-container.c-custom-input-city"); 
	public static final cselector state= new cselector("css,.add-address-dialog .addrStateSpot input","css,#checkout-add-address-modal-form > div > div > div:nth-child(5) > div:nth-child(2) > div > div > select");
	public static final cselector zipCode = new cselector( "css,.add-address-dialog .addrZipSpot input","css,.m-address_widget_modal>div>div>div>div>form>div>div>div.u-padding-bottom-md>.t-address-widget__addrzip-wrapper>div>div>input"); 
	public static final cselector phone =new cselector("css,.add-address-dialog .addrPhone1Spot input","css,.m-address_widget_modal .c-custom-input-addphone1 input");
	//Step 1 Single Addresses 
	public static final cselector firstNameSingle =new cselector( "css,#ship_fnbox","css,#checkout-single-address-form > div > div > div.u-flexbox.u-padding-bottom-md > div.c-custom-input-container.c-custom-redux-container.c-custom-input-fname.u-margin-end-md > div.u-position-relative.u-width-full.input-label-container > input");
	public static final cselector lastNameSingle= new cselector("css,#ship_lnbox","css,#checkout-single-address-form > div > div > div.u-flexbox.u-padding-bottom-md > div.c-custom-input-container.c-custom-redux-container.c-custom-input-lname > div > input"); 
	public static final cselector streetAddressSingle =new cselector( "css,#ship_sa1box","css,.c-custom-input-street1>div>input");
	public static final cselector citySingle =new cselector( "css,#ship_citybox","css,#checkout-single-address-form > div > div > div:nth-child(5) > div.c-custom-input-container.c-custom-redux-container.c-custom-input-city.u-flex.u-margin-end-md.has-text > div > input"); 
	public static final cselector stateSingle= new cselector("css,#ship_region","css,#checkout-single-address-form > div > div > div:nth-child(5) > div:nth-child(2) > div > div > select");
	public static final cselector zipCodeSingle = new cselector( "css,#ship_zipbox","css,#checkout-single-address-form > div > div > div:nth-child(4) > div.t-address-widget__addrzip-wrapper.u-flexbox > div.c-custom-input-container.c-custom-redux-container.c-custom-input-addrzip.addrZipSpot.u-flex.u-margin-end-md > div > input"); 
	public static final cselector phoneSingle =new cselector("css,#ship_phone1box","css,#checkout-single-address-form > div > div > div.c-custom-input-container.c-custom-redux-container.c-custom-input-addphone1 > div.u-position-relative.u-width-full.input-label-container > input");
	public static final cselector suggestedAddressSingle =new cselector("css,#checkout-single-address-form > div > div > div.address-search.c-custom-input-container.c-custom-redux-container.c-custom-input-street1.has-text>ul");
			
	//Step 2
	public static final cselector secondStepNextButton = new cselector("css,.next-botton-panel .ship-method-and-gift-next-button","css,.c-checkout-accordion__next-cancel-panel .pw--primary");
	public static final cselector productContainerInStepTwo =new cselector("css,.ship-method-panel","css,.c-cart-product__link");
	public static final cselector stepTwoIdentifier =new cselector("css,.ship-method-panel","css,.t-checkout-shipping-and-gift__help-btn");
	public static final cselector stepTwoIdentifierGR =new cselector("css,.ship-method-panel .csb-panels-list-box","css,.t-checkout-shipping-and-gift__help-btn");
	public static final cselector stepTwoIdentifier2 =new cselector("css,.ship-method-panel","css,.t-checkout-step2__truck-delivery-panel");
	public static final cselector stepTwoIdentifier2GR =new cselector("css,.ship-method-panel .csb-panels-list-box","css,.t-checkout-step2__truck-delivery-panel");
	public static final cselector stepTwoPhoneNumber =new cselector("css,#scheduling_phone_number.c-custom-input");	
	//Step 3
	public static final cselector thirdStepNextButton = new cselector("css,.billing-address .next-botton-panel .primary-button","css,#billing-next-btn");
	public static final cselector emailBillingAddress =new cselector("css,#guest_email_field","css,#subscribe_form > div > div.u-position-relative.u-width-full.input-label-container > input");
	
	//Step 4
	public static final cselector creditCartTab = new cselector("css,.cc-tab-header", "css,#single-page-checkout-container > div > div.left-container > div.gwt-accordion.checkout-steps.tabopen > div:nth-child(4) > div.gwt-accordion-tab-content.tabopen > div > div > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td.gwt-TabBarItem-wrapper.gwt-TabBarItem-wrapper-selected > div > button","css, div.pw-tabs__strip-container > ol > li:nth-child(1) > a");	
	public static final cselector shippingAndTaxCost = new cselector("css,.costs-holder .gwt-InlineLabel", "css,.pw-ledger__value");
	public static final cselector offShippingMessagePromo = new cselector("css,.pw-button.u-text-align-start");
	public static final cselector subTotalValue = new cselector("css,.costs-holder .subtotal-value"); 
	public static final cselector creditCardField = new cselector("css,#accountcc", "css,#accountcc","css,#account-cc"); 
	public static final cselector monthField = new cselector("css,#exp-month", "css,.t-checkout-payment__card-month .c-custom-select");  
	public static final cselector yearField = new cselector("css,#exp-year", "css,.t-checkout-payment__card-year .c-custom-select"); 
	public static final cselector cvv = new cselector("css,#security-id", "css,#security-id","css,#security-id");
	public static final cselector cvv2 = new cselector("css,#cvv", "css,#cvv","css,#cvv");
	public static final cselector cvvGH = new cselector("css,#security-id", "css,#security-id","css,#security-id");

	public static final cselector placeSecureOrderButton = new cselector("css,.place-order-panel .primary-button","css,.t-checkout-footer .pw--primary");
	
	//Confirmation Page
	public static final cselector closeRegisterButton = new cselector("css,.okCancelPanel .button.secondary");
	public static final cselector itemID= new cselector("css,.gwt-oid-number", "css,.order-item-part-number");
	public static final cselector closePoromotionalModal= new cselector("css,.extole-js-widget-wrapper.extole-widget-wrapper > a","css,.extole-js-widget-wrapper.extole-widget-wrapper > a");
	public static final cselector orderID = new cselector("css,.order-number-value","css,.order-number");

	
	// PayPal
	public static final cselector paymentPagePayPalTitle=new cselector("css,.gwt-TabPanelBottom>div>div > div.gwt-Label","css, div > div.pw-accordion__title > a > h1 > span");
    public static final cselector paymentPagePayPalSubmitBtn=new cselector("css,.place-order-panel > button:nth-child(1)","css,div.c-checkout-buttons__checkout > button");
    public static final cselector paymentSubmitPopUpClose=new cselector("css,#extole-6763275864515365558 > div > div.extole-js-widget-wrapper.extole-widget-wrapper > a","css,#extole-6763275864515365558 > div > div.extole-js-widget-wrapper.extole-widget-wrapper > a");
    public static final cselector paymentPayPalSubmitRegistrationCloseBtn=new cselector("css,td > div > button.secondary");
    public static final cselector paypalSubmitConfermationMessage=new cselector("css,div.header-panel > div.brand-confirm-message-panel > div","css,p.t-checkout-confirmation__header-confirm-message");
    public static final cselector paypalConfermationPageAllProduct=new cselector("css,div.ship-method-and-gift-container-panel","css,div.t-checkout-order-details-and-shipping > div > div > div:nth-child(2) > div> div > div");
    public static final cselector orderNumber=new cselector("css,div.header-panel > div.order-number-panel > div:nth-child(2)","css,div.order-number");
    public static final cselector email=new cselector("css,div.header-panel > div.email-address-panel > div:nth-child(2)","css,div.email-address"); 
    public static final cselector shippingAddress=new cselector("css,div.shipping-address-title-holder > div","css,div.city-state-address-panel");
    public static final cselector confirmationPageProductImg=new cselector("css,div.order-item-image-holder > img","css,div.c-cart-product-item__image-container > img");
    public static final cselector confirmationPageAccountType=new cselector("css,div.paypal-account-header-panel > div","css,div.paypal-account-header-panel > div");
    public static final cselector confirmationPageSubtotal=new cselector("css,h4.subtotal-value","css,.t-cart__summary-subtotal > td.pw-ledger__value");
    
    public static final cselector confirmationShipping=new cselector("css,div.additional-charges-value.shipping > span","css,.additional-costs.estimated-shipping>div>.additional-charges-value.shipping.right>span","css,.pw-ledger.t-cart__summary-shipping-tax-charges>tbody>tr:nth-child(1)>td:nth-child(2)");
    public static final cselector confirmationPageTax=new cselector("css,div.additional-charges-value.tax> span","css,.pw-ledger.t-cart__summary-shipping-tax-charges>tbody>tr:nth-child(2)>td:nth-child(2)");
    
    public static final cselector BDconfirmationPageTax=new cselector("css,.additional-costs.estimated-tax>div>.additional-charges-value.tax.right>span","css,.pw-ledger.t-cart__summary-shipping-tax-charges>tbody>tr:nth-child(3)>td:nth-child(2)");
    public static final cselector confirmationTotal=new cselector("css,div.estimated-total-value.right","css,.estimated-total > span:nth-child(2)");

}
