package platform.codingnomads.co.springweb.resttemplate.GET.getForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import platform.codingnomads.co.springweb.resttemplate.GET.models.BoredTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.ExcuseTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.QuoteTemplate;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootApplication
public class GetForObjectDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForObjectDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            QuoteTemplate[] randomQuote;
            randomQuote = restTemplate.getForObject("https://zenquotes.io/api/random/", QuoteTemplate[].class);
            System.out.println(Arrays.toString(randomQuote));

            // submit more requests here
            ExcuseTemplate[] randomExcuse;
            ExcuseTemplate[] categoryExcuse;
            ResponseEntity<ExcuseTemplate[]> idCategoryExcuse;
            ResponseEntity<ExcuseTemplate[]> getForTestExcuse;

            // random excuse
            try {
                randomExcuse = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse", ExcuseTemplate[].class);
                System.out.println(Arrays.toString(randomExcuse));
            } catch (RestClientException restClientException) {
                System.out.println("Error with randomExcuse:\n" + restClientException);
            }

            // by category excuse
            try {
                categoryExcuse = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/party", ExcuseTemplate[].class);
                System.out.println(Arrays.toString(categoryExcuse));
            } catch (RestClientException restClientException) {
                System.out.println("Error with categoryExcuse:\n" + restClientException);
            }

            // getForEntity test
            try {
                getForTestExcuse = restTemplate.getForEntity("https://excuser-three.vercel.app/v1/excuse", ExcuseTemplate[].class);
                System.out.println(getForTestExcuse);
                if (getForTestExcuse.getStatusCode().equals(HttpStatus.OK) && getForTestExcuse.getBody() != null) {
                    ExcuseTemplate[] someExcuse = getForTestExcuse.getBody();
                    System.out.println(Arrays.toString(someExcuse));
                }
            } catch (RestClientException restClientException) {
                System.out.println("Error with excuse API.");
            }

            ResponseEntity<BoredTemplate> randomToDo = restTemplate.getForEntity("http://www.boredapi.com/api/activity/", BoredTemplate.class);
            System.out.println(randomToDo);
            System.out.println(randomToDo.getBody().getActivity());

            //Bored API response POJO structure
            /**
             * activity
             * accessibility
             * type
             * participants
             * price
             * link
             * key
             */
            String boredBaseUrl = "http://www.boredapi.com/api/activity/";
            HashMap<String, String> boredParamMap = new HashMap();
            boredParamMap.put("type", "education");
            String fullUrl = boredBaseUrl + boredParamMap.get("type");
            ResponseEntity someActivity = restTemplate.getForEntity(boredBaseUrl, BoredTemplate.class, boredParamMap);
            System.out.println("Using query parameters:\n" + someActivity.getBody());

            Integer someInt;

            // codingNomads API
//            CodingNomadsTasksApiResponse response =
//                    restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/5",
//                            CodingNomadsTasksApiResponse.class);
//
//            System.out.println(response.toString());

        };
    }
}
