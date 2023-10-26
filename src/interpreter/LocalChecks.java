package interpreter;

import gradingTools.comp524f22.assignment6.F22Assignment6Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class LocalChecks {
    public static void main(final String[] args) {
        Tracer.showInfo(true);
        GraderBasicsTraceUtility.setBufferTracedMessages(true);
        F22Assignment6Suite.main(args);
    }
}
