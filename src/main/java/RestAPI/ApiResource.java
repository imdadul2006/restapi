package RestAPI;

public class  ApiResource {

    // Post API

    public static String postLogin(){
        return "auth/login";
    }
    public static String postLogout(){
        return "auth/logout";
    }
    public static String postAddClient(){
        return "";
    }
    public static String postAddUser(){
        return "rest/user";
    }

    // Get API

    public static String getenumAdapters(){return "ABCDphysicalresource/physicaladapter";}
    public static String getaAdapter(int adapterID) {return "physicalresource/physicaladapter/"+adapterID;}
    public static String getClientInitiator (){return "physicalresource/physicaladapter/fcclientinitiators";}
    public static String getFCbasePort(){return "physicalresource/physicaladapter/fcwwpn" ;}
    public static String getEnumPhysicalDevices (){return "ABCDphysicalresource/physicaldevice";}
    public static String getPhyiscalDevicePath (String guid){return  "ABCDphysicalresource/physicaldevice/scsialias/"+guid;}
    public static String getFCTargetPort(){return "physicalresource/physicaladapter/fctgtwwpn";}
    public static String getEnumUnassignedPhysicalDevices(){return  "physicalresource/physicaldevice/unassigned";}
    public static String getEnumeleligibleTarget(){return "physicalresource/physicaldevice/eligibletargets";}
    public static String getPhysicalDevices(String guid){return "physicalresource/physicaldevice/"+ guid;}
    public static String getEnumStoragePool(){return "physicalresource/storagepool";}


    // Put API
    // Requires lots of Testing

    public static String putManagePhysicalAdapter(int adapterNumberID){return "physicalresource/physicaladapter/"+adapterNumberID;}
    public static String putRescanPhysicalDevices(){return "physicalresource/physicaldevice/rescan";}
    public static String putManagePhysicalDevice(int guid){return "physicalresource/physicaldevice/"+guid;}
    public static String putManagePhysicalResourceBatch(){return "batch/physicalresource/physicaldevice";}

    //Post API
    public static String postCreateBlockDevice(){return "physicalresource/physicaldevice";}
    public static String postCreateStoragePool(){return "physicalresource/storagepool";}

}
