## Overview

**Aidbox** is heavily based on [FHIR](http://www.hl7.org/fhir/).
**FHIR** (Fast Healthcare Interoperability Resources) is a modern open HL7 standard
for exchanging healthcare information electronically.

FHIR describes about 100 models for medical data - [**Resources**]()
(such as Patient, Encounter, Observation etc)
and [REST API]() to access and manipulate such data (Create, Update, Search etc).

**Aidbox** is FHIR server as a service with some useful additions.

With Aidbox you can focus on your buissiness ideas validation,
deligating technical details to us.

Aidbox provides you with all you need to start
your next healthcare application:

* Scalable and powerful *database*  - [fhirbase](http://fhirbase.github.io/) - to store and query your data
* [FHIR](http://www.hl7.org/fhir/) compliant REST API to access and manipulate this data <!--  -->
* OAuth and flexible security rules to control access to application data
* API to manage application users, with optional registration module
* Terminology service for popular coding systems (LOINC, SNOMED, ICD10, RxNorm) and custom dictionaries (ValueSets)
* Hosting for Single Page Applicatons written in HTML and JavaScript


With **aidbox** you can develop Mobile, Single Page as well as classic Web Applications.



## Boxes

If you have aidbox account, than you can create your own **boxes**.
**Box** is an instance of FHIR server with separate database and url.

For example: you can create several **boxes** for development,
one **box** for staging and another for production.

Boxes could be created from dashboard UI, using REST API or **aidbox-cli** util.

We take care maintains, scaling and updates for your boxes.

## REST API

The primary **box** interface  is REST API.
Box is expected to be fully compliant to FHIR Specification.

## OAuth

Every box implements OAuth 2.0 Provider Service and
all REST API calls is secured by OAuth. A

Aidbox supports all basic OAuth workflows:

* Web Application (Autorization Code)
* Single Page Applications (Implicite)
* REST clients (Client Credentials)
* JSON web tokens ???

## OAuth Scopes

## Security

Each box has their own users and security rules.
You can use REST API, **Box Admin UI** or **aidbox-cli** to manage users in box.
Also you can enable registration module to allow users register in box by themself.

Users could be assigned to groups and for each group you can create specific security rules.


## Database

Each **box** includes separate PostgreSQL database with installed **fhirbase**.
Fhirbase is an open source PostgreSQL extension to store FHIR resources
in PostgreSQL.
You can get direct connection to it from **Box Administration Interface**.


## Terminology

Almost all healthcare apps require a lot of terminologies, dictionaries and lookups.
Box implements FHIR Terminology Service Specification and shipped with
most popular Naming Systems, such as: 

* LOINC
* SNOMED
* ICD10
* RxNorm

Also you can create and use your own NamingSystems and ValueSets.

## Static Hosting

You can host One Page applications, written in HTML & JavaScript, directly on your box.
This applications could be easyly developed on your local machine and deployed in box
in a seconds with one command (See Getting Started).

## SDK

You can interact with box from most popular platforms - Java, .NET, nodejs, Ruby, Python etc - using
FHIR reference libraries.
