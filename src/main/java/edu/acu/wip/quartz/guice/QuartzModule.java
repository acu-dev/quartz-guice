package edu.acu.wip.quartz.guice;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class QuartzModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(SchedulerFactory.class).to(StdSchedulerFactory.class).in(Singleton.class);
		bind(JobFactory.class).to(GuiceJobFactory.class).in(Singleton.class);
		bind(Scheduler.class).toProvider(SchedulerProvider.class).in(Singleton.class);
	}

}
