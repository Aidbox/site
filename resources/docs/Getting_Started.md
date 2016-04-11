## Getting Started

An overview of Aidbox, how to start development, run your first app and deploy it into the cloud.

### Creating an Account

To start working with Aidbox you have to [create a free Aidbox account](/landing.html#/signup). After you receive a confirmation email from us, click the link it contains to confirm that you own the email address.

### Setup Development Environment

For taking full advantage of Aidbox you will need [GIT](https://git-scm.com) and [NODE.JS](https://nodejs.org/).   

* You can download and install GIT from [git-scm.com/downloads](https://git-scm.com/downloads).    
* All the instructions how to install NODE.JS you can find at [nodejs.org/download](https://nodejs.org/download/)

You will also need [aidbox-cli](https://www.npmjs.com/package/aidbox-cli). You can install it with NPM. Just make sure that you have permissions for installing modules globally.

```sh
$ npm install -g aidbox-cli
$ aidbox v
```

If “aidbox v” returns OK, everything is ready for development of apps with Aidbox.

### Clone a Sample Application

To try Aidbox run our [sample single-page application (SPA)](https://github.com/Aidbox/sample-spa.git).

Execute the following commands to clone it, and install modules and packages it depends on:

```sh
$ git clone https://github.com/Aidbox/sample-spa
$ cd sample-spa
$ npm install
```

__Sample App Structure__

It is a very simple app which consists of a minimal set of files.

```bsh
|-README.md
|- package.json
|- dist
    |- app.js
    |- index.html
    |- style.css
```

### Prepare a Box

You can work with Aidbox in two ways - using the [dashboard](/dashboard.html#/) or the command line interface (CLI) aidbox-cli. Command line interface is preferable because it provides more extensive functionality.

For preparing the box for work, you need to complete the following steps:

* Log into Aidbox
* Create a new box or switch to an existing one
* Create users for your box

### Aidbox CLI

__Login__

For logging into Aidbox, execute the following command while in the root folder of your app:

```sh
$ aidbox login
```

Enter email and password of your Aidbox account.

__Boxes__

If you have created some boxes earlier, you can display all of your boxes by entering the command ``aidbox box list``. You have to choose a box to work with.

```sh
$ aidbox box list
$ aidbox box use <boxname>
```

Otherwise enter the command ``aidbox box new <boxname>`` to create your first box.

```sh
$ aidbox box new <boxname>
$ aidbox box list
```

__Users__

Now You can create users for all the people who will be using your box.

```sh
$ aidbox user new <username>:<password>
$ aidbox user list
```

Another way of doing this is to run a wizard by entering the command ``aidbox user new``.

### Run Sample App

Link your app to the box. In the file ``dist\app.js`` set the variable ``BOX_URL`` to the URL of your box. For instance, if the name of your box is ``mysuperapp`` then set the variable ``BOX_URL`` this way:


```js
var BOX_URL = 'https://mysuperapp.aidbox.io';
```

Now you can start your app locally. To do this enter the following command:

```sh
$ npm run start
```

Your application will be running at [http://localhost:5000](http://localhost:5000). Click on login button and enter login and password of one of the box users. Just in case, these are the users you have just created with ``aidbox user`` command, not your Aidbox account user.

After logging in you will see a simple patient list which allows to filter, add and edit patients.

### Deploy App into the Box

Now you can deploy your app into the box. To achieve this, enter the following command: 

```sh
$ aidbox deploy
```

After receiving a message about successful deploy, you can visit your app at the URL generated from the box name - ``https://mysuperapp.aidbox.io`` for the box mysuperapp.


