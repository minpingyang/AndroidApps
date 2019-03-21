package nz.ac.vuw.ecs.moviewebnews.utils;

/**
 * Created by yimingpeng on 32/09/17.
 */
public class ECSAuthenticator extends java.net.Authenticator {
    protected java.net.PasswordAuthentication getPasswordAuthentication() {
        //Please change the username and password to yours
        return new java.net.PasswordAuthentication("username", "password".toCharArray());
    }
}

