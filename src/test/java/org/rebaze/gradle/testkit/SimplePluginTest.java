package org.rebaze.gradle.testkit;

import java.io.File;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.TaskOutcome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimplePluginTest {
    @Test
    public void testSiwthTestKit() {
        BuildResult result = GradleRunner.create().withDebug(true)
                .withProjectDir( new File("src/test/resources/demo-project"))
                .withPluginClasspath()
              //  .withArguments("kit")
                .build();
        assertEquals(TaskOutcome.SUCCESS, result.getTasks().get(0).getOutcome());

        //assertEquals("",result.getOutput());

    }
}
