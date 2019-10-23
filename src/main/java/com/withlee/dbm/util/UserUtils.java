package com.withlee.dbm.util;

import javax.servlet.http.HttpServletRequest;

public class UserUtils {

	public static Integer getUserId(HttpServletRequest request){
		return (Integer)request.getAttribute("curr_user_id");
	}
}
