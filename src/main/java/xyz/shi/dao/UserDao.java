package xyz.shi.dao;

import com.github.pagehelper.Page;
import xyz.shi.entity.User;

// 注意这里的方法名称，一定要和mapper.xml中的id名称一致，不然无法映射到就会报错
public interface UserDao {
    int save(User user);
    int update(User user);
    User findById(int id);
    Page<User> findAll();
    int delete(int id);
}