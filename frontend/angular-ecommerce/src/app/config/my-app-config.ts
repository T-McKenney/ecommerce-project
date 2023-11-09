export default {

  oidc: {
    clientID: '0oad6uveobfKss75l5d7', // public identifier
    issuer: 'https://dev-76186856.okta.com/oauth2/default', // issuer of tokens, URL that will be used when authorizing with the Okta authorization server
    redirectUri: 'http://localhost:4200/login/callback', // Once user logs-in, send them to this URL
    scopes: ['openid', 'profile', 'email'] // provides access to info about a user. OpenId: req'd for auth requests. Profile: users fname, lname. Email: user email
  }
}
