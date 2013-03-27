/**
 * 
 */
package eu.emi.emir.ui.thread;

import eu.emi.emir.ui.view.main.ConnectionTask;

/**
 * @author a.memon
 *
 */
public class TaskStarter {
	
	/**
	 * 
	 */
	public TaskStarter() {
		// TODO Auto-generated constructor stub	
	}
	
	public void run(){
		runScheduledTasks();
	}
	
	private void runScheduledTasks(){
		ScheduledBatchTaskRunner r =new ScheduledBatchTaskRunner(3, 3);
		//TODO: use annotations here to find the scheduled tasks
		r.addTask(new ConnectionTask());
		r.execute();
	}
}
