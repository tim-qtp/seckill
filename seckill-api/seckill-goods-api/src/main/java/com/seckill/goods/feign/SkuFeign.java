package com.seckill.goods.feign;

import com.seckill.goods.pojo.Sku;
import com.seckill.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author http://www.itheima.com
 */
@FeignClient(value = "seckill-goods")
public interface SkuFeign {

    /**
     * 分页查询-查询总数量
     */
    @GetMapping(value = "/sku/count")
    Integer count();

    /**
     * 分页查询集合列表
     */
    @GetMapping(value = "/sku/list/{page}/{size}")
    List<Sku> list(@PathVariable(value = "page") Integer page, @PathVariable(value = "size") Integer size);

    /**
     * 锁定商品
     */
    @GetMapping(value = "/sku/lock/{id}")
    Result lock(@PathVariable(value = "id") String id);

    /**
     * 解锁商品
     */
    @GetMapping(value = "/sku/unlock/{id}")
    Result unlock(@PathVariable(value = "id") String id);

    /**
     * 根据ID查询Sku数据
     */
    @GetMapping("/sku/{id}")
    Result<Sku> findById(@PathVariable String id);

    /**
     * 商品数据归0
     */
    @GetMapping(value = "/sku/zero/{id}")
    Result zero(@PathVariable(value = "id") String id);
}