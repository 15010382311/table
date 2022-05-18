package domain;

public class Student {
	
	private String hostid;
    private String pro;
    private String cpu;
    private String memory;
    private String disk;
    private String shouye;
    private String service;
    private String network;
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getDisk() {
		return disk;
	}
	public void setDisk(String disk) {
		this.disk = disk;
	}
	public String getShouye() {
		return shouye;
	}
	public void setShouye(String shouye) {
		this.shouye = shouye;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	@Override
	public String toString() {
		return "Student [hostid=" + hostid + ", pro=" + pro + ", cpu=" + cpu + ", memory=" + memory + ", disk=" + disk
				+ ", shouye=" + shouye + ", service=" + service + ", network=" + network + "]";
	}
    
	
}
