package com.threads.printdetails;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class PrintThreadDetails {
	public static void main(String[] args) {
		ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
		long[] threadIds = mxBean.getAllThreadIds();
		ThreadInfo[] threadInfos = mxBean.getThreadInfo(threadIds);
		
		for (ThreadInfo threadInfo : threadInfos) {
			StringBuilder builder = new StringBuilder();
			//builder.append(threadInfo.getThreadName());
			builder.append(String.format("%-20s= %s" , threadInfo.getThreadName(), threadInfo.getThreadId()));
			builder.append(" | ");
			builder.append(threadInfo.getBlockedCount());
			builder.append(" | ");
			builder.append(threadInfo.getBlockedTime());
			builder.append(" | ");
			builder.append(threadInfo.getWaitedCount());
			builder.append(" | ");
			builder.append(threadInfo.getWaitedTime());
			
			System.out.println(builder.toString());
			
			long count = ManagementFactory.getThreadMXBean().getThreadCount();
			System.out.println("Threadcount =" + count);
			
			count = Thread.activeCount();
			System.out.println("Threadcount =" + count);
		}
		
		long count = ManagementFactory.getThreadMXBean().getThreadCount();
		System.out.println("Threadcount =" + count);
		
		count = Thread.activeCount();
		System.out.println("Threadcount =" + count);
	}

}
