package com.seckill.page.feign;

import com.seckill.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "seckill-page")
public interface SkuPageFeign {
    
    /**
     * 静态页生成
     */
    @GetMapping(value = "/page/html/{id}")
    Result html(@PathVariable(value = "id") String id) throws Exception;

    /**
     * 静态页删除
     */
    @DeleteMapping(value = "/page/html/{id}")
    Result delHtml(@PathVariable(value = "id") String id) throws Exception;
}