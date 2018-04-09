package com.kkd.farmerloginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kkd.farmerloginservice.FarmerDetailsProxy;
import com.kkd.farmerloginservice.modal.FarmerLoginBean;

@RestController
public class FarmerLoginController {

	@Autowired
	private FarmerDetailsProxy proxy;

	@PostMapping("/farmer/login")
	// @HystrixCommand(fallbackMethod="fallback")
	public String getPhone_no(@RequestBody FarmerLoginBean farmerLoginBean) {
		String password = proxy.getByMobileNo(farmerLoginBean.getMobileNo());
		if (farmerLoginBean.getPassword().equals(password)) {
			return "success";
		}
		return "Incorrect Password";
	}

	@PostMapping("/farmer/forget/{mobile_No}")
	// @HystrixCommand(fallbackMethod="fallback") public String
	public String forgetPassword(@RequestBody String newPassword, @PathVariable String mobile_No) {

		String status=proxy.updatePassword(newPassword, mobile_No);
		return status ;
	}

	public String fallback() {
		return "fallback";
	}

}
