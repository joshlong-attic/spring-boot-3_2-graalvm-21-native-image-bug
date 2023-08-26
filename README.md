# oddity with JSON during graalvm

hi, 

I'm using `graalvm-community-openjdk-21+34.1` to compile my application as native image with the following command: `mvn -DskipTests -Pnative native:compile`. 

I get the following exception: 


```
4.9% of   18,664 total)
   21,054 reachable fields  (58.1% of   36,252 total)
   64,327 reachable methods (54.3% of  118,388 total)
    5,833 types,   441 fields, and 6,895 methods registered for reflection
        1 native library: -framework CoreServices

Fatal error: com.oracle.graal.pointsto.util.AnalysisError$ParsingError: Error encountered while parsing com.fasterxml.jackson.core.io.doubleparser.JavaBigIntegerFromCharSequence.parseHexDigits(JavaBigIntegerFromCharSequence.java:85) 
Parsing context:
   at com.fasterxml.jackson.core.io.doubleparser.JavaBigIntegerFromCharSequence.parseBigIntegerLiteral(JavaBigIntegerFromCharSequence.java:54)
   at com.fasterxml.jackson.core.io.doubleparser.JavaBigIntegerParser.parseBigInteger(JavaBigIntegerParser.java:79)
   at com.fasterxml.jackson.core.io.BigIntegerParser.parseWithFastParser(BigIntegerParser.java:21)
   at com.fasterxml.jackson.core.io.NumberInput.parseBigInteger(NumberInput.java:504)
   at com.fasterxml.jackson.databind.util.TokenBuffer$Parser.getNumberValue(TokenBuffer.java:1918)
   at com.fasterxml.jackson.databind.util.TokenBuffer$Parser.getIntValue(TokenBuffer.java:1854)
   at com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer.deserialize(LocalTimeDeserializer.java:99)
   at com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer.deserialize(LocalTimeDeserializer.java:35)
   at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
   at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4825)
   at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3772)
   at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3755)
   at org.springframework.boot.json.JacksonJsonParser.lambda$parseMap$0(JacksonJsonParser.java:56)
   at org.springframework.boot.json.JacksonJsonParser$$Lambda/0x0000007001d9c8f8.call(Unknown Source)
   at org.springframework.boot.json.AbstractJsonParser.tryParse(AbstractJsonParser.java:53)
   at org.springframework.boot.json.BasicJsonParser.parseMap(BasicJsonParser.java:45)
   at org.springframework.boot.env.SpringApplicationJsonEnvironmentPostProcessor.processJson(SpringApplicationJsonEnvironmentPostProcessor.java:105)
   at org.springframework.boot.env.SpringApplicationJsonEnvironmentPostProcessor$$Lambda/0x0000007001cb0670.accept(Unknown Source)
   at com.oracle.svm.core.WeakIdentityHashMap$EntrySpliterator.forEachRemaining(WeakIdentityHashMap.java:1346)
   at java.util.Spliterators$1Adapter.forEachRemaining(Spliterators.java:706)
   at java.util.Spliterators$IteratorSpliterator.forEachRemaining(Spliterators.java:1939)
   at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)
   at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:679)
   at java.lang.reflect.Executable.sharedToString(Executable.java:123)
   at java.lang.reflect.Method.toString(Method.java:416)
   at root method.(Unknown Source)

        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.AnalysisError.parsingError(AnalysisError.java:149)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.createFlowsGraph(MethodTypeFlow.java:184)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.ensureFlowsGraphCreated(MethodTypeFlow.java:153)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.getOrCreateMethodFlowsGraphInfo(MethodTypeFlow.java:111)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.typestate.DefaultSpecialInvokeTypeFlow.lambda$onObservedUpdate$0(DefaultSpecialInvokeTypeFlow.java:88)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.LightImmutableCollection.forEach(LightImmutableCollection.java:90)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.typestate.DefaultSpecialInvokeTypeFlow.onObservedUpdate(DefaultSpecialInvokeTypeFlow.java:87)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.TypeFlow.update(TypeFlow.java:620)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.PointsToAnalysis$1.run(PointsToAnalysis.java:491)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.CompletionExecutor.executeCommand(CompletionExecutor.java:187)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.CompletionExecutor.lambda$executeService$0(CompletionExecutor.java:171)
        at java.base/java.util.concurrent.ForkJoinTask$RunnableExecuteAction.exec(ForkJoinTask.java:1423)
        at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:387)
        at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1312)
        at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1843)
        at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1808)
        at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:188)
Caused by: java.lang.ClassCastException: class com.oracle.graal.pointsto.heap.ImageHeapInstance cannot be cast to class com.oracle.svm.core.meta.DirectSubstrateObjectConstant (com.oracle.graal.pointsto.heap.ImageHeapInstance is in module org.graalvm.nativeimage.pointsto of loader 'app'; com.oracle.svm.core.meta.DirectSubstrateObjectConstant is in module org.graalvm.nativeimage.builder of loader 'app')
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.meta.SubstrateObjectConstant.asObject(SubstrateObjectConstant.java:68)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.graal.meta.SubstrateSnippetReflectionProvider.asObject(SubstrateSnippetReflectionProvider.java:57)
        at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.ameta.AnalysisMethodHandleAccessProvider.toOriginalConstant(AnalysisMethodHandleAccessProvider.java:81)
        at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.ameta.AnalysisMethodHandleAccessProvider.resolveLinkToTarget(AnalysisMethodHandleAccessProvider.java:75)
        at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.nodes.MethodHandleNode.getLinkToTarget(MethodHandleNode.java:232)
        at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.nodes.MethodHandleNode.tryResolveTargetInvoke(MethodHandleNode.java:111)
        at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.nodes.MethodHandleWithExceptionNode.trySimplify(MethodHandleWithExceptionNode.java:74)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.phases.InlineBeforeAnalysisGraphDecoder.handleMethodHandle(InlineBeforeAnalysisGraphDecoder.java:350)
        at jdk.internal.vm.compiler/org.graalvm.compiler.nodes.GraphDecoder.processNextNode(GraphDecoder.java:924)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.phases.InlineBeforeAnalysisGraphDecoder.processNextNode(InlineBeforeAnalysisGraphDecoder.java:344)
        at jdk.internal.vm.compiler/org.graalvm.compiler.nodes.GraphDecoder.decode(GraphDecoder.java:650)
        at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.decode(PEGraphDecoder.java:892)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.phases.InlineBeforeAnalysis.decodeGraph(InlineBeforeAnalysis.java:76)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.parse(MethodTypeFlowBuilder.java:194)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.apply(MethodTypeFlowBuilder.java:606)
        at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.createFlowsGraph(MethodTypeFlow.java:167)
        ... 15 more
------------------------------------------------------------------------------------------------------------------------
                        1.5s (8.3% of total time) in 48 GCs | Peak RSS: 2.97GB | CPU load: 7.13
========================================================================================================================
Finished generating 'service' in 17.8s.

```

