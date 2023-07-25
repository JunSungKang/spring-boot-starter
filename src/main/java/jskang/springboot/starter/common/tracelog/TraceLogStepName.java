package jskang.springboot.starter.common.tracelog;

public enum TraceLogStepName {

    EMPTY(""),
    CONTROLLER("Controller"),
    SERVICE("Service"),
    ALGORITHM1("Algorithm1"),
    ALGORITHM2("Algorithm2"),
    ALGORITHM3("Algorithm3");

    /**
     * The Step name.
     */
    private final String stepName;

    /**
     * Instantiates a new Trace log step name.
     *
     * @param stepName the step name
     */
    TraceLogStepName(String stepName) {
        this.stepName = stepName;
    }

    @Override
    public String toString() {
        return stepName;
    }
}
