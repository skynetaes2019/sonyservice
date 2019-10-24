package com.sony.sonyservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sony.sonyservice.cotizaciones.Item;
import com.sony.sonyservice.cotizaciones.Quote;
import com.sony.sonyservice.cotizaciones.SonyQuoteServiceProcessRequest;
import com.sony.sonyservice.cotizaciones.SonyQuoteServiceProcessResponse;
import com.sony.sonyservice.model.entities.DetailOrderSony;
import com.sony.sonyservice.model.entities.OrderSony;
import com.sony.sonyservice.service.DetailOrderSonyService;
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
	
	@Autowired
	DetailOrderSonyService detalleService;
	
	@Value("${texto.cliente}")
	private String cliente;
    
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SonyQuoteServiceProcessRequest")
    @ResponsePayload
    public SonyQuoteServiceProcessResponse getQuote(@RequestPayload SonyQuoteServiceProcessRequest request) {
    	SonyQuoteServiceProcessResponse response = new SonyQuoteServiceProcessResponse();
            	
    	long totalPrice =0;
    	
    	List<Item> itemsCotizar = request.getItems();
    	
    	
    	int index = 1;
    	for (Item itemType : itemsCotizar) {    
    		DetailOrderSony detalleOrden = new DetailOrderSony();
    		detalleOrden.setIdOrden(request.getOrderId());
    		detalleOrden.setCantItem((int) itemType.getQuantity());
    		detalleOrden.setIdItem(itemType.getItemId());
    		detalleOrden.setIdDetalle(index++);
    		
    		detalleService.InsertarDetalle(detalleOrden);
    		
    		totalPrice = totalPrice + (itemType.getQuantity() *
    				itemService.getItemById(itemType.getItemId()).getCost() );
		}   	
    	
    	Quote quote = new Quote();
    	quote.setSupplierPrice(String.valueOf(totalPrice));
    	
    	//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	OrderSony orden = new OrderSony();
    	orden.setId(request.getOrderId());
    	orden.setCliente(cliente);
    	orden.setCostoTotal(totalPrice);
    	orden.setEstado("P");
    	orden.setFechaRecepcion(new Date());
    	
    	orderService.InsertarOrden(orden);
    	    	
        response.setResult(quote); 
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI2, localPart = "OrderQuouteElementRequest")
    @ResponsePayload
    public OrderQuouteElementResponse getQuoteValidation(@RequestPayload OrderQuouteElementRequest request) {
    	OrderQuouteElementResponse response = new OrderQuouteElementResponse();  
    	response.setResult((orderService.aprobarOrden(request.getOrderId(),new Date())>0)?true:false);
        return response;
    }
   
    
    @Scheduled(fixedDelayString = "${actualizaorden.tarea}")
    public void inactivaOrden() {
    	orderService.inactivarTodasOrdPend(new Date());
    }
    

	
	
}
