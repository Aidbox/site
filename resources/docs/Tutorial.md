## Sample app tutorial

We are offering this tutorial for learning core concepts of application development with Aidbox. We will develop a sample [AngularJS](https://angularjs.org), Web application which consists of a form for onboarding patients (CRUD) with a search by name function.

![Sample SPA](/site/imgs/app.png)

After completing this tutorial you should learn:

* how to create Aidbox Web applications with NodeJS and AngularJS
* how to use aidbox-cli
* how to use REST API and query the FHIR server
* __What else?__

### Get started

To start your development you have to install NodeJS. All the instructions how to install NODE.JS you can find at [nodejs.org/download](https://nodejs.org/download/)
. The next step of preparing your development environment is installation of aidbox-cli and box setup. All the information you need for working with aidbox-cli you can find on [its official page](https://www.npmjs.com/package/aidbox-cli).


```sh
$ npm install -g aidbox-cli
$ aidbox v
```

### Sample app structure

Sample app consists of three main files:

```bsh
├── package.json
└── dist
    ├── app.js
    └── index.html
```

* ``package.json`` - manifest file of your app. It contains the name of your project, its version, dependencies, commands to run etc You can read more about package.json file on [this page](https://docs.npmjs.com/files/package.json) of npm documentation.
* ``index.html`` - the first HTML file of your application.
* ``app.js`` - main part of your app. It contains all business logic, queries to the FHIR server via REST API, authorisation etc

Let’s look at each file more closely

__Package.json__

``package.json`` contains only minimally required settings, one dependency ``http-server`` and one command ``start`` for starting a local Web server on the port 5000.

``package.json``
```js
{
  "name": "Aidbox-sample-spa",
  "version": "0.0.0",
  "dependencies": { },
  "devDependencies": {
    "http-server": "latest"
  },
  "engines": {
    "node": ">=0.12.0"
  },
  "scripts": {
    "start": "`npm bin`/http-server dist -p 5000"
  }
}
```

__index.html__

To simplify the app let’s load all the styles and scripts from the CDN. Please pay attention that   ``angular-aidbox.js`` - is a service for the AngularJS framework providing REST API and authorisation implementation. You can read more details about this project on the [aidboxjs](https://github.com/Aidbox/aidboxjs) official page.

``index.html``
```html
<!doctype html>
<html ng-app="app">
  <head>
    <meta charset="utf-8">
    <title>My sample app</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.1/angular.min.js" ></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.1/angular-cookies.min.js" ></script>
   <script src="//aidbox.io/angular-aidbox.js" ></script>
  </head>
  <body>
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
      <div class="container">
        <div id="navbar" class="navbar">
          <ul class="nav navbar-nav navbar-right">
            <li ng-if="user" class="login">
              <a href="#">{{user.email}}</a>
            </li>
            <li ng-if="!user">
              <a ng-click="auth.signin()" href="#">Sign in</a>
            </li>
            <li ng-if="user">
              <a ng-click="auth.signout()" href="#">Sign out</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container">
      <h3>Sample app</h3>
      <div ng-show="user" class="ng-hide">
      </div>
    </div>
  </body>
</html>
```

__app.js__

``app.js``
```js
(function() {
    var BOX_URL = 'https://myapp.aidbox.io';
    var app = angular.module('app', ['ngCookies', 'ngAidbox']);
    app.run(function($rootScope, $aidbox) {
        $aidbox.init({
            box: BOX_URL,
            onSignIn: function(user) {
                $rootScope.user = user;
            },
            onSignOut: function() {
                $rootScope.user = null;
            }
        });
    });
})();
```

Run

```bsh
npm run start
```

### Create patient form


### Patients list

### Patients CRUD

### Deploy

```bsh
aibox deploy
```
