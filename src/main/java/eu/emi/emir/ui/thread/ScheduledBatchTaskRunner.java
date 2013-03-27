/**
 * 
 */
package eu.emi.emir.ui.thread;

import java.util.concurrent.TimeUnit;

/**
 * A global runner which is independent of any session state
 * 
 * @author a.memon
 *
 */
public class ScheduledBatchTaskRunner extends AbsractBatchTaskRunner{
	
	private final Integer period;
	/**
	 * @param threadPoolSize
	 */
	public ScheduledBatchTaskRunner(Integer threadPoolSize, Integer period) {
		super(threadPoolSize);
		this.period = period;
	}

	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.thread.TaskRunner#execute()
	 */
	@Override
	public void execute() {
		for(Runnable r : lstRunnable){
			ses.scheduleAtFixedRate(r,3,period,TimeUnit.SECONDS);
		}
	}
	
}
