package com.kkd.farmerloginservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "farmer-details-service", url = "http://10.151.60.218:8001")
@RibbonClient(name = "farmer-details-service")
public interface FarmerDetailsProxy {

	@GetMapping("/farmer/users/phone/{mobileNo}")
	public String getByMobileNo(@PathVariable(value = "mobileNo") String mobileNo);
	@PutMapping("/farmer/users/change/{mobileNo}")
	public String updatePassword(@RequestBody String password, @PathVariable (value = "mobileNo") String mobileNo);

}
