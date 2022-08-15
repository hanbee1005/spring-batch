package com.example.springbatch.custom;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomJobParametersIncrementer implements JobParametersIncrementer {
    static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public JobParameters getNext(JobParameters parameters) {
        String id = SIMPLE_DATE_FORMAT.format(new Date());
        return new JobParametersBuilder(parameters).addString("run.id", id).toJobParameters();
    }
}
