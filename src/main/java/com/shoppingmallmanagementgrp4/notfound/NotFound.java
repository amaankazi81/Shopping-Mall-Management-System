package com.shoppingmallmanagementgrp4.notfound;

import java.util.HashMap;
import java.util.Map;

public class NotFound {

	// error response method
		public static Map<String, String> notFound(Integer id, String type){
			Map<String, String> response = new HashMap<>();
			response.put("error", type + " not found with id " + id);
			return response;
		}
		
//		public static Map<String, String> orderNotFound(Integer id){
//			Map<String, String> response = new HashMap<>();
//			response.put("error", "Order not found with id " + id);
//			return response;
//		}
//		
//		public static Map<String, String> entryPosted(){
//			Map<String, String> response = new HashMap<>();
//			response.put("message", "Entry posted succesfully");
//			return response;
//		}
	
}
