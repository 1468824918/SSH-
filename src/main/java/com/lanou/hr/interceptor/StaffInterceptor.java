package com.lanou.hr.interceptor;

import com.lanou.hr.domain.Staff;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 登录拦截器
 */
public class StaffInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Staff staff = (Staff) ActionContext.getContext().getSession().get("staff");
        if (null == staff) {
            ActionContext.getContext().put("msg", "不是管理员瞎点啥");
            return "login";
        }
        return actionInvocation.invoke();
    }
}
