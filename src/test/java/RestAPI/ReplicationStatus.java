package RestAPI;
import com.beust.jcommander.Parameter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ReplicationStatus {

    @Test
    public void replicationStatus() throws IOException {
      /*  java.io.InputStream is = this.getClass().getResourceAsStream("my.properties");
        java.util.Properties p = new Properties();
        p.load(is);*/

      /*  Properties p = new Properties();
        FileInputStream fis = new FileInputStream("target/classes/my.properties");
        p.load( fis);
        String name = p.getProperty("name");
        String version = p.getProperty("version");
        String foo = p.getProperty("foo");

        String server = p.getProperty("server");
        String username = p.getProperty("username");
        String password = p.getProperty("password");

        String loginBody = "{\"server\": \"" +server+"\",\"username\":\"" +username +"\",\"password\":\"" +password +"\"}";



        System.out.println(loginBody);
*/
        List<Integer> list = CommonAPI.getParsedIntgerList(ApiResource.getSanresource(),"data.total","data.virtualdevices[*].replicationenabled","data.virtualdevices[*].id");
        System.out.println(list);
        for(int i =0; i<list.size();i++) {
            CommonAPI.commonGet(ApiResource.getReplication(list.get(i)));
                if(i==list.size()-1){
                // Once the replication status is recived from all the devies, update the list and start again {
                list = CommonAPI.getParsedIntgerList(ApiResource.getSanresource(),"data.total","data.virtualdevices[*].replicationenabled","data.virtualdevices[*].id");
                i=0;
                System.out.println(list);
            }
        }
    }
}


