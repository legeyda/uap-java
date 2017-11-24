package ua_parser;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class CustTest {

	private static class Case {
		private final String osName;
		private final String osVersion;
		private final String browserName;
		private final String browserVersion;
		private final String userAgent;

		public Case(String osName, String osVersion, String browserName, String browserVersion, String userAgent) {
			this.osName = osName;
			this.osVersion = osVersion;
			this.browserName = browserName;
			this.browserVersion = browserVersion;
			this.userAgent = userAgent;
		}

		public String getOsName() {
			return osName;
		}

		public String getOsVersion() {
			return osVersion;
		}

		public String getBrowserName() {
			return browserName;
		}

		public String getBrowserVersion() {
			return browserVersion;
		}

		public String getUserAgent() {
			return userAgent;
		}
	}

	// https://techblog.willshouse.com/2012/01/03/most-common-user-agents/
	private final static Collection<Case> testData = Arrays.asList(
			new Case("Windows 10",          "10.0",     "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("OS X",                "10.12.6",  "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Windows 10",          "10.0",     "Firefox",       "56.0",          "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("Windows 10",          "10.0",     "Chrome",        "62.0.3202.94",  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "Firefox",       "56.0",          "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("OS X",                "10.13.1",  "Safari",        "11.0.1",        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5"),
			new Case("OS X",                "10.12.6",  "Safari",        "11.0",          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Safari/604.1.38"),
			new Case("Windows 10",          "10.0",     "Chrome",        "62.0.3202.89",  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36"),
			new Case("OS X",                "10.12.6",  "Safari",        "11.0.1",        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5"),
			new Case("Linux (Ubuntu)",      "",         "Firefox",       "56.0",          "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("OS X",                "10.13",    "Safari",        "11.0",          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Safari/604.1.38"),
			new Case("Windows 10",          "10.0",     "Chrome",        "62.0.3202.75",  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36"),
			new Case("OS X",                "10.11.6",  "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "IE",            "11.0",          "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko"),
			new Case("Windows 10",          "10.0",     "Firefox",       "57.0",          "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0"),
			new Case("OS X",                "10.12",    "Firefox",       "56.0",          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("Windows 8.1",         "6.3",      "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("OS X",                "10.13.0",  "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "Chrome",        "62.0.3202.94",  "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
			new Case("Windows 10",          "10.0",     "Chrome",        "52.0.2743.116", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36 Edge/15.15063"),
			new Case("Windows 10",          "10.0",     "Chrome",        "62.0.3202.62",  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36"),
			new Case("Linux",               "",         "Firefox",       "57.0",          "Mozilla/5.0 (X11; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57.0"),
			new Case("Linux",               "",         "Chrome",        "62.0.3202.75",  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36"),
			new Case("OS X",                "10.13.1",  "Chrome",        "62.0.3202.94",  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "Chrome",        "62.0.3202.75",  "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36"),
			new Case("OS X",                "10.13.1",  "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Windows 10",          "10.0",     "Mozilla",       "rv:11.0",       "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko"),
			new Case("Windows 7",           "6.1",      "Firefox",       "57.0",          "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0"),
			new Case("Linux",               "",         "Chrome",        "61.0.3163.100", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Linux",               "",         "Firefox",       "52.0",          "Mozilla/5.0 (X11; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0"),
			new Case("Linux",               "",         "Chrome",        "62.0.3202.62",  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "Chrome",        "62.0.3202.89",  "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36"),
			new Case("OS X",                "10.12.6",  "Chrome",        "62.0.3202.94",  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
			new Case("OS X",                "10.12.6",  "Chrome",        "62.0.3202.75",  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36"),
			new Case("Windows 8.1",         "6.3",      "Firefox",       "56.0",          "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("OS X",                "10.12.6",  "Chrome",        "62.0.3202.89",  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36"),
			new Case("Windows 10",          "10.0",     "Opera",         "48.0.2685.52",  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36 OPR/48.0.2685.52"),
			new Case("Windows 10",          "10.0",     "Chrome",        "58.0.3029.110", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299"),
			new Case("Windows 7",           "6.1",      "Chrome",        "62.0.3202.62",  "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36"),
			new Case("Linux",               "",         "Chrome",        "62.0.3202.89",  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "Firefox",       "52.0",          "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:52.0) Gecko/20100101 Firefox/52.0"),
			new Case("OS X 10.10 Yosemite", "10.10.5",  "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("OS X",                "10.11",    "Firefox",       "56.0",          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("OS X",                "10.11.6",  "Safari",        "11.0.1",        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5"),
			new Case("OS X",                "10.12.5",  "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("OS X",                "10.12.6",  "Chrome",        "62.0.3202.62",  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36"),
			new Case("Linux",               "",         "Firefox",       "56.0",          "Mozilla/5.0 (X11; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("Windows 10",          "10.0",     "Chrome",        "60.0.3112.113", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"),
			new Case("OS X 10.10 Yosemite", "10.10.3",  "Safari",        "8.0.5",         "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/600.5.17 (KHTML, like Gecko) Version/8.0.5 Safari/600.5.17"),
			new Case("OS X 10.10 Yosemite", "10.10.5",  "Safari",        "10.1.2",        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/603.3.8 (KHTML, like Gecko) Version/10.1.2 Safari/603.3.8"),
			new Case("Windows 10",          "10.0",     "Firefox",       "56.0",          "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("Windows 7",           "6.1",      "Firefox",       "56.0",          "Mozilla/5.0 (Windows NT 6.1; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("OS X",                "10.13",    "Firefox",       "56.0",          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("OS X",                "10.12.6",  "Safari",        "10.1.2",        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/603.3.8 (KHTML, like Gecko) Version/10.1.2 Safari/603.3.8"),
			new Case("OS X",                "10.13",    "Firefox",       "57.0",          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:57.0) Gecko/20100101 Firefox/57.0"),
			new Case("Windows 7",           "6.1",      "Firefox",       "56.0",          "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("OS X",                "10.12",    "Firefox",       "57.0",          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0"),
			new Case("iOS",                 "11.0.3",   "Mobile Safari", "11.0",          "Mozilla/5.0 (iPad; CPU OS 11_0_3 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A432 Safari/604.1"),
			new Case("OS X",                "10.11.6",  "Safari",        "11.0",          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Safari/604.1.38"),
			new Case("Windows 7",           "6.1",      "IE",            "11.0",          "Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko"),
			new Case("Windows 7",           "6.1",      "Firefox",       "52.0",          "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0"),
			new Case("OS X",                "10.13.1",  "Chrome",        "62.0.3202.89",  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36"),
			new Case("Windows 10",          "10.0",     "Chrome",        "51.0.2704.79",  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393"),
			new Case("Windows 7",           "6.1",      "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Windows 8.1",         "6.3",      "Chrome",        "62.0.3202.94",  "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
			new Case("Linux (Ubuntu)",      "",         "Chromium",      "62.0.3202.75",  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/62.0.3202.75 Chrome/62.0.3202.75 Safari/537.36"),
			new Case("OS X",                "10.11.6",  "Chrome",        "62.0.3202.94",  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "Chrome",        "62.0.3202.94",  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "IE",            "9.0",           "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;  Trident/5.0)"),
			new Case("Windows 10",          "10.0",     "Mozilla",       "rv:11.0",       "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko"),
			new Case("Linux",               "",         "Chrome",        "62.0.3202.94",  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
			new Case("Windows 10",          "10.0",     "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Linux",               "",         "Chrome",        "51.0.2704.106", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36"),
			new Case("Linux",               "",         "Chrome",        "59.0.3071.115", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
			new Case("OS X",                "10.13.0",  "Chrome",        "62.0.3202.75",  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36"),
			new Case("Windows 7",           "6.1",      "Firefox",       "52.0",          "Mozilla/5.0 (Windows NT 6.1; rv:52.0) Gecko/20100101 Firefox/52.0"),
			new Case("Windows Vista",       "6.0",      "IE",            "9.0",           "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.0; Trident/5.0;  Trident/5.0)"),
			new Case("Windows 10",          "10.0",     "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
			new Case("Windows 8.1",         "6.3",      "Chrome",        "62.0.3202.75",  "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36"),
			new Case("OS X 10.10 Yosemite", "10.10",    "Firefox",       "56.0",          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:56.0) Gecko/20100101 Firefox/56.0"),
			new Case("OS X",                "10.12.5",  "Safari",        "10.1.1",        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/603.2.4 (KHTML, like Gecko) Version/10.1.1 Safari/603.2.4"),
			new Case("Windows 10",          "10.0",     "Firefox",       "52.0",          "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0"),
			new Case("Windows 7",           "6.1",      "Firefox",       "50.0",          "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"),
			new Case("Windows 8.1",         "6.3",      "Firefox",       "57.0",          "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0"),
			new Case("Linux",               "",         "Chrome",        "60.0.3112.78",  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.78 Safari/537.36"),
			new Case("Linux",               "",         "Firefox",       "58.0",          "Mozilla/5.0 (X11; Linux x86_64; rv:58.0) Gecko/20100101 Firefox/58.0"),
			new Case("OS X",                "10.12.3",  "Chrome",        "61.0.3163.100", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"));



	@Test
	public void testParse() throws IOException {
		for(final Case expected: testData) {
			System.out.println("");
			System.out.println("======== " + expected.getUserAgent() + " ========");

			Parser uaParser = new Parser();
			Client c = uaParser.parse(expected.getUserAgent());

			assertEquals("os name",         expected.getOsName(),         c.os.family);
			assertEquals("os version",      expected.getOsVersion(),      Joiner.on('.').skipNulls().join(c.os.major, c.os.minor, c.os.patch, c.os.patchMinor));
			assertEquals("browser name",    expected.getBrowserName(),    c.userAgent.family);
			assertEquals("browser version", expected.getBrowserVersion(), Joiner.on('.').skipNulls().join(c.userAgent.major, c.userAgent.minor, c.userAgent.patch));
		}
	}

	private void assertEquals(final String name, final String expected, final String actual) {
		if(!expected.equals(actual)) {
			System.out.println(String.format("failed asserting that expected %s <%s> equals to actual <%s>", name, expected, actual));
		}
	}

}