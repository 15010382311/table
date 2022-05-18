package domain;

import java.sql.Date;

public class Zonglan {
	
	private String pro;
    private String ho;
    private String bushu;
    private String lujing;
    private String qidong;
    private String itemid;
    private String xiangqing;
	public String getPro() {
		return pro;
	}
	public String getXiangqing() {
		return xiangqing;
	}
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getBushu() {
		return bushu;
	}
	public void setBushu(String bushu) {
		this.bushu = bushu;
	}
	public String getLujing() {
		return lujing;
	}
	public void setLujing(String lujing) {
		this.lujing = lujing;
	}
	public String getQidong() {
		return qidong;
	}
	public void setQidong(String qidong) {
		this.qidong = qidong;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	@Override
	public String toString() {
		return "Zonglan [pro=" + pro + ", ho=" + ho + ", bushu=" + bushu + ", lujing=" + lujing + ", qidong=" + qidong
				+ ", itemid=" + itemid + "]";
	}
	
	
	

}
