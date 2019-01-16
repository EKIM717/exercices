package loop;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

public class DoWhile {
	
//	 private final Log log = LogFactory.getLog(DoWhile.class);
	
	private static int MAX_ERROR_RETRY = 5;

	public static void main(String[] args) throws InterruptedException {
		boolean shouldRetry = true;
		int retries = 0;
		do {
			int status = 0;
			// @TODO: Add Codes Here To change status
			
			
			if (1 == status && pauseIfRetryNeeded(++retries)) {
				shouldRetry = true;
			} else {
				// @TODO: Add Codes Here
				
				
				shouldRetry = false;
			}
		} while(shouldRetry);
	}
	
	/**
     * Exponential sleep on failed request. Sleeps and returns true if retry needed
     * @param retries current retry
     * @throws java.lang.InterruptedException
     */
    private static boolean pauseIfRetryNeeded(int retries)
          throws InterruptedException {
        if (retries <= getMaxErrorRetry()) {
        	//尝试间隔时间依次增加,每次是retries的四次方
            long delay = (long) (Math.pow(4, retries) * 100L);
//            log.debug("Retriable error detected, will retry in " + delay + "ms, attempt numer: " + retries);
            System.out.println("Retriable error detected, will retry in " + delay + "ms, attempt numer: " + retries);
            Thread.sleep(delay);
            return true;
        } else {
            return false;
        }
    }
    
    private static int getMaxErrorRetry() {
    	return MAX_ERROR_RETRY;
    }
}
