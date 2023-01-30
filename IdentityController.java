//import statements
import java.util.LinkedHashMap;
import java.util.Map;

public class IdentityController {
    //private variable to hold the uri
    private String uri;
    //constructor
    public IdentityController(String uri){
        this.uri = uri;
    }
    // public function which returns the path attached to all the parameters in key, value pairs
    public Map<String,Map<String,String>> checkURI(){
        //finds the index of the :// which splits the source from the path
        int index = uri.indexOf("://");
        //if there is none, returns null
        if(index == -1){
            return null;
        }
        //holds the path in a substring
        String path = uri.substring(index + 3);
        //first, checks that the scheme is valid
        if(uri.startsWith("visma-identity")){
            //checks if path is valid and equal to login
            if(path.startsWith("login")) {
                //creates a map with login as the key and the parameters as the values
                Map<String, Map<String, String>> login = new LinkedHashMap<>();
                login.put("login",getParameters());
                //returns this map
                return login;
            }
            //checks if path is valid and equal to confirm
            if(path.startsWith("confirm")){
                //creates a map with confirm as the key and the parameters as the values
                Map<String, Map<String, String>> confirm = new LinkedHashMap<>();
                confirm.put("confirm",getParameters());
                //returns this map
                return confirm;
            }
            //checks if path is valid and equal to sign
            if(path.startsWith("sign")){
                //creates a map with sign as the key and the parameters as the values
                Map<String, Map<String, String>> sign = new LinkedHashMap<>();
                sign.put("sign",getParameters());
                //returns this map
                return sign;
            }
        }
        return null;
    }
    //private function which deconstructs the URI and returns the parameters that it finds
    private Map<String,String> getParameters(){
        //empty linked hash map that takes a string key and string value
        Map<String,String> parameters = new LinkedHashMap<>();
        //splits the parameters from the path and scheme
        String uriParams = uri.substring(uri.indexOf("?")+1);
        //splits the parameters wherever there is an &
        String [] couples = uriParams.split("&");
        //for loop so that each parameter is split, no matter how many parameters there are
        for (String couple : couples){
            //splits each parameter by the = so that the key and value can be distinguished
            int divide = couple.indexOf("=");
            //checks if there is an =
            if(divide>0){
                //assigns the key and the value for each parameter
                parameters.put(couple.substring(0,divide),couple.substring(divide+1));
            }
        }
        //returns all parameters split into keys and values
        return parameters;
    }


}
