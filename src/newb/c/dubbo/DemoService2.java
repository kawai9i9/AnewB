package newb.c.dubbo;

import java.util.List;

import newb.c.backend.model.basemodel.User;  
public interface DemoService2 {
	
	String sayHello(String name);

	public List<User> getUsers();
}
