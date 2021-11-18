package boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ 2021-11-17 19:07
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class User {
    private String userName;
    private String password;
}
