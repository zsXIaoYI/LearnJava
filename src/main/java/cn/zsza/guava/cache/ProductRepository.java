package cn.zsza.guava.cache;

import cn.zsza.domain.Product;
import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;

/**
 * package: cn.zsza.guava
 * Time: 2020/4/15 22:04
 * Author: zs
 */
public class ProductRepository {

    private static final ImmutableList<Product> PRODUCT_IMMUTABLE_LIST
            = ImmutableList.of(new Product(1, "Apple", new BigDecimal(12.28)),
            new Product(2, "Samsung", new BigDecimal(20.25)),
            new Product(3, "HuaWei", new BigDecimal(17.35)),
            new Product(4, "Honor", new BigDecimal(16.45)),
            new Product(5, "MI", new BigDecimal(10.98)),
            new Product(6, "Oppo", new BigDecimal(21.67)));

    /**
     * 根据id获取一个商品
     * @param id
     * @return
     */
    public static Product getProductById(Integer id){
        System.out.println("getProductById... id is:" + id);
        for (Product product: PRODUCT_IMMUTABLE_LIST){
            if (id == product.getId()){
                return product;
            }
        }
        return null;
    }
}
