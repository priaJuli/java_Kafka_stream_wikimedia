# Getting Started

From my prespective, Apache Kafka is good for java programming, 
build server for mini API to the kafka topics and build any microservices 
from other language programming.

But, in order to build program with java, at least you must understand 
several packages from maven/spring java.

This is sample Application for kafka java stream insert from WikimediaDataChanges
to Mysql

## Modules

1. Producer Wikimedia
2. Consumer Wikimedia to Database


### Producer Wikimedia

Producer Wikimedia using an Url for stream changes happen in Wikipedia, 
and each Row publish to topics "wikimedia_recentchange". The stream from 
wikimedia API is applied using EventSource with timeout of 10 ms.

### Consumer Wikimedia

Consumer is listen to topics "wikimedia_recentchange" then make data from 
the string and save to database MySQL.