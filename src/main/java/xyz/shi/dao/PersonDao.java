package xyz.shi.dao;

import com.github.pagehelper.Page;
import xyz.shi.entity.Person;

public interface PersonDao {
    Page<Person> findAll();
    Person queryOne(int id);
    int insert(Person person);
    int modify(Person person);
    int delete(int id);

}
