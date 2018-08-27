package com.scbeasy.demo.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scbeasy.demo.Bean.MiradoBean;
import com.scbeasy.demo.Bean.ScbeasyPriceBean;
import com.scbeasy.demo.Dao.KasikornServer;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ServerController {

	
	

	@Autowired
	KasikornServer kasikornServer;

	@RequestMapping(value="/sc" , method = RequestMethod.POST)
	public ScbeasyPriceBean kars(@RequestBody MiradoBean miradoBean) throws SQLException {
		ScbeasyPriceBean ff = new ScbeasyPriceBean();

		String a = miradoBean.getGroupType();
		String b = miradoBean.getCarMake2();
		ff = kasikornServer.checkpriceKa(a, b);
		return ff;
	}
}
