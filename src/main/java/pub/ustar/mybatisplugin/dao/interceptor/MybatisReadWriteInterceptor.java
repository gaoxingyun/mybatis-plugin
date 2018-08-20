package pub.ustar.mybatisplugin.dao.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Properties;

import pub.ustar.mybatisplugin.dao.dataSource.SpringRoutingDataSource;

@Intercepts(
        {
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class,Object.class, RowBounds.class,ResultHandler.class}),
        }
        )
public class MybatisReadWriteInterceptor implements Interceptor {

    private final static Logger log = LoggerFactory.getLogger(MybatisReadWriteInterceptor.class);
        
    private String writeDataSourceKey;
    private String readDataSourceKey;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("mybatis进入拦截方法，{}",invocation);

        String key = "slave";
        SpringRoutingDataSource.setDataSourceTypeKey(key);

        log.info("设置数据源为：{}", key);

        Object object = invocation.proceed();
        return object;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        String readDataSourceKey = properties.getProperty("readDataSourceKey");
        String writeDataSourceKey = properties.getProperty("writeDataSourceKey");
        this.readDataSourceKey = readDataSourceKey;
        this.writeDataSourceKey = writeDataSourceKey;
        log.debug("参数为：{}", properties.toString());
    }
}
