package org.example.cronjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ScheduledTask {

    @Scheduled(cron = "0 0 9 * * MON-FRI") // Example: Runs every weekday at 9:00 AM
    public void performDailyTask() {
        System.out.println("Executing daily scheduled task...");
        // Your task logic here
    }

    @Scheduled(fixedRate = 5000) // Example: Runs every 5 seconds
    public void performFixedRateTask() {
        System.out.println("Executing fixed rate task...");
        // Your task logic here
    }
}