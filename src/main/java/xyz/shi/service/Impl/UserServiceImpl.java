package xyz.shi.service.Impl;

import com.github.pagehelper.Page;
import xyz.shi.dao.UserDao;
import xyz.shi.entity.User;
import xyz.shi.service.UserService;


public class UserServiceImpl implements UserService {

    // 引用类型
    private UserDao userDao;

    // 为了使用set注入来赋值,一定要加这个
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public int save(User user) {
        return this.userDao.save(user);
    }

    @Override
    public Page<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int update1(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }
}
