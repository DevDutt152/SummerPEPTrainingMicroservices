package com.example.demo.consumer;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartRestConsumer {

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getCartData() {

        List<ServiceInstance> instances =
                discoveryClient.getInstances("CARTSERVICE_DAY5");

        if (instances == null || instances.isEmpty()) {
            return "CART_SERVICE not available right now";
        }

        ServiceInstance instance = instances.get(0);

        String url = instance.getUri() + "/cart/getData";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, String.class);
    }

    public String getHDFCData() {

        List<ServiceInstance> instances =
                discoveryClient.getInstances("HDFCBANKSERVICE_DAY5");

        if (instances == null || instances.isEmpty()) {
            return "HDFC_SERVICE not available right now";
        }

        ServiceInstance instance = instances.get(0);

        String url = instance.getUri() + "/hdfc/getData";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, String.class);
    }
}
