package ${parentPackage}.${modulePackage}.controller;


import com.zengtengpeng.mongodb.bean.MongoPage;
import com.zengtengpeng.mongodb.bean.Req;
import com.zengtengpeng.mongodb.bean.Res;
import ${filePath.beanPackage}.${table.businessName?cap_first};
import ${parentPackage}.${modulePackage}.service.${table.businessName?cap_first}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: ztp
 * date: 2024-01-01: 11:11:11
 */
@RestController
@RequestMapping("/api/${table.businessName}")
public class ${table.businessName?cap_first}Controller {

    @Autowired
    private ${table.businessName?cap_first}Service ${table.businessName}Service;

    /**
     * 新增
     */
    @PostMapping("insert")
    public Res<${table.businessName?cap_first}> insert(@RequestBody Req<${table.businessName?cap_first}> req) {
        ${table.businessName?cap_first} udpUpMessage = req.getData();
        return Res.success(${table.businessName}Service.insert(udpUpMessage));
    }

    /**
     * 批量新增
     *
     * @return
     */
    @PostMapping("insertBatch")
    public Res<List<${table.businessName?cap_first}>> insertBatch(@RequestBody Req<List<${table.businessName?cap_first}>> req) {
        return Res.success(${table.businessName}Service.insertBatch(req.getData()));
    }

    /**
     * 根据id查询
     */
    @PostMapping("getId")
    Res<${table.businessName?cap_first}> getId(@RequestBody Req<String> req) {
        return Res.success(${table.businessName}Service.getId(req.getData()));
    }

    /**
     * 统计
     */
    @PostMapping("count")
    Res<Long> count(@RequestBody Req<${table.businessName?cap_first}> req) {
        return Res.success(${table.businessName}Service.count(req.getData()));
    }

    /**
     * 分页查询
     */
    @PostMapping("page")
    Res<MongoPage<${table.businessName?cap_first}>> page(@RequestBody Req<${table.businessName?cap_first}> req) {
        return Res.success(${table.businessName}Service.page(req));
    }

    /**
     * 查询一条记录
     */
    @PostMapping("getOne")
    Res<${table.businessName?cap_first}> getOne(@RequestBody Req<${table.businessName?cap_first}> req) {
        return Res.success(${table.businessName}Service.getOne(req.getData()));
    }

    /**
     * 保存
     */
    @PostMapping("save")
    Res<${table.businessName?cap_first}> save(@RequestBody Req<${table.businessName?cap_first}> req) {
        return Res.success(${table.businessName}Service.save(req.getData()));
    }

    /**
     * 查询list
     */
    @PostMapping("list")
    public Res<List<${table.businessName?cap_first}>> list(@RequestBody Req<${table.businessName?cap_first}> req) {
        return Res.success(${table.businessName}Service.list(req.getData()));
    }

    /**
     * 根据id更新
     */
    @PostMapping("updateById")
    public Res<Long> updateById(@RequestBody Req<${table.businessName?cap_first}> req) {
        return Res.success(${table.businessName}Service.updateById(req.getData()));
    }

    /**
    * 根据id更新(只更新一条)
    */
    @PostMapping("updateOneById")
    public Res<Long> updateOneById(@RequestBody Req<${table.businessName?cap_first}> req) {
        return Res.success(${table.businessName}Service.updateOneById(req.getData()));
    }
}
