package jskang.springboot.starter.common.tracelog;

import java.time.LocalDateTime;
import jskang.springboot.starter.common.utils.DateUtil;
import org.junit.jupiter.api.Test;

class TraceLogWriterTest {

    @Test
    void testWrite0() throws InterruptedException {
        TraceLogWriter traceLogWriter = new TraceLogWriter();

        LocalDateTime currentTime = DateUtil.today();
        Thread.sleep(500);
        traceLogWriter.write(currentTime, TraceLogStepName.SERVICE);

        currentTime = DateUtil.today();
        Thread.sleep(600);
        traceLogWriter.write(currentTime, TraceLogStepName.ALGORITHM1);

        currentTime = DateUtil.today();
        Thread.sleep(700);
        traceLogWriter.write(currentTime, TraceLogStepName.ALGORITHM2);

        currentTime = DateUtil.today();
        Thread.sleep(800);
        traceLogWriter.write(currentTime, TraceLogStepName.ALGORITHM3);

        String traceLog = traceLogWriter.printTraceLog();
        System.out.println(traceLog);
    }

    @Test
    void testWrite1() throws InterruptedException {
        TraceLogWriter traceLogWriter = new TraceLogWriter();

        LocalDateTime currentTime = DateUtil.today();
        Thread.sleep(500);
        traceLogWriter.write(currentTime, TraceLogStepName.SERVICE, "This is SERVICE description");

        currentTime = DateUtil.today();
        Thread.sleep(600);
        traceLogWriter.write(currentTime, TraceLogStepName.ALGORITHM1, "This is ALGORITHM1 description");

        currentTime = DateUtil.today();
        Thread.sleep(700);
        traceLogWriter.write(currentTime, TraceLogStepName.ALGORITHM2, "This is ALGORITHM2 description");

        currentTime = DateUtil.today();
        Thread.sleep(800);
        traceLogWriter.write(currentTime, TraceLogStepName.ALGORITHM3, "This is ALGORITHM3 description");

        String traceLog = traceLogWriter.printTraceLog();
        System.out.println(traceLog);
    }

    @Test
    void testWrite2() throws InterruptedException {
        TraceLogWriter traceLogWriter = new TraceLogWriter();

        LocalDateTime startTime = null;
        LocalDateTime endTime = null;

        startTime = DateUtil.today();
        Thread.sleep(500);
        endTime = DateUtil.today();
        traceLogWriter.write(startTime, endTime, TraceLogStepName.SERVICE, "This is SERVICE description");

        startTime = DateUtil.today();
        Thread.sleep(600);
        endTime = DateUtil.today();
        traceLogWriter.write(startTime, endTime, TraceLogStepName.ALGORITHM1, "This is ALGORITHM1 description");

        startTime = DateUtil.today();
        Thread.sleep(700);
        endTime = DateUtil.today();
        traceLogWriter.write(startTime, endTime, TraceLogStepName.ALGORITHM2, "This is ALGORITHM2 description");

        startTime = DateUtil.today();
        Thread.sleep(800);
        endTime = DateUtil.today();
        traceLogWriter.write(startTime, endTime, TraceLogStepName.ALGORITHM3, "This is ALGORITHM3 description");

        String traceLog = traceLogWriter.printTraceLog();
        System.out.println(traceLog);
    }
}