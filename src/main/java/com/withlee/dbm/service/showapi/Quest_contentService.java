
package com.withlee.dbm.service.showapi;

import java.util.List;

import com.withlee.dbm.domain.showapi.IPaper;
import com.withlee.dbm.domain.showapi.Iquest_content;


public interface Quest_contentService {

	public List<Iquest_content> getquest_content(String questType);
	public int addquest_content(Iquest_content iquest_content);
	

}
