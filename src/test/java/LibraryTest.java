import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

import org.ao.JSONRunnerMain;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library --with testng'
 * by 'ahmetozkesek' at '11/11/16 13:58' with Gradle 3.2-rc-2
 *
 * @author ahmetozkesek, @date 11/11/16 13:58
 */
public class LibraryTest {
    @Test public void someLibraryMethodReturnsTrue() {
        JSONRunnerMain classUnderTest = new JSONRunnerMain();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }
}
