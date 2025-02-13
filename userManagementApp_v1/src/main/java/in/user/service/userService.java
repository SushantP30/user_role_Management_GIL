package in.user.service;

import java.util.List;

import in.user.entity.User;

public interface userService {

	public User createUser(User user);
	public List<User> getAllUser();
	public User findByuserId(Integer id);
	public User updateUser(User user);
	public Boolean deleteUser(Integer id);
}
