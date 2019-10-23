
package com.withlee.dbm.service.showapi;

import java.util.List;


import com.withlee.dbm.domain.showapi.IUserinfo;


public interface UserinfoService {


	
	public List<IUserinfo> getIUserinfo(String level);
	
	
	public List<IUserinfo> getLogin(String username,String password);
	
	


}
