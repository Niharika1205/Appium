package practise.AppiumFrame;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "ApiDemoData")
	public Object[][] getTextApiDemo() {
		return new Object[][] {  {"hello"}, {"@#$%" }};
	}

	@DataProvider(name = "InputData")
	public Object[][] getDataforEditField() {
		// 2 sets of data, "hello" , "!@#$$"
		Object[][] obj = new Object[][] { { "hello" }, { "@#$%" } };

		return obj;

	}
}