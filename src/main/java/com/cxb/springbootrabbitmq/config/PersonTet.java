package com.cxb.springbootrabbitmq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author: cxb
 * @create: 2022-07-07 19:34
 */
@Component
@Data
@ConfigurationProperties(prefix = "person")
@Validated
public class PersonTet {
    @Max(value = 1200, message = "不能超过最大值1200")
    @Min(value = 120, message = "不能低于最小值120")
    private int id;
    private String name;
    private String publishTIme;
    private String publishTIme2;
    private String publishTIme3;

}
