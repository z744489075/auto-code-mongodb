package ${parentPackage}.${modulePackage}.service;

import com.zengtengpeng.mongodb.bean.MongoPage;
import com.zengtengpeng.mongodb.bean.Req;
import ${filePath.beanPackage}.${table.businessName?cap_first};

import java.util.Collection;
import java.util.List;

public interface ${table.businessName?cap_first}Service {

        /**
        * 新增
        */
        ${table.businessName?cap_first} insert(${table.businessName?cap_first} ${table.businessName});

        /**
        * 保存
        */
        ${table.businessName?cap_first} save(${table.businessName?cap_first} ${table.businessName});

        /**
        * 根据id 查询
        */
        ${table.businessName?cap_first} getId(String id);

        /**
        * 统计
        */
        Long count(${table.businessName?cap_first} ${table.businessName});

        /**
        * 查询一条记录
        */
        ${table.businessName?cap_first} getOne(${table.businessName?cap_first} ${table.businessName});

        /**
        * 分页查询
        */
        MongoPage<${table.businessName?cap_first}> page(Req<${table.businessName?cap_first}> req);

        /**
        * 查询list
        */
        List<${table.businessName?cap_first}> list(${table.businessName?cap_first} ${table.businessName});

        /**
        * 批量insert
        *
        * @return
        */
        List<${table.businessName?cap_first}> insertBatch(List<${table.businessName?cap_first}> ${table.businessName}List);

        /**
        * 根据id更新集合
        */
        Long updateById(${table.businessName?cap_first} ${table.businessName});

        /**
        * 根据id更新集合(只更新一条)
        */
        Long updateOneById(${table.businessName?cap_first} ${table.businessName});
                    
}
