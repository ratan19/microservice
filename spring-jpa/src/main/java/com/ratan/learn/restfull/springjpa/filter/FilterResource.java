package com.ratan.learn.restfull.springjpa.filter;


import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterResource {


    @GetMapping(path = "/filtered-bean")
    public MappingJacksonValue getOut(){
        SampleBean s= new SampleBean("1","2","3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(s);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2") ;
        FilterProvider filters = new SimpleFilterProvider().addFilter("sampleBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
