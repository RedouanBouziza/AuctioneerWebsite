// see https://www.npmjs.com/package/fetch-intercept
import fetchIntercept from 'fetch-intercept';

export class FetchInterceptor {
    static theInstance; // the singleton instance that has been registered
    sessionService;     // the sessionService which tracks the authorisation
    unregister;         // callback function to unregister this instance

    constructor(sessionService) {
        FetchInterceptor.theInstance = this;
        this.sessionService = sessionService;
        // fetchIntercept does not register the object closure, only the methods as functions
        this.unregister = fetchIntercept.register(this);
        console.log("FetchInterceptor has been registered.");
    }

    request(url, options) {
        let token = FetchInterceptor.theInstance.sessionService.currentToken;
        //console.log("FetchInterceptor request: ", url, options, token);

        if (token == null) {
            return [url, options];
        } else if (options == null) {
            return [url, { headers: { Authorization: token }}]
        } else {
            let newOptions = { ...options };



            // console.log("FetchInterceptor request: ", url, newOptions);
            return [url, newOptions];
        }
    }
    response(response) {
        // console.log("FetchInterceptor response: ", response);
        FetchInterceptor.theInstance.tryRecoverNewJWToken(response);
        if (response.status >= 400 && response.status < 600) {
            FetchInterceptor.theInstance.handleErrorInResponse(response);
        }
        return response;
    }

    requestError(error) {
        // Called when an error occured during another 'request' interceptor call
        console.log("FetchInterceptor requestError: ", error);
        return Promise.reject(error);
    }
    responseError(error) {
        // Handle a fetch error
        console.log("FetchInterceptor responseError: ", error);
        return Promise.reject(error);
    }

    async handleErrorInResponse(response) {
        if (response.status == 401) {
            // unauthorised request, redirect to signIn page
            // this.router.navigate(['/sign-out']);    // ng-router
            this.router.push({ path: '/sign-out',});   // vue-router
        } else if (response.status != 406) {
            // 406='Not Acceptable' error is used for logon failure
        }
    }

    tryRecoverNewJWToken(response) {
    }
}
