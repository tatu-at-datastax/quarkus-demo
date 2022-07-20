# Quarkus-demo Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

It reproduces issue reported as:

    https://github.com/quarkusio/quarkus/issues/26848

Issue is reproducible by

    ./mvnw clean verify

and should print out a lengthy stack trace looking something like:

```
[INFO] Running com.fasterxml.quarkus.GreetingResourceTest
2022-07-20 16:03:45,294 INFO  [org.jbo.threads] (main) JBoss Threads version 3.4.2.Final
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 2.507 s <<< FAILURE! - in com.fasterxml.quarku
s.GreetingResourceTest
[ERROR] com.fasterxml.quarkus.GreetingResourceTest.testHelloEndpoint  Time elapsed: 0.004 s  <<< ERROR!
java.lang.RuntimeException: 
java.lang.RuntimeException: io.quarkus.builder.BuildException: Build failure: Build failed due to errors
        [error]: Build step io.quarkus.smallrye.openapi.deployment.SmallRyeOpenApiProcessor#build threw an exception: java.lang.NullPointerException: Cannot invoke "org.eclipse.microprofile.openapi.models.parameters.Parameter$In.equals(Object)" because the return value of "org.eclipse.microprofile.openapi.models.parameters.Parameter.getIn()" is null
        at io.smallrye.openapi.runtime.scanner.spi.AnnotationScanner.isPathParameter(AnnotationScanner.java:944)
        at io.smallrye.openapi.runtime.scanner.spi.AnnotationScanner.lambda$getRequestBodyParameterClassType$7(AnnotationScanner.java:930)
        at java.base/java.util.stream.IntPipeline$10$1.accept(IntPipeline.java:392)
        at java.base/java.util.stream.IntPipeline$10$1.accept(IntPipeline.java:393)
        at java.base/java.util.stream.Streams$RangeIntSpliterator.tryAdvance(Streams.java:82)
        at java.base/java.util.stream.IntPipeline.forEachWithCancel(IntPipeline.java:163)
        at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        at java.base/java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        at java.base/java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
```
