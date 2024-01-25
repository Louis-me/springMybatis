package xyz.shi.service;

import com.github.pagehelper.Page;
import xyz.shi.entity.Student;

import java.util.Map;

public interface StudentService {
    Student queryOne(int id);
    Page<Student> findAllStuCourse();
    int insertStudent(Student student);
    int batchInsertStudentCourse(Map<String, Object> parameterMap);

    int updateStudent(Student student);
    int updateStudentCourse(Map<String, Object> parameterMap);
    int deleteStudentAndRelations(Integer student_id);


}
