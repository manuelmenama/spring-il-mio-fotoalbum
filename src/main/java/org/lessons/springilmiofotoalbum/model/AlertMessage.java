package org.lessons.springilmiofotoalbum.model;

public class AlertMessage {

    public enum AlertMessageType {
        SUCCESS, ERROR
    }

    private AlertMessageType alertMessageType;
    private String message;

    public AlertMessage() {
    }

    public AlertMessage(AlertMessageType alertMessageType, String message) {
        this.alertMessageType = alertMessageType;
        this.message = message;
    }

    public AlertMessageType getAlertMessageType() {
        return alertMessageType;
    }

    public void setAlertMessageType(AlertMessageType alertMessageType) {
        this.alertMessageType = alertMessageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AlertMessage{" +
                "alertMessageType=" + alertMessageType +
                ", message='" + message + '\'' +
                '}';
    }
}
