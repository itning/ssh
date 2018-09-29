package sl.young.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UserInterceptor implements Interceptor {

    private static final String USER_ACTION = "userAction";

    @Override
    public void destroy() {

    }
    @Override
    public void init() {

    }
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext invocationContext = actionInvocation.getInvocationContext();
        String userInfo = (String) invocationContext.getSession().get("userInfo");
        ActionProxy proxy = actionInvocation.getProxy();
        String actionName = proxy.getActionName();
        if("".equals(actionName)){
            return actionInvocation.invoke();
        }
        if (USER_ACTION.equals(actionName)){
            return actionInvocation.invoke();
        }
        if (userInfo!=null){
            return actionInvocation.invoke();
        }
        return "login";
    }
}
