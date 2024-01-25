import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.shi.dao.StudentDao;
import xyz.shi.entity.Grade;
import xyz.shi.entity.Student;
import xyz.shi.service.GradeService;
import xyz.shi.service.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradeTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    // 其实就是调用的app..xml中的<bean id="userService" class="xyz.shi.service.Impl.UserServiceImpl">
    GradeService gradeService = (GradeService) context.getBean("gradeService");

    @Test
    public void findAll() {
        //在查询之前，设置分页条件 显示第一页，展示10条数据
        Page<Object> page = PageHelper.startPage(1, 10);

        List<Grade> gradeList = gradeService.findAll();

        PageInfo<Grade> pageInfo = new PageInfo<>(gradeList, 5);

        for (Grade grade:gradeList) {
            System.out.println("------每个用户的信息-------");
            System.out.println(grade.getName());
            System.out.println(grade.getStudents());
            List<Student> students = grade.getStudents();
            for(Student student: students) {
                System.out.println(student.getName());

            }

        }
        System.out.println();
        ///xxx
        System.out.println("---------全面配置信息：--------");
        System.out.println("总数据量 :"+pageInfo.getTotal());
        System.out.println("每页的数量:"+pageInfo.getPageSize());
        System.out.println("当前页码:"+pageInfo.getPageNum());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("上一页是:"+pageInfo.getPrePage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("下一页是:"+pageInfo.getNextPage());
        System.out.println("是否是第一页:"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页:"+pageInfo.isIsLastPage());
        System.out.println("导航页的第一个页码是："+pageInfo.getNavigateFirstPage());
        System.out.println("导航页的最后一个页码是："+pageInfo.getNavigateLastPage());
        System.out.println("每页显示的页码个数："+pageInfo.getNavigatePages());
        System.out.println("页码数："+ Arrays.toString(pageInfo.getNavigatepageNums()));
    }
    @Test
    public void queryOne() {
        Grade grade = gradeService.queryOne(2);
        System.out.println(grade.getName());
        List<Student> students = grade.getStudents();
        for(Student student: students) {
            System.out.println(student.getName());
        }
    }
    @Test
    public void insertGrade() {
        Grade grade = new Grade();
        grade.setName("初中1");
        gradeService.insertGrade(grade);
    }
    @Test
    public void insertBatchStudent() {
        Grade grade = new Grade();
        grade.setId(38);

        List<Student> students = new ArrayList<>();

        Student student1 = new Student();
        student1.setName("s11");
        student1.setGrade(grade);
        students.add(student1);

        Student student2 = new Student();
        student2.setName("s21");
        student2.setGrade(grade);
        students.add(student2);

        gradeService.insertBatchStudent(students);
    }
    @Test
    public void  updateBatchStudent() {
        Grade grade = new Grade();
        grade.setId(38);

        List<Student> students = new ArrayList<>();
        students.add(new Student(78, "新姓名1", grade));
        students.add(new Student(79, "新姓名2", grade));
        students.add(new Student(80, "新姓名3", grade));

        gradeService.updateBatchStudent(students);
    }

    @Test
    public void deleteBatchStudent() {
        List<Integer> ids = new ArrayList<>();
        ids.add(75);
        ids.add(76);
//        ids.add(50);
        gradeService.deleteBatchStudent(ids);
        // 如果想删除班级和学生呢,可以先删除学生然后再次删除年纪，就是写两个delete语句
        //delete from student  where gid = #{gid}
        //delete from grade  where id = #{gid}
    }
}
