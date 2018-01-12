package RestAPI;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class ReplicationStatus {

    @Test
    public void replicationStatus() throws IOException {
        List<Integer> list = CommonAPI.getParsedIntgerList(ApiResource.getSanresource(),"data.total","data.virtualdevices[*].replicationenabled","data.virtualdevices[*].id");
        System.out.println(list);
        for(int i =0; i<list.size();i++) {
            CommonAPI.commonGet(ApiResource.getReplication(list.get(i)));
           /*     if(i==list.size()-1){
                // Once the replication status is recived from all the devies, update the list and start again {
                list = CommonAPI.getParsedIntgerList(ApiResource.getSanresource(),"data.total","data.virtualdevices[*].replicationenabled","data.virtualdevices[*].id");
                i=0;
                System.out.println(list);
            }*/
        }
    }
}


