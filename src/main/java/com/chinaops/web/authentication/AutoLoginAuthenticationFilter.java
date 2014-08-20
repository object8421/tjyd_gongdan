/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.authentication;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.xml.sax.SAXException;

import com.chinaops.web.ydgd.utils.AESEncryptor;
import com.chinaops.web.ydgd.utils.RSAEncryptor;

/**
 * Processes an auto login request.
 * <p>
 * Login parameters must be encrypted by private key. This controller use the public key to decrypt it and do login.
 * The default parameter names to use are contained in the
 * static fields {@link #AUTO_LOGIN_PARANAME}
 * <p>
 * This filter by default responds to the URL {@code /j_ecloud_autologin}.
 * @author Harley Ren  
 */
public class AutoLoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private static final Log   LOG                 = LogFactory
                                                           .getLog(AutoLoginAuthenticationFilter.class);
    // ========================== Attributes ============================
    public static final String AUTO_LOGIN_PARANAME = "auth_token";
    public static final String SECRET_KEY_PARANAME = "sk";

    private String             publicKey;

    // ========================= Constructors ===========================
    /**
     * @param defaultFilterProcessesUrl
     */
    public AutoLoginAuthenticationFilter() {
        //This filter will response this URL.
        super("/j_ecloud_autologin");

        if (this.getSuccessHandler() instanceof AbstractAuthenticationTargetUrlRequestHandler) {
            ((AbstractAuthenticationTargetUrlRequestHandler) this.getSuccessHandler())
                    .setAlwaysUseDefaultTargetUrl(true);
            ((AbstractAuthenticationTargetUrlRequestHandler) this.getSuccessHandler())
                    .setDefaultTargetUrl("/index.htm");
        }
    }

    // ======================= Getters & Setters ========================
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    // ======================== Public methods ==========================
    /* （非 Javadoc）
     * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException, IOException,
            ServletException {

        String authToken = obtainAuthToken(request);
        LOG.debug("authToken: " + authToken);
        String encodedKey = obtainEncodedKey(request);
        LOG.debug("encodedKey: " + encodedKey);

        if (StringUtils.isEmpty(authToken)) {
            throw new AuthenticationServiceException("Bad credential !");
        }

        //
        byte[] encryptedData;
        try {
            LOG.debug("publicKey: " + publicKey);
            byte[] encryptedKey = RSAEncryptor.decryptByPublicKey(Hex.decode(encodedKey),
                    publicKey.trim());
            //Generate AES secret key.
            SecretKeySpec aesKey = AESEncryptor.generateKey(encryptedKey);
            encryptedData = AESEncryptor.decrypt(Hex.decode(authToken), aesKey);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new AuthenticationServiceException("Bad credential !");
        }

        String xml = new String(encryptedData, "UTF-8");
        LOG.debug("xml: " + xml);
        LoginForm loginForm = null;

        try {
            loginForm = new LoginFormParser().parse(xml);
        } catch (SAXException e) {
            throw new AuthenticationServiceException("Bad credential !");
        }

        if (loginForm == null || loginForm.getUsername() == null || loginForm.getPassword() == null) {
            throw new AuthenticationServiceException("Bad credential !");
        }

        if (isRequestTimeout(loginForm.getTime())) {
            throw new AuthenticationServiceException("Request timeout !");
        }

        LOG.debug("username:" + loginForm.getUsername() + " login at "
                + new Date(loginForm.getTime()).toString());

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                loginForm.getUsername(), loginForm.getPassword());
        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * Provided so that subclasses may configure what is put into the authentication request's details
     * property.
     *
     * @param request that an authentication request is being created for
     * @param authRequest the authentication request object that should have its details set
     */
    protected void setDetails(HttpServletRequest request,
            UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    // ==================== Private utility methods =====================

    /**
     * Determine whether the request is timeout.
     * @param time request time.
     * @return
     */
    private boolean isRequestTimeout(long time) {
        long currentTime = System.currentTimeMillis();
        //当前时间必须在请求时间的前后10分钟内
        return !(currentTime >= (time - (10 * 60 * 1000)) && currentTime <= (time + (10 * 60 * 1000)));
    }

    /**
     * @param request
     * @return
     */
    private String obtainAuthToken(HttpServletRequest request) {
        return request.getParameter(AUTO_LOGIN_PARANAME);
    }

    private String obtainEncodedKey(HttpServletRequest request) {
        return request.getParameter(SECRET_KEY_PARANAME);
    }

    // ========================== main method ===========================
    public static class LoginForm {
        private String username;
        private String password;
        private long   time;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }
    }

    private class LoginFormParser {
        public LoginForm parse(String xml) throws IOException, SAXException {
            Digester digester = new Digester();
            digester.setValidating(false);
            digester.addObjectCreate("loginform", LoginForm.class);
            digester.addBeanPropertySetter("loginform/username");
            digester.addBeanPropertySetter("loginform/password");
            digester.addBeanPropertySetter("loginform/time");

            LoginForm loginForm = (LoginForm) digester.parse(new StringReader(xml));
            return loginForm;
        }
    }
}
