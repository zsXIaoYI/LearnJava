package cn.zsza.domain;

import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

/**
 * package: cn.zsza.domain
 * Time: 2020/4/15 21:48
 * Author: zs
 */
@Data
@AllArgsConstructor
public class Product {

    private int id;

    private String name;

    private BigDecimal price;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}
