package com.javacodegeeks.user.util;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(String.class)
public class TestPowerMock {
	
	@Test
	public void testMockStatic() {
		PowerMock.mockStaticPartial(String.class, "format");
		EasyMock.expect(String.format(EasyMock.anyString(), EasyMock.anyString())).andReturn("Verified");
		Assert.assertEquals(String.format("%s - Test static mock", "JCG"), "Verified");		
	}
}
