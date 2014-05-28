package fr.treeptik.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CustomInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("custom interceptor start");
		String result = invocation.invoke();
		System.out.println("custom interceptor end");
		return result;
	}

}
