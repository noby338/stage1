package note.annotation;

import lombok.Data;
import note.annotation.anno2.Driver;
import note.annotation.anno2.Pwd;
import note.annotation.anno2.Url;
import note.annotation.anno2.Username;


@Data
class DataSource2 {
    @Driver(value = "driver1")
    private String dataSourceDriver;
    @Url("url1")
    private String dataSourceUrl;
    @Username("username1")
    private String dataSourceUsername;
    @Pwd("pwd1")
    private String dataSourcePwd;
}
