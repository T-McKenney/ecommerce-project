import {Component, Inject, OnInit} from '@angular/core';
import myAppConfig from "../../config/my-app-config";
import {OKTA_AUTH} from "@okta/okta-angular";
import {OktaAuth} from "@okta/okta-auth-js";
// @ts-ignore
import OktaSignIn from '@okta/okta-signin-widget';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  oktaSignIn: any;

  constructor(@Inject(OKTA_AUTH) private oktaAuth: OktaAuth) {

    this.oktaSignIn = new OktaSignIn({
      logo: 'assets/images/logo.png',
      baseUrl: myAppConfig.oidc.issuer.split('/oauth2')[0],
      clientId: myAppConfig.oidc.clientID,
      redirectUri: myAppConfig.oidc.redirectUri,
      authParams: {
        pkce: true, // proof key for code exchange
        issuer: myAppConfig.oidc.issuer,
        scopes: myAppConfig.oidc.scopes
      }
    });
  }

  ngOnInit(): void {

    this.oktaSignIn.remove(); // remove any previous elements that may have been rendered

    this.oktaSignIn.renderEl({ // render the signin widget
        el: '#okta-sign-in-widget'
      }, // render the element with the id of 'okta-sign-in-widget' from HTML file
      (response: any) => {
        if (response.status === 'SUCCESS') {
          this.oktaAuth.signInWithRedirect();
        }
      },
      (error: any) => {
        throw error;
      }
    );
  }

}
