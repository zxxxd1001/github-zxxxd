package com.heren.his.commons.plugin.client;

/**
 * Created by zhangxuedong on 2017/2/21.
 */
public class PluginEvent {
    private String eventId;     //插入点编码
    private Object objectIdentifier;
    private Object businessObject;
    private Boolean cancel;
    private String errorDescription;
    private String appendDescription;

    public PluginEvent() {
    }

    public PluginEvent(String eventId, Object objectIdentifier, Object businessObject) {
        this.eventId = eventId;
        this.objectIdentifier = objectIdentifier;
        this.businessObject = businessObject;
        this.cancel = false;
    }


    public String getEventId() {
        return eventId;
    }

    public Object getObjectIdentifier() {
        return objectIdentifier;
    }

    public Object getBusinessObject() {
        return businessObject;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getAppendDescription() {
        return appendDescription;
    }

    public void setAppendDescription(String appendDescription) {
        this.appendDescription = appendDescription;
    }

    public void setBusinessObject(Object businessObject) {
        this.businessObject = businessObject;
    }
}
