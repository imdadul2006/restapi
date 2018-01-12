package RestAPI;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
public class PhysicalDeviceManage {

    @Test
    public void putManagePhysicalDevice() throws IOException {
        JsonPath jPhysicalDevices= CommonAPI.commonGet(ApiResource.getEnumPhysicalDevices());
        jPhysicalDevices.prettyPrint();
        List<String> list = CommonAPI.getParsedStringList(ApiResource.getEnumPhysicalDevices(),"data.total","data.physicaldevices[*].isforeign","data.physicaldevices[*].id");
        System.out.println(list);
       /* for(int i =0; i<list.size();i++) {
            CommonAPI.commonGet(ApiResource.getReplication(list.get(i)));

        }*/

    }
}


