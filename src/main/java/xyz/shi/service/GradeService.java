package xyz.shi.service;

import com.github.pagehelper.Page;
import xyz.shi.entity.Grade;
import xyz.shi.entity.Student;

import java.util.List;

public interface GradeService {
    Page<Grade> findAll();
    Grade queryOne(int id);
    int insertGrade(Grade grade);
    int insertBatchStudent(List<Student> studentList);
    int updateBatchStudent(List<Student> studentList);
    int deleteBatchStudent(List<Integer> ids);

}
