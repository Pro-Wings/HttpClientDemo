import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientPostDemo2 {

	
	public static void main(String[] args) {
		
		
		String uri = "http://localhost:8080/employee_mgmt/employee";

		CloseableHttpClient client = HttpClients.createDefault();
		
		try
		{
			HttpPost request = new HttpPost(uri);

            // add request headers
//            request.addHeader("custom-key", "mkyong");
//            request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
			
			String jsonBody = "{\r\n"
					+ "    \"name\": \"ABC\",\r\n"
					+ "    \"address\":\"DUBAI\"\r\n"
					+ "}";

			HttpEntity stringEntity = new StringEntity(jsonBody,ContentType.APPLICATION_JSON);
			request.setEntity(stringEntity);
			
            CloseableHttpResponse response = client.execute(request);
			
            
            try {
            	System.out.println(response.getProtocolVersion());             
                System.out.println(response.getStatusLine().getStatusCode());  
                System.out.println(response.getStatusLine().getReasonPhrase());
                System.out.println(response.getStatusLine().toString());  
            	
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    System.out.println("Response is  :   "+result);
                }
                
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("exception while decoding response");
				e.printStackTrace();
			}
            
            
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("issue in making http call");
			e.printStackTrace();
		}
		 
		
		
	}
}
