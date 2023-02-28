package org.example.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpResponse;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;


class WebServletTest {
	 private static final int NUM_CLIENTS = 100;

	//@Test
	void testHelloServletGet() throws Exception {
		
		HttpClient client = new HttpClient();
        client.start();

        ContentResponse res = client.GET("http://localhost:9090/coen6317/HelloServlet");
        
        System.out.println(res.getContentAsString());
        
        client.stop();
		
	}
	
	
	//@Test
	void testBlockingServletGet() throws Exception {
		
		HttpClient client = new HttpClient();
        client.start();

        ContentResponse res = client.GET("http://localhost:9090/coen6317/BlockingServlet");
        
        System.out.println(res.getContentAsString());
        
        client.stop();
		
	}
	
	//@Test
	void testAsyncServletGet() throws Exception {
		
		String url = "http://localhost:9090/coen6317/longtask";
		HttpClient client = new HttpClient();
        client.start();

        ContentResponse response = client.GET(url);

		assertThat(response.getStatus(), equalTo(200));
		
		String responseContent = IOUtils.toString(response.getContent());
		
		 System.out.println(responseContent);
		//assertThat(responseContent, equalTo( "This is some heavy resource that will be served in an async way"));
		
	}

	
	@Test
	void testArtistsGet() throws Exception {
		String url = "http://localhost:9090/coen6317/artists";
		HttpClient client = new HttpClient();
        client.start();

        Request request = client.newRequest(url);
        request.param("id","id200");
        ContentResponse response = request.send();
   

		assertThat(response.getStatus(), equalTo(200));
		
		String responseContent = IOUtils.toString(response.getContent());
		
		 System.out.println(responseContent);
		client.stop();
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testArtistsPost() throws Exception {
		
//		String url = "http://localhost:9090/coen6317/artists";
//		HttpClient client = new HttpClient();
//        client.start();
//        
//        ExecutorService executor = Executors.newFixedThreadPool(NUM_CLIENTS);
//        
//        for (int i = 0; i < NUM_CLIENTS; i++) {
//        	executor.execute(() -> {
//        		Request request = client.POST(url).content(new StringContentProvider("{}"),"application/json"));
//        		
//        	})
//        }
//        
//        request.param("id","id200");
//        request.param("name","artist200");
//        
//        ContentResponse response = request.send();
//		String res = new String(response.getContent());
//		System.out.println(res);
//		client.stop();
        
//		String url = "http://localhost:9090/coen6317/artists";
//		HttpClient client = new HttpClient();
//        client.start();
//        
//        Request request = client.POST(url);
//        
//        request.param("id","id200");
//        request.param("name","artist200");
//        
//        ContentResponse response = request.send();
//		String res = new String(response.getContent());
//		System.out.println(res);
//		client.stop();
        
//        for (int i = 0; i < NUM_CLIENTS; i++) {
//            executor.execute(() -> {
//                HttpRequest request = HttpRequest.newBuilder()
//                        .uri(URI.create("http://localhost:9090/coen6317/audios"))
//                        .POST(HttpRequest.BodyPublishers.ofString("{}"))
//                        .build();
//                try {
//                	ContentResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//                    System.out.println("Response status code: " + response.statusCode());
//                } catch (IOException | InterruptedException e) {
//                    System.out.println("Request failed: " + e.getMessage());
//                }
//            });
//        }
//
//        executor.shutdown();
    }

}





