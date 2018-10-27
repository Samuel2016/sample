package com.sample.webService;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import javax.jws.Oneway;
import java.io.IOException;
import java.util.Random;

public class CrudAPICall {

        /**
         * Sample API test. These pages are meant to be broken up into different pages depending on
         * the automation framework.
         */

        private Object requestJson;
        private JSONObject responseBodyJson = new JSONObject();
        private int fieldNameId;
        private String fieldNameBody;
        private final static String BASE_URL = "http://dummy.restapiexample.com/api/v1/"; //posts
        private final static String CREATE = BASE_URL + "create";
        private final static String GET = BASE_URL + "employee";
        private final static String UPDATE = BASE_URL + "update";
        private final static String DELETE = BASE_URL + "delete";

        private CloseableHttpClient httpClientClosable = HttpClients.createDefault();
        private String responseCode = null;
        private  CloseableHttpResponse response;
        private String body;

        // create random object and generating integer
        Random ran = new Random();
        int randomInt = ran.nextInt();

        @Test (priority = 1)
        public void post () {

                generateJson("post");
                httpCall("post", CREATE, getRequestJson().toString());
                validation("post");

        }

        @Test (priority = 2)
        public void get () {

                httpCall("get", GET + "/"+getFieldNameId(), getRequestJson().toString());
                validation("get");
        }

        @Test (priority = 3)
        public void put () {

                generateJson("put");
                httpCall("put" , UPDATE + "/"+ getFieldNameId(), getRequestJson().toString());
                validation("put");

        }

        @Test (priority = 4)
        public void delete () {

                httpCall("delete",DELETE + "/"+ getFieldNameId(), getRequestJson().toString());
                validation("delete");

        }

        private void generateJson(String httpMethod) {

                JSONObject requestBody = new JSONObject();
                requestBody.put("name", "Sam");
                requestBody.put("salary", randomInt);
                requestBody.put("age", 28);
                setRequestJson(requestBody);

                System.out.println("JSON Generated.");

        }

        private void httpCall (String httpMethods, String endpoint, String requestJson) {

                try {
                        if ("post".equals(httpMethods)) {

                                HttpPost post = new HttpPost(endpoint);
                                post.setEntity(new StringEntity(requestJson, "UTF-8"));
                                System.out.println("url : " + post);
                                System.out.println("requestBody : " + requestJson);
                                //post.setHeader("Content-type", "application/json");
                                //post.setHeader("Authorization", "Bearer/Basic " + "token");
                                response = httpClientClosable.execute(post);

                        } else if ("put".equals(httpMethods)) {
                                HttpPut put = new HttpPut(endpoint);
                                put.setEntity(new StringEntity(requestJson, "UTF-8"));
                                System.out.println("url : " + put);
                                response = httpClientClosable.execute(put);
                                System.out.println("requestBody : " + requestJson);

                        } else if ("get".equals(httpMethods)) {
                                HttpGet get = new HttpGet(endpoint);
                                response = httpClientClosable.execute(get);
                                System.out.println("url : " + get);

                        } else if ("delete".equals(httpMethods)) {
                                HttpDelete delete = new HttpDelete(endpoint);
                                response = httpClientClosable.execute(delete);
                                System.out.println("url : " + delete);

                        }

                        responseCode = response.getStatusLine().toString();
                        body = EntityUtils.toString(response.getEntity());
                        System.out.println("response code : " + responseCode);
                        System.out.println("responseBody : " + body);

                } catch (IOException e) {
                        e.printStackTrace();
                }

        }

        private void validation(String method) {

                JSONObject jsonResponse = new JSONObject(body);
                if ("post".equals(method)) {

                        setResponseBodyJson(jsonResponse);
                        int salary = jsonResponse.getInt("salary");
                        int idValue = jsonResponse.getInt("id");
                        if (salary == randomInt) {
                                System.out.println("Post passed. Created id : " + idValue);
                                setFieldNameId(idValue);

                        } else {
                                System.out.println("Test failed. Logic to create defect on failure could be here.");
                        }

                } else if ("get".equals(method)) {
                        int employee_salary = jsonResponse.getInt("employee_salary");
                        if (employee_salary == randomInt) {
                                System.out.println("Get passed.");

                        } else {
                                System.out.println("Test failed. Logic to create defect on failure could be here.");
                        }

                }else if ("put".equals(method)) {
                        int salary = jsonResponse.getInt("salary");
                        if (salary == randomInt) {
                                System.out.println("Put passed.");

                        } else {
                                System.out.println("Test failed. Logic to create defect on failure could be here.");
                        }

                }else if ("delete".equals(method)) {
                        if (jsonResponse.toString().contains("successfully! deleted Records")) {
                                System.out.println("Delete passed.");

                        } else {
                                System.out.println("Test failed. Logic to create defect on failure could be here.");
                        }

                }
                System.out.println();
        }


        public Object getRequestJson() {
                return requestJson;
        }

        public void setRequestJson(Object requestJson) {
                this.requestJson = requestJson;
        }

        public String getFieldNameBody() {
                return fieldNameBody;
        }

        public void setFieldNameBody(String fieldNameBody) {
                this.fieldNameBody = fieldNameBody;
        }

        public int getFieldNameId() {
                return fieldNameId;
        }

        public void setFieldNameId(int fieldNameId) {
                this.fieldNameId = fieldNameId;
        }

        public JSONObject getResponseBodyJson() {
                return responseBodyJson;
        }

        public void setResponseBodyJson(JSONObject responseBodyJson) {
                this.responseBodyJson = responseBodyJson;
        }
}
