package boot;

import boot.bean.Pet;
import boot.bean.User;
import boot.config.MyConfig;
import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ 2021-11-09 12:49
 */
@SpringBootConfiguration
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1、返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3、从容器中获取组件
        Pet tom1 = run.getBean("tom", Pet.class);
        Pet tom2 = run.getBean("tom", Pet.class);
        System.out.println("组件：" + (tom1 == tom2));

        //4、boot.config.MyConfig$$EnhancerBySpringCGLIB$$ec1b2230@4aa3d36
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configration(proxyBeanMethods = true)代理对象调用方法，springboot总是会检查这个组件是否含有
        //保存组件单实例
        User user = bean.user1();
        User user1 = bean.user1();
        System.out.println(user == user1);

        User user2 = run.getBean("user1", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println("用户的宠物：" + (user1.getPet() == tom));

        //5、获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("===============");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);
    }
}
