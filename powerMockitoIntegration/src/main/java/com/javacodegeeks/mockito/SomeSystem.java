package com.javacodegeeks.mockito;

import java.util.ArrayList;
import java.util.List;

public class SomeSystem {
	private List<Service> services = new ArrayList<Service>();
	private ServiceListener serviceListener;
	private List<String> events = new ArrayList<String>();

	public void start() {
		for (Service service : services) {
			boolean success = startServiceStaticWay(service) > 0;
			notifyServiceListener(serviceListener, service, success);
			addEvent(service, success);
		}
	}
	
	private void addEvent(Service service, boolean success) {
		events.add(getEvent(service.getName(), success));
	}

	private String getEvent(String serviceName, boolean success) {
		return serviceName + (success ? "started" : "failed");
	}

	public static void notifyServiceListener(ServiceListener serviceListener,
			Service service, boolean success) {
		if (serviceListener != null) {
			if (success) {
				serviceListener.onSuccess(service);
			} else {
				serviceListener.onFailure(service);
			}
		}
	}

	public void add(Service someService) {
		services.add(someService);
	}

	public static int startServiceStaticWay(Service service) {
		int returnCode = service.start();
		return returnCode;
	}

	public void setServiceListener(ServiceListener serviceListener) {
		this.serviceListener = serviceListener;
	}	
	
	public List<String> getEvents() {
		return events;
	}
}
