package com.spring.cache.api.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    /*@Bean
    public Config configure(){
        return new Config().setInstanceName("hazelcast-instance").addMapConfig(new MapConfig()
                  .setName("employeeCache").setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                  .setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(2000));
    }*/


     CacheManagerCustomizer<ConcurrentMapCacheManager> costomizer(){
        return new ConcurrentCustomizer();
    }

    class ConcurrentCustomizer implements  CacheManagerCustomizer<ConcurrentMapCacheManager>{

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
            cacheManager.setAllowNullValues(false);
            cacheManager.setStoreByValue(true);
            System.out.println("customize()..invoked");
        }
    }
}
