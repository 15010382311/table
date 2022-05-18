package cn.ybzy.mvcproject.service;

public class FactoryService {

	public static HostsService getHostsService() {

		return new HostsServiceImpl();
	}

}
