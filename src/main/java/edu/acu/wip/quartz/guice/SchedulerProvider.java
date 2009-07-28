package edu.acu.wip.quartz.guice;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class SchedulerProvider implements Provider<Scheduler> {
	
	private final Logger log = LoggerFactory.getLogger(SchedulerProvider.class);
	
	@Inject 
	SchedulerFactory factory;
	
	@Inject
	JobFactory jobFactory;

	public Scheduler get() { 
		Scheduler scheduler = null;
		try {
			scheduler = factory.getScheduler();
			scheduler.setJobFactory(jobFactory);
		} catch (SchedulerException e) {
			log.error("Error creating scheduler", e);
		}
		return scheduler;
	}

}
