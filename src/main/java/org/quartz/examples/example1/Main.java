package org.quartz.examples.example1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

class MyJob implements Job {
MyJob() {

}

public void execute(JobExecutionContext context) throws JobExecutionException {
    System.out.println("天下大势为我所控");
}
}

public class Main {

public static void main(String[] args) throws SchedulerException {
    StdSchedulerFactory factory = new StdSchedulerFactory();
    Scheduler scheduler = factory.getScheduler();
    JobDetail job = JobBuilder.newJob(HelloJob.class)
            .withDescription("我的工作")
            .withIdentity("我的名字", "我的分组")
            .build();
    Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("触发器", "触发器分组")
            .startAt(DateBuilder.todayAt(0, 9, 20))
            .build();
    scheduler.scheduleJob(job, trigger);
    scheduler.start();
}
}
