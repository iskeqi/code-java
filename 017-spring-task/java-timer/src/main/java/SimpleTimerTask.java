import java.util.Date;
import java.util.TimerTask;

public class SimpleTimerTask extends TimerTask {

	private int count = 0;

	/**
	 * The action to be performed by this timer task.
	 */
	public void run() {
		System.out.println("execute task.");
		// 返回最近一次需要执行的时间
		Date exeTime = (new Date(scheduledExecutionTime()));
		System.out.println("本次安排的执行时间点为：" + exeTime);
		if (++count > 10) {
			// 任务执行到第 10 次时结束当前任务的执行
			cancel();
		}
	}
}
