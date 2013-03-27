/**
 * 
 */
package eu.emi.emir.ui.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author a.memon
 *
 */
public abstract class AbsractBatchTaskRunner implements TaskRunner {

    protected ScheduledExecutorService ses = null;
	
	protected List<Runnable> lstRunnable;
	/**
	 * 
	 */
	
	/**
	 * 
	 */
	public AbsractBatchTaskRunner(Integer threadPoolSize) {
		ses = Executors.newScheduledThreadPool(threadPoolSize);
		lstRunnable = new ArrayList<Runnable>();
	}
	
	
	
	public void addTask(Runnable r){
		lstRunnable.add(r);
	}
	
	public void removeTask(Runnable r){
		lstRunnable.remove(r);
	}
	
	public void removeAll(){
		lstRunnable.clear();
	}
	
	
}
