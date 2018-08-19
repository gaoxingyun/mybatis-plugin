package pub.ustar.mybatisplugin.dao.interceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {

    @Bean
    Interceptor mybatisReadWritePlugin(){
        MybatisReadWriteInterceptor mybatisReadWritePlugin = new MybatisReadWriteInterceptor();
        return mybatisReadWritePlugin;
    }
}
