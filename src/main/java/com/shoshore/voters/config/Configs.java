package com.shoshore.voters.config;

import com.shoshore.voters.service.VoterService;
import com.shoshore.voters.service.VoterServiceImpl;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configs {
    @Bean
    public VoterService voterService(){
        return new VoterServiceImpl();
    }
    @Bean
    public Mapper mapper(){
        return DozerBeanMapperBuilder.buildDefault();
    }
}
