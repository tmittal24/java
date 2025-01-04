package com.file.dircopy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Properties;

public class CopyDir {

	static HashMap<String, String> map = new HashMap<String, String>();

	static {
		try {
			Properties pro = readProperties();

			String p = pro.getProperty((String) Constants.srcDirkey);
			if (p != null)
				map.put((String) Constants.srcDirkey, p);

			p = pro.getProperty((String) Constants.dstDirkey);
			if (p != null)
				map.put((String) Constants.dstDirkey, p);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		CopyDir cf = new CopyDir();

		String inputDirName = cf.map.get(Constants.srcDirkey);
		String outputDirName = cf.map.get(Constants.dstDirkey);

		cf.copyDir(inputDirName, outputDirName);
	}

	public static Properties readProperties() throws IOException {

		Properties pro = new Properties();
		// InputStream is =
		// this.getClass().getcloader().getresourceasStream("app.properties");
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResource("app1.properties").openStream();
		pro.load(is);

		return pro;
	}

	public void copyDir(String srcDir, String trgDir) {

		try {
			System.out.println("starting copy.........");
			copyDirectory(new File(srcDir), new File(trgDir));
			System.out.println("copy done.........");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyDirectory(File sourceLocation, File targetLocation)
			throws IOException {

		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				boolean flag = targetLocation.mkdirs();
				if (!flag) {
					System.out.println(targetLocation + " : Dir not created="
							+ flag);
				}
			}

			String[] children = sourceLocation.list();
			for (int i = 0; i < children.length; i++) {
				copyDirectory(new File(sourceLocation, children[i]), new File(
						targetLocation, children[i]));
			}
		} else {

			InputStream in = new FileInputStream(sourceLocation);
			OutputStream out = new FileOutputStream(targetLocation);

			// Copy the bits from instream to outstream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
	}
	// --------------------------------------------------------------------------------------------------
}
