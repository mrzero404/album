package com.zero.mytime.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.mytime.damain.Tomato;
import com.zero.mytime.dao.impl.TomatoDaoImpl;
import com.zero.mytime.service.TomatoService;

@Controller
public class TomatoController {		
	
	private static final Log logger = LogFactory.getLog(TomatoController.class);
	@Autowired
	private TomatoService tomatoService;
	@Autowired
	private TomatoDaoImpl tomatoDaoImpl;
	
	@ResponseBody  
	@RequestMapping(value="/getTodayTomatos", method = RequestMethod.POST)
	public ResponseEntity<?> inputProduct(Model model) {
		logger.info("inputProduct called");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fitomatos",tomatoService.getTodayTomatos());
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@ResponseBody 
	@RequestMapping(value="/addTomato", method = RequestMethod.POST)
	public ResponseEntity<?> saveProduct(@RequestBody Tomato tomato) {
		logger.info("saveProduct called");
		tomatoService.addTomato(tomato);
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("code", "10000");
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
	
//	@ResponseBody 
//	@RequestMapping(value="/addTomato", method = RequestMethod.POST)
//	public ResponseEntity<?> editTomato(@RequestBody Tomato tomato) {
//		logger.info("saveProduct called");
//		tomatoService.addTomato(tomato);
//		Map<String, Object> retMap = new HashMap<String, Object>();
//		retMap.put("code", "10000");
//		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
//	}
	
	@ResponseBody 
	@RequestMapping(value="/removeTomato/{id}")
	public ResponseEntity<?> removeTomato(@PathVariable Integer id) {
		logger.info("saveProduct called");
		tomatoService.removeTomato(id);
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("code", "10000");
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
	
}
