package ${filePath.beanPackage};


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;

import java.util.List;
/**
 * ${remark}
 * author: ${author}
 * date: ${date}
*/
@Getter
@Setter
public class ${table.businessName?cap_first} {


    /**
    * 主键
    */
    private String id;

    <#list table.columnList as column>


    /**
    * ${column.name}:${column.remark}
    */
    <#if column.type=="datetime">
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    </#if>
    private <#if column.type=="number">Integer<#rt>
            <#t><#elseif column.type=="bigDecimal">BigDecimal<#rt>
            <#t><#elseif column.type=="object">Object<#rt>
            <#t><#elseif column.type=="array">List<Object><#rt>
            <#t><#elseif column.type=="date">LocalDate<#rt>
            <#t><#elseif column.type=="datetime">LocalDateTime<#rt>
            <#t><#elseif column.type=="text">String</#if><#rt> ${column.name};
    </#list>

}