import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.shi.entity.User;
import xyz.shi.service.UserService;

import java.util.Arrays;
import java.util.List;

public class MybatisTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    // 其实就是调用的app..xml中的<bean id="userService" class="xyz.shi.service.Impl.UserServiceImpl">
    UserService userMybatisService = (UserService) context.getBean("userService");

    @Test
    public void save() {
        User user = new User();
        user.setName("test009");
        user.setPassword("1234566");
        int num = userMybatisService.save(user);
        System.out.println(num);
    }
    @Test
    public void findAll() {
        //在查询之前，设置分页条件 显示第一页，展示3条数据
        Page<Object> page = PageHelper.startPage(1, 3);
        List<User> userList = userMybatisService.findAll();
        // 设置分页导航数量5
        PageInfo<User> pageInfo = new PageInfo<>(userList, 5);
        for (User user:userList) {
            System.out.println("------每个用户的信息-------");
            System.out.println(user.getName());
            System.out.println(user.getPassword());
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
    public void update() {
        User user = new User();
        user.setId(41);
        user.setName("test41");
        user.setPassword("111111");
        userMybatisService.update1(user);
    }
    @Test
    public void delete() {
        userMybatisService.delete(48);
    }
}

