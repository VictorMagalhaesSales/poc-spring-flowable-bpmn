package org.poc.service.listener;

import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.engine.delegate.event.impl.FlowableEntityEventImpl;
import org.flowable.task.service.impl.persistence.entity.TaskEntityImpl;

public class TaskMonitorEventListener implements FlowableEventListener {
    @Override
    public void onEvent(FlowableEvent event) {
        if(event.getType() == FlowableEngineEventType.TASK_CREATED) {
            org.flowable.common.engine.impl.event.FlowableEntityEventImpl entityEvent = ((org.flowable.common.engine.impl.event.FlowableEntityEventImpl) event);
            TaskEntityImpl task = (TaskEntityImpl) entityEvent.getEntity();
            System.out.println("Task '"+task.getName()+"' created to process definition "+task.getProcessDefinitionId());
        } else if(event.getType() == FlowableEngineEventType.TASK_ASSIGNED) {
            FlowableEntityEventImpl entityEvent = ((FlowableEntityEventImpl) event);
            TaskEntityImpl task = (TaskEntityImpl) entityEvent.getEntity();
            System.out.println("Task '"+task.getName()+"' assined to "+task.getAssignee());
        } else if(event.getType() == FlowableEngineEventType.TASK_COMPLETED) {
            FlowableEntityEventImpl entityEvent = ((FlowableEntityEventImpl) event);
            TaskEntityImpl task = (TaskEntityImpl) entityEvent.getEntity();
            System.out.println("Task '"+task.getName()+"' completed");
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return false;
    }

    @Override
    public String getOnTransaction() {
        return null;
    }
}
