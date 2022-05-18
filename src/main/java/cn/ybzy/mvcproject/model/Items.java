package cn.ybzy.mvcproject.model;

public class Items {
	private int itemid;
	private Integer type;
	private String snmp_oid;
	private int hostid;
	private String name;
	private String key_;
	private String delay;
	private String history;
	private String trends;
	private Integer status;
	private Integer value_type;
	private String trapper_hosts;
	private String units;
	private String formula;
	private String logtimefmt;
	private int templateid;
	private int valuemapid;
	private String params;
	private String ipmi_sensor;
	private Integer authtype;
	private String username;
	private String password;
	private String publickey;
	private String privatekey;
	private Integer flags;
	private int interfaceid;
	private String description;
	private Integer inventory_link;
	private String lifetime;
	private Integer evaltype;
	private String jmx_endpoint;
	private int master_itemid;
	private String timeout;
	private String url;
	private String query_fields;
	private String posts;
	private String status_codes;
	private Integer follow_redirects;
	private Integer post_type;
	private String http_proxy;
	private String headers;
	private Integer retrieve_mode;
	private Integer request_method;
	private Integer output_format;
	private String ssl_cert_file;
	private String ssl_key_file;
	private String ssl_key_password;
	private Integer verify_peer;
	private Integer verify_host;
	private Integer allow_traps;
	private Integer discover;
	public int getItemid(){
		return itemid;
	}
	public void setItemid(int itemid){
		this.itemid=itemid;
	}
	public Integer getType(){
		return type;
	}
	public void setType(Integer type){
		this.type=type;
	}
	public String getSnmp_oid(){
		return snmp_oid;
	}
	public void setSnmp_oid(String snmp_oid){
		this.snmp_oid=snmp_oid;
	}
	public int getHostid(){
		return hostid;
	}
	public void setHostid(int hostid){
		this.hostid=hostid;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getKey_(){
		return key_;
	}
	public void setKey_(String key_){
		this.key_=key_;
	}
	public String getDelay(){
		return delay;
	}
	public void setDelay(String delay){
		this.delay=delay;
	}
	public String getHistory(){
		return history;
	}
	public void setHistory(String history){
		this.history=history;
	}
	public String getTrends(){
		return trends;
	}
	public void setTrends(String trends){
		this.trends=trends;
	}
	public Integer getStatus(){
		return status;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	public Integer getValue_type(){
		return value_type;
	}
	public void setValue_type(Integer value_type){
		this.value_type=value_type;
	}
	public String getTrapper_hosts(){
		return trapper_hosts;
	}
	public void setTrapper_hosts(String trapper_hosts){
		this.trapper_hosts=trapper_hosts;
	}
	public String getUnits(){
		return units;
	}
	public void setUnits(String units){
		this.units=units;
	}
	public String getFormula(){
		return formula;
	}
	public void setFormula(String formula){
		this.formula=formula;
	}
	public String getLogtimefmt(){
		return logtimefmt;
	}
	public void setLogtimefmt(String logtimefmt){
		this.logtimefmt=logtimefmt;
	}
	public int getTemplateid(){
		return templateid;
	}
	public void setTemplateid(int templateid){
		this.templateid=templateid;
	}
	public int getValuemapid(){
		return valuemapid;
	}
	public void setValuemapid(int valuemapid){
		this.valuemapid=valuemapid;
	}
	public String getParams(){
		return params;
	}
	public void setParams(String params){
		this.params=params;
	}
	public String getIpmi_sensor(){
		return ipmi_sensor;
	}
	public void setIpmi_sensor(String ipmi_sensor){
		this.ipmi_sensor=ipmi_sensor;
	}
	public Integer getAuthtype(){
		return authtype;
	}
	public void setAuthtype(Integer authtype){
		this.authtype=authtype;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPublickey(){
		return publickey;
	}
	public void setPublickey(String publickey){
		this.publickey=publickey;
	}
	public String getPrivatekey(){
		return privatekey;
	}
	public void setPrivatekey(String privatekey){
		this.privatekey=privatekey;
	}
	public Integer getFlags(){
		return flags;
	}
	public void setFlags(Integer flags){
		this.flags=flags;
	}
	public int getInterfaceid(){
		return interfaceid;
	}
	public void setInterfaceid(int interfaceid){
		this.interfaceid=interfaceid;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public Integer getInventory_link(){
		return inventory_link;
	}
	public void setInventory_link(Integer inventory_link){
		this.inventory_link=inventory_link;
	}
	public String getLifetime(){
		return lifetime;
	}
	public void setLifetime(String lifetime){
		this.lifetime=lifetime;
	}
	public Integer getEvaltype(){
		return evaltype;
	}
	public void setEvaltype(Integer evaltype){
		this.evaltype=evaltype;
	}
	public String getJmx_endpoint(){
		return jmx_endpoint;
	}
	public void setJmx_endpoint(String jmx_endpoint){
		this.jmx_endpoint=jmx_endpoint;
	}
	public int getMaster_itemid(){
		return master_itemid;
	}
	public void setMaster_itemid(int master_itemid){
		this.master_itemid=master_itemid;
	}
	public String getTimeout(){
		return timeout;
	}
	public void setTimeout(String timeout){
		this.timeout=timeout;
	}
	public String getUrl(){
		return url;
	}
	public void setUrl(String url){
		this.url=url;
	}
	public String getQuery_fields(){
		return query_fields;
	}
	public void setQuery_fields(String query_fields){
		this.query_fields=query_fields;
	}
	public String getPosts(){
		return posts;
	}
	public void setPosts(String posts){
		this.posts=posts;
	}
	public String getStatus_codes(){
		return status_codes;
	}
	public void setStatus_codes(String status_codes){
		this.status_codes=status_codes;
	}
	public Integer getFollow_redirects(){
		return follow_redirects;
	}
	public void setFollow_redirects(Integer follow_redirects){
		this.follow_redirects=follow_redirects;
	}
	public Integer getPost_type(){
		return post_type;
	}
	public void setPost_type(Integer post_type){
		this.post_type=post_type;
	}
	public String getHttp_proxy(){
		return http_proxy;
	}
	public void setHttp_proxy(String http_proxy){
		this.http_proxy=http_proxy;
	}
	public String getHeaders(){
		return headers;
	}
	public void setHeaders(String headers){
		this.headers=headers;
	}
	public Integer getRetrieve_mode(){
		return retrieve_mode;
	}
	public void setRetrieve_mode(Integer retrieve_mode){
		this.retrieve_mode=retrieve_mode;
	}
	public Integer getRequest_method(){
		return request_method;
	}
	public void setRequest_method(Integer request_method){
		this.request_method=request_method;
	}
	public Integer getOutput_format(){
		return output_format;
	}
	public void setOutput_format(Integer output_format){
		this.output_format=output_format;
	}
	public String getSsl_cert_file(){
		return ssl_cert_file;
	}
	public void setSsl_cert_file(String ssl_cert_file){
		this.ssl_cert_file=ssl_cert_file;
	}
	public String getSsl_key_file(){
		return ssl_key_file;
	}
	public void setSsl_key_file(String ssl_key_file){
		this.ssl_key_file=ssl_key_file;
	}
	public String getSsl_key_password(){
		return ssl_key_password;
	}
	public void setSsl_key_password(String ssl_key_password){
		this.ssl_key_password=ssl_key_password;
	}
	public Integer getVerify_peer(){
		return verify_peer;
	}
	public void setVerify_peer(Integer verify_peer){
		this.verify_peer=verify_peer;
	}
	public Integer getVerify_host(){
		return verify_host;
	}
	public void setVerify_host(Integer verify_host){
		this.verify_host=verify_host;
	}
	public Integer getAllow_traps(){
		return allow_traps;
	}
	public void setAllow_traps(Integer allow_traps){
		this.allow_traps=allow_traps;
	}
	public Integer getDiscover(){
		return discover;
	}
	public void setDiscover(Integer discover){
		this.discover=discover;
	}
}