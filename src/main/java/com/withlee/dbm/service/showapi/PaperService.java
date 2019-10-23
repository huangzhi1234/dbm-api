
package com.withlee.dbm.service.showapi;

import java.util.List;

import com.withlee.dbm.domain.showapi.IPaper;


public interface PaperService {

	public List<IPaper> getIPaper(String paperType);
	public int addIPaper(IPaper ipaper);
	

}
