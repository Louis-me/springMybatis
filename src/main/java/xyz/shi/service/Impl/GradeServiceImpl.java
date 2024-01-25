package xyz.shi.service.Impl;

import com.github.pagehelper.Page;
import xyz.shi.dao.GradeDao;
import xyz.shi.dao.PersonDao;
import xyz.shi.entity.Grade;
import xyz.shi.entity.Student;
import xyz.shi.service.GradeService;
import xyz.shi.service.StudentService;

import java.util.List;
import java.util.Map;

public class GradeServiceImpl implements GradeService {

    private GradeDao gradeDao;
    public void setGradeDao(GradeDao gradeDao) {
        this.gradeDao = gradeDao;
    }
    @Override
    public Page<Grade> findAll() {
        return gradeDao.findAll();
    }

    @Override
    public Grade queryOne(int id) {
        return gradeDao.queryOne(id);
    }

    @Override
    public int insertGrade(Grade grade) {
        return gradeDao.insertGrade(grade);
    }

    @Override
    public int insertBatchStudent(List<Student> studentList) {
        return gradeDao.insertBatchStudent(studentList);
    }

    @Override
    public int updateBatchStudent(List<Student> studentList) {
        return gradeDao.updateBatchStudent(studentList);
    }

    @Override
    public int deleteBatchStudent(List<Integer> ids) {
        return gradeDao.deleteBatchStudent(ids);
    }
}
