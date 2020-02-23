package com.xxxx.payment.salary;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.FieldSetter;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
 
@RunWith(PowerMockRunner.class)
@PrepareForTest({PowerMockDemo.class,Employee.class})
public class PowerMockDemoTest {
 
    private PowerMockDemo powerMockDemoSpy;
    private TestStatic testStaticSpy;
    private Company companySpy;
   // private Employee employeeSpy;
 
    @Before
    public void setUp() {
        powerMockDemoSpy = PowerMockito.spy(new PowerMockDemo());
        testStaticSpy = PowerMockito.spy(new TestStatic());
        companySpy = PowerMockito.spy(new Company());
       // employeeSpy = PowerMockito.spy(new Employee("HHHHHH"));
    }
 
    @Test
    public void testMockPrivateMethod() throws Exception {
    	Employee mockPoint = new Employee("Bhawani111");
    	HashMap channelDetails = new HashMap();
		channelDetails.put("ABC", "N");
		channelDetails.put("XYZ", "N");
		
        PowerMockito.doReturn(mockPoint).when(powerMockDemoSpy, "privateMethod", anyObject());
        PowerMockito.doReturn(channelDetails).when(testStaticSpy, "retrieveChannelDetails", anyObject());
        
        Field executorField = testStaticSpy.getClass().getDeclaredField("companyObj");
		FieldSetter fieldSetter = new FieldSetter(testStaticSpy, executorField);
		fieldSetter.set(companySpy);
        
		when(companySpy.getCompanyName()).thenReturn("xxxx Enterprises");
        
       // PowerMockito.doReturn(mockPoint).when(employeeSpy, "getEmployee", anyObject());
        PowerMockito.mockStatic(Employee.class);
        when(Employee.getEmployee(anyObject())).thenReturn(mockPoint);
 
        Employee actualMockPoint = powerMockDemoSpy.callPrivateMethod();
        System.out.println("PowerMockDemoTest.testMockPrivateMethod() actualMockPoint = " + actualMockPoint.name);
        actualMockPoint = powerMockDemoSpy.callGetEmployee();
        System.out.println("PowerMockDemoTest.testMockPrivateMethod() actualMockPoint = " + actualMockPoint.name);
        actualMockPoint = testStaticSpy.callTestStaticGetEmployee();
        System.out.println("PowerMockDemoTest.testMockPrivateMethod() actualMockPoint = " + actualMockPoint.name);
        channelDetails = testStaticSpy.retrieveChannelDetails("9");
		System.out.println("TestStatic.callTestStaticGetEmployee() channelDetails = " + channelDetails);
		
				
		String val = testStaticSpy.getCompanyName();
		System.out.println("TestStatic.callTestStaticGetEmployee() val = " + val);
        assertThat(actualMockPoint, is(mockPoint));
    }
}
