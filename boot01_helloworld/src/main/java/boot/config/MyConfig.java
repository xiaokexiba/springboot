package boot.config;

import boot.bean.Car;
import boot.bean.Pet;
import boot.bean.User;
import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1、配置类里面使用@bean标注方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods:代理bean的方法
 *
 * @ 2021-11-10 8:18
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)//告诉springboot这是一个配置类==配置文件
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例
     *
     * 给容器中添加组件，一方法名作为组件的id。
     * 返回类型就是组件类型。返回的值就是组件在容器中的实例
     */
    @Bean
    public User user1() {
        User zhangsan = new User("zhangsan",18);
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
