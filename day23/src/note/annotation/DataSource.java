package note.annotation;

import lombok.Data;
import note.annotation.anno.Jdbc;


@Data//这是lombok的注解
@Jdbc(url = "othersUrl")//@Jdbc表示使用该注解， (url = "othersUrl")表示给注解中的属性赋值
class DataSource {
    private String dataSourceDriver;
    private String dataSourceUrl;
    private String dataSourceUsername;
    private String dataSourcePwd;
}
