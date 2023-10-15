$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/featurefiles/releasesModule.feature");
formatter.feature({
  "line": 1,
  "name": "To test the Releases module",
  "description": "",
  "id": "to-test-the-releases-module",
  "keyword": "Feature"
});
formatter.before({
  "duration": 28601214200,
  "error_message": "org.openqa.selenium.SessionNotCreatedException: session not created: This version of ChromeDriver only supports Chrome version 114\nCurrent browser version is 118.0.5993.70 with binary path C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-JAPR9I4\u0027, ip: \u0027192.168.1.13\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002715.0.2\u0027\nDriver info: driver.version: ChromeDriver\nremote stacktrace: Backtrace:\n\tGetHandleVerifier [0x0030A813+48355]\n\t(No symbol) [0x0029C4B1]\n\t(No symbol) [0x001A5358]\n\t(No symbol) [0x001C61AC]\n\t(No symbol) [0x001C1EF3]\n\t(No symbol) [0x001C0579]\n\t(No symbol) [0x001F0C55]\n\t(No symbol) [0x001F093C]\n\t(No symbol) [0x001EA536]\n\t(No symbol) [0x001C82DC]\n\t(No symbol) [0x001C93DD]\n\tGetHandleVerifier [0x0056AABD+2539405]\n\tGetHandleVerifier [0x005AA78F+2800735]\n\tGetHandleVerifier [0x005A456C+2775612]\n\tGetHandleVerifier [0x003951E0+616112]\n\t(No symbol) [0x002A5F8C]\n\t(No symbol) [0x002A2328]\n\t(No symbol) [0x002A240B]\n\t(No symbol) [0x00294FF7]\n\tBaseThreadInitThunk [0x7767FCC9+25]\n\tRtlGetAppContainerNamedObjectPath [0x77C37B1E+286]\n\tRtlGetAppContainerNamedObjectPath [0x77C37AEE+238]\n\t(No symbol) [0x00000000]\n\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.W3CHandshakeResponse.lambda$errorHandler$0(W3CHandshakeResponse.java:62)\r\n\tat org.openqa.selenium.remote.HandshakeResponse.lambda$getResponseFunction$0(HandshakeResponse.java:30)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$0(ProtocolHandshake.java:126)\r\n\tat java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)\r\n\tat java.base/java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)\r\n\tat java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:127)\r\n\tat java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:502)\r\n\tat java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:488)\r\n\tat java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)\r\n\tat java.base/java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)\r\n\tat java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)\r\n\tat java.base/java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:543)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:128)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:74)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:136)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:131)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:181)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:168)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:157)\r\n\tat com.releases.basepage.BasePageClass.invokeBrowser(BasePageClass.java:34)\r\n\tat com.releases.stepdefinitionfiles.ReleasesModuleSteps.pageSetUp(ReleasesModuleSteps.java:43)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:202)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat com.releases.testrunner.ReleasesTestRunner.feature(ReleasesTestRunner.java:42)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:132)\r\n\tat org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:599)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:174)\r\n\tat org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)\r\n\tat org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:822)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:147)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)\r\n\tat java.base/java.util.ArrayList.forEach(ArrayList.java:1511)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:764)\r\n\tat org.testng.TestRunner.run(TestRunner.java:585)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:384)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:378)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:337)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:286)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1218)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1140)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1069)\r\n\tat org.testng.TestNG.run(TestNG.java:1037)\r\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 4,
  "name": "Add and check release details",
  "description": "",
  "id": "to-test-the-releases-module;add-and-check-release-details",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@checkReleases"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Navigate to project site",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Select Releases option",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Click add Release",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Add Release details",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Capture Id and navigate back to Releases page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "create new release",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Handle alert for the mandatory fields",
  "keyword": "And "
});
formatter.match({
  "location": "ReleasesModuleSteps.navigate_to_project_site()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ReleasesModuleSteps.select_Releases_option()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ReleasesModuleSteps.click_add_Release()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ReleasesModuleSteps.add_Release_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ReleasesModuleSteps.capture_Id_and_navigate_back_to_Releases_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ReleasesModuleSteps.create_new_release()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ReleasesModuleSteps.handle_alert_for_the_mandatory_fields()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 3015093100,
  "error_message": "java.lang.NullPointerException: Cannot invoke \"org.openqa.selenium.WebDriver.quit()\" because \"this.driver\" is null\r\n\tat com.releases.stepdefinitionfiles.ReleasesModuleSteps.closeBrowser(ReleasesModuleSteps.java:116)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:206)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat com.releases.testrunner.ReleasesTestRunner.feature(ReleasesTestRunner.java:42)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:132)\r\n\tat org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:599)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:174)\r\n\tat org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)\r\n\tat org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:822)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:147)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)\r\n\tat java.base/java.util.ArrayList.forEach(ArrayList.java:1511)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:764)\r\n\tat org.testng.TestRunner.run(TestRunner.java:585)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:384)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:378)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:337)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:286)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1218)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1140)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1069)\r\n\tat org.testng.TestNG.run(TestNG.java:1037)\r\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\r\n",
  "status": "failed"
});
});