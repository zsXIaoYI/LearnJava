package cn.zsza.guava.cache;

import cn.zsza.domain.Product;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * package: cn.zsza.guava
 * Time: 2020/4/15 21:48
 * Author: zs
 */
public class GuavaCache {

    private  LoadingCache<String, Product> loadingCache =
            CacheBuilder.newBuilder().refreshAfterWrite(10, TimeUnit.SECONDS)
            .recordStats().build(new CacheLoader<String, Product>() {
                @Override
                public Product load(String key) {
                    return ProductRepository.getProductById(Integer.parseInt(key));
                }
            });

    public Product getProductCache(String id) throws ExecutionException {
        return loadingCache.get(id);
    }

    public  CacheStats getCacheStatus(){
        return this.loadingCache.stats();
    }
}
