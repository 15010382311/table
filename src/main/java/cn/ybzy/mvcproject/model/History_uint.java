package cn.ybzy.mvcproject.model;

public class History_uint {
	private int itemid;
	private Integer clock;
	private long value;
	private Integer ns;
	public int getItemid(){
		return itemid;
	}
	public void setItemid(int itemid){
		this.itemid=itemid;
	}
	public Integer getClock(){
		return clock;
	}
	public void setClock(Integer clock){
		this.clock=clock;
	}
	public long getValue(){
		return value;
	}
	public void setValue(long value){
		this.value=value;
	}
	public Integer getNs(){
		return ns;
	}
	public void setNs(Integer ns){
		this.ns=ns;
	}
}