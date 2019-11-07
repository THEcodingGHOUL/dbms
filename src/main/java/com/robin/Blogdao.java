package com.robin;

import java.util.List;

public interface Blogdao {
	public List<Blog> getallbysid(String subName);
	//blogdao.addblog(sr,sid);
	public void addblog(Blog blog,String subName);
}
