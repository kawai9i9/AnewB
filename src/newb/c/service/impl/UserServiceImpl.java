package newb.c.service.impl;

import java.util.List;

import newb.c.model.User;
import newb.c.service.UserService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Override
	@Cacheable(value="default")
	public User getUserById(int id) {
		User user = mapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	@Cacheable(value="guavaCache1hour")
	public List<User> getUsers() {
		return mapper.selectAll();
	}
}
