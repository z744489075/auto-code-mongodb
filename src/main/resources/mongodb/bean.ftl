package ${filePath.beanPackage};


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;

@Getter
@Setter
public class ${table.businessName?cap_first} {


    <#list table.columnList as column>

        /**
        * ${column.remark}
        */
        private <#if column.type==number>Integer<#elseif column.type==bigDecimal>BigDecimal<#elseif column.type==object>Object<#elseif column.type==array>List<Object><#elseif column.type==date>LocalDate<#elseif column.type==datetime>LocalDateTime   </#if> ${column.name};
    </#list>

        @Transient
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime endCreateTime;
}