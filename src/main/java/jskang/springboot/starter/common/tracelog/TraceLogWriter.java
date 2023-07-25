package jskang.springboot.starter.common.tracelog;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TraceLogWriter {

    private boolean logging = false;
    private double processingTime = 0.0;
    private ArrayList<TraceLog> traceLogList = new ArrayList<>();

    public void write(LocalDateTime startTime, TraceLogStepName stepName) {
        write(startTime, LocalDateTime.now(), stepName, "");
    }

    public void write(LocalDateTime startTime, TraceLogStepName stepName, String stepDescription) {
        write(startTime, LocalDateTime.now(), stepName, stepDescription);
    }

    public void write(LocalDateTime startTime, LocalDateTime endTime, TraceLogStepName stepName, String stepDescription) {
        double processingSeconds = Duration.between(startTime, endTime).toMillis() / 1000d;
        this.processingTime += processingSeconds;

        TraceLog traceLog;
        if (!stepDescription.isEmpty()) {
            stepDescription = " >> " + stepDescription;
            traceLog = new TraceLog(processingSeconds, stepName, stepDescription);
        } else {
            traceLog = new TraceLog(processingSeconds, stepName, "");
        }

        traceLogList.add(traceLog);
        double totalTime = traceLogList.get(0).getSeconds();
        traceLogList.get(0).setSeconds(totalTime + processingSeconds);
    }

    public boolean isLogging() {
        return logging;
    }

    public double getProcessingTime() {
        return processingTime;
    }

    public ArrayList<TraceLog> getTraceLogList() {
        return traceLogList;
    }

    public String printTraceLog() {
        StringBuilder sb = new StringBuilder();
        for (TraceLog traceLog : traceLogList) {
            sb.append(
                String.format("\n[%s] Duration of time : %f seconds - %s", traceLog.getStepName(), traceLog.getSeconds(), traceLog.getStepDescription())
            );
        }
        return sb.toString();
    }
}
