package ${parentPackage}.${modulePackage}.service.impl;

import com.zengtengpeng.mongodb.bean.MongoPage;
import com.zengtengpeng.mongodb.bean.Req;
import ${filePath.beanPackage}.${table.businessName?cap_first};
import ${parentPackage}.${modulePackage}.service.${table.businessName?cap_first}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


/**
* ${remark}
* author: ${author}
* date: ${date}
*/
@Service
public class ${table.businessName?cap_first}ServiceImpl implements ${table.businessName?cap_first}Service {


    @Autowired
    private MongoTemplate mongoTemplate;


    private String getCollectionName() {
        return "${table.collectionName}";
    }

    @Override
    public ${table.businessName?cap_first} insert(${table.businessName?cap_first} ${table.businessName}) {
        return mongoTemplate.insert(${table.businessName}, getCollectionName());
    }


    @Override
    public ${table.businessName?cap_first} save(${table.businessName?cap_first} ${table.businessName}) {
        return mongoTemplate.save(${table.businessName}, getCollectionName());
    }

    @Override
    public ${table.businessName?cap_first} getId(String id) {
        return mongoTemplate.findById(id, ${table.businessName?cap_first}.class, getCollectionName());
    }

    @Override
    public Long count(${table.businessName?cap_first} ${table.businessName}) {
        Criteria criteria = getCriteria(${table.businessName});
        Query query = new Query(criteria);
        return mongoTemplate.count(query, getCollectionName());
    }

    @Override
    public ${table.businessName?cap_first} getOne(${table.businessName?cap_first} ${table.businessName}) {
        Criteria criteria = getCriteria(${table.businessName});
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, ${table.businessName?cap_first}.class, getCollectionName());
    }

    private Criteria getCriteria(${table.businessName?cap_first} ${table.businessName}) {
        Criteria criteria = new Criteria();

        <#list table.columnList as column>
        if (!ObjectUtils.isEmpty(${table.businessName}.get${column.name?cap_first}())) {
            criteria.and("${column.name}").is(${table.businessName}.get${column.name?cap_first}());
        }

        </#list>

        return criteria;
    }

    @Override
    public MongoPage<${table.businessName?cap_first}> page(Req<${table.businessName?cap_first}> req) {
        Criteria criteria = getCriteria(req.getData());
        Query query = new Query(criteria);
        MongoPage<${table.businessName?cap_first}> mongoPage = new MongoPage<>();
        Long size = mongoTemplate.count(query, getCollectionName());
        mongoPage.setTotal(size);
        Integer skip = MongoPage.getSkip(req.getPage(), req.getPageSize());
        query.limit(req.getPageSize());
        query.skip(skip);
        query.with(Sort.by(Sort.Direction.DESC, "id"));
        mongoPage.setRecords(mongoTemplate.find(query, ${table.businessName?cap_first}.class, getCollectionName()));
        return mongoPage;
    }

    @Override
    public List<${table.businessName?cap_first}> list(${table.businessName?cap_first} ${table.businessName}) {
        Criteria criteria = getCriteria(${table.businessName});
        Query query = new Query(criteria);
        return mongoTemplate.find(query, ${table.businessName?cap_first}.class, getCollectionName());
    }


    @Override
    public List<${table.businessName?cap_first}> insertBatch(List<${table.businessName?cap_first}> data) {
        return mongoTemplate.insert(data, getCollectionName()).stream().toList();
    }

    @Override
    public Long updateById(${table.businessName?cap_first} ${table.businessName}) {
        Criteria criteria = new Criteria().and("_id").is(${table.businessName}.getId());
        Update update = getUpdate(${table.businessName});
        return mongoTemplate.updateMulti(new Query(criteria), update, getCollectionName()).getModifiedCount();
    }

    @Override
    public Long updateOneById(${table.businessName?cap_first} ${table.businessName}) {
        Criteria criteria = new Criteria().and("_id").is(${table.businessName}.getId());
        Update update = getUpdate(${table.businessName});
        return mongoTemplate.updateFirst(new Query(criteria), update, getCollectionName()).getModifiedCount();
    }

    private static Update getUpdate(${table.businessName?cap_first} ${table.businessName}) {
        Update update = new Update();

        <#list table.columnList as column>
        if (!ObjectUtils.isEmpty(${table.businessName}.get${column.name?cap_first}())) {
            update.set("${column.name}", ${table.businessName}.get${column.name?cap_first}());
        }

        </#list>

        return update;
    }
}
