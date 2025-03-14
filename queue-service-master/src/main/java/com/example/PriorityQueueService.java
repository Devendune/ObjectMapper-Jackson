package com.example;

public interface PriorityQueueService
{
    public void push(String queueUrl,String msgBody,int priority);

    public Message getRequest();
}
