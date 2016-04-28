## Aidbox supports 3 types of Oauth authorization:

1. __Implicit__ for browser-based or mobile apps
2. __Authorization Code__ for apps running on a web server
3. __Client credentials__ for application access

There is available by default __implicit__ client with id __site__. You can view a list of available clients, 
add new or edit existing clients on the __Client__ page in the box [dashboard](/dashboard.html#/). 
See [RFC6749](https://tools.ietf.org/html/rfc6749) for more information about OAuth 2.0 authorization.

### Implicit

Let's check that there is existing default client of type implicit and with the client_id = site.

1. Open the Clients tab.
2. Select a record named __site__.
3. Check that the client_id is __site__.

In order to test implicit authorization, let's add a new policy that will be checking for implicit client with the client_id = site.

```
{
 "required" : [ "client" ],
 "properties" : {
   "client" : {
     "type" : "object",
     "properties" : {
       "client_id" : {
         "constant" : "site"
       }
     }
   }
 }
}
```

* Deploy your aidbox and after receiving a message about successful deploy, visit your app at the URL generated from the box name - e.g. https://mysuperapp.aidbox.io for the __mysuperapp__ box.
* Ensure that you have added a user for the box (see http://aidbox.github.io/site/docs/Users_and_Groups.html for instructions). E.g. a user with login = boxuser1@gmail.com.
* Click the Sign in link.
* You will see a login form labeled __Allow site to use your account__ where __site__ is the name of your client.
* Log in with the box user credentials (not your aidbox account credentials).
* You will see Patients list page.

### Authorization Code

In order to test the Authorization Code type of authorization, you will need a tool for testing RESTful requests. For example [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en).

Let's add a new client with the Authorization Code type.

1. Open the Clients tab.
2. Click the plus button
3. Fill in the fields:
  * Name = auth_code
  * Client Id = auth_code123
  * Client Secret = pwd
  * Redirect Uri = localhost, www.getpostman.com
4. Click the Create button

Let's add a new policy that would allow an access for all clients.

1. Open the Policies tab;
2. Click the plus button;
3. Fill in the fields Id, Title, Type, Policy;
4. Click the Create button.

```
{
  "required" : [ "client" ],
  "properties" : {
    "client" : {
      "type" : "object"
    }
  }
}
```

* Open Postman.
* Select Type = OAuth 2.0
* GET = https://yourboxname.aidbox.io/users
* Fill in the following fields:

* Auth URL = https://yourboxname.aidbox.io/oauth/authorize
* Access Token URL = https://yourboxname.aidbox.io/oauth/token
* Client ID = auth_code123
* Client Secret = pwd
* Grant Type = Authorization Code

* Click the Request Token button.
* You will see a login form labeled __Allow auth_code to use your account__ where __auth_code__ is the name of your client.
* Log in with the box user credentials (not your aidbox account credentials).
* Click on Token Name in order to add the token to the request URL.
* Click the Send button.
* Check the request body below.
* 
You will see something like:

```
[
  {
    "id": 1,
    "status": null,
    "email": "boxuser1@gmail.com",
    "data": "null",
    "groups": null,
    "group-ids": []
  }
]
```

### Client credentials

Let's add a new client with the Client credentials type.

1. Open the Clients tab.
2. Click the plus button
3. Fill in the fields:
  * Name = client_credentials
  * Client Id = client_credentials123
  * Client Secret = secret
  * Redirect Uri = localhost, www.getpostman.com
4. Click the Create button

Ensure that there is the policy:

```
{
  "required" : [ "client" ],
  "properties" : {
    "client" : {
      "type" : "object"
    }
  }
}
```

* Open Postman.
* Select Type = OAuth 2.0
* GET = https://yourboxname.aidbox.io/users

Fill in the following fields:

* Auth URL = https://yourboxname.aidbox.io
* Access Token URL = https://yourboxname.aidbox.io/oauth/token
* Client ID = client_credentials123
* Client Secret = secret
* Grant Type = Client Credentials

* Click the Request Token button.
* Click on Token Name in order to add the token to the request URL.
* Click the Send button.
* Check the request body below.

You will see something like:

```
[
  {
    "id": 1,
    "status": null,
    "email": "boxuser1@gmail.com",
    "data": "null",
    "groups": null,
    "group-ids": []
  }
]
```
