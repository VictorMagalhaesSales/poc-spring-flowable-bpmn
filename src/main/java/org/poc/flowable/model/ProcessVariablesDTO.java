package org.poc.flowable.model;

import lombok.Data;

import java.util.Map;

@Data
public class ProcessVariablesDTO {

    private Map<String, Object> variables;

}
