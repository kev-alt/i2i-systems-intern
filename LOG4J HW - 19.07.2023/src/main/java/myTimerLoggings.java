import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {
    private static final Logger debugLogger = LogManager.getLogger("DebugLog");
    private static final Logger infoLogger = LogManager.getLogger("InfoLog");
    private static final Logger errorLogger = LogManager.getLogger("ErrorLog");

    public static void main(String[] args) {

        Configurator.initialize(null, "log4j2.xml");

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            int seconds = 0;

            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                debugLogger.debug(String.format("Debug - Saat: 20:27:%02d", seconds));
                seconds++;

                if (seconds > 2) {
                    cancel();
                }
            }
        }, 0, 1000);

        timer.schedule(new TimerTask() {
            int minutes = 28;

            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                infoLogger.info(String.format("Info - Saat: 20:%02d:00", minutes));
                minutes++;

                if (minutes > 30) {
                    cancel();
                }
            }
        }, 60000, 60000);

        timer.schedule(new TimerTask() {
            int hours = 21;

            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                errorLogger.error(String.format("Error - Saat: %02d:00:00", hours));
                hours++;

                if (hours > 23) {
                    cancel();
                }
            }
        }, 3600000, 3600000);
    }
}
