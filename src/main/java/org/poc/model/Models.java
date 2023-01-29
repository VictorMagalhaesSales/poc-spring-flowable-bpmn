package org.poc.model;

import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.Date;

public class Models {

    public static class TaskDTO {

        private String id;
        private String name;
        private String description;
        private String assignee;
        private String category;
        private Date createTime;

        public TaskDTO(Task task) {
            this.id = task.getId();
            this.name = task.getName();
            this.assignee = task.getAssignee();
            this.category = task.getCategory();
            this.description = task.getDescription();
            this.createTime = task.getCreateTime();
        }

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAssignee() {
            return assignee;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
    }

    public static class ProcessDTO {
        private String id;
        private String name;
        private String description;
        private String category;
        private String deploymentId;
        private String key;
        private String resourceName;

        public ProcessDTO(ProcessDefinition process) {
            this.id = process.getId();
            this.name = process.getName();
            this.category = process.getCategory();
            this.description = process.getDescription();
            this.deploymentId = process.getDeploymentId();
            this.key = process.getKey();
            this.resourceName = process.getResourceName();
        }

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getDeploymentId() {
            return deploymentId;
        }

        public void setDeploymentId(String deploymentId) {
            this.deploymentId = deploymentId;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getResourceName() {
            return resourceName;
        }

        public void setResourceName(String resourceName) {
            this.resourceName = resourceName;
        }
    }

    public static class ProcessInstanceDTO {
        private String id;
        private String name;
        private String deploymentId;
        private String businessStatus;
        private String processDefinitionKey;
        private Integer processDefinitionVersion;
        private String tenantId;

        public ProcessInstanceDTO(ProcessInstance pi) {
            this.id = pi.getId();
            this.name = pi.getName();
            this.deploymentId = pi.getDeploymentId();
            this.businessStatus = pi.getBusinessStatus();
            this.processDefinitionKey = pi.getProcessDefinitionKey();
            this.processDefinitionVersion = pi.getProcessDefinitionVersion();
            this.tenantId = pi.getTenantId();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDeploymentId() {
            return deploymentId;
        }

        public void setDeploymentId(String deploymentId) {
            this.deploymentId = deploymentId;
        }

        public String getBusinessStatus() {
            return businessStatus;
        }

        public void setBusinessStatus(String businessStatus) {
            this.businessStatus = businessStatus;
        }

        public String getProcessDefinitionKey() {
            return processDefinitionKey;
        }

        public void setProcessDefinitionKey(String processDefinitionKey) {
            this.processDefinitionKey = processDefinitionKey;
        }

        public Integer getProcessDefinitionVersion() {
            return processDefinitionVersion;
        }

        public void setProcessDefinitionVersion(Integer processDefinitionVersion) {
            this.processDefinitionVersion = processDefinitionVersion;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }
    }
}