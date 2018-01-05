package RestAPI;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhysicalDeviceManage {


    @BeforeClass
    public List<String> getListOfForeignDisk() throws IOException {
        JsonPath jPhysicalDevices= CommonAPI.commonGet(ApiResource.getEnumPhysicalDevices());

        //This List only have foreign Disk

        List<String> physicalDeviceList2 = new ArrayList<String>();

        for(int i = 0; i< jPhysicalDevices.getInt("data.total");i++){
            if(jPhysicalDevices.getBoolean("data.physicaldevices["+i+"].isforeign"))
                physicalDeviceList2.add(jPhysicalDevices.getString("data.physicaldevices["+i+"].id"));
        }

        System.out.println("Respond : rc = "+jPhysicalDevices.get("rc"));
        Assert.assertEquals(jPhysicalDevices.get("rc"),0);
        return physicalDeviceList2;
    }

    @Test
    public void putManagePhysicalDevice(List<String> guid){

    }
}


