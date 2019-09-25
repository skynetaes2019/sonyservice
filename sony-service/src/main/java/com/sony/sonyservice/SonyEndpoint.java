package com.sony.sonyservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sony.sonyservice.cotizaciones.Item;
import com.sony.sonyservice.cotizaciones.Quote;
import com.sony.sonyservice.cotizaciones.SonyQuoteServiceProcessRequest;
import com.sony.sonyservice.cotizaciones.SonyQuoteServiceProcessResponse;
import com.sony.sonyservice.service.ItemSonyService;
import com.sony.sonyservice.service.OrderSonyService;
import com.sony.sonyservice.validaciones.OrderQuouteElementRequest;
import com.sony.sonyservice.validaciones.OrderQuouteElementResponse;


@Endpoint
public class SonyEndpoint {
	private static final String NAMESPACE_URI = "http://www.sony.com/sonyservice/cotizaciones";
	private static final String NAMESPACE_URI2 = "http://www.sony.com/sonyservice/validaciones";
	
	@Autowired
	private ItemSonyService itemService;	
	
	@Autowired
	private OrderSonyService orderService;	
    
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SonyQuoteServiceProcessRequest")
    @ResponsePayload
    public SonyQuoteServiceProcessResponse getQuote(@RequestPayload SonyQuoteServiceProcessRequest request) {
    	SonyQuoteServiceProcessResponse response = new SonyQuoteServiceProcessResponse();
            	
    	long totalPrice =0;
    	
    	List<Item> itemsCotizar = request.getItems();
    	
    	for (Item itemType : itemsCotizar) {    		
    		totalPrice = totalPrice + (itemType.getQuantity() *
    				itemService.getItemById(itemType.getItemId()).getCost() );
		}   	
    	
    	Quote quote = new Quote();
    	quote.setSupplierPrice(String.valueOf(totalPrice));
    	    	
        response.setResult(quote);
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI2, localPart = "OrderQuouteElementRequest")
    @ResponsePayload
    public OrderQuouteElementResponse getQuoteValidation(@RequestPayload OrderQuouteElementRequest request) {
    	OrderQuouteElementResponse response = new OrderQuouteElementResponse();
    	response.setResult(orderService.getOrderById(request.getOrderId()).getEstado().equals("Y"));
        return response;
    }
    

	
	
}
