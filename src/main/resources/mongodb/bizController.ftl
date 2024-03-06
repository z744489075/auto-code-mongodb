package ${parentPackage}.${modulePackage}.controller;


import com.zengtengpeng.mongodb.bean.MongoPage;
import com.zengtengpeng.mongodb.bean.Req;
import com.zengtengpeng.mongodb.bean.Res;
import ${filePath.beanPackage}.${table.businessName?cap_first};
import ${parentPackage}.${modulePackage}.service.${table.businessName?cap_first}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* ${remark}
* author: ${author}
* date: ${date}
*/
@RestController
@RequestMapping("/${table.businessName}")
@Slf4j
public class ${table.businessName?cap_first}Controller {

    @Autowired
    private ${table.businessName?cap_first}Feign ${table.businessName}Feign;

    /**
     * 新增
     */
    @PostMapping("insert")
    public Res<${table.businessName?cap_first}> insert(@RequestBody Req<${table.businessName?cap_first}> req) {
        return ${table.businessName}Feign.insert(req);
    }

    /**
     * 批量新增
     *
     * @return
     */
    @PostMapping("insertBatch")
    public Res<List<${table.businessName?cap_first}>> insertBatch(@RequestBody Req<List<${table.businessName?cap_first}>> req) {
        return ${table.businessName}Feign.insertBatch(req);
    }

    /**
     * 根据id查询
     */
    @PostMapping("getId")
    Res<${table.businessName?cap_first}> getId(@RequestBody Req<String> req) {
        return ${table.businessName}Feign.getId(req);
    }

    /**
     * 统计
     */
    @PostMapping("count")
    Res<Long> count(@RequestBody Req<${table.businessName?cap_first}> req) {
        return ${table.businessName}Feign.count(req);
    }

    /**
     * 分页查询
     */
    @PostMapping("page")
    Res<MongoPage<${table.businessName?cap_first}>> page(@RequestBody Req<${table.businessName?cap_first}> req) {
        return ${table.businessName}Feign.page(req);
    }

    /**
     * 查询一条记录
     */
    @PostMapping("getOne")
    Res<${table.businessName?cap_first}> getOne(@RequestBody Req<${table.businessName?cap_first}> req) {
        return ${table.businessName}Feign.getOne(req);
    }

    /**
     * 保存
     */
    @PostMapping("save")
    Res<${table.businessName?cap_first}> save(@RequestBody Req<${table.businessName?cap_first}> req) {
        return ${table.businessName}Feign.save(req);
    }

    /**
     * 查询list
     */
    @PostMapping("list")
    public Res<List<${table.businessName?cap_first}>> list(@RequestBody Req<${table.businessName?cap_first}> req) {
        return ${table.businessName}Feign.list(req);
    }

    /**
     * 根据id更新
     */
    @PostMapping("updateById")
    public Res<Long> updateById(@RequestBody Req<${table.businessName?cap_first}> req) {
        return ${table.businessName}Feign.updateById(req);
    }

    /**
    * 根据id更新
    */
    @PostMapping("updateOneById")
    public Res<Long> updateOneById(@RequestBody Req<${table.businessName?cap_first}> req) {
        return ${table.businessName}Feign.updateOneById(req);
    }

}
