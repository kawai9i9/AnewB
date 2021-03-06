package newb.c.proxy.log;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogProxy {
	
	private static final Logger logger = LoggerFactory.getLogger(LogProxy.class);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Pointcut("execution(* newb.c.controller.*Controller.*(..)) and !execution(* newb.c.controller.ApiController.rep())")//execution(* newb.c.controller.*.*(..))
	private void Log() {
	}

	@Before("Log()")
	public void beforeAdvice(JoinPoint point) throws ClassNotFoundException {
		/*logger.info("");
		logger.info("");
		logger.info("-------------------------------日志代理开始--------------------------------------------------");
		logger.info("----------------进入的方法为 --- "+point.toString());
		logger.info("----------------传入的参数为---" +Arrays.toString(point.getArgs()));
		logger.info("----------------传入的参数为---" +Arrays.toString(point.getArgs()));
		String curtime=sdf.format(Calendar.getInstance().getTime());
		logger.info("----------------开始时间---"+curtime);*/
		
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("-------------------------------日志代理开始--------------------------------------------------");
		System.out.println("----------------进入的方法为 --- "+point.toString());
		//Struts2的切面方法切不到,所以只能输出这个
//		System.out.println("----------------截取Struts2 --- "+point.getThis()+"+++"+point.toShortString());
		//Struts2的切面方法切不到,所以只能输出这个
		System.out.println("----------------传入的参数为---" +Arrays.toString(point.getArgs()));
//		System.out.println("1--"+point.toString());
//		System.out.println("2--"+point.toShortString());
//		System.out.println("3--"+point.toLongString());
//		Class<?> c = Class.forName(point.getSignature().getDeclaringTypeName());
//		System.out.println("代理--"+c.getName());
//		Arrays.toString(c.getMethods());
		String curtime=sdf.format(Calendar.getInstance().getTime());
	 	System.out.println("----------------开始时间---"+curtime);
	}

	@After("Log()")
	public void afterAdvice() {
		String curtime=sdf.format(Calendar.getInstance().getTime());
//		logger.info("----------------结束时间---"+curtime);
//		logger.info("-------------------------------日志代理结束--------------------------------------------------");
		System.out.println("----------------结束时间---"+curtime);
		System.out.println("-------------------------------日志代理结束--------------------------------------------------");
	}

	@SuppressWarnings("rawtypes")
	@AfterReturning(pointcut = "Log()", returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		if (retVal!=null) {
			if(retVal instanceof List){
				System.out.println("----------------返回List的个数为--"+((List)retVal).size());
			}else {
				System.out.println("----------------返回值为--" + retVal.toString());
			}
		}
	}

	@AfterThrowing(pointcut = "Log()", throwing = "ex")
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("日志Aop出错了" + ex.toString());
	}
}
