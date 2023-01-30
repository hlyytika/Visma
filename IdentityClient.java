
import java.util.Map;
//client class implements the Identity Controller
public class IdentityClient {

    public static void main(String [] args){
        //four examples of uris
        IdentityController identityController1 = new IdentityController("visma-identity://confirm?source=netvisor&paymentnumber=102226");
        IdentityController identityController2 = new IdentityController("visma-identity://login?source=severa");
        IdentityController identityController3 = new IdentityController("visma-identity://sign?source=vismasign&documentid=105ab44");
        IdentityController identityController4 = new IdentityController("://sign?source=vismasign&documentid=105ab44");
        //four examples of the identityController checkURI function being called
        Map<String,Map<String,String>> params1 = identityController1.checkURI();
        Map<String,Map<String,String>> params2 = identityController2.checkURI();
        Map<String,Map<String,String>> params3 = identityController3.checkURI();
        Map<String,Map<String,String>> params4 = identityController4.checkURI();
        //Results of each is printed
        System.out.println(params1);
        System.out.println(params2);
        System.out.println(params3);
        System.out.println(params4);

    }

}
