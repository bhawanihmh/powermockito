package com.javacodegeeks.user.test;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

import java.util.UUID;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.javacodegeeks.user.controller.UserController;
import com.javacodegeeks.user.domain.User;
import com.javacodegeeks.user.service.DefaultUserService;

/**
 * Test class for UserController
 * @author Meraj
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserController.class)
public class UserControllerTest {
	
	private DefaultUserService mockUserService;
	
	@Test
	public void testGetUserCount() {
		mockUserService = mock(DefaultUserService.class);
		when(mockUserService.getUserCount()).thenReturn(100L);
		UserController userController = new UserController(mockUserService);
		assertEquals(100L, userController.getUserCount().longValue());
	}
	
	@Test
	public void testMockPrivateMethod() throws Exception {
		UserController spy = spy(new UserController());
		when(spy, method(UserController.class, "getGreetingFormat")).withNoArguments().thenReturn("Good Morning %s %s");
		User user = getNewUser();
		assertEquals("Good Morning Code Geeks", spy.getGreetingText(user));
	}
	
	@Test
	public void testMockStatic() throws Exception {
		PowerMock.mockStaticPartial(UUID.class, "randomUUID");		
		EasyMock.expect(UUID.randomUUID()).andReturn(UUID.fromString("067e6162-3b6f-4ae2-a171-2470b63dff00"));
		PowerMock.replayAll();
		UserController userController = new UserController();
		Assert.assertTrue(userController.createUserId(getNewUser()).contains("067e6162-3b6f-4ae2-a171-2470b63dff00"));
		PowerMock.verifyAll();		
	}

	private User getNewUser() {
		User user = new User();
		user.setFirstName("Code");
		user.setSurname("Geeks");
		return user;
	}
	
}
