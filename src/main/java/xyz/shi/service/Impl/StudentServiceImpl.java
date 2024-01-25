package xyz.shi.service.Impl;

import com.github.pagehelper.Page;
import xyz.shi.dao.PersonDao;
import xyz.shi.dao.StudentDao;
import xyz.shi.entity.Student;
import xyz.shi.service.StudentService;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;
    // 为了使用set注入来赋值,一定要加这个
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    @Override
    public Student queryOne(int id) {
        return studentDao.queryOne(id);
    }

    @Override
    public Page<Student> findAllStuCourse() {
        return studentDao.findAllStuCourse();
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int batchInsertStudentCourse(Map<String, Object> parameterMap) {
        return studentDao.batchInsertStudentCourse(parameterMap);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int updateStudentCourse(Map<String, Object> parameterMap) {
        return studentDao.updateStudentCourse(parameterMap);
    }

    @Override
    public int deleteStudentAndRelations(Integer id) {
        return studentDao.deleteStudentAndRelations(id);
    }

}
