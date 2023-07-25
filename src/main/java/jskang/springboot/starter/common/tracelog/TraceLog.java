package jskang.springboot.starter.common.tracelog;

import java.io.Serializable;

public class TraceLog implements Serializable {

    private double seconds;
    private TraceLogStepName stepName;
    private String stepDescription;

    public TraceLog(double seconds, TraceLogStepName stepName) {
        this.seconds = seconds;
        this.stepName = stepName;
        this.stepDescription = "";
    }

    public TraceLog(double seconds, TraceLogStepName stepName, String stepDescription) {
        this.seconds = seconds;
        this.stepName = stepName;
        this.stepDescription = stepDescription;
    }

    public double getSeconds() {
        return seconds;
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public TraceLogStepName getStepName() {
        return stepName;
    }

    public void setStepName(TraceLogStepName stepName) {
        this.stepName = stepName;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }
}
