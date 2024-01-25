package xyz.shi.service;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import xyz.shi.entity.User;

@Service
public interface UserService {
    int save(User user);
    Page<User> findAll();
    int update1(User user);
    int delete(int id);
}
