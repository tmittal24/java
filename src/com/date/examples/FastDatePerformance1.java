package com.date.examples;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang.time.FastDateFormat;


public class FastDatePerformance1 {

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd-HH.mm.ss.SSS000";
    private static final FastDateFormat fastDateFormat = FastDateFormat.getInstance(DATE_FORMAT_PATTERN);

    private static final class DateFormatThread implements Runnable
    {
        private final String mExpectedA;
        private final TestResult mTestResult;
        private final Date mDateA;
        private final String mExpectedC;
        private final String mExpectedB;
        private final Date mDateC;
        private final Date mDateB;
        private final int mRoundsPerThread;
        private final DateFormatAccess mDateFormatAccess;

        private DateFormatThread(String aExpectedA, TestResult aTestResult, Date aDateA, String aExpectedC,
                String aExpectedB, Date aDateC, Date aDateB, int aRoundsPerThread,
                DateFormatAccess aDateFormatAccess)
        {
            mExpectedA = aExpectedA;
            mTestResult = aTestResult;
            mDateA = aDateA;
            mExpectedC = aExpectedC;
            mExpectedB = aExpectedB;
            mDateC = aDateC;
            mDateB = aDateB;
            mRoundsPerThread = aRoundsPerThread;
            mDateFormatAccess = aDateFormatAccess;
        }

        public void run() {
            try {
                for(int j = 0; j < mRoundsPerThread; j++) {
                    String resultA = mDateFormatAccess.format(mDateA);
                    if(!mExpectedA.equals(resultA)) throw new IllegalStateException("Expected " + mExpectedA + " but found " + resultA);
                    String resultB = mDateFormatAccess.format(mDateB);
                    if(!mExpectedA.equals(resultA)) throw new IllegalStateException("Expected " + mExpectedB + " but found " + resultB);
                    String resultC = mDateFormatAccess.format(mDateC);
                    if(!mExpectedA.equals(resultA)) throw new IllegalStateException("Expected " + mExpectedC + " but found " + resultC);
                }
            } catch (RuntimeException e) {
                mTestResult.exceptions.add(e);
            } 
        }
    }

    public interface DateFormatAccess {
        public String format(Date date);
    }

    /**
     * get shared instance of FastDateFormat on every invocation.
     */
    public static class SharedDateFormatAccess implements DateFormatAccess {
        private static FastDateFormat fastDateFormat = FastDateFormat.getInstance(DATE_FORMAT_PATTERN);
        public String format(Date date) {
            return fastDateFormat.format(date);
        }
    }

    /**
     * Create a FastDateFormat.getInstance on every invocation.
     */
    public static class NewInstanceDateFormatAccess implements DateFormatAccess {
        public String format(Date date) {
            return FastDateFormat.getInstance(DATE_FORMAT_PATTERN).format(date);
        }
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("RUN UP: 300 threads x 3000 executions");        
        System.out.println(test(new SharedDateFormatAccess(), 3000, 300));
        System.out.println(test(new NewInstanceDateFormatAccess(), 3000, 300));

    }

    /**
     * Test a particular implemenation and return the result.
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    private static TestResult test(final DateFormatAccess dateFormatAccess, final int roundsPerThread, final int threadCount) throws InterruptedException, ExecutionException {
        final TestResult testResult = new TestResult();
        testResult.input = dateFormatAccess.getClass();
        testResult.roundsPerThread = roundsPerThread;
        testResult.threadCount = threadCount;

        final Date dateA = new Date(System.currentTimeMillis());
        final Date dateB = new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 7));
        final Date dateC = new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 31));
        
        final String expectedA = fastDateFormat.format(dateA);
        final String expectedB = fastDateFormat.format(dateB);
        final String expectedC = fastDateFormat.format(dateC);

        ExecutorService es = Executors.newFixedThreadPool(300);
        Future [] future= new  Future[threadCount];
        DateFormatThread[] dateFormat= new  DateFormatThread[threadCount];
        
        long start = System.currentTimeMillis();
        for(int i = 0; i < threadCount; i++) {
            dateFormat[i] = new DateFormatThread(expectedA, testResult, dateA, expectedC, expectedB, dateC, dateB,
                    roundsPerThread, dateFormatAccess);
            future[i]= es.submit(dateFormat[i]);
        }
        for (int i = 0; i < threadCount; i++)
        {
            future[i].get();
        }
        es.shutdown();
        
        long end = System.currentTimeMillis();

        testResult.runtime = end - start;
        return testResult;
    }

    /**
     * Result of a test execution.
     */
    private static class TestResult {
        int threadCount;
        int roundsPerThread;
        Class input;
        long runtime;
        final List<RuntimeException> exceptions = new ArrayList<RuntimeException>();

        public String toString() {
            if(exceptions.isEmpty()) {
                return "threads: " + threadCount + ", rounds: " + roundsPerThread + ", implementation " + input.getName() + ": time: " + runtime + "ms";
            } else {
                return "threads: " + threadCount + ", rounds: " + roundsPerThread + ", implementation " + input.getName() + " failed";
            }
        }
    }
}
