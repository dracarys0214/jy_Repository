package com.bdqn.jy.homework2018_9_3;

public class Book {
	private String title;
	private int pageNum=200;
	
	 void detail(){
		 System.out.print("教材名:"+title+"\t页数:");
		 if(pageNum<200){
			 System.out.println("错误信息");
			 return;
		 }
		 System.out.println(pageNum);
	 }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
