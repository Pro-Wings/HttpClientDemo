import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {

	
	public static void main(String[] args) {
		
		
		String uri = "http://localhost:8080/employee_mgmt/employee/4";

		CloseableHttpClient client = HttpClients.createDefault();
		
		
		try
		{
			HttpGet request = new HttpGet(uri);

            // add request headers
//            request.addHeader("custom-key", "mkyong");
//            request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

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
