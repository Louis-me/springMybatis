package xyz.shi.dao;

import com.github.pagehelper.Page;
import xyz.shi.entity.Grade;
import xyz.shi.entity.Student;

import java.util.List;

// 注意这里的方法名称，一定要和mapper.xml中的id名称一致，不然无法映射到就会报错
public interface GradeDao {
    Page<Grade> findAll();
    Grade queryOne(int id);
    int insertGrade(Grade grade);
    int insertBatchStudent(List<Student> studentList);
    int updateBatchStudent(List<Student> studentList);
    int deleteBatchStudent(List<Integer> ids);
}