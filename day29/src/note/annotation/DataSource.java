package note.annotation;

import lombok.Data;

@Jdbc(url = "othersUrl")
//@Jdbc表示使用该注解， (url = "othersUrl")表示给注解中的属性赋值
@Data
class DataSource {
    @Driver(value = "driver1")
    private String dataSourceDriver;
    @Url("url1")
    private String dataSourceUrl;
    @Username("username1")
    private String dataSourceUsername;
    @Pwd("pwd1")
    private String dataSourcePwd;
}
