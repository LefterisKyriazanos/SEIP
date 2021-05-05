package unittesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyMathFactorialParameterizedTest.class})
public class MyMathTestSuite {

	// this class is empty. It's used as a holder
	// of the above annotations

}
