
package com.withlee.dbm.service.showapi;

import java.util.List;


import com.withlee.dbm.domain.showapi.Ianswer_content;



public interface Answer_contentService {

	public List<Ianswer_content> getanswer_content(String questId);
	public int addanswer_content(Ianswer_content ianswer_content);
	

}
