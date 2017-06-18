import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder

import static org.gradle.testkit.runner.TaskOutcome.*
import spock.lang.Specification

class SimpleSpockTest extends Specification {

    @Rule final TemporaryFolder testProjectDir = new TemporaryFolder()

    File buildFile

    def setup() {
        buildFile = testProjectDir.newFile('build.gradle')
    }

    def "hello world task prints hello world"() {
        given:
        buildFile << """
        plugins {
            id 'org.rebaze.gradle.testsetup'
        }
        
        task kit() {
            doLast { 
            println 'Hello world!'
            
            }
        }
        
        
    """

        when:
        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('kit')
                .withPluginClasspath()

                .build()

        then:
        result.output.contains('Hello world!')
        result.task(":kit").outcome == SUCCESS
    }

}
