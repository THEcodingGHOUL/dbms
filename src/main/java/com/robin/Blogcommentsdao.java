package com.robin;

import java.util.List;

public interface Blogcommentsdao {
	public List<Blogcomments> getall();
	public List<Blogcomments> getallbybid(int bid);
	//bcd.addblogcomment(sr,bid);
	public void addblogcomment(Blogcomments sr,int blogid);
}
