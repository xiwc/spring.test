package com.emc.pie.esa.test.spring;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;

@org.testng.annotations.Test
public class Test {

	public void readFileFromClassPath() throws IOException {

		URL resource = Test.class.getResource("/application-beans.properties");

		System.out.println(resource.toString());

		List<String> lines = FileUtils.readLines(FileUtils.toFile(resource), "utf-8");

		System.out.println(lines.size());
	}
}
