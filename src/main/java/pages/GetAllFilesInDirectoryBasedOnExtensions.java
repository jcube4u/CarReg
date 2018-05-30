package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class GetAllFilesInDirectoryBasedOnExtensions {

	public static void main(String[] args) throws IOException {

		File directoryWork = new File("directoryWork");
		String[] extensions = new String[] {"csv"};
		System.out.println("Getting all .csv files in " + directoryWork.getCanonicalPath()
				+ " directory");
		List<File> files = (List<File>) FileUtils.listFiles(directoryWork, extensions, true);
		for (File file : files) {
			System.out.println("file: " + file.getCanonicalPath());
		}
	}
}


