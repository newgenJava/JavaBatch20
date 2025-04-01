package com.newgen.course.socialMedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.newgen.course.socialMedia.model.User;

@Service
public class UserService {

	private static List<User> userList = new ArrayList<>();

	private static Integer userCount = 2;

	static {
		userList.add(new User(0, "Name1"));
		userList.add(new User( 1, "John"));
		userList.add(new User(2, "Sarah"));
	}

	public List<User> findAll() {
		return userList;
	}

	public Optional<User> findOne(Integer id) {
		Predicate<? super User> findOneUser = user -> user.getId().equals(id);
		Optional<User> user = userList.stream().filter(findOneUser).findFirst();
		return user;
	}

	public User save(User user) {
		if (user.getId() == null || user.getId() == 0) {
			// Automatically add ID
			user.setId(++userCount);
		}
		Optional<User> userToBeAdded = findOne(user.getId());

		if (userToBeAdded.isPresent()) {
//			throw new 
		}

		userList.add(user);

		return user;
	}

	public User update(Integer id, User user) {
		if (user.getId() == null || user.getId() == 0) {
			// Error user does not exist
			user.setId(id);
		}
//		Optional<User> userToBeUpdated = findOne(user.getId());
//		
//		if(userToBeUpdated.isEmpty()) {
////			throw new 
//		}
//		
//		Predicate<? super User> findOtherUsers = userToBeremoved -> !userToBeremoved.getId().equals(id);
//		List<User> updatedUserList = userList.stream().filter(findOtherUsers).toList();
//		
//		userList.clear();
//		
//		updatedUserList.add(user);
//		
//		userList.addAll(updatedUserList);

		userList.remove(id.intValue());
		userList.add(user);
		return user;

	}

}
