package domain;

import java.sql.Date;

public class ClassNo {
	
	private String alertid;
	private String zhuji;
    private String dizhi;
    private String time;
    private String dengji;
    private String xinxi;
    private String jilu;
    public String getAlertid() {
		return alertid;
	}
	public void setAlertid(String alertid) {
		this.alertid = alertid;
	}
	public String getZhuji() {
		return zhuji;
	}
	public void setZhuji(String zhuji) {
		this.zhuji = zhuji;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDengji() {
		return dengji;
	}
	public void setDengji(String dengji) {
		this.dengji = dengji;
	}
	public String getXinxi() {
		return xinxi;
	}
	public void setXinxi(String xinxi) {
		this.xinxi = xinxi;
	}
	public String getJilu() {
		return jilu;
	}
	public void setJilu(String jilu) {
		this.jilu = jilu;
	}
	@Override
	public String toString() {
		return "ClassNo [zhuji=" + zhuji + ", dizhi=" + dizhi + ", time=" + time + ", dengji=" + dengji + ", xinxi="
				+ xinxi + ", jilu=" + jilu + "]";
	}
    
	

}
