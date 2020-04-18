package cn.zsza.guava.cache;

import cn.zsza.domain.Product;
import java.util.concurrent.ExecutionException;

/**
 * package: cn.zsza.guava
 * Time: 2020/4/15 22:12
 * Author: zs
 */
public class GuavaCacheMain {
    public static void main(String[] args) throws ExecutionException {

        GuavaCache cache = new GuavaCache();

        Product product = cache.getProductCache("" + 1);
        System.out.println(product);
        System.out.println(cache.getCacheStatus());

        System.out.println();

        Product product2 = cache.getProductCache("" + 1);
        System.out.println(product2);
        System.out.println(cache.getCacheStatus());

        System.out.println();

        Product product3 = cache.getProductCache("" + 1);
        System.out.println(product3);
        System.out.println(cache.getCacheStatus());

    }
}
