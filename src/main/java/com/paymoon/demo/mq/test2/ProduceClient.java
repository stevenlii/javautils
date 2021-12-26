package com.paymoon.demo.mq.test2;
public class ProduceClient {

    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();

        client.produce("SEND:Hello World");
    }

}

