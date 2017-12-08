package team12.stockist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team12.stockist.model.DamageRecord;
import team12.stockist.service.DamageRecordService;

@RequestMapping(value ="/damagerecord/")
@Controller
public class DamageRecordController {
	
	@Autowired
	DamageRecordService drs;
	
	//@RequestMapping (value = "/yourlinkhere", method = RequestMethod.GET (or POST)
	//Public blah blah methods here
	

}
