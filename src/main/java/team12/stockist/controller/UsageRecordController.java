package team12.stockist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import team12.stockist.service.UsageRecordDetailService;
import team12.stockist.service.UsageRecordService;

@RequestMapping(value ="/usagerecord/")
@Controller
public class UsageRecordController {
	
	@Autowired
	UsageRecordService usageRecordService;
	
	@Autowired
	UsageRecordDetailService usageRecordDetailService;
	
	//@RequestMapping (value = "/yourlinkhere", method = RequestMethod.GET (or POST)
	//Public blah blah methods here
	

}
