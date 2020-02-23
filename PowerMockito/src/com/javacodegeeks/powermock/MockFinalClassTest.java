package com.javacodegeeks.powermock;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SimpleFinalClazz.class)
public class MockFinalClassTest {
	
	@Test
	public void testMockFinal() {
		SimpleFinalClazz simpleFinalClazz = PowerMock.createMock(SimpleFinalClazz.class);
		FinalClazzUser finalClazzUser = new FinalClazzUser(simpleFinalClazz);
		EasyMock.expect(simpleFinalClazz.simpleFinalMethod()).andReturn("Hurray!!!");
		PowerMock.replay(simpleFinalClazz);
		String actual = finalClazzUser.getMeSomething();
		PowerMock.verify(simpleFinalClazz);
		Assert.assertEquals(actual, "Get Me Something Hurray!!!");
	}

}
