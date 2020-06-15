import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用 java.util.Timer 来执行定时任务
 */
public class TimeRunner {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask timerTask = new SimpleTimerTask();
		// 延迟 1 秒之后，开始每隔 5 秒钟之后再执行任务
		timer.schedule(timerTask, 1000L, 5000L);
	}
}
