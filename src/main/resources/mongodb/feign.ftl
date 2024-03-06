package ${filePath.feignPackage};


import com.zengtengpeng.mongodb.bean.MongoPage;
import com.zengtengpeng.mongodb.bean.Req;
import com.zengtengpeng.mongodb.bean.Res;
import ${filePath.beanPackage}.${table.businessName?cap_first};
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
* author: ztp
* date: 2024-03-05 11:11:11
*/
@FeignClient(value = "${filePath.mongodbModule}", path = "/api/${table.businessName}", contextId = "${table.businessName}Feign")
public interface ${table.businessName?cap_first}Feign {


        /**
        * 新增
        */
        @PostMapping("insert")
        public Res<${table.businessName?cap_first}> insert(@RequestBody Req<${table.businessName?cap_first}> req);


        /**
        * 批量新增
        */
        @PostMapping("insertBatch")
        Req<List<${table.businessName?cap_first}>> insertBatch(@RequestBody Req<List<${table.businessName?cap_first}>> req);

        /**
        * 根据id查询
        */
        @PostMapping("getId")
        Res<${table.businessName?cap_first}> getId(@RequestBody Req<String> req);

        /**
        * 统计
        */
        @PostMapping("count")
        Res<Long> count(@RequestBody Req<${table.businessName?cap_first}> req);

        /**
        * 分页查询
        */
        @PostMapping("page")
        Res<MongoPage<${table.businessName?cap_first}>> page(@RequestBody Req<${table.businessName?cap_first}> req);

         /**
         * 查询一个
         */
         @PostMapping("getOne")
         Res<${table.businessName?cap_first}> getOne(@RequestBody Req<${table.businessName?cap_first}> req);

         /**
         * 保存
         */
         @PostMapping("save")
         Req<${table.businessName?cap_first}> save(@RequestBody Req<${table.businessName?cap_first}> req);


        /**
        * 查询列表
        */
        @PostMapping("list")
        public Res<List<${table.businessName?cap_first}>> list(@RequestBody Req<${table.businessName?cap_first}> req);


        /**
        * 根据id更新
        */
        @PostMapping("updateById")
        public Res<Long> updateById(@RequestBody Req<${table.businessName?cap_first}> req);


        /**
        * 根据id更新(只更新一条)
        */
        @PostMapping("updateOneById")
        public Res<Long> updateOneById(@RequestBody Req<${table.businessName?cap_first}> req);

}
