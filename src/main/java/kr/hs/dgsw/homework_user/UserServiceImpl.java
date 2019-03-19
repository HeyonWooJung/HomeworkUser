package kr.hs.dgsw.homework_user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service

public class UserServiceImpl implements UserService{


    List<User> userList;

    public UserServiceImpl() {
        userList = new ArrayList<>();

        userList.add(new User("user1", "user111@dgsw", "1"));
        userList.add(new User("user2", "user222@dgsw", "2"));
        userList.add(new User("user3", "user333@dgsw", "3"));
    }

    @Override
    public List<User> list() {
        return this.userList;
    }

    @Override
    public User view(String id) {
        return this.userList.stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean add(User user) {
        User found = this.view(user.getId());
        if (found != null)
            return false;
        return this.userList.add(user);
    }

    @Override
    public User update(User user) {
        User found = this.view(user.getId());
        if (found != null)
            found.setEmail(user.getEmail());
        return  found;
    }

    @Override
    public boolean delete(String id) {
        User found = this.view(id);
        return this.userList.remove(found);
    }
}
