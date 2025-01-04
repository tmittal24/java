package com.scjp;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test2 test2 = new Test2();
		System.out.println(test2.getBuildAndServerInfo());
	}

	public String getBuildAndServerInfo() {
		// e.g - Release 4.7, Build 47 (TC: Build 48) / gha_qlpu01b"
		StringBuffer buildAndServerInfo = new StringBuffer();
		buildAndServerInfo.append("Release ");
		buildAndServerInfo.append("0.0");
		buildAndServerInfo.append(", Build ");
		buildAndServerInfo.append("016");
		buildAndServerInfo.append(" (TC: Build ");
		buildAndServerInfo.append("115");
		buildAndServerInfo.append(") ");
		if (true) {
			buildAndServerInfo.append(", ");
			buildAndServerInfo.append("deb1117".toUpperCase());
		}

		System.setProperty("server.name", "BURE");
		String serverName = System.getProperty("server.name");
		if (serverName != null) {
			buildAndServerInfo.append(" / ");
			buildAndServerInfo.append(serverName);
		}

		return buildAndServerInfo.toString();
	}
//Release 4.7, Build 047 (TC: Build 48) / gha_qlpu01b	
//Release 0.0, Build 016 (TC: Build 000) , DEB1117
//Release 0.0, Build 016 (TC: Build 115) , DEB1117 / BURE
}
