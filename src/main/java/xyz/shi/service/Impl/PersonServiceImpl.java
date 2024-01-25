package xyz.shi.service.Impl;

import com.github.pagehelper.Page;
import xyz.shi.dao.PersonDao;
import xyz.shi.entity.Person;
import xyz.shi.service.PersonService;


public class PersonServiceImpl implements PersonService {

    // 引用类型
    private PersonDao personDao;

    // 为了使用set注入来赋值,一定要加这个
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Page<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public Person queryOne(int id) {
        return personDao.queryOne(id);
    }

    @Override
    public int insert(Person person) {
        return personDao.insert(person);
    }

    @Override
    public int modify(Person person) {
        return personDao.modify(person);
    }

    @Override
    public int delete(int id) {
        return personDao.delete(id);
    }
}
