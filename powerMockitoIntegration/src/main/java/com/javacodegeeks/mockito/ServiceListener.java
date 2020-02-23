package com.javacodegeeks.mockito;

public interface ServiceListener {
	void onSuccess(Service service);
	void onFailure(Service service);
}
