@*****************************************************************************
 * ScalaBlog. 
 * Copyright 2014-2015 Gavin Baumanis
 * gavinb@thespidernet.com 
 * http://www.thespidernet.com/scalablog
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 *
 * The ScalaBlog is a fully functioning Blog.
 * It was originally written as a training tool for Scala and the TypeSafe
 * technology stack; http://typesafe.com/products/typesafe-reactive-platform
 * 
 * It is subsequently written with verbose comments and with readability
 * always in focus. Thus we have not always used the most concise / terse
 * code that we could have. Which is a real strength of Scala.
 * 
 * The ScalaBlog also became the training ground for our efforts to 
 * better understand "BIG DATA". Subsequently it uses Hadoop and some related
 * technologies that simply just aren't a requirement for a blog application.
 * Nonetheless - they are used here!
 *
 * The ScalaBlog application is free to use.
 *
 * 
 * The blog utilises the following technology;
 * 
 * Scala 2.11.6
 * Scala Test 2.2.5 - Testing Framework
 * Play 2.4.3 - MVC Framework
 * Akka 2.3.9 - Messaging
 * spray 2.3.3 - http
 * Cassandra Database 2.1.8
 * Hadoop / Hadoop File System 2.7.1
 * jQuery 2.1.4 - JavaScript Library
 * Bootstrap 3.3.4 - JavaScript Library
 * 
 *****************************************************************************@
 
 The models folder is used to contain all the model segments of your application. 
 The model is what is used to programmatically interface between the application
 and the data storage for the application.
 
 It contains all the code that maps object properties to database columns and also
 contains all the required code for Creating / Reading / Updating and Deleting (CRUD)
 records to or from the database.
 
 Typical items in here are "Service Layers / Object Managers", Data Access Objects (DAOs) 
 and the objects themselves,too - reside here.
 
 The models folder forms part of the Model View Controller (MVC) design pattern.
 
 MVC has become a standard for building web applications and allows 
 developers to cleanly separate different areas of concern in their applications.
 Which allows for better collaboration, easier troubleshooting, simpler code maintenance.
 