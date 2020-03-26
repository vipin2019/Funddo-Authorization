package com.funddoauthorization.useradmin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/useradmin")
public class UserAdminApiController {
	
	@RequestMapping(value="/useradmin/login",method=RequestMethod.POST)
	public String loginUser() {
		return "success";
	}
	
}
