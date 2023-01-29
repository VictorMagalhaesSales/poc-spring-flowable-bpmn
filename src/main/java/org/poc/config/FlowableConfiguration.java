package org.poc.config;

import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowableConfiguration {

    @Bean
    public ProcessEngineConfigurationConfigurer processEngineConfigurationConfigurer(){
        return new ProcessEngineConfigurationConfigurer(){

            @Override
            public void configure(SpringProcessEngineConfiguration engineConfiguration) {
                engineConfiguration.setDeploymentMode("single-resource");
            }
        };
    }

}
