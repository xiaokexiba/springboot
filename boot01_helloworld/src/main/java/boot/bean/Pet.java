package boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 宠物
 *
 * @ 2021-11-10 8:12
 */
@Data
@ToString
@NoArgsConstructor//无参构造器
@AllArgsConstructor//全参构造器
public class Pet {

    private String name;
}
