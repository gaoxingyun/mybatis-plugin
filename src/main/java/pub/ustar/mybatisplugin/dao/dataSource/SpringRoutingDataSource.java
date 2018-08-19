package pub.ustar.mybatisplugin.dao.dataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;


public class SpringRoutingDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<>();

    public static void setDataSourceTypeKey(String dataSourceTypeKey){
        dataSourceKey.set(dataSourceTypeKey);
    }


    private final static Logger log = LoggerFactory.getLogger(SpringRoutingDataSource.class);
    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }

    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String key = dataSourceKey.get();
        log.info("选择数据源：{}", key);
        return key;
    }
}
