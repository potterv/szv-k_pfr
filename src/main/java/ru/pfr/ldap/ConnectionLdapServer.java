package ru.pfr.ldap;

import javax.naming.directory.SearchResult;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.directory.*;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Map;

//Active Directory прекрасно может работать как LDAP-сервер. Аттрибут с логином и доменом для пользователя называется userPrincipalName. Вот пример работы с AD через LDAP использую библиотеку ldaptive

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.ldaptive.*;
import org.ldaptive.auth.*;
import org.ldaptive.pool.BlockingConnectionPool;
import org.ldaptive.pool.PoolConfig;
import org.ldaptive.pool.PooledConnectionFactory;
import org.ldaptive.pool.SearchValidator;
import ru.pfr.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.log4j.PropertyConfigurator.*;

public class ConnectionLdapServer {

   public  ConnectionLdapServer(){
       configure("src\\main\\resources\\log4j.properties");
    }
    public void setConnection(){
        Hashtable<String, String> env = new Hashtable<String, String>();

        String userName = "092GoncharVV";
        String userPassword = "Sev7777";
        String ldapURL = "ldap://10.92.0.25:389";

        //Access the keystore, this is where the Root CA public key cert was installed
        //Could also do this via the command line option java -Djavax.net.ssl.trustStore....
        //No need to specifiy the keystore password for read operations
        String keystore = "c:/Program Files (x86)/Java/jdk1.8.0_231/jre/lib/security/cacerts";
        System.setProperty("javax.net.ssl.trustStore", keystore);

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        //set security credentials
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, userName);
        env.put(Context.SECURITY_CREDENTIALS, userPassword);

        //specify use of ssl
        //        env.put(Context.SECURITY_PROTOCOL, "ssl");

        //connect to my domain controller
        env.put(Context.PROVIDER_URL, ldapURL);
        try {

            // Create the initial directory context
            DirContext ctx = new InitialLdapContext(env, null);

            //Create the search controls
            SearchControls searchCtls = new SearchControls();

            //Specify the attributes to return
            //String returnedAtts[] = {"sn", "givenName", "mail"};
            //searchCtls.setReturningAttributes(returnedAtts);
            searchCtls.setReturningAttributes(null);

            //Specify the search scope
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            //specify the LDAP search filter
            String searchFilter = "(&(objectClass=user)(mail=ematyushkin*))";

            //Specify the Base for the search
            String searchBase = "DC=0092,DC=PFR,DC=RU";

            //initialize counter to total the results
            int totalResults = 0;


            // Search for objects using the filter
            NamingEnumeration answer = ctx.search(searchBase, searchFilter, searchCtls);

            //Loop through the search results
            while (answer.hasMoreElements()) {
                SearchResult sr = (SearchResult) answer.next();

                totalResults++;

                System.out.println(">>>" + sr.getName());

                // Print out some of the attributes, catch the exception if the attributes have no values
                Attributes attrs = sr.getAttributes();
                if (attrs != null) {
                    NamingEnumeration myattrs = attrs.getAll();
                    TreeMap<String, Object> sorted = new TreeMap<String, Object>();
                    while (myattrs.hasMoreElements()){
                        Attribute attr = (Attribute)myattrs.next();
                        sorted.put(attr.getID(), attr.get());
                    }
                    for(Map.Entry entry : sorted.entrySet()){
                        if (entry.getValue() instanceof String)
                            System.out.println(entry.getKey()+": "+entry.getValue());
                        else
                            System.out.println(entry.getKey()+": binary");
                    }
                }

            }
            System.out.println("Total results: " + totalResults);
            ctx.close();
        }
        catch (NamingException e) {
            System.err.println("Problem searching directory: " + e);
        }
    }

    public void getUser() throws LdapException {

        ConnectionConfig connectionConfig = new ConnectionConfig();
        connectionConfig.setLdapUrl("ldap://0092.pfr.ru:389");
        connectionConfig.setConnectionInitializer(new BindConnectionInitializer("092infomat@092.pfr.ru", new Credential("Sev7777")));
        DefaultConnectionFactory connectionFactory = new DefaultConnectionFactory(connectionConfig);
        PoolConfig pollConfig = new PoolConfig();
        pollConfig.setMinPoolSize(3);
        pollConfig.setMaxPoolSize(10);
        pollConfig.setValidateOnCheckOut(false);
        pollConfig.setValidatePeriodically(true);
        pollConfig.setValidatePeriod(3000);
        BlockingConnectionPool pool = new BlockingConnectionPool(pollConfig, connectionFactory);
        pool.setValidator(new SearchValidator());
        pool.initialize();
        PooledConnectionFactory cf = new PooledConnectionFactory(pool);
        SearchExecutor executor = new SearchExecutor();
        executor.setBaseDn("ou=092infomat,dc=0092,dc=pfr,dc=ru");
        String userLogin = "092infomat";
        org.ldaptive.SearchResult res = executor.search(cf, "(samaccountname=" + userLogin + ")",/*логин без домена*/"samaccountname",/*логин@домен*/"userPrincipalName", /*имя*/ "givenName", /*фамилия*/ "sn").getResult();
        Collection<LdapEntry> ents = res.getEntries();
        System.out.println("ents.size() = " + ents.size());
        for (LdapEntry le : ents) {
            System.out.println(le);
            System.out.println(new String(le.getAttribute("givenName").getBinaryValue()));
            System.out.println(new String(le.getAttribute("sn").getBinaryValue()));
            System.out.println(new String(le.getAttribute("samaccountname").getBinaryValue()));
            System.out.println(new String(le.getAttribute("userPrincipalName").getBinaryValue()));
        }


    }

    public void conLdap() throws NamingException {
        Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);
        ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        ldapEnv.put(Context.PROVIDER_URL,  "ldap://0092.pfr.ru:389");
        ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
        ldapEnv.put(Context.SECURITY_PRINCIPAL, "092Infomat@0092.pfr.ru");
        ldapEnv.put(Context.SECURITY_CREDENTIALS, "Sev7777");
        InitialDirContext ldapContext = new InitialDirContext(ldapEnv);
        // Create the search controls
        SearchControls searchCtls = new SearchControls();
        // Specify the attributes to return
        String returnedAtts[]={"sn","givenName", "samAccountName","mail"};
        searchCtls.setReturningAttributes(returnedAtts);
        // Specify the search scope
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        // specify the LDAP search filter
        String searchFilter = "(&(objectCategory=user)(objectClass=person)(samAccountName=userName))";
        // Specify the Base for the search
        String searchBase = "cn=092Infomat,dc=0092,dc=pfr,dc=ru";
        // initialize counter to total the results
        int totalResults = 0;
        // Search for objects using the filter
        NamingEnumeration<javax.naming.directory.SearchResult> answer = ldapContext.search(searchBase, searchFilter, searchCtls);
        // Loop through the search results
        while (answer.hasMoreElements()) {
            javax.naming.directory.SearchResult sr = answer.next();
            totalResults++;
            System.out.println(">>>" + sr.getName());
            Attributes attrs = sr.getAttributes();
            System.out.println(">>>>>>" + attrs.get("samAccountName"));
            System.out.println(">>>>>>" + attrs.get("mail"));
            System.out.println(">>>>>>" + attrs.get("url"));

        }
    }
    private static final Logger log = Logger.getLogger(Model.class);
}
