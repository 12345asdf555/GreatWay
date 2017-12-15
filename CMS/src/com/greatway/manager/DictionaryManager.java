package com.greatway.manager;

import java.util.List;
import com.greatway.model.*;
import com.greatway.page.Page;

public interface DictionaryManager {
	/**
	 * 分页获取字典信息
	 * @param page
	 * @param str
	 * @return
	 */
	List<Dictionarys> getAllDictionary(Page page,String str);
	
    void addDictionary(Dictionarys d);
	
	void editDictionary(Dictionarys d);
	
	int getDictionaryMaxValue(int typeid);
	
	Dictionarys getDictionaryByFid(int id);
	
	void deleteDictionary(int id);
}
