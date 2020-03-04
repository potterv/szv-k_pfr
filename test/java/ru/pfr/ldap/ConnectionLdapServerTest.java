package ru.pfr.ldap;

import org.junit.Test;
import org.ldaptive.LdapException;

import javax.naming.NamingException;

import static org.junit.Assert.*;

public class ConnectionLdapServerTest {

    @Test
    public void setConnection() {
        ConnectionLdapServer ldapConnect = new ConnectionLdapServer();
        ldapConnect.setConnection();
    }

    @Test
    public void conLdap() throws NamingException {
        ConnectionLdapServer ldapConnect = new ConnectionLdapServer();
        ldapConnect.conLdap();
    }

    @Test
    public void getUser() throws LdapException {
        ConnectionLdapServer ldapConnect = new ConnectionLdapServer();
        ldapConnect.getUser();
    }

}