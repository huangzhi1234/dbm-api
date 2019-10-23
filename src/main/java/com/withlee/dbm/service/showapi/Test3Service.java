
package com.withlee.dbm.service.showapi;

import java.util.List;

import com.withlee.dbm.domain.showapi.ITest3;
import com.withlee.dbm.persistence.mapper.showapi.Test3;




public interface Test3Service {

	public List<ITest3> getTest3(String id);
	public int addTest3(ITest3 test3);
	

}
